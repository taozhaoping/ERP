
set define off
spool job.log

prompt
prompt 定时执行采购需求采购情况(每天凌晨)
prompt ==========================================
prompt

--select job, broken, what, interval, t.* from user_jobs t;

--show parameter job

--删除job
--exec dbms_job.remove(jobID)

--输出日记
--set serveroutput on


drop  procedure erp.task_purchasing_demand;

create or replace procedure task_Purchasing_demand as
begin
  declare
    isProd number; -- 所有采购是否采购完成
  begin
    --获取状态在处理中的所有采购需求头表数据
    for sub in (select id, order_id
                  from t_procurement_demand_primary
                 where status = 1) loop
      isProd := 0;
      dbms_output.PUT_LINE(isProd);
      for demandObject in (select dd.ProductsID,
                                  isMainProducts,
                                  Demand_Number,
                                  nvl(v.storageNumber, 0) storageNumber
                             from t_procurement_demand_detail dd
                             left join (select pd.procurementid,
                                              sum(sd.storage_number) storageNumber
                                         from t_purchaseorder_detail pd
                                         left join t_purchaseorder_primary pp
                                           on pd.purchaseorderid = pp.id
                                         left join t_storage_detail sd
                                           on pd.id = sd.purchaseorderid
                                        where pp.status = 3
                                        group by pd.procurementid) v
                               on dd.id = v.procurementid
                            where dd.ProcuremenID = sub.id) loop
        --处理数据
        if (isProd = 0) then
          if (demandObject.storageNumber<demandObject.Demand_Number) then
            isProd := 1;
            dbms_output.PUT_LINE('未完成');
            exit;
          end if;
        end if;
      end loop;
      if (isProd = 0) then
        --修改当前采购需求单状态
        update t_Procurement_Demand_Primary
           set status = 2
         where id = sub.id;
        update T_SALES_ORDER_PRIMARY
           set status = 2
         where id = sub.order_id;
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
					,'task_purchasing_demand;'
					,sysdate
					,'sysdate+1/1440' --测试
					--,'TRUNC(sysdate) + 1 +1/ (24)'  --正式 每天一点执行
					);	
  commit;
end;

create or replace procedure task_Production_Decom as
begin
declare
       isProd  number; -- 所有采购是否采购完成
begin
       --分解加工单到生产任务单
      for sub in (select * from t_processing_single_primary p where p.status=1 and exists (select 1 from T_ProductionTask t where p.id!=t.inventory_countid)) loop
        isProd  := 0;
        task_Production_task(sub.id);
      end loop;
end;
end task_Production_Decom;
/

--添加作业
declare
  job1 number;
begin
sys.dbms_job.submit(job1
					,'task_Production_Decom;'
					,sysdate
					,'sysdate+1/1440' --测试
					--,'TRUNC(sysdate) + 1 +1/ (24)'  --正式 每天一点执行
					);	
  commit;
end;
