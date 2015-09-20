--获取产品库存数量
drop  function getProducts_stock_Number;
--获取产品库存数量
create or replace function getProducts_stock_Number(v_productId number)
  return number is
  stockNumber     number; --库存数量
  material_number number; --领料单数量
  productId number;
  --根据产品的编号查询最新库存剩余数
begin
  stockNumber:=0;
  productId := v_productId;
  if (productId is not null) then
    --库存数量
    select sum(st.stock_number) into stockNumber from t_stock st where st.products_id=productId group by st.products_id;
    
    --领料单数量
    select sum(m.material_number) into material_number from t_material_requisition_detail m left join t_productiontask t on m.productiontaskid=t.id where m.products_id=productId and t.status='0' group by m.products_id;
    stockNumber := stockNumber - material_number;
    
    --待货中的物料
  end if;
  return(stockNumber);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    return(stockNumber);
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
                stockNumber := bom.qty - getProducts_stock_Number(bom.products_id);
                stockNumber:=stockNumber*scrap_factor;
    else
                stockNumber := stockNumber * bom.own_qty;
                --减去替代料
                if(bom.main_sub='Y') then
                        for sub in (select t.products_id from  T_SALES_ORDER_BOM t where t.order_id=bom.order_id and t.main_sub='N' and t.tier=bom.tier and t.main_products_id=bom.products_id) loop
                            stockNumber:= stockNumber - getProducts_stock_Number(sub.products_id);
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
