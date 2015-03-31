alter table T_Customer  drop primary key cascade;
alter table T_Products  drop primary key cascade;


drop table T_Products cascade constraints;
drop table T_T_Customer cascade constraints;



drop sequence SEQUENCE_T_Customer;

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
  safety_stock        NUMBER,
  createdate          DATE,
  updatedate          DATE,
  userid              NUMBER,
  remarks             VARCHAR2(500),
  approval            VARCHAR2(1)
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
'加工费';

comment on column T_Products.Estimated_price is
'预估价';

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