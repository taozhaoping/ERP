alter table T_Customer  drop primary key cascade;
alter table T_Products  drop primary key cascade;
/*alter table t_product_structure drop primary key cascade;*/
alter table t_Stock     drop primary key cascade;
alter table T_Storage_Primary drop primary key cascade;
alter table T_Storage_Detail   drop primary key cascade;
alter table T_BOM_PRIMARY      drop primary key cascade;
alter table T_BOM_DETAIL       drop primary key cascade;
alter table T_BOM_SUB          drop primary key cascade;
alter table t_library_Primary  drop primary key cascade;
alter table t_library_DETAIL   drop primary key cascade;
alter table T_SALES_ORDER_PRIMARY drop primary key cascade;
alter table T_Sales_order_DETAIL    drop primary key cascade;
alter table T_Cutting_scheme     drop primary key cascade;

drop table T_Cutting_scheme cascade constraints;
drop table T_Sales_order_DETAIL cascade constraints;
drop table T_SALES_ORDER_PRIMARY cascade constraints;
drop table t_library_DETAIL cascade constraints;
drop table t_library_Primary cascade constraints;
drop table T_BOM_SUB cascade constraints;
drop table T_BOM_DETAIL cascade constraints;
drop table T_BOM_PRIMARY cascade constraints;
drop table T_Storage_Detail cascade constraints;
drop table T_Storage_Primary cascade constraints;
drop table t_Stock cascade constraints;
drop table t_product_structure cascade constraints;
drop table T_Products cascade constraints;
drop table T_T_Customer cascade constraints;



drop sequence SEQUENCE_T_Customer;
drop sequence SEQUENCE_T_Products;
/*drop sequence SEQUENCE_t_product_structure;*/
drop sequence SEQUENCE_t_Stock;
drop sequence SEQUENCE_Position;
drop sequence SEQUENCE_T_Storage_Primary;
drop sequence SEQUENCE_T_Storage_Detail;
drop sequence SEQUENCE_T_BOM_PRIMARY;
drop sequence SEQUENCE_T_BOM_DETAIL;
drop sequence SEQUENCE_T_BOM_SUB;
drop sequence SEQUENCE_t_library_Primary;
drop sequence SEQUENCE_t_library_Detail;
drop sequence SEQUENCE_T_SALES_ORDER_PRIMARY
drop sequence SEQUENCE_T_Sales_order_DETAIL
drop sequence SEQUENCE_T_Cutting_scheme
/*==============================================================*/
/* 序列号                                                                                                                                                                           */
/*==============================================================*/
create sequence SEQUENCE_T_Customer
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_Products
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;
/*
create sequence SEQUENCE_t_product_structure
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;
*/
create sequence SEQUENCE_t_Stock
start with 10000
 maxvalue 999999999
 minvalue 10000
 cache 10
order;

/*库位序号*/
create sequence SEQUENCE_Position
start with 10000
 maxvalue 999999999
 minvalue 10000
 cache 10
order;


create sequence SEQUENCE_T_Storage_Primary
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_Storage_Detail
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_BOM_PRIMARY
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_BOM_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_BOM_SUB
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_t_library_Primary
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_t_library_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_SALES_ORDER_PRIMARY
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_Sales_order_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_Cutting_scheme
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;
/*==============================================================*/
/* Table: 客户资料                                            */
/*==============================================================*/
create table T_Customer 
(
   id                 number               not null,
   name               varchar(100),
   Legal_person       varchar(100),
   type               NUMBER,
   status             NUMBER,
   mail               varchar(50),
   iphone             varchar(30),
   fax_number         varchar(30),
   Address            varchar(100),
   lev                varchar(10),
   opening_bank       varchar(100),
   Bank_account       varchar(100)
);

comment on table T_Customer is
'客户资源信息';

comment on column T_Customer.id is
'客户编号';

comment on column T_Customer.name is
'客户名称';

comment on column T_Customer.Legal_person is
'法人';

comment on column T_Customer.type is
'客户类型';

comment on column T_Customer.status is
'客户状态';

comment on column T_Customer.mail is
'邮箱';

comment on column T_Customer.iphone is
'电话号码';

comment on column T_Customer.fax_number is
'传真号';

comment on column T_Customer.Address is
'地址';

comment on column T_Customer.lev is
'客户等级';

comment on column T_Customer.opening_bank is
'开户银行';

comment on column T_Customer.Bank_account is
'银行账号';

alter table T_Customer
   add constraint PK_T_Customer primary key (id);
   
/*==============================================================*/
/* Table: 产品信息                                                                                                                                                  */
/*==============================================================*/
create table T_PRODUCTS
(
  id                  NUMBER not null,
  name                VARCHAR2(100),
  long_degree         FLOAT,
  wide_degree         FLOAT,
  specifications      VARCHAR2(100),
  surface_treatment   VARCHAR2(100),
  paint               VARCHAR2(100),
  ispaint             NUMBER,
  measurement_company NUMBER,
  source_type         VARCHAR2(50),
  approvaluserid      NUMBER,
  product_type        NUMBER not null,
  processing_fee      FLOAT,
  estimated_price     FLOAT,
  sales_price         FLOAT,
  safety_stock        NUMBER  default 0,
  createdate          DATE,
  updatedate          DATE,
  userid              NUMBER,
  remarks             VARCHAR2(500),
  approval            VARCHAR2(1),
  Position           NUMBER
)

comment on table T_Products is
'产品信息';

comment on column T_Products.ID is
'产品编码';

comment on column T_Products.NAME is
'名称';

comment on column T_Products.Long_Degree is
'长度';

comment on column T_Products.Wide_Degree is
'宽度';

comment on column T_Products.Specifications is
'规格';

comment on column T_Products.Surface_treatment is
'表面处理';

comment on column T_Products.Paint is
'颜色';

comment on column T_Products.isPaint is
'是否油漆';

comment on column T_Products.Measurement_Company is
'计量单位';

comment on column T_Products.Source_type is
'来源,如采购，委外加工，自加工，';

comment on column T_Products.approval is
'是否审核';

comment on column T_Products.approvalUSERID is
'审核用户';

comment on column T_Products.product_type is
'产品类型';

comment on column T_Products.processing_fee is
'成本';

comment on column T_Products.Estimated_price is
'采购价';

comment on column T_Products.Sales_price is
'销售价';

comment on column T_Products.Safety_stock is
'安全库存数量';

comment on column T_Products.createDate is
'创建时间';

comment on column T_Products.updateDate is
'修改时间';

comment on column T_Products.userID is
'更新用户';

comment on column T_Products.Remarks is
'备注';

alter table T_Products
   add constraint PK_T_Products primary key (ID);
   

/*==============================================================*/
/* Table:  产品结构                                                                                                                                               */
/*==============================================================*/
/*create table t_product_structure 
(
   ID                 NUMBER               not null,
   ProductsID         NUMBER,
   Sub_productsID     NUMBER,
   isMainProducts     NUMBER,
   group_id           NUMBER,
   ma_al_meterials    NUMBER,
   PRODUCTS_NUMBER      NUMBER,
   createDate         varchar2(20),
   updateDate         varchar2(20)
);

comment on table t_product_structure is
'产品结构清单';

comment on column t_product_structure.ID is
'主键';

comment on column t_product_structure.ProductsID is
'产品主键';

comment on column t_product_structure.Sub_productsID is
'子产品主键';

comment on column t_product_structure.isMainProducts is
'是否主要产品';

comment on column t_product_structure.group_id is
'组';

comment on column t_product_structure.ma_al_meterials is
'主料或替代料';

comment on column t_product_structure.PRODUCTS_NUMBER is
'数量';

alter table t_product_structure
   add constraint PK_t_product_structure primary key (ID);
   */
   
/*==============================================================*/
/* Table: 库存信息	                                                */
/*==============================================================*/
create table t_Stock 
(
   id                 NUMBER               not null,
   Position           NUMBER               not null,
   PRODUCTS_ID          NUMBER,
   Warehouse_ID       NUMBER,
   Stock_number       FLOAT           default 0
);

comment on table t_Stock is
'库存信息';

comment on column t_Stock.id is
'主键';

comment on column t_Stock.Position is
'库位';

comment on column t_Stock.PRODUCTS_ID is
'商品编号';

comment on column t_Stock.Warehouse_ID is
'所属仓库';

comment on column t_Stock.t_Stock_number is
'库存数量';

alter table t_Stock
   add constraint PK_t_Stock primary key (id);
   
   
/*==============================================================*/
/* Table: 入库头表                                                                                                                                                 */
/*==============================================================*/
create table T_Storage_Primary 
(
   ID                   NUMBER,
   Order_No_id        varchar2(50),
   Storage_Date       varchar2(20),
   Purchase_order_ID  varchar2(50),
   UserID             NUMBER,
   Warehouse_ID       NUMBER,
   mount_meoey        FLOAT,
   Remarks            VARCHAR2(500),
   Customer_ID        NUMBER,
   createDate         varchar2(20),
   updateDate         varchar2(20),
  status            NUMBER
);
alter table T_Storage_Primary
   add constraint PK_T_STORAGE_HEADER primary key (ID);
   
comment on table T_Storage_Primary is
'入库信息_主表';

comment on column T_Storage_Primary.ID is
'主键';

comment on column T_Storage_Primary.Order_No_id is
'入库单号';

comment on column T_Storage_Primary.Storage_Date is
'入库时间';

comment on column T_Storage_Primary.Purchase_order_ID is
'对应单据';

comment on column T_Storage_Primary.UserID is
'收货人';

comment on column T_Storage_Primary.Warehouse_ID is
'收入仓库';

comment on column T_Storage_Primary.mount_meoey is
'金额';

comment on column T_Storage_Primary.Remarks is
'备注';

comment on column T_Storage_Primary.Customer_ID is
'发货客户';

comment on column T_Storage_Primary.createDate is
'创建时间';

comment on column T_Storage_Primary.updateDate is
'修改时间';
comment on column T_STORAGE_PRIMARY.status
  is '是否入库';
  
/*==============================================================*/
/* Table: 入库明细表                                                                                                                                              */
/*==============================================================*/
create table T_Storage_Detail 
(
   ID                   NUMBER,
   STORAGEPRIMARYID        NUMBER,
   Products_ID        NUMBER,
   Position           NUMBER,
   Storage_number     NUMBER,
   Use                VARCHAR2(100),
   Remarks            varchar2(500)
);
alter table T_Storage_Detail
   add constraint PK_T_STORAGE_BODY primary key (ID);
   
comment on table T_Storage_Detail is
'入库信息_明细表';

comment on column T_Storage_Detail.ID is
'主键';

comment on column T_Storage_Detail.STORAGEPRIMARYID is
'入库表头主建';

comment on column T_Storage_Detail.Products_ID is
'产品编号';

comment on column T_Storage_Detail.Position is
'库位';

comment on column T_Storage_Detail.Storage_number is
'入库数量';

comment on column T_Storage_Detail.Use is
'用途';

comment on column T_Storage_Detail.Remarks is
'备注';

/*==============================================================*/
/* Table: 产品结构_表头                                         */
/*==============================================================*/
create table T_BOM_PRIMARY 
(
   ID                   NUMBER	not null,
   PRODUCTS_ID        	NUMBER,
   DESCR                VARCHAR(500),
   EFFDT                VARCHAR(40),
   EFF_STATUS           VARCHAR(1)
);

comment on table T_BOM_PRIMARY is
'产品结构头表';

comment on column T_BOM_PRIMARY.ID is
'主键';

comment on column T_BOM_PRIMARY.PRODUCTS_ID is
'主产品编号';

comment on column T_BOM_PRIMARY.DESCR is
'描述';

comment on column T_BOM_PRIMARY.EFFDT is
'生效日期';

comment on column T_BOM_PRIMARY.EFF_STATUS is
'生效状态';

alter table T_BOM_PRIMARY
   add constraint PK_T_BOM_PRIMARY primary key (ID);

   
/*==============================================================*/
/* Table: 产品结构明细                                          */
/*==============================================================*/
create table T_BOM_DETAIL
(
  ID            	 NUMBER not null,
  PRIMARY_ID  		 NUMBER,
  SUB_PRODUCTS_ID	 NUMBER,
  POSITION      	 NUMBER,
  IS_MAIN_PRODUCTS	 NUMBER,
  QTY            	 FLOAT,
  REMARKS        	 VARCHAR2(500)
)

comment on table T_BOM_DETAIL
  is '产品结构清单';
-- Add comments to the columns 
comment on column T_BOM_DETAIL.ID
  is '主键';
comment on column T_BOM_DETAIL.PRIMARY_ID
  is '产品结构头表主建';
comment on column T_BOM_DETAIL.SUB_PRODUCTS_ID
  is '子产品主键';
comment on column T_BOM_DETAIL.POSITION
  is '仓库位号';
comment on column T_BOM_DETAIL.IS_MAIN_PRODUCTS
  is '是否主要产品';
comment on column T_BOM_DETAIL.QTY
  is '数量';

alter table T_BOM_DETAIL
   add constraint PK_T_BOM_DETAIL primary key (ID);

/*==============================================================*/
/* Table: bom替代料表                                             */
/*==============================================================*/
create table T_BOM_SUB 
(
   ID					NUMBER               not null,
   PRIMARY_ID			NUMBER,
   MAIN_PRODUCTS_ID    	NUMBER,
   SUB_PRODUCTS_ID     	NUMBER,
   QTY					FLOAT,
   REMARKS            	VARCHAR2(500),
   POSITION           	NUMBER
);

comment on table T_BOM_SUB is
'替代料产品结构清单';

comment on column T_BOM_SUB.ID is
'主键';

comment on column T_BOM_SUB.PRIMARY_ID is
'产品结构主表主键';

comment on column T_BOM_SUB.MAIN_PRODUCTS_ID is
'主料产品主键';

comment on column T_BOM_SUB.SUB_PRODUCTS_ID is
'子产品主键';

comment on column T_BOM_SUB.QTY is
'数量';

comment on column T_BOM_SUB.REMARKS is
'备注';

comment on column T_BOM_SUB.POSITION is
'仓库位号';

alter table T_BOM_SUB
   add constraint PK_T_BOM_SUB primary key (ID);

/*==============================================================*/
/* Table: 出库头表                                                                                                                                                  */
/*==============================================================*/
create table t_library_Primary 
(
   ID                   NUMBER               not null,
   Order_No_id        varchar2(50),
   Purchase_order_ID  varchar2(50),
   library_Date       varchar2(20),
   UserID             NUMBER,
   Warehouse_ID       NUMBER,
   mount_meoey        FLOAT,
   Remarks            VARCHAR2(500),
   Customer_ID        NUMBER,
   createDate         varchar2(20),
   updateDate         varchar2(20),
   STATUS               NUMBER
);

comment on table t_library_Primary is
'出库信息主表';

comment on column t_library_Primary.ID is
'主键';

comment on column t_library_Primary.Order_No_id is
'出单号';

comment on column t_library_Primary.Purchase_order_ID is
'对应单据';

comment on column t_library_Primary.library_Date is
'出库时间';

comment on column t_library_Primary.UserID is
'出货人';

comment on column t_library_Primary.Warehouse_ID is
'出货仓库';

comment on column t_library_Primary.mount_meoey is
'金额';

comment on column t_library_Primary.Remarks is
'备注';

comment on column t_library_Primary.Customer_ID is
'接收客户';

comment on column t_library_Primary.createDate is
'创建时间';

comment on column t_library_Primary.updateDate is
'修改时间';

comment on column t_library_Primary.STATUS is
'状态';

alter table t_library_Primary
   add constraint PK_T_LIBRARY_PRIMARY primary key (ID);

/*==============================================================*/
/* Table: 出库明细                                              */
/*==============================================================*/
create table t_library_DETAIL 
(
   ID                   NUMBER               not null,
   LIBRARYPRIMARYID        varchar2(50),
   Products_ID        NUMBER,
   Position           NUMBER,
   Storage_number     NUMBER,
   Use                VARCHAR2(100),
   Remarks            varchar2(500)
);

comment on table t_library_DETAIL is
'出库信息_明细表';

comment on column t_library_DETAIL.ID is
'主键';

comment on column t_library_DETAIL.LIBRARYPRIMARYID is
'出库单号';

comment on column t_library_DETAIL.Products_ID is
'产品编号';

comment on column t_library_DETAIL.Position is
'仓位';

comment on column t_library_DETAIL.Storage_number is
'出库数量';

comment on column t_library_DETAIL.Use is
'用途';

comment on column t_library_DETAIL.Remarks is
'备注';

alter table t_library_DETAIL
   add constraint PK_T_LIBRARY_DETAIL primary key (ID);
   
/*==============================================================*/
/* Table: 销售订单                                                                                                                                                  */
/*==============================================================*/
create table T_SALES_ORDER_PRIMARY 
(
   ID                   NUMBER               not null,
   order_id           VARCHAR(50),
   Customer_ID        NUMBER,
   Payment_term       NUMBER,
   Inspection         VARCHAR(20),
   LRDDATE              VARCHAR(20),
   Container_type     VARCHAR(20),
   Loading_port       VARCHAR(50),
   Discharge_port     VARCHAR(50),
   STATUS               NUMBER,
   Price              FLOAT,
   createDate         VARCHAR(20),
   updateDate         VARCHAR(20),
   Remarks            varchar2(500),
   currency_payment   NUMBER,
   userID             NUMBER,
   contractNumber     VARCHAR(50)
);

comment on table T_SALES_ORDER_PRIMARY is
'销售订单';

comment on column T_SALES_ORDER_PRIMARY.ID is
'主键';

comment on column T_SALES_ORDER_PRIMARY.order_id is
'销售订单';

comment on column T_SALES_ORDER_PRIMARY.Customer_ID is
'客户主键';

comment on column T_SALES_ORDER_PRIMARY.Payment_term is
'付款方式';

comment on column T_SALES_ORDER_PRIMARY.Inspection is
'检查日期';

comment on column T_SALES_ORDER_PRIMARY.LRDDATE is
'进港日期';

comment on column T_SALES_ORDER_PRIMARY.Container_type is
'集装箱号';

comment on column T_SALES_ORDER_PRIMARY.Loading_port is
'装货港口';

comment on column T_SALES_ORDER_PRIMARY.Discharge_port is
'卸货港口';

comment on column T_SALES_ORDER_PRIMARY.STATUS is
'订单状态';

comment on column T_SALES_ORDER_PRIMARY.Price is
'总价';

comment on column T_SALES_ORDER_PRIMARY.createDate is
'创建时间';

comment on column T_SALES_ORDER_PRIMARY.updateDate is
'修改时间';

comment on column T_SALES_ORDER_PRIMARY.Remarks is
'备注';

comment on column T_SALES_ORDER_PRIMARY.currency_payment is
'付款货币';

comment on column T_SALES_ORDER_PRIMARY.contractNumber is
'合同单号';

alter table T_SALES_ORDER_PRIMARY
   add constraint PK_T_SALES_ORDER_PRIMARY primary key (ID);


/*==============================================================*/
/* Table: T_Sales_order_DETAIL                                */
/*==============================================================*/
create table T_Sales_order_DETAIL 
(
   ID                   NUMBER               not null,
   Sales_order_id     varchar2(20),
   Products_ID        NUMBER,
   Position           NUMBER,
   Storage_number     NUMBER,
   Unit_price         FLOAT,
   Order_value        FLOAT,
   FSC_type           VARCHAR2(100),
   Remarks            varchar2(500)
);

comment on table T_Sales_order_DETAIL is
'销售订单_明细表';

comment on column T_Sales_order_DETAIL.ID is
'主键';

comment on column T_Sales_order_DETAIL.Sales_order_id is
'入库单号';

comment on column T_Sales_order_DETAIL.Products_ID is
'产品编号';

comment on column T_Sales_order_DETAIL.Position is
'库位';

comment on column T_Sales_order_DETAIL.Storage_number is
'入库数量';

comment on column T_Sales_order_DETAIL.FSC_type is
'用途';

comment on column T_Sales_order_DETAIL.Remarks is
'备注';

comment on column T_Sales_order_DETAIL.Unit_price is
'单价';

comment on column T_Sales_order_DETAIL.Order_value is
'总价';

alter table T_Sales_order_DETAIL
   add constraint PK_T_SALES_ORDER_DETAIL primary key (ID);
   
/*==============================================================*/
/* Table: 切割方案					                                */
/*==============================================================*/
create table T_Cutting_scheme 
(
   ID                   NUMBER               not null,
   NAME                 VARCHAR(30),
   main_products      NUMBER,
   MAN_NUMBER           NUMBER,
   By_product         NUMBER,
   By_NUMBER          NUMBER,
   enabled            NUMBER
);

comment on table T_Cutting_scheme is
'切割方案';

comment on column T_Cutting_scheme.ID is
'方案编报';

comment on column T_Cutting_scheme.NAME is
'方案名称';

comment on column T_Cutting_scheme.main_products is
'主产品编号';

comment on column T_Cutting_scheme.MAN_NUMBER is
'主产品数量';

comment on column T_Cutting_scheme.By_product is
'副产品';

comment on column T_Cutting_scheme.By_NUMBER is
'副产品数量';

comment on column T_Cutting_scheme.enabled is
'状态';
alter table T_Cutting_scheme
   add constraint PK_T_Cutting_scheme primary key (ID);

