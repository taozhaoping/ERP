
set define off
spool job.log

prompt
prompt 定时执行采购需求采购情况(每天凌晨)
prompt ==========================================
prompt

--select job, broken, what, interval, t.* from user_jobs t;

--show parameter job


drop  procedure erp.task_purchasing_demand;

create or replace procedure erp.task_Purchasing_demand as
begin
declare
       isProd  number; -- 所有采购是否采购完成
begin
       --获取状态在处理中的所有采购需求头表数据
      for sub in (select id from t_procurement_demand_primary where status = 1) loop
        isProd  := 0;
        dbms_output.PUT_LINE(isProd);
          for demandObject in (
         select p.order_id as orderID,
       s.ProductsID,
       isMainProducts,
       Demand_Number,
       nvl(sp.storageNumber,0) storageNumber 
  from T_Procurement_Demand_DETAIL S
  LEFT JOIN t_Procurement_Demand_Primary p
    on s.productsid = p.id
  left join (select procurementid,
                    productsid,
                    nvl(sum(purchase_number),0) storageNumber
               from t_purchaseorder_detail pd
               left join t_purchaseorder_primary pp
                 on pd.purchaseorderid = pp.id
              where pp.status = 3
              group by procurementid, productsid) sp
    on s.id = sp.procurementid
 where ProcuremenID = sub.id ) loop
                   --处理数据
                 if(isProd = 0) then
                   if (demandObject.Demand_Number != demandObject.storageNumber) then  
                     isProd  := 1;
                     dbms_output.PUT_LINE('未完成');
                     exit;
                   end if;
                 end if;
          end loop;
          if(isProd = 0) then
               --修改当前采购需求单状态
               update t_Procurement_Demand_Primary set status = 2 where id = sub.id;
                dbms_output.PUT_LINE('完成');
               commit;
          end if;
      end loop;
end;
end task_Purchasing_demand;
/



set serveroutput on

exec erp.task_Purchasing_demand;

--添加作业
declare
  job1 number;
begin
sys.dbms_job.submit(job1
					,'erp.task_purchasing_demand;'
					,sysdate
					--,'sysdate+1/1440' --测试
					,'TRUNC(sysdate) + 1 +1/ (24)'  --正式 每天一点执行
					);
					--		
  commit;
end;