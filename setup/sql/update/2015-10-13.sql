
--入库明细添加跟采购订单明细对应的主键  TZP
alter   table   T_STORAGE_DETAIL   add(PURCHASEORDERID   number);
comment on column T_STORAGE_DETAIL.PURCHASEORDERID is
'采购订单明细ID';