alter table T_Customer
   drop primary key cascade;

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