--获取产品库存数量
create or replace function getProducts_stock_Number(v_productId number)
  return number is
  stockNumber     number;
  productId number;
  --根据产品的编号查询最新库存剩余数
begin
  productId := v_productId;
  if (productId is not null) then
    select sum(st.stock_number) into stockNumber from t_stock st where st.products_id=productId group by st.products_id;
  end if;
  return(stockNumber);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    return(stockNumber);
end getProducts_stock_Number;

--获取产品结构ID
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
