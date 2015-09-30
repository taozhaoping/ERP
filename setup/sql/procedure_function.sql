--------------------------------------------
-- Export file for user ERP               --
-- Created by 21829 on 2015/9/7, 19:52:50 --
--------------------------------------------

set define off
spool procedure_function.log

prompt
prompt Creating procedure EXPAND_PRODUCT_BOM
prompt =====================================
prompt
create or replace procedure erp.EXPAND_PRODUCT_BOM(V_SALES_ORDER_ID  IN NUMBER,
                                               V_PRODUCT_ID      IN NUMBER,
                                               V_IS_MAIN_PRODUCT IN NUMBER,
                                               V_TIER            IN NUMBER,
                                               V_QTY             IN NUMBER,
                                               V_PARENT_ID IN NUMBER) as
begin
  declare
    SALES_ORDER_ID  number; -- 销售订单编号
    PRODUCT_ID      number; -- 产品编号
    IS_MAIN_PRODUCT number; -- 是否主要产品（只展开第一成为准）
    TIER            number; -- 层级（产品本身为0）
    QTY             number; -- 数量
    PARENT_ID       number; -- 父类的id
    
    bom_qty        number; -- 数量
    bom_sub_qty    number; -- 数量
    scrap_factor   float; --损耗率
  
    SOURCE_TYPE    varchar2(50); -- 来源,如采购(120)，外加工(122)，自生产(121)
    insert_id      number; -- 产品id
    temp_parent_id number; -- 暂存的parent_id
  
    bom_primary_id number; -- 产品结构中的主表id
    
    bom_sub_primary_id number; -- 产品结构中的主表id
    
    sub_bom_primary_id number; -- 替代料的产品结构中的主表id
  
    sub_count number; -- 替代料的数量
  begin
    SALES_ORDER_ID  := V_SALES_ORDER_ID;
    PRODUCT_ID      := V_PRODUCT_ID;
    IS_MAIN_PRODUCT := V_IS_MAIN_PRODUCT;
    TIER            := V_TIER;
    QTY             := V_QTY;
    PARENT_ID := V_PARENT_ID;
  
    select t.source_type
      into SOURCE_TYPE
      from T_PRODUCTS t
     where t.id = PRODUCT_ID;
     
    select t.scrap_factor into scrap_factor from sys_param t ;
  
    dbms_output.put_line('EXPAND_PRODUCT_BOM');
    /**
    * 1、插入数据库,根据层级判断
    * 2、判断主料、替代料的关系
    * 3、判断产品来源是否是<自生产>，如果是，则递归调用自己
    *
    */
  
    -- 自生产的递归调用,考虑死循环的情况，如果层级大约100，则不继续递归
    if (SOURCE_TYPE is not null and SOURCE_TYPE = 121 and TIER < 100) then
      -- 根据产品编号找到结构主表的primary_id
      bom_primary_id := getReleaseBOMByProductId(PRODUCT_ID);
      --找到产品结构
      if (bom_primary_id is not null) then
        --迭代产品结构，进行指定的操作
        for p in (select t.id,
                         t.primary_id,
                         t.sub_products_id,
                         t.is_main_products,
                         t.qty
                    from t_bom_detail t
                   where t.primary_id = bom_primary_id) loop
        
          select decode(TIER, 1, p.is_main_products, IS_MAIN_PRODUCT)
            into IS_MAIN_PRODUCT
            from dual;
            
          select decode(TIER, 1, round(p.qty * QTY * (1+scrap_factor)), p.qty * QTY)
            into bom_qty
            from dual;
        
          -- dbms_output.put_line(p.id);
          -- 查找产品的来源,如采购(120)，外加工(122)，自生产(121)
          select t.source_type
            into SOURCE_TYPE
            from T_PRODUCTS t
           where t.id = p.sub_products_id;
          -- 需要插入的ID
          select SEQUENCE_T_SALES_ORDER_BOM.nextval
            into insert_id
            from dual;
        
          -- 查询是否有主料、替代料
          select count(1)
            into sub_count
            from T_BOM_SUB t
           where t.primary_id = p.primary_id
             and t.main_products_id = p.sub_products_id;
             
          --获取产品结构id
          bom_sub_primary_id := getReleaseBOMByProductId(p.sub_products_id);
          
           
        
          --层级为1的时候,需要获取[是否为主要材料]值,计算主料、替代料,parentId
          --继承[是否是主要材料],计算主料、替代料,parentId
          insert into T_SALES_ORDER_BOM
            (ID,
             ORDER_ID,
             PRODUCTS_ID,
             PRODUCTS_BOM_ID,
             OWN_QTY,
             QTY,
             TIER,
             SOURCE_TYPE,
             PARENT_ID,
             IS_MAIN_PRODUCTS,
             MAIN_SUB)
          values
            (insert_id,
             SALES_ORDER_ID,
             p.sub_products_id,
             bom_sub_primary_id,
             p.qty,
             bom_qty,
             TIER,
             SOURCE_TYPE,
             PARENT_ID,
             IS_MAIN_PRODUCT,
             decode(sub_count, 0, '', 'Y'));
          commit;
          --dbms_output.put_line(2);
        
          temp_parent_id := insert_id;
        
          --添加替代料
          if (sub_count is not null and sub_count > 0) then
            for sub in (select t.sub_products_id,
                               t.qty,
                               t.primary_id,
                               t.main_products_id
                          from T_BOM_SUB t
                         where t.primary_id = p.primary_id
                           and t.main_products_id = p.sub_products_id) loop
            
              -- 产品来源                  
              select t.source_type
                into SOURCE_TYPE
                from T_PRODUCTS t
               where t.id = sub.sub_products_id;
              -- 需要插入的ID
              select SEQUENCE_T_SALES_ORDER_BOM.nextval
                into insert_id
                from dual;
                
          select decode(TIER, 1, round(sub.qty * QTY * (1+scrap_factor)), sub.qty * QTY)
            into bom_sub_qty
            from dual;
            
            sub_bom_primary_id := getReleaseBOMByProductId(sub.sub_products_id);
            
              --插入替代料   
              insert into T_SALES_ORDER_BOM
                (ID,
                 ORDER_ID,
                 PRODUCTS_ID,
                 PRODUCTS_BOM_ID,
                 OWN_QTY,
                 QTY,
                 TIER,
                 SOURCE_TYPE,
                 PARENT_ID,
                 IS_MAIN_PRODUCTS,
                 MAIN_PRODUCTS_ID,
                 MAIN_SUB)
              values
                (insert_id,
                 SALES_ORDER_ID,
                 sub.sub_products_id,
                 sub_bom_primary_id,
                 sub.qty,
                 bom_sub_qty,
                 TIER,
                 SOURCE_TYPE,
                 PARENT_ID,
                 IS_MAIN_PRODUCT,
                 sub.main_products_id,
                 'N');
              commit;
            
            end loop;
          end if;
        
          --递归调用存储过程，展开产品
          EXPAND_PRODUCT_BOM(SALES_ORDER_ID,
                             p.sub_products_id,
                             IS_MAIN_PRODUCT,
                             TIER + 1,
                             bom_qty,
                             temp_parent_id);
        
        end loop;
      end if;
    
    end if;
  end;
end EXPAND_PRODUCT_BOM;
/

prompt
prompt Creating procedure EXPAND_SALES_ORDER_BOM
prompt =========================================
prompt
create or replace procedure erp.expand_sales_order_bom(sales_order_id in number) as
begin
  declare
    --count_products number;
    input_id    number;
    SOURCE_TYPE varchar2(50); -- 来源,如采购(120)，外加工(122)，自生产(121)
    insert_id   number; -- 产品id
    bom_primary_id number; -- 产品结构中的主表id
  begin
    input_id := sales_order_id;
    --查询销售订单中的产品明细
    for so in (select t.id,
                      t.sales_order_id, -- 销售订单id
                      t.products_id, -- 产品编号
                      t.storage_number --数量
                 from T_SALES_ORDER_DETAIL t
                where t.sales_order_id = input_id) loop
      dbms_output.put_line(so.id || ' : ' || so.sales_order_id || ' : ' ||
                           so.products_id);
    
      select SEQUENCE_T_SALES_ORDER_BOM.nextval into insert_id from dual;
    
      select t.source_type
        into SOURCE_TYPE
        from T_PRODUCTS t
       where t.id = so.products_id;
       
       bom_primary_id := getReleaseBOMByProductId(so.products_id);
       
      --插入顶级的产品
      insert into T_SALES_ORDER_BOM
        (ID, ORDER_ID, PRODUCTS_ID,PRODUCTS_BOM_ID, QTY, OWN_QTY, TIER, SOURCE_TYPE)
      values
        (insert_id,
         so.sales_order_id,
         so.products_id,
         bom_primary_id,
         so.storage_number,
         so.storage_number,
         0,
         SOURCE_TYPE);
       commit;  
      --展开的每个产品                       
      EXPAND_PRODUCT_BOM(so.sales_order_id,
                         so.products_id,
                         '',
                         1,
                         so.storage_number,
                         insert_id);
    end loop;
  end;
end expand_sales_order_bom;
/


prompt
prompt Creating 任务单自动生成加工任务单和验收单
prompt =========================================
prompt
drop  procedure erp.task_Production_task;

--进程ID
create sequence SEQUENCE_procedure_id
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

drop table t_Material_requisition_TEMP;
 --领料临时表
   create table t_Material_requisition_TEMP 
(
   ID                   NUMBER               not null,
   PROCEDURE_ID         NUMBER，
   ProductionTaskID     NUMBER,
   Products_ID        NUMBER,
   MATERIAL_NUMBER    FLOAT
);

create or replace procedure task_Production_task(v_ProcessingSingleID number) as
begin
declare
       temp_procedure_id number;           --进程ID
       t_processingSingleID  number; -- 生产单id
       t_status number;          --生产单状态
       task_id number;           --生产任务主表ID
       task_detail_id number;    --生产任务单明细ID
       acceptanceList_id number; --验收单ID
       productionStorageID number;   --生产单入库ID
       t_dateChar char(8);
       bomPrimaryID number;   --销售订单产品结构ID
       order_id number;  --销售订单
       processingsingleid VARCHAR2(50); --加工单
       substitute_number FLOAT; --替代料数量
       main_product_number FLOAT;  --主产品数量
       Material_id number; --领料明细ID
       stock_Number FLOAT; --产品库存数量
       scrap_factor FLOAT; --损耗率
       cutting_number FLOAT;  --原材料数量
       isCutting    number;  --是否需要查找切割方案 (0 查找切割方案，不等于0的，直接查看结构子类)
       --processStr varcahr(500);
begin
        t_processingSingleID  := v_ProcessingSingleID;

    select t.status,purchase_order_id,processingsingleid  into t_status, order_id,processingsingleid from t_processing_single_primary t where t.id= t_processingSingleID;
    select to_char(sysdate,'yyyymmdd') into t_dateChar from dual;
        if(t_status = 1) then
           dbms_output.PUT_LINE('生成生产任务单');

           --损耗率
           select t.scrap_factor+1 into scrap_factor from sys_param t;

           --进程编号
            select SEQUENCE_procedure_id.nextval into temp_procedure_id from dual;

           --加工单明细列表
           for sub in (select processingsingleid,startdate, enddate
  from t_processing_single_detail t left join T_SALES_ORDER_BOM b on t.salesorderbomid=b.id
 where t.processingsingleid =t_processingSingleID and t.PRODUCTIONMARK = 0
 group by processingsingleid, startdate, enddate) loop
             dbms_output.PUT_LINE(sub.startdate);

             --获取生产任务主表ID
             select SEQUENCE_T_ProductionTask.nextval into task_id from dual;

             --插入主表数据
             insert into T_ProductionTask (ID,Production_order,Inventory_countID,STARTDATE,ENDDATE,Processingsingleid) values (task_id,t_dateChar || task_id ,t_processingSingleID,sub.startdate,sub.enddate,processingsingleid);

             --获取指定开始和结束日期的加工明细列表
             for task in ( select t.products_id,processingnumber,T.SALESORDERBOMID,b.main_sub,b.tier  from t_processing_single_detail t left join T_SALES_ORDER_BOM b on t.salesorderbomid=b.id where t.processingsingleid=t_processingSingleID  and t.productionmark=0 and startdate=sub.startdate and enddate=sub.enddate  order by b.tier) loop
                 --初始化替代料总数0
                 substitute_number :=0;

                 --查看是否拥有替代料
                 if(task.main_sub='Y') then
                    --获取替代料信息
                    for substitute in (select t.products_id from  T_SALES_ORDER_BOM t  where t.order_id=order_id and t.main_sub='N' and t.tier=task.tier and t.main_products_id=task.products_id) loop

                       --替代料库存数量
                       substitute_number:=getProducts_stock_Number(substitute.products_id);
                       if (substitute_number != 0) then
                         --领料明细
                         select SEQUENCE_t_Material_DETAIL.nextval into Material_id from dual;
                         insert into t_Material_requisition_TEMP (ID,PROCEDURE_ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) values (Material_id,temp_procedure_id,task_id,substitute.products_id,substitute_number*scrap_factor);
                         dbms_output.PUT_LINE('替代料库:' || task.products_id || '，领料生产数量：' || cutting_number);
                       end if;
                    end loop;
                 end if;

                 --获取产品库存数量
                 stock_Number := getProducts_stock_Number(task.products_id);
                 dbms_output.PUT_LINE('库存数量' || stock_Number);
                 --主产品需要生产的数量
                 main_product_number := getSalesOrderBOMProductNumber(task.SALESORDERBOMID);
                  dbms_output.PUT_LINE('结构ID：' || task.SALESORDERBOMID || '    生产数量' || main_product_number);
                 --库存数量大于需要生产的数量的时候，不需要进行生产
                 if(stock_Number < main_product_number) then

                                 --主产品实际需要生产的数量
                                 main_product_number := main_product_number - stock_Number;

                                 --获取生产任务明细表ID
                                 select SEQUENCE_T_Production_DETAIL.nextval into task_detail_id from dual;
                                 insert into T_PRODUCTIONTASK_DETAIL (id,productiontaskid,products_id,processingnumber)values(task_detail_id,task_id,task.products_id,task.processingnumber-substitute_number);

                                 --获取产品结构主键
                                 bomPrimaryID :=task.SALESORDERBOMID;

                                 for process in (select * from T_PRODUCTPROCESS pr left join t_process ce on pr.process_id = ce.id LEFT JOIN ( select id, bomP.Products_Id
               from t_bom_primary bomP where bomP.Eff_Status = '1' and bomP.Effdt =
                    (select Max(bomb.effdt) from t_bom_primary bomb where bomP.Eff_Status = bomb.eff_status)) bomA on bomA.id = pr.bomprimary_id
    where bomA.products_id=task.products_id) loop
                                    select SEQUENCE_T_AcceptanceList.nextval into acceptanceList_id from dual;
                                    insert into T_AcceptanceList (id,productiontaskid,products_id,processid,Isacceptance)values(acceptanceList_id,task_id,task.products_id,process.process_id,'0');
                                 end loop;

                                 --领料单数据初始化
                                 if(main_product_number > 0) then
                                        --判断当前产品是否拥有结构。没有的时候，去切割方案中获取原材料
                                        select count(id) into isCutting from t_sales_order_bom t where t.order_id=order_id and t.parent_id=task.salesorderbomid;
                                        if(isCutting > 0) then
                                               --获取结构子类的非自产产品
                                               for matreial in (select t.id,t.products_id,t.own_qty from t_sales_order_bom t where t.order_id=order_id and t.source_type ='120' and t.parent_id=task.salesorderbomid) loop
                                                    --领料明细
                                                   select SEQUENCE_t_Material_DETAIL.nextval into Material_id from dual;
                                                   select ceil(main_product_number*matreial.own_qty) into cutting_number from dual;
                                                   insert into t_Material_requisition_TEMP (ID,PROCEDURE_ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) values (Material_id,temp_procedure_id,task_id,matreial.products_id,cutting_number);
                                                  --dbms_output.PUT_LINE('非自产产品:' || task.products_id || '，领料生产数量：' || main_product_number*matreial.own_qty);
                                               end loop;

                                        else
                                               --查找切割方案
                                               dbms_output.PUT_LINE('查找切割方案:');
                                               for cutting in (select * from t_cutting_scheme t where t.main_products=task.products_id and rownum=1) loop
                                                   cutting_number:= (main_product_number)/cutting.man_number;
                                                   select ceil(cutting_number) into cutting_number from dual;
                                                   dbms_output.PUT_LINE('产品:' || task.products_id || '，实际需要生产数量：' || main_product_number || '原材料数量:' || cutting_number);
                                                   --领料明细
                                                     select SEQUENCE_t_Material_DETAIL.nextval into Material_id from dual;
                                                     insert into t_Material_requisition_TEMP (ID,PROCEDURE_ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) values (Material_id,temp_procedure_id,task_id,cutting.raw_materials,cutting_number);
                                                    dbms_output.PUT_LINE('切割产品:' || cutting.raw_materials || '，领料生产数量：' || cutting_number);

                                                    --生产入库单初始化(剩余料)
                                                    select SEQUENCE_t_productionStorage.nextval into productionStorageID from dual;
                                                    insert into t_productionStorage_DETAIL (id,processingsingleid,products_id,Processingnumber，warehouse_type) values(productionStorageID,t_processingSingleID,cutting.by_product,cutting_number*cutting.by_number,1);
                                               end loop;
                                        end if;

                                 end if;

                end if;
             end loop;
           end loop;

            --拷贝临时领料表到正式表
            Insert into T_MATERIAL_REQUISITION_DETAIL(ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) select ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER from t_Material_requisition_TEMP tem where tem.procedure_id=temp_procedure_id and tem.procedure_id=temp_procedure_id;

            --生产入库单初始化(成品)
            for psdet in (select * from t_sales_order_bom where tier=0 and order_id=order_id) loop
              select SEQUENCE_t_productionStorage.nextval into productionStorageID from dual;
              insert into t_productionStorage_DETAIL (id,processingsingleid,products_id,Processingnumber，warehouse_type) values(productionStorageID,t_processingSingleID,psdet.products_id,psdet.qty,0);
            end loop;



            --delete from t_Material_requisition_TEMP;
        else
           dbms_output.PUT_LINE('已经存在生产任务单');
        end if;
        commit;
end;
end task_Production_task;
/

--产品结构分解采购需求订单
delete from T_PROCUREMENT_DEMAND_PRIMARY t where t.order_id is not null;
delete from T_PROCUREMENT_DEMAND_DETAIL t ;

drop  procedure bom_Purchasing_demand;

create or replace procedure bom_Purchasing_demand(v_order_id number) as
begin
declare
       t_status number;          --是否已经生成采购需求清单状态
       procedure_id number;           --进程ID
       DEMAND_PRIMARY_ID number;   --采购需求清单头表ID
       DEMAND_DETAIL_ID  number;   --采购需求清单明细ID
       inspectionDate        varchar(20);  --销售订单检查日期
       userid            number;    --用户ID
       bom_order_id number;  --销售订单
       main_product_number FLOAT;  --主产品数量
       stock_Number FLOAT; --产品库存数量
       scrap_factor FLOAT; --损耗率
       cutting_number FLOAT;  --原材料数量
       isCutting    number;  --是否需要查找切割方案 (0 查找切割方案，不等于0的，直接查看结构子类)
       t_dateChar char(8);
begin
  DBMS_OUTPUT.ENABLE (buffer_size=>null);
        bom_order_id  := v_order_id;
        
        --判断当前采购订单是否已经生成过采购需求清单
        select count(1) into t_status from T_PROCUREMENT_DEMAND_PRIMARY t where t.order_id=bom_order_id;

        if (t_status=0) then
          dbms_output.PUT_LINE('开始计算采购需求单：' || bom_order_id );
          select to_char(sysdate,'yyyymmdd') into t_dateChar from dual;
          
          --损耗率
          select t.scrap_factor+1 into scrap_factor from sys_param t;
             
          --进程编号
          select SEQUENCE_procedure_id.nextval into procedure_id from dual;
          
          --获取销售订单信息
          select t.userid,t.inspection into userid,inspectionDate from T_SALES_ORDER_PRIMARY t where t.id=bom_order_id;
          
          --初始化采购需求清单表头
          select SEQUENCE_T_Procurement_PRIMARY.nextval into DEMAND_PRIMARY_ID from dual;
          insert into T_PROCUREMENT_DEMAND_PRIMARY (ID,CREATEDATE,LIMITDATE,USERID,ORDER_ID,STATUS,REMARKS) values (DEMAND_PRIMARY_ID,sysdate,to_date(inspectionDate,'yyyy-mm-dd'),userid,bom_order_id,1,'销售订单分解');

          --获取指定的采购订单
          for sub in (select * from  T_SALES_ORDER_BOM b where b.order_id =bom_order_id and b.tier!=0 and (b.main_sub is null or b.main_sub='Y')) loop
               
               --获取产品库存数量
               stock_Number := getProducts_stock_Number(sub.products_id);
               dbms_output.PUT_LINE('库存数量' || stock_Number);
               --主产品需要生产的数量
               main_product_number := getSalesOrderBOMProductNumber(sub.id);
               dbms_output.PUT_LINE('结构ID：' || sub.id || '    生产数量' || main_product_number);
               
                if(stock_Number < main_product_number) then

                  --主产品实际需要生产的数量
                  main_product_number := main_product_number - stock_Number;
                  if(sub.source_type=120) then
                    dbms_output.PUT_LINE('采购产品：' || sub.products_id );
                    --直接添加采购材料
                    select SEQUENCE_T_Procurement_DETAIL.nextval into DEMAND_DETAIL_ID from dual;
                    insert into T_PROCUREMENT_DEMAND_DETAIL (ID,PROCUREMENID,PRODUCTSID,DEMAND_NUMBER,REMARKS,ISMAINPRODUCTS) values (DEMAND_DETAIL_ID,DEMAND_PRIMARY_ID,sub.products_id,main_product_number,'',sub.is_main_products);
                  else
                    --自生产产品
                    dbms_output.PUT_LINE('自生产产品：' || sub.products_id );
                    --判断当前产品是否拥有结构。没有的时候，去切割方案中获取原材料
                    select count(id) into isCutting from t_sales_order_bom t where t.order_id=bom_order_id and t.parent_id=sub.id;
                    if(isCutting = 0) then
                         --查找切割方案
                         dbms_output.PUT_LINE('查找切割方案:');
                         for cutting in (select * from t_cutting_scheme t where t.main_products=sub.products_id and rownum=1) loop
                             cutting_number:= main_product_number/cutting.man_number;
                             select ceil(cutting_number) into cutting_number from dual;
                             dbms_output.PUT_LINE('产品:' || sub.products_id || '，实际需要生产数量：' || main_product_number || '原材料数量:' || cutting_number);
                             --添加采购材料
                             select SEQUENCE_T_Procurement_DETAIL.nextval into DEMAND_DETAIL_ID from dual;
                             insert into T_PROCUREMENT_DEMAND_DETAIL (ID,PROCUREMENID,PRODUCTSID,DEMAND_NUMBER,REMARKS,ISMAINPRODUCTS) values (DEMAND_DETAIL_ID,DEMAND_PRIMARY_ID,cutting.raw_materials,cutting_number,'切割原材料',sub.is_main_products);
                             dbms_output.PUT_LINE('切割产品:' || cutting.raw_materials || '，领料生产数量：' || cutting_number);
                         end loop;
                    end if;
                  end if;
                end if;
          end loop;
           
        else
            dbms_output.PUT_LINE('采购需求单已经存在：' || bom_order_id );
        end if;
        commit;
end;
end bom_Purchasing_demand;
/


spool off
