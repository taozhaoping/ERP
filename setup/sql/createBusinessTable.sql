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
alter table T_SALES_ORDER_BOM    drop primary key cascade;
alter table T_Cutting_scheme     drop primary key cascade;
alter table T_Procurement_Demand_PRIMARY drop primary key cascade;
alter table T_Procurement_Demand_DETAIL drop primary key cascade;
alter table T_purchaseOrder_PRIMARY    drop primary key cascade;
alter table T_purchaseOrder_DETAIL     drop primary key cascade;
alter table t_Inventory_count_Primary  drop primary key cascade;
alter table t_Inventory_count_DETAIL   drop primary key cascade;
alter table t_Processing_single_Primary  drop primary key cascade;
alter table t_Processing_single_DETAIL   drop primary key cascade;
alter table t_Material_requisition_DETAIL  drop primary key cascade;
alter table T_Process      drop primary key cascade;
alter table T_ProductionTask drop primary key cascade;
alter table T_ProductionTask_DETAIL drop primary key cascade;
alter table T_ProductProcess drop primary key cascade;
alter table T_AcceptanceList drop primary key cascade;
alter table t_productionStorage_DETAIL drop primary key cascade;

drop table t_productionStorage_DETAIL cascade constraints;
drop table T_AcceptanceList cascade constraints;
drop table T_ProductProcess cascade constraints;
drop table T_ProductionTask_DETAIL cascade constraints;
drop table T_ProductionTask cascade constraints;
drop table T_Process cascade constraints;
drop table t_Material_requisition_DETAIL cascade constraints;
drop table t_Processing_single_DETAIL cascade constraints;
drop table t_Processing_single_Primary cascade constraints;
drop table T_purchaseOrder_DETAIL cascade constraints;
drop table T_purchaseOrder_PRIMARY cascade constraints;
drop table T_Procurement_Demand_DETAIL cascade constraints;
drop table T_Procurement_Demand_PRIMARY cascade constraints;
drop table T_Cutting_scheme cascade constraints;
drop table T_Sales_order_DETAIL cascade constraints;
drop table T_SALES_ORDER_BOM cascade constraints;
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
drop table t_Inventory_count_Primary cascade constraints;
drop table t_Inventory_count_DETAIL cascade constraints;


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
drop sequence SEQUENCE_T_SALES_ORDER_PRIMARY;
drop sequence SEQUENCE_T_Sales_order_DETAIL;
drop sequence SEQUENCE_T_SALES_ORDER_BOM;
drop sequence SEQUENCE_T_Cutting_scheme;
drop sequence SEQUENCE_T_Procurement_PRIMARY;
drop sequence SEQUENCE_T_Procurement_DETAIL;
drop sequence SEQUENCE_T_purchaseOrder_PRIMARY;
drop sequence SEQUENCE_t_Inventory_Primary;
drop sequence SEQUENCE_t_Inventory_DETAIL;
drop sequence SEQUENCE_t_Processing_Primary;
drop sequence SEQUENCE_t_Processing_DETAIL;
drop sequence SEQUENCE_t_Material_DETAIL;
drop sequence SEQUENCE_T_Process;
drop sequence SEQUENCE_T_ProductionTask;
drop sequence SEQUENCE_T_Production_DETAIL;
drop sequence SEQUENCE_T_PRODUCTPROCESS;
drop sequence SEQUENCE_T_AcceptanceList;
drop sequence SEQUENCE_t_productionStorage;
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

create sequence SEQUENCE_T_SALES_ORDER_BOM
start with 10000
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

create sequence SEQUENCE_T_Procurement_PRIMARY
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_Procurement_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_purchase_PRIMARY
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_purchase_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_t_Inventory_Primary
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_t_Inventory_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;


create sequence SEQUENCE_t_Processing_Primary
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_t_Processing_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_t_Material_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_Process
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_ProductionTask
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_Production_DETAIL
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_PRODUCTPROCESS
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_T_AcceptanceList
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_t_productionStorage
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
  processing_fee      FLOAT   default 0,
  estimated_price     FLOAT   default 0,
  sales_price         FLOAT   default 0,
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
  status            NUMBER default 0
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
   STATUS               NUMBER default 0
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
   STATUS               NUMBER default 0,
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
'销售单号';

comment on column T_Sales_order_DETAIL.Products_ID is
'产品编号';

comment on column T_Sales_order_DETAIL.Position is
'库位';

comment on column T_Sales_order_DETAIL.Storage_number is
'销售数量';

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
/* Table: 销售订单产品结构                                                                                                                                                */
/*==============================================================*/
create table T_SALES_ORDER_BOM 
(
   ID                 NUMBER      not null,
   ORDER_ID           VARCHAR(50),
   PRODUCTS_ID		  NUMBER,
   PRODUCTS_BOM_ID	  NUMBER,
   QTY				  NUMBER,
   IS_MAIN_PRODUCTS   NUMBER,
   MAIN_PRODUCTS_ID	  NUMBER,
   PARENT_ID 		  NUMBER,
   TIER			  	  NUMBER,
   MAIN_SUB			  VARCHAR2(1),
   SOURCE_TYPE		  NUMBER,
   CREATE_DATE        VARCHAR(20),
   UPDATE_DATE        VARCHAR(20),
   PRODUCTS_BOM_ID	  NUMBER,
   OWN_QTY			  NUMBER
);

comment on table T_SALES_ORDER_BOM is
'销售订单产品结构';

comment on column T_SALES_ORDER_BOM.ID is
'主键';

comment on column T_SALES_ORDER_BOM.ORDER_ID is
'销售订单号';

comment on column T_SALES_ORDER_BOM.PRODUCTS_ID is
'产品编号';

comment on column T_SALES_ORDER_BOM.PRODUCTS_BOM_ID is
'产品结构编号';

comment on column T_SALES_ORDER_BOM.QTY is
'数量(计算后的)';

comment on column T_SALES_ORDER_BOM.IS_MAIN_PRODUCTS is
'是否主要材料';

comment on column T_SALES_ORDER_BOM.MAIN_PRODUCTS_ID is
'主料ID';

comment on column T_SALES_ORDER_BOM.PARENT_ID is
'父节点ID';

comment on column T_SALES_ORDER_BOM.TIER is
'层级';

comment on column T_SALES_ORDER_BOM.MAIN_SUB is
'主料(Y),替代料(N),没有替代关系为空';

comment on column T_SALES_ORDER_BOM.SOURCE_TYPE is
'来源,如采购，委外加工，自加工，';

comment on column T_SALES_ORDER_BOM.CREATE_DATE is
'创建时间';

comment on column T_SALES_ORDER_BOM.UPDATE_DATE is
'修改时间';

comment on column T_SALES_ORDER_BOM.PRODUCTS_BOM_ID is
'产品结构编号';

comment on column T_SALES_ORDER_BOM.OWN_QTY is
'数量(计算后的)';

alter table T_SALES_ORDER_BOM
   add constraint PK_T_SALES_ORDER_BOM primary key (ID);

   
/*==============================================================*/
/* Table: 切割方案					                                */
/*==============================================================*/
create table T_Cutting_scheme 
(
   ID                   NUMBER               not null,
   NAME                 VARCHAR(30),
   RAW_MATERIALS      NUMBER,
   main_products      NUMBER,
   MAN_NUMBER           NUMBER,
   By_product         NUMBER,
   By_NUMBER          NUMBER,
   enabled            NUMBER default 0
);

comment on table T_Cutting_scheme is
'切割方案';

comment on column T_Cutting_scheme.ID is
'方案编报';

comment on column T_Cutting_scheme.NAME is
'方案名称';

comment on column T_Cutting_scheme.RAW_MATERIALS is
'原材料';

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

/*==============================================================*/
/* Table: 采购需求清单头表					                        */
/*==============================================================*/
create table T_Procurement_Demand_PRIMARY 
(
   ID                   NUMBER               not null,
   createDate         VARCHAR(30),
   limitDate          VARCHAR(30),
   UserID             NUMBER,
   order_id           VARCHAR(50),
   STATUS               NUMBER default 0,
   Remarks            varchar(500) 
);

comment on table T_Procurement_Demand_PRIMARY is
'采购需求清单头表';

comment on column T_Procurement_Demand_PRIMARY.ID is
'主键';

comment on column T_Procurement_Demand_PRIMARY.createDate is
'申请日期';

comment on column T_Procurement_Demand_PRIMARY.limitDate is
'期限';

comment on column T_Procurement_Demand_PRIMARY.UserID is
'创建人';

comment on column T_Procurement_Demand_PRIMARY.order_id is
'单据号';

comment on column T_Procurement_Demand_PRIMARY.STATUS is
'状态';

comment on column T_Procurement_Demand_PRIMARY.Remarks is
'备注';

alter table T_Procurement_Demand_PRIMARY
   add constraint PK_T_PROCUREMENT_DEMAND_PRIMAR primary key (ID);
   
/*==============================================================*/
/* Table: 采购需求清单明细					                        */
/*==============================================================*/
create table T_Procurement_Demand_DETAIL 
(
   id                 NUMBER               not null,
   ProcuremenID       NUMBER,
   ProductsID         NUMBER,
   isMainProducts      NUMBER,
   Demand_Number      NUMBER,
   Remarks            varchar2(500)
);

comment on table T_Procurement_Demand_DETAIL is
'采购需求清单明细表';

comment on column T_Procurement_Demand_DETAIL.id is
'主键';

comment on column T_Procurement_Demand_DETAIL.ProcuremenID is
'采购需求头表ID';

comment on column T_Procurement_Demand_DETAIL.ProductsID is
'产品编号';

comment on column T_Procurement_Demand_DETAIL.isMainProducts is
'是否主要材料';

comment on column T_Procurement_Demand_DETAIL.Demand_Number is
'数量';

comment on column T_Procurement_Demand_DETAIL.Remarks is
'备注';

alter table T_Procurement_Demand_DETAIL
   add constraint PK_T_PROCUREMENT_DEMAND_DETAIL primary key (id);
   
/*==============================================================*/
/* Table: 采购订单表头					                             */
/*==============================================================*/
create table T_purchaseOrder_PRIMARY 
(
   ID                   NUMBER               not null,
   purchaseOrderID    VARCHAR(50),
   purchaseDate       VARCHAR(30),
   arrivalDate        VARCHAR(30),
   Customer_ID        NUMBER,
   UserID             NUMBER,
   Warehouse_ID       NUMBER,
   Remarks            VARCHAR(500),
   createDate         VARCHAR(30),
   updateDate         VARCHAR(30),
   status             NUMBER default 0
);

comment on table T_purchaseOrder_PRIMARY is
'采购订单_头表';

comment on column T_purchaseOrder_PRIMARY.ID is
'主键';

comment on column T_purchaseOrder_PRIMARY.purchaseOrderID is
'采购编号';

comment on column T_purchaseOrder_PRIMARY.purchaseDate is
'订单日期';

comment on column T_purchaseOrder_PRIMARY.arrivalDate is
'到货日期';

comment on column T_purchaseOrder_PRIMARY.Customer_ID is
'供应商';

comment on column T_purchaseOrder_PRIMARY.UserID is
'采购员';

comment on column T_purchaseOrder_PRIMARY.Warehouse_ID is
'仓库';

comment on column T_purchaseOrder_PRIMARY.Remarks is
'备注';

comment on column T_purchaseOrder_PRIMARY.createDate is
'创建时间';

comment on column T_purchaseOrder_PRIMARY.updateDate is
'修改时间';

comment on column T_purchaseOrder_PRIMARY.status is
'状态';

alter table T_purchaseOrder_PRIMARY
   add constraint PK_T_PURCHASEORDER_PRIMARY primary key (ID);
   
/*==============================================================*/
/* Table: 采购订单明细					                              */
/*==============================================================*/
create table T_purchaseOrder_DETAIL 
(
   ID                   NUMBER               not null,
   purchaseOrderID    NUMBER,
   ProductsID         NUMBER,
   purchase_Number    NUMBER,
   price              FLOAT,
   orderValue         FLOAT,
   Remarks            VARCHAR(500),
   ProcurementID      NUMBER
);

comment on table T_purchaseOrder_DETAIL is
'采购订单_明细';

comment on column T_purchaseOrder_DETAIL.ID is
'编号';

comment on column T_purchaseOrder_DETAIL.purchaseOrderID is
'采购订单头表ID';

comment on column T_purchaseOrder_DETAIL.ProductsID is
'产品编号';

comment on column T_purchaseOrder_DETAIL.purchase_Number is
'数量';

comment on column T_purchaseOrder_DETAIL.price is
'价格';

comment on column T_purchaseOrder_DETAIL.Remarks is
'备注';

comment on column T_purchaseOrder_DETAIL.ProcurementID is
'对应需求清单明细ID';

alter table T_purchaseOrder_DETAIL
   add constraint PK_T_PURCHASEORDER_DETAIL primary key (ID);

/*==============================================================*/
/* Table: 库存盘点头表     				                                */
/*==============================================================*/ 
create table t_Inventory_count_Primary 
(
   ID                   NUMBER               not null,
   NAME                 VARCHAR(80),
   Remarks           VARCHAR(500),
   Warehouse_ID       VARCHAR(500),
   createDate         VARCHAR(30),
   inventoryDate         VARCHAR(30),
   UserID             NUMBER,
   status             NUMBER
);

comment on column t_Inventory_count_Primary.ID is
'编号';

comment on column t_Inventory_count_Primary.NAME is
'名称';

comment on column t_Inventory_count_Primary.Remarks1 is
'备注';

comment on column t_Inventory_count_Primary.Warehouse_ID is
'所属仓库';

comment on column t_Inventory_count_Primary.createDate is
'创建时间';

comment on column t_Inventory_count_Primary.inventoryDate is
'盘点时间';

comment on column t_Inventory_count_Primary.UserID is
'创建人';

comment on column t_Inventory_count_Primary.status is
'是否审核';

alter table t_Inventory_count_Primary
   add constraint PK_T_INVENTORY_COUNT_PRIMARY primary key (ID);

/*==============================================================*/
/* Table: 库存盘点明细表     				                                */
/*==============================================================*/ 
create table t_Inventory_count_DETAIL 
(
   ID                   NUMBER               not null,
   Inventory_id       NUMBER,
   Products_ID        NUMBER,
   Warehouse_ID       NUMBER,
   stockID            NUMBER,
   Original_quantity  NUMBER,
   change_quantity    NUMBER,
   createDate         VARCHAR(30),
   User_ID            NUMBER
);

comment on column t_Inventory_count_DETAIL.ID is
'主键';

comment on column t_Inventory_count_DETAIL.Inventory_id is
'库存盘点表头ID';

comment on column t_Inventory_count_DETAIL.Products_ID is
'商品编号';

comment on column t_Inventory_count_DETAIL.stockID is
'库存ID';

comment on column t_Inventory_count_DETAIL.Warehouse_ID is
'所属仓库';

comment on column t_Inventory_count_DETAIL.Original_quantity is
'原库存数量';

comment on column t_Inventory_count_DETAIL.change_quantity is
'变更库存数量';

comment on column t_Inventory_count_DETAIL.createDate is
'创建时间';

comment on column t_Inventory_count_DETAIL.User_ID is
'创建人';

alter table t_Inventory_count_DETAIL
   add constraint PK_T_INVENTORY_COUNT_DETAIL primary key (ID);
   
/*==============================================================*/
/* Table:加工单头表                            			                            */
/*==============================================================*/
create table t_Processing_single_Primary 
(
   id                 NUMBER               not null,
   ProcessingSingleID VARCHAR(50),
   Purchase_order_ID  NUMBER,
   createDate             VARCHAR(20),
   status             NUMBER,
   Remarks            VARCHAR(500)
);

comment on table t_Processing_single_Primary is
'加工单_头表';

comment on column t_Processing_single_Primary.id is
'主键';

comment on column t_Processing_single_Primary.ProcessingSingleID is
'加工单号';

comment on column t_Processing_single_Primary.Purchase_order_ID is
'销售订单';

comment on column t_Processing_single_Primary.createDate is
'创建日期';

comment on column t_Processing_single_Primary.status is
'状态';

comment on column t_Processing_single_Primary.Remarks is
'描述';

alter table t_Processing_single_Primary
   add constraint PK_PROCESSING_SINGLE_PRIMARY primary key (id);
   
/*==============================================================*/
/* Table:加工单_明细                           			                            */
/*==============================================================*/
create table t_Processing_single_DETAIL 
(
   ID                   NUMBER               not null,
   ProcessingSingleID NUMBER,
   salesOrderBomID    NUMBER,
   productionMark     NUMBER,
   TIER               NUMBER,
   startDate          DATE,
   endDate            DATE,
   Products_ID        NUMBER,
   ProcessingNumber   FLOAT,
   ProcessID          NUMBER
);

comment on table t_Processing_single_DETAIL is
'加工单_明细';

comment on column t_Processing_single_DETAIL.ID is
'主键';

comment on column t_Processing_single_DETAIL.ProcessingSingleID is
'加工单头表id';

comment on column t_Processing_single_DETAIL.salesOrderBomID is
'销售订单分解结构表ID';

comment on column t_Processing_single_DETAIL.TIER is
'层级';

comment on column t_Processing_single_DETAIL.startDate is
'生产日期';

comment on column t_Processing_single_DETAIL.endDate is
'结束日期';

comment on column t_Processing_single_DETAIL.Products_ID is
'生产物料';

comment on column t_Processing_single_DETAIL.ProcessingNumber is
'生产数量';

comment on column t_Processing_single_DETAIL.ProcessID is
'工序';

comment on column t_Processing_single_DETAIL.productionMark is
'生产标示';

alter table t_Processing_single_DETAIL
   add constraint PK_PROCESSING_SINGLE_DETAIL primary key (ID);
   
/*==============================================================*/
/* Table:领料单_明细                           			                            */
/*==============================================================*/
create table t_Material_requisition_DETAIL 
(
   ID                   NUMBER               not null,
   ProductionTaskID NUMBER,
   Products_ID        NUMBER,
   MATERIAL_NUMBER    FLOAT
);

comment on table t_Material_requisition_DETAIL is
'领料单_明细';

comment on column t_Material_requisition_DETAIL.ID is
'主键';

comment on column t_Material_requisition_DETAIL.ProductionTaskID is
'生产任务单号';

comment on column t_Material_requisition_DETAIL.Products_ID is
'物料';

comment on column t_Material_requisition_DETAIL.MATERIAL_NUMBER is
'数量';

alter table t_Material_requisition_DETAIL
   add constraint PK_T_MATERIAL_REQUISITION_DETA primary key (ID);

   

/*==============================================================*/
/* Table:工序清单                              			                            */
/*==============================================================*/ 
create table T_Process 
(
   ID                   NUMBER               not null,
   name               varchar(100),
   Reference_price    FLOAT,
   Processing_cycle   FLOAT,
   Remarks            VARCHAR(500)
);

comment on table T_Process is
'加工工序';

comment on column T_Process.ID is
'主键';

comment on column T_Process.name is
'工序名称';

comment on column T_Process.Reference_price is
'参考单价';

comment on column T_Process.Processing_cycle is
'加工周期';

comment on column T_Process.Remarks is
'备注';

alter table T_Process
   add constraint PK_T_PROCESS primary key (ID);
   
   
/*==============================================================*/
/* Table: 生产加工单                                   */
/*==============================================================*/
create table T_ProductionTask 
(
   ID                   NUMBER               not null,
   Inventory_countID    NUMBER,
   PROCESSINGSINGLEID	VARCHAR(150),
   Production_order     VARCHAR(150),
   STARTDATE            DATE,
   ENDDATE              DATE，
   status               NUMBER default 0
);

comment on table T_ProductionTask is
'生产任务单';

comment on column T_ProductionTask.ID is
'主键';

comment on column T_ProductionTask.Inventory_countID is
'加工单';

comment on column T_ProductionTask.PROCESSINGSINGLEID is
'加工单编号';

comment on column T_ProductionTask.Production_order is
'生产单号';

comment on column T_ProductionTask.STARTDATE is
'生产日期';

comment on column T_ProductionTask.ENDDATE is
'结束日期';

comment on column T_ProductionTask.status is
'状态';

alter table T_ProductionTask
   add constraint PK_T_PRODUCTIONTASK primary key (ID);
   
/*==============================================================*/
/* Table: 生产任务单明细                             */
/*==============================================================*/
create table T_ProductionTask_DETAIL 
(
   ID                   NUMBER               not null,
   ProductionTaskID   NUMBER,
   Products_ID        NUMBER,
   ProcessingNumber   FLOAT,
   ProcessID          NUMBER
);

comment on table T_ProductionTask_DETAIL is
'生产任务单明细';

comment on column T_ProductionTask_DETAIL.ID is
'主键';

comment on column T_ProductionTask_DETAIL.ProductionTaskID is
'生产任务单主表ID';

comment on column T_ProductionTask_DETAIL.Products_ID is
'物料';

comment on column T_ProductionTask_DETAIL.ProcessingNumber is
'数量';

comment on column T_ProductionTask_DETAIL.ProcessID is
'工序';

alter table T_ProductionTask_DETAIL
   add constraint PK_T_PRODUCTIONTASK_DETAIL primary key (ID);
   
/*==============================================================*/
/* Table: 产品工序                                                                       							*/
/*==============================================================*/   

create table T_ProductProcess
(
  id            NUMBER not null,
  products_id   NUMBER,
  process_id    NUMBER,
  process_price FLOAT,
  process_cycle FLOAT,
  remarks       VARCHAR2(500)
)

comment on table T_PRODUCTPROCESS
  is '物料工序维护';
-- Add comments to the columns 
comment on column T_PRODUCTPROCESS.id
  is '主键';
comment on column T_PRODUCTPROCESS.products_id
  is '物料ID';
comment on column T_PRODUCTPROCESS.process_id
  is '工序ID';
comment on column T_PRODUCTPROCESS.process_price
  is '价格';
comment on column T_PRODUCTPROCESS.process_cycle
  is '周期';
comment on column T_PRODUCTPROCESS.remarks
  is '备注';
   
alter table T_PRODUCTPROCESS
   add constraint PK_T_PRODUCTPROCESS primary key (ID);
   
/*==============================================================*/
/* Table: 验收明细				                                    */
/*==============================================================*/
create table T_AcceptanceList 
(
   ID                   NUMBER               not null,
   ProductionTaskID   NUMBER,
   Products_ID        NUMBER,
   ProcessID          NUMBER,
   AcceptanceDate     VARCHAR(30),
   isAcceptance       VARCHAR(10)
);

comment on table T_AcceptanceList is
'验收单';

comment on column T_AcceptanceList.ID is
'主键';

comment on column T_AcceptanceList.ProductionTaskID is
'加工单头表';

comment on column T_AcceptanceList.Products_ID is
'产品ID';

comment on column T_AcceptanceList.ProcessID is
'工序ID';

comment on column T_AcceptanceList.AcceptanceDate is
'验收时间';

comment on column T_AcceptanceList.isAcceptance is
'是否验收';

alter table T_AcceptanceList
   add constraint PK_T_ACCEPTANCELIST primary key (ID);

/*==============================================================*/
/* Table: 加工单入库			                                    */
/*==============================================================*/
create table t_productionStorage_DETAIL 
(
   ID                   NUMBER               not null,
   ProcessingSingleID NUMBER,
   Products_ID        NUMBER,
   ProcessingNumber   FLOAT,
   WAREHOUSE_TYPE     NUMBER
);

comment on table t_Processing_single_DETAIL is
'加工单入库_明细';

comment on column t_Processing_single_DETAIL.id is
'主键';

comment on column t_Processing_single_DETAIL.ProcessingSingleID is
'加工单头表id';

comment on column t_Processing_single_DETAIL.Products_ID is
'物料';

comment on column t_Processing_single_DETAIL.ProcessingNumber is
'数量';

comment on column t_Processing_single_DETAIL.WAREHOUSE_TYPE is
'产品类型 0:成本，1为剩余物料（半成品）';

alter table t_productionStorage_DETAIL
   add constraint PK_productionStorage_DETAIL primary key (ID);