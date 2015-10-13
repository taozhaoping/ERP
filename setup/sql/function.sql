--获取产品库存数量
drop  function getProducts_stock_Number;
--获取产品库存数量
create or replace function getProducts_stock_Number(v_productId number,
                                                    v_orderID   number)
  return number is
  stockNumber      number; --库存数量
  demand_number    number; --所有订单实际采购需求数量
  order_bom_number number; --采购订单采购需求数量
  storage_Number   number; --采购需求已经采购数量
  Excess_number    number; --实际采购超额采购数量
  material_number  number; --领料单数量
  material_count   number;
  demand_count     number;
  storageCount     number;
  order_bom_Count  number;
  order_number     number; --订单数量
  productId        number; --产品编号
  orderID          number; --订单编号
  scrap_factor     number; --损耗率
  --根据产品的编号查询最新库存剩余数
begin
  stockNumber := 0;
  productId   := v_productId;
  orderID     := v_orderID;

  --损耗率
  select t.scrap_factor + 1 into scrap_factor from sys_param t;

  if (productId is not null) then
  
    --库存数量
    select sum(st.stock_number)
      into stockNumber
      from t_stock st
     where st.products_id = productId
     group by st.products_id;
  
    --实际采购需求数量
    select count(d.id)
      into demand_count
      from t_procurement_demand_detail d
      left join t_procurement_demand_primary dp
        on d.procuremenid = dp.id
        and dp.order_id is not null
     where d.productsid = productId;
  
    if (demand_count > 0) then
      select sum(d.demand_number)
        into demand_number
        from t_procurement_demand_detail d
        left join t_procurement_demand_primary dp
          on d.procuremenid = dp.id
       where d.productsid = productId
       and dp.order_id is not null
       group by d.productsid;
    
      stockNumber := stockNumber + demand_number;
    end if;
  
    --销售订单采购数量
    select count(t.id)
      into order_bom_Count
      from T_SALES_ORDER_BOM t
     where t.order_id != orderID
       and t.tier != 0
       and t.products_id = productId;
  
    if (order_bom_Count > 0) then
      select sum(t.qty)
        into order_bom_number
        from T_SALES_ORDER_BOM t
       where t.order_id != orderID
         and t.products_id = productId
         and t.tier != 0
       group by t.products_id;
    
      stockNumber := stockNumber - order_bom_number;
    end if;
  
    --实际采购需求入库数量
    select count(s.id)
      into storageCount
      from T_Procurement_Demand_DETAIL S
      left join (select procurementid,
                        productsid,
                        sum(purchase_number) storageNumber
                   from t_purchaseorder_detail pd
                   left join t_purchaseorder_primary pp
                     on pd.purchaseorderid = pp.id
                  where pp.status = 3
                  group by procurementid, productsid) sp
        on s.id = sp.procurementid
     where sp.storageNumber > 0
       and s.productsid = productId;
    if (storageCount > 0) then
      select sum(sp.storageNumber)
        into storage_Number
        from T_Procurement_Demand_DETAIL S
        left join (select procurementid,
                          productsid,
                          sum(purchase_number) storageNumber
                     from t_purchaseorder_detail pd
                     left join t_purchaseorder_primary pp
                       on pd.purchaseorderid = pp.id
                    where pp.status = 3
                    group by procurementid, productsid) sp
          on s.id = sp.procurementid
       where sp.storageNumber > 0
         and s.productsid = productId
         group by s.productsid;
    
      stockNumber := stockNumber - storage_Number;
      
       --实际采购超额采购数量
     select sum(sp.storageNumber - s.demand_number)
        into Excess_number
        from T_Procurement_Demand_DETAIL S
        left join (select procurementid,
                          productsid,
                          sum(purchase_number) storageNumber
                     from t_purchaseorder_detail pd
                     left join t_purchaseorder_primary pp
                       on pd.purchaseorderid = pp.id
                    where pp.status = 3
                    group by procurementid, productsid) sp
          on s.id = sp.procurementid
       where sp.storageNumber > 0
         and s.productsid = productId
         group by s.productsid;
         stockNumber := stockNumber + Excess_number;
         
    end if;
    
   
  end if;
  return(stockNumber);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    return(0);
end getProducts_stock_Number;
/

--获取产品结构ID
drop  function getReleaseBOMByProductId;
create or replace function getReleaseBOMByProductId(v_productId number)
  return number is
  retId     number;
  productId number;
  --根据产品的编号查询最新发放且审核过的结构id
begin
  productId := v_productId;
  if (productId is not null) then
    select t.ID
      into retId
    --t.PRODUCTS_ID, t.DESCR, t.EFFDT, t.EFF_STATUS
      from T_BOM_PRIMARY t
     where t.EFF_STATUS = '1'
       and t.effdt < to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')
       and t.PRODUCTS_ID = productId
       and rownum = 1
     order by t.EFFDT desc;
  end if;
  return(retId);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    --retId:='';
    --When Others Then
    --retId:='';
    return(retId);
end getReleaseBOMByProductId;
/

--获取产品实际生产数量
drop  function getSalesOrderBOMProductNumber;
create or replace function getSalesOrderBOMProductNumber(sales_order_bom_id number)
  return number is
  stockNumber number; --数量
  scrap_factor FLOAT;
begin
  stockNumber := 0;
  select t.scrap_factor+1 into scrap_factor from sys_param t;
  for bom in (select * from t_sales_order_bom t start wITh id = sales_order_bom_id connect by prior t.parent_id = t.id order by tier) loop
    if(bom.tier = 0) then
                stockNumber := bom.qty - getProducts_stock_Number(bom.products_id,bom.order_id);
                stockNumber:=stockNumber*scrap_factor;
    else
                stockNumber := stockNumber * bom.own_qty;
                --减去替代料
                if(bom.main_sub='Y') then
                        for sub in (select t.products_id from  T_SALES_ORDER_BOM t where t.order_id=bom.order_id and t.main_sub='N' and t.tier=bom.tier and t.main_products_id=bom.products_id) loop
                            stockNumber:= stockNumber - getProducts_stock_Number(sub.products_id,bom.order_id);
                        end loop;
                end if;
    end if;

  end loop;

  --小数点进已
  select ceil(stockNumber) into stockNumber from dual;

  return(stockNumber);

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    --retId:='';
    --When Others Then
    --retId:='';
    return(-1);
end getSalesOrderBOMProductNumber;
/
