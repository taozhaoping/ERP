
set define off
spool job.log

prompt
prompt 定时执行采购需求采购情况(每天凌晨)
prompt ==========================================
prompt

--select job, broken, what, interval, t.* from user_jobs t;

--show parameter job


create or replace procedure erp.task_Purchasing_demand as
begin
declare
       orderID  number; -- 销售订单编号
       isMainProducts  number; -- 销售订单编号
       Demand_Number  number; -- 销售订单编号
       placeOrderNumber  number; -- 销售订单编号
       notPlaceOrderNumber  number; -- 销售订单编号
       storageNumber  number; -- 销售订单编号
begin
       --获取状态在处理中的所有采购需求头表数据
      for sub in (select id from t_procurement_demand_primary where status = 0) loop
          for demandObject in (
          select 
                   orderID,
                   isMainProducts,
                   Demand_Number,
                   placeOrderNumber,
                   notPlaceOrderNumber,
                   storageNumber
           from (select S.ID,
                         ProcuremenID,
                         p.order_id as orderID,
                         s.ProductsID,
                         isMainProducts,
                         Demand_Number,
                         CASE
                           WHEN o.purchase_number is null then
                            0
                           when o.purchase_number is not null then
                            o.purchase_number
                         end as placeOrderNumber,
                         CASE
                           WHEN o.purchase_number is null THEN
                            s.demand_number
                           WHEN o.purchase_number is not null THEN
                            s.demand_number - o.purchase_number
                         END as notPlaceOrderNumber,
                         sp.storageNumber
                    from T_Procurement_Demand_DETAIL S
                    LEFT JOIN t_Procurement_Demand_Primary p
                      on s.procuremenid = p.id
                    left join (select procurementid,
                                     productsid,
                                     sum(purchase_number) purchase_number
                                from t_purchaseorder_detail
                               group by procurementid, productsid) o
                      on s.id = o.procurementid
                    left join (select procurementid,
                                     productsid,
                                     sum(purchase_number) storageNumber
                                from t_purchaseorder_detail pd
                                left join t_purchaseorder_primary pp
                                  on pd.purchaseorderid = pp.id
                               where pp.status = 2
                               group by procurementid, productsid) sp
                      on s.id = sp.procurementid)
           where ProcuremenID = sub.id ) loop
          dbms_output.PUT_LINE(demandObject.Demand_Number);
          end loop;
      end loop;
end;
end task_Purchasing_demand;
/

--输出信息
set serveroutput on

exec erp.task_Purchasing_demand;



drop  procedure erp.task_purchasing_demand;