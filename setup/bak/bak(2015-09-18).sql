---------------------------------------------
-- Export file for user ERP                --
-- Created by 21829 on 2015/9/18, 20:29:41 --
---------------------------------------------

set define off
spool bak(2015-09-18).log

prompt
prompt Creating table SYS_AUTHORITIES
prompt ==============================
prompt
create table ERP.SYS_AUTHORITIES
(
  id          NUMBER not null,
  name        VARCHAR2(25 CHAR),
  description VARCHAR2(50 CHAR),
  enabled     NUMBER default '0',
  module      VARCHAR2(25 CHAR),
  permission  VARCHAR2(200)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_AUTHORITIES
  is '权限表';
comment on column ERP.SYS_AUTHORITIES.name
  is '权限名称';
comment on column ERP.SYS_AUTHORITIES.description
  is '权限描述';
comment on column ERP.SYS_AUTHORITIES.enabled
  is '是否启用 0启动 1:停用';
comment on column ERP.SYS_AUTHORITIES.module
  is '模块';
alter table ERP.SYS_AUTHORITIES
  add constraint PK_SYS_AUTHORITIES_ID primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_BASI_TYPE
prompt ============================
prompt
create table ERP.SYS_BASI_TYPE
(
  id   NUMBER not null,
  name VARCHAR2(50)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_BASI_TYPE
  is '基础分类';
comment on column ERP.SYS_BASI_TYPE.id
  is '主键';
comment on column ERP.SYS_BASI_TYPE.name
  is '名称';
alter table ERP.SYS_BASI_TYPE
  add constraint PK_SYS_BASI_TYPE primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_DEPT
prompt =======================
prompt
create table ERP.SYS_DEPT
(
  id            NUMBER not null,
  dept_name     VARCHAR2(50),
  enterprise_id NUMBER,
  type          NUMBER,
  enabled       NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_DEPT
  is '部门配置';
comment on column ERP.SYS_DEPT.id
  is '主键';
comment on column ERP.SYS_DEPT.dept_name
  is '部门名称';
comment on column ERP.SYS_DEPT.enterprise_id
  is '所属公司';
comment on column ERP.SYS_DEPT.type
  is '部门类型';
comment on column ERP.SYS_DEPT.enabled
  is '状态';
alter table ERP.SYS_DEPT
  add constraint PK_SYS_DEPT primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_DICTIONARY
prompt =============================
prompt
create table ERP.SYS_DICTIONARY
(
  key          NUMBER not null,
  descr        VARCHAR2(50),
  basi_type_id NUMBER,
  sorting      NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_DICTIONARY
  is '数据库字典';
comment on column ERP.SYS_DICTIONARY.key
  is 'KEY';
comment on column ERP.SYS_DICTIONARY.descr
  is '名称';
comment on column ERP.SYS_DICTIONARY.basi_type_id
  is '类型';
comment on column ERP.SYS_DICTIONARY.sorting
  is '排序';
alter table ERP.SYS_DICTIONARY
  add constraint PK_SYS_DICTIONARY primary key (KEY)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ENTERPRISE
prompt =============================
prompt
create table ERP.SYS_ENTERPRISE
(
  id        NUMBER not null,
  name      VARCHAR2(100 CHAR),
  address   VARCHAR2(150 CHAR),
  phonecall VARCHAR2(25 CHAR),
  enabled   NUMBER default '0'  -- 是否启用 0启动 1:停用
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_ENTERPRISE
  is '企业信息表';
alter table ERP.SYS_ENTERPRISE
  add constraint PK_SYS_ENTERPRISE_ID primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_FILEINFO
prompt ===========================
prompt
create table ERP.SYS_FILEINFO
(
  id                     NUMBER not null,
  name                   VARCHAR2(100 CHAR),
  nametype               VARCHAR2(10 CHAR),
  type                   VARCHAR2(100 CHAR),
  descr                  VARCHAR2(100 CHAR),
  createdate             VARCHAR2(30 CHAR),
  updatedate             VARCHAR2(30 CHAR),
  state                  VARCHAR2(2 CHAR),
  technologicalprocessid NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table ERP.SYS_FILEINFO
  is '文件信息 ';
comment on column ERP.SYS_FILEINFO.name
  is '文件名';
comment on column ERP.SYS_FILEINFO.nametype
  is '文件类型';
comment on column ERP.SYS_FILEINFO.type
  is '种类';
comment on column ERP.SYS_FILEINFO.descr
  is '描述';
comment on column ERP.SYS_FILEINFO.state
  is '状态';
alter table ERP.SYS_FILEINFO
  add constraint PK_FILEINFO primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYS_MAIL_LIST
prompt ============================
prompt
create table ERP.SYS_MAIL_LIST
(
  id         NUMBER not null,
  createdate VARCHAR2(20 CHAR),
  updatedate VARCHAR2(20 CHAR),
  phone      VARCHAR2(20 CHAR),
  name       VARCHAR2(25 CHAR),
  foreignid  NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_MAIL_LIST
  is '加盟商信息';
comment on column ERP.SYS_MAIL_LIST.id
  is '主键';
comment on column ERP.SYS_MAIL_LIST.createdate
  is '创建时间';
comment on column ERP.SYS_MAIL_LIST.updatedate
  is '修改时间';
comment on column ERP.SYS_MAIL_LIST.phone
  is '电话号码';
comment on column ERP.SYS_MAIL_LIST.name
  is '姓名';
comment on column ERP.SYS_MAIL_LIST.foreignid
  is '加盟商ID';
alter table ERP.SYS_MAIL_LIST
  add constraint PK_MAIL_LIST primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_MENU
prompt =======================
prompt
create table ERP.SYS_MENU
(
  id        NUMBER not null,
  name      VARCHAR2(150 CHAR),
  namespace VARCHAR2(30 CHAR),
  action    VARCHAR2(150 CHAR),
  url       VARCHAR2(150 CHAR),
  i18n_key  VARCHAR2(100 CHAR),
  enabled   VARCHAR2(1 CHAR) default '0',
  parentid  NUMBER,
  reorder   NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_MENU
  is '菜单表';
alter table ERP.SYS_MENU
  add constraint PK_SYS_MENU_ID primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_NOTICE
prompt =========================
prompt
create table ERP.SYS_NOTICE
(
  id         NUMBER not null,
  title      VARCHAR2(60 CHAR),
  content    VARCHAR2(200 CHAR),
  userid     NUMBER,
  createdate DATE,
  updatedate DATE,
  enabled    NUMBER default '0'
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_NOTICE
  is '公司公告';
comment on column ERP.SYS_NOTICE.id
  is 'ID';
comment on column ERP.SYS_NOTICE.title
  is '标题';
comment on column ERP.SYS_NOTICE.content
  is '内容';
comment on column ERP.SYS_NOTICE.userid
  is '创建人';
comment on column ERP.SYS_NOTICE.createdate
  is '创建时间';
comment on column ERP.SYS_NOTICE.updatedate
  is '修改时间';
comment on column ERP.SYS_NOTICE.enabled
  is '是否启用';
alter table ERP.SYS_NOTICE
  add constraint PK_SYS_NOTICE primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_PARAM
prompt ========================
prompt
create table ERP.SYS_PARAM
(
  id               NUMBER not null,
  emailservice     VARCHAR2(50 CHAR),
  emailform        VARCHAR2(50 CHAR),
  emailusername    VARCHAR2(50 CHAR),
  emailpassword    VARCHAR2(50 CHAR),
  emailisauth      VARCHAR2(1 CHAR),
  emailurlpassword VARCHAR2(30 CHAR),
  scrap_factor     FLOAT
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column ERP.SYS_PARAM.scrap_factor
  is '损耗率';
alter table ERP.SYS_PARAM
  add constraint PK_SYS_PARAM_ID primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_RESOURCEINFO
prompt ===============================
prompt
create table ERP.SYS_RESOURCEINFO
(
  id         NUMBER not null,
  name       VARCHAR2(30 CHAR),
  value      VARCHAR2(30 CHAR),
  type       VARCHAR2(20 CHAR),
  createtime DATE,
  updatetime DATE,
  enabled    NUMBER default '0'-- 是否启用 0启动 1:停用
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table ERP.SYS_RESOURCEINFO
  is '资源信息表';
alter table ERP.SYS_RESOURCEINFO
  add constraint PK_SYS_RESOURCEINFO_ID primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table ERP.SYS_ROLE
(
  id         NUMBER not null,
  name       VARCHAR2(50 CHAR),
  describe   VARCHAR2(100 CHAR),
  createtime DATE,
  updatetime DATE
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_ROLE
  is '角色信息表';
comment on column ERP.SYS_ROLE.name
  is '角色名称';
comment on column ERP.SYS_ROLE.describe
  is '角色描述';
comment on column ERP.SYS_ROLE.createtime
  is '创建时间';
comment on column ERP.SYS_ROLE.updatetime
  is '更新时间';
alter table ERP.SYS_ROLE
  add constraint PK_SYS_ROLE_ID primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLE_TO_AUTHORITIES
prompt ======================================
prompt
create table ERP.SYS_ROLE_TO_AUTHORITIES
(
  role_id        NUMBER,
  authorities_id NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLE_TO_MENU
prompt ===============================
prompt
create table ERP.SYS_ROLE_TO_MENU
(
  menu_id NUMBER,
  role_id NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_ROLE_TO_MENU
  is '角色和菜单中间表（一对多）';

prompt
prompt Creating table SYS_TEMP_FBT
prompt ===========================
prompt
create global temporary table ERP.SYS_TEMP_FBT
(
  schema      VARCHAR2(32),
  object_name VARCHAR2(32),
  object#     NUMBER,
  rid         UROWID(4000),
  action      CHAR(1)
)
on commit preserve rows;

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
create table ERP.SYS_USER
(
  id                   NUMBER not null,
  loginname            VARCHAR2(20 CHAR) not null,
  userpassword         VARCHAR2(100 CHAR) not null,
  name                 VARCHAR2(20 CHAR),
  enabled              VARCHAR2(1 CHAR) default '0',
  usertype             VARCHAR2(1 CHAR),
  role_id              NUMBER,
  enterprise_id        NUMBER,
  email                VARCHAR2(25 CHAR),
  age                  DATE,
  sex                  VARCHAR2(1 CHAR),
  phone                VARCHAR2(20 CHAR),
  qq                   VARCHAR2(20 CHAR),
  mobile_number        VARCHAR2(20 CHAR),
  entrytime            DATE,
  address              VARCHAR2(100 CHAR),
  education_background VARCHAR2(1 CHAR),
  createtime           DATE,
  updatetime           DATE,
  nonce                VARCHAR2(50 CHAR)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ERP.USER_LOGINNAME_INDEX on ERP.SYS_USER (LOGINNAME)
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ERP.SYS_USER
  add constraint PK_SYS_USER_ID primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_WAREHOUSE
prompt ============================
prompt
create table ERP.SYS_WAREHOUSE
(
  id            NUMBER not null,
  name          VARCHAR2(30),
  address       VARCHAR2(100),
  enabled       NUMBER default 0,
  enterprise_id NUMBER,
  type          NUMBER default 0
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.SYS_WAREHOUSE
  is '仓库管理';
comment on column ERP.SYS_WAREHOUSE.id
  is '主键';
comment on column ERP.SYS_WAREHOUSE.name
  is '仓库名称';
comment on column ERP.SYS_WAREHOUSE.address
  is '仓库地址';
comment on column ERP.SYS_WAREHOUSE.enabled
  is '状态';
comment on column ERP.SYS_WAREHOUSE.enterprise_id
  is '企业ID';
comment on column ERP.SYS_WAREHOUSE.type
  is '0用户创建，1系统仓库';
alter table ERP.SYS_WAREHOUSE
  add constraint PK_SYS_WAREHOUSE primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_ACCEPTANCELIST
prompt ===============================
prompt
create table ERP.T_ACCEPTANCELIST
(
  id               NUMBER not null,
  productiontaskid NUMBER,
  products_id      NUMBER,
  processid        NUMBER,
  acceptancedate   VARCHAR2(30),
  isacceptance     VARCHAR2(10)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_ACCEPTANCELIST
  is '验收单';
comment on column ERP.T_ACCEPTANCELIST.id
  is '主键';
comment on column ERP.T_ACCEPTANCELIST.productiontaskid
  is '加工单头表';
comment on column ERP.T_ACCEPTANCELIST.products_id
  is '产品ID';
comment on column ERP.T_ACCEPTANCELIST.processid
  is '工序ID';
comment on column ERP.T_ACCEPTANCELIST.acceptancedate
  is '验收时间';
comment on column ERP.T_ACCEPTANCELIST.isacceptance
  is '是否验收';
alter table ERP.T_ACCEPTANCELIST
  add constraint PK_T_ACCEPTANCELIST primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_BOM_DETAIL
prompt ===========================
prompt
create table ERP.T_BOM_DETAIL
(
  id               NUMBER not null,
  primary_id       NUMBER,
  sub_products_id  NUMBER,
  position         NUMBER,
  is_main_products NUMBER,
  qty              FLOAT,
  remarks          VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_BOM_DETAIL
  is '产品结构清单';
comment on column ERP.T_BOM_DETAIL.id
  is '主键';
comment on column ERP.T_BOM_DETAIL.primary_id
  is '产品结构头表主建';
comment on column ERP.T_BOM_DETAIL.sub_products_id
  is '子产品主键';
comment on column ERP.T_BOM_DETAIL.position
  is '库位号';
comment on column ERP.T_BOM_DETAIL.is_main_products
  is '是否主要产品';
comment on column ERP.T_BOM_DETAIL.qty
  is '数量';
comment on column ERP.T_BOM_DETAIL.remarks
  is '备注';
alter table ERP.T_BOM_DETAIL
  add constraint PK_T_BOM_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_BOM_PRIMARY
prompt ============================
prompt
create table ERP.T_BOM_PRIMARY
(
  id          NUMBER not null,
  products_id NUMBER,
  descr       VARCHAR2(500),
  effdt       VARCHAR2(40),
  eff_status  VARCHAR2(1)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_BOM_PRIMARY
  is '产品结构头表';
comment on column ERP.T_BOM_PRIMARY.id
  is '主键';
comment on column ERP.T_BOM_PRIMARY.products_id
  is '主产品编号';
comment on column ERP.T_BOM_PRIMARY.descr
  is '描述';
comment on column ERP.T_BOM_PRIMARY.effdt
  is '生效日期';
comment on column ERP.T_BOM_PRIMARY.eff_status
  is '生效状态';
alter table ERP.T_BOM_PRIMARY
  add constraint PK_T_BOM_PRIMARY primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_BOM_SUB
prompt ========================
prompt
create table ERP.T_BOM_SUB
(
  id               NUMBER not null,
  primary_id       NUMBER,
  main_products_id NUMBER,
  sub_products_id  NUMBER,
  qty              FLOAT,
  remarks          VARCHAR2(500),
  position         NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_BOM_SUB
  is '替代料产品结构清单';
comment on column ERP.T_BOM_SUB.id
  is '主键';
comment on column ERP.T_BOM_SUB.primary_id
  is '产品结构头表主键';
comment on column ERP.T_BOM_SUB.main_products_id
  is '主料产品主建';
comment on column ERP.T_BOM_SUB.sub_products_id
  is '子产品主键';
comment on column ERP.T_BOM_SUB.qty
  is '数量';
comment on column ERP.T_BOM_SUB.remarks
  is '备注';
comment on column ERP.T_BOM_SUB.position
  is '仓库位';
alter table ERP.T_BOM_SUB
  add constraint PK_T_BOM_SUB primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_CUSTOMER
prompt =========================
prompt
create table ERP.T_CUSTOMER
(
  id           NUMBER not null,
  name         VARCHAR2(100),
  type         NUMBER,
  enabled      NUMBER,
  mail         VARCHAR2(50),
  iphone       VARCHAR2(30),
  fax_number   VARCHAR2(30),
  address      VARCHAR2(100),
  lev          VARCHAR2(10),
  opening_bank VARCHAR2(100),
  bank_account VARCHAR2(100),
  legal_person VARCHAR2(100)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_CUSTOMER
  is '客户资源信息';
comment on column ERP.T_CUSTOMER.id
  is '客户编号';
comment on column ERP.T_CUSTOMER.name
  is '客户名称';
comment on column ERP.T_CUSTOMER.type
  is '客户类型';
comment on column ERP.T_CUSTOMER.enabled
  is '客户状态';
comment on column ERP.T_CUSTOMER.mail
  is '邮箱';
comment on column ERP.T_CUSTOMER.iphone
  is '电话号码';
comment on column ERP.T_CUSTOMER.fax_number
  is '传真号';
comment on column ERP.T_CUSTOMER.address
  is '地址';
comment on column ERP.T_CUSTOMER.lev
  is '客户等级';
comment on column ERP.T_CUSTOMER.opening_bank
  is '开户银行';
comment on column ERP.T_CUSTOMER.bank_account
  is '银行账号';
comment on column ERP.T_CUSTOMER.legal_person
  is '法人';
alter table ERP.T_CUSTOMER
  add constraint PK_T_CUSTOMER primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_CUTTING_SCHEME
prompt ===============================
prompt
create table ERP.T_CUTTING_SCHEME
(
  id            NUMBER not null,
  name          VARCHAR2(30),
  main_products NUMBER,
  man_number    NUMBER,
  by_product    NUMBER,
  by_number     NUMBER,
  enabled       NUMBER default 0,
  raw_materials NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_CUTTING_SCHEME
  is '切割方案';
comment on column ERP.T_CUTTING_SCHEME.id
  is '方案编报';
comment on column ERP.T_CUTTING_SCHEME.name
  is '方案名称';
comment on column ERP.T_CUTTING_SCHEME.main_products
  is '主产品编号';
comment on column ERP.T_CUTTING_SCHEME.man_number
  is '主产品数量';
comment on column ERP.T_CUTTING_SCHEME.by_product
  is '副产品';
comment on column ERP.T_CUTTING_SCHEME.by_number
  is '副产品数量';
comment on column ERP.T_CUTTING_SCHEME.enabled
  is '状态';
comment on column ERP.T_CUTTING_SCHEME.raw_materials
  is '原材料';
alter table ERP.T_CUTTING_SCHEME
  add constraint PK_T_CUTTING_SCHEME primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_INVENTORY_COUNT_DETAIL
prompt =======================================
prompt
create table ERP.T_INVENTORY_COUNT_DETAIL
(
  id                NUMBER not null,
  inventory_id      NUMBER,
  products_id       NUMBER,
  warehouse_id      NUMBER,
  original_quantity NUMBER,
  change_quantity   NUMBER,
  createdate        VARCHAR2(30),
  user_id           NUMBER,
  stockid           NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_INVENTORY_COUNT_DETAIL
  is '库存盘点';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.id
  is '主键';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.inventory_id
  is '库存盘点表头ID';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.products_id
  is '商品编号';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.warehouse_id
  is '所属仓库';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.original_quantity
  is '原库存数量';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.change_quantity
  is '变更库存数量';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.createdate
  is '创建时间';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.user_id
  is '创建人';
comment on column ERP.T_INVENTORY_COUNT_DETAIL.stockid
  is '库存ID';
alter table ERP.T_INVENTORY_COUNT_DETAIL
  add constraint PK_T_INVENTORY_COUNT_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_INVENTORY_COUNT_PRIMARY
prompt ========================================
prompt
create table ERP.T_INVENTORY_COUNT_PRIMARY
(
  id            NUMBER not null,
  name          VARCHAR2(80),
  remarks       VARCHAR2(500),
  warehouse_id  VARCHAR2(500),
  createdate    VARCHAR2(30),
  userid        NUMBER,
  status        NUMBER,
  inventorydate VARCHAR2(30)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_INVENTORY_COUNT_PRIMARY
  is '库存盘点';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.id
  is '编号';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.name
  is '名称';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.remarks
  is '备注';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.warehouse_id
  is '所属仓库';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.createdate
  is '创建时间';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.userid
  is '创建人';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.status
  is '是否审核';
comment on column ERP.T_INVENTORY_COUNT_PRIMARY.inventorydate
  is '盘点时间';
alter table ERP.T_INVENTORY_COUNT_PRIMARY
  add constraint PK_T_INVENTORY_COUNT_PRIMARY primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_LIBRARY_DETAIL
prompt ===============================
prompt
create table ERP.T_LIBRARY_DETAIL
(
  id               NUMBER not null,
  libraryprimaryid VARCHAR2(50),
  products_id      NUMBER,
  position         NUMBER,
  storage_number   NUMBER,
  use              VARCHAR2(100),
  remarks          VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_LIBRARY_DETAIL
  is '出库信息_明细表';
comment on column ERP.T_LIBRARY_DETAIL.id
  is '主键';
comment on column ERP.T_LIBRARY_DETAIL.libraryprimaryid
  is '出库单号';
comment on column ERP.T_LIBRARY_DETAIL.products_id
  is '产品编号';
comment on column ERP.T_LIBRARY_DETAIL.position
  is '仓位';
comment on column ERP.T_LIBRARY_DETAIL.storage_number
  is '出库数量';
comment on column ERP.T_LIBRARY_DETAIL.use
  is '用途';
comment on column ERP.T_LIBRARY_DETAIL.remarks
  is '备注';
alter table ERP.T_LIBRARY_DETAIL
  add constraint PK_T_LIBRARY_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_LIBRARY_PRIMARY
prompt ================================
prompt
create table ERP.T_LIBRARY_PRIMARY
(
  id                NUMBER not null,
  order_no_id       VARCHAR2(50),
  purchase_order_id VARCHAR2(50),
  library_date      VARCHAR2(20),
  userid            NUMBER,
  warehouse_id      NUMBER,
  mount_meoey       FLOAT,
  remarks           VARCHAR2(500),
  customer_id       NUMBER,
  createdate        VARCHAR2(20),
  updatedate        VARCHAR2(20),
  status            NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_LIBRARY_PRIMARY
  is '出库信息主表';
comment on column ERP.T_LIBRARY_PRIMARY.id
  is '主键';
comment on column ERP.T_LIBRARY_PRIMARY.order_no_id
  is '出单号';
comment on column ERP.T_LIBRARY_PRIMARY.purchase_order_id
  is '对应单据';
comment on column ERP.T_LIBRARY_PRIMARY.library_date
  is '出库时间';
comment on column ERP.T_LIBRARY_PRIMARY.userid
  is '出货人';
comment on column ERP.T_LIBRARY_PRIMARY.warehouse_id
  is '出货仓库';
comment on column ERP.T_LIBRARY_PRIMARY.mount_meoey
  is '金额';
comment on column ERP.T_LIBRARY_PRIMARY.remarks
  is '备注';
comment on column ERP.T_LIBRARY_PRIMARY.customer_id
  is '接收客户';
comment on column ERP.T_LIBRARY_PRIMARY.createdate
  is '创建时间';
comment on column ERP.T_LIBRARY_PRIMARY.updatedate
  is '修改时间';
comment on column ERP.T_LIBRARY_PRIMARY.status
  is '状态';
alter table ERP.T_LIBRARY_PRIMARY
  add constraint PK_T_LIBRARY_PRIMARY primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_MATERIAL_REQUISITION_DETAIL
prompt ============================================
prompt
create table ERP.T_MATERIAL_REQUISITION_DETAIL
(
  id               NUMBER not null,
  productiontaskid NUMBER,
  products_id      NUMBER,
  material_number  FLOAT
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_MATERIAL_REQUISITION_DETAIL
  is '领料单_明细';
comment on column ERP.T_MATERIAL_REQUISITION_DETAIL.id
  is '主键';
comment on column ERP.T_MATERIAL_REQUISITION_DETAIL.productiontaskid
  is '生产任务单号';
comment on column ERP.T_MATERIAL_REQUISITION_DETAIL.products_id
  is '物料';
comment on column ERP.T_MATERIAL_REQUISITION_DETAIL.material_number
  is '数量';
alter table ERP.T_MATERIAL_REQUISITION_DETAIL
  add constraint PK_T_MATERIAL_REQUISITION_DETA primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_MATERIAL_REQUISITION_TEMP
prompt ==========================================
prompt
create table ERP.T_MATERIAL_REQUISITION_TEMP
(
  id               NUMBER,
  productiontaskid NUMBER,
  products_id      NUMBER,
  material_number  FLOAT,
  procedure_id     NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column ERP.T_MATERIAL_REQUISITION_TEMP.procedure_id
  is '进程ID';

prompt
prompt Creating table T_PROCESS
prompt ========================
prompt
create table ERP.T_PROCESS
(
  id               NUMBER not null,
  name             VARCHAR2(100),
  reference_price  FLOAT,
  processing_cycle FLOAT,
  remarks          VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PROCESS
  is '加工工序';
comment on column ERP.T_PROCESS.id
  is '主键';
comment on column ERP.T_PROCESS.name
  is '工序名称';
comment on column ERP.T_PROCESS.reference_price
  is '参考单价';
comment on column ERP.T_PROCESS.processing_cycle
  is '加工周期';
comment on column ERP.T_PROCESS.remarks
  is '备注';
alter table ERP.T_PROCESS
  add constraint PK_T_PROCESS primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESSING_SINGLE_DETAIL
prompt =========================================
prompt
create table ERP.T_PROCESSING_SINGLE_DETAIL
(
  id                 NUMBER not null,
  processingsingleid NUMBER,
  startdate          DATE,
  enddate            DATE,
  products_id        NUMBER,
  processingnumber   FLOAT,
  processid          NUMBER,
  salesorderbomid    NUMBER,
  productionmark     NUMBER,
  tier               NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PROCESSING_SINGLE_DETAIL
  is '加工单入库_明细';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.id
  is '主键';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.processingsingleid
  is '加工单头表id';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.startdate
  is '生产日期';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.enddate
  is '结束日期';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.products_id
  is '物料';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.processingnumber
  is '数量';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.processid
  is '工序';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.salesorderbomid
  is '销售订单分解结构表ID';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.productionmark
  is '生产标示';
comment on column ERP.T_PROCESSING_SINGLE_DETAIL.tier
  is '层级';
alter table ERP.T_PROCESSING_SINGLE_DETAIL
  add constraint PK_PROCESSING_SINGLE_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESSING_SINGLE_PRIMARY
prompt ==========================================
prompt
create table ERP.T_PROCESSING_SINGLE_PRIMARY
(
  id                 NUMBER not null,
  processingsingleid VARCHAR2(50),
  purchase_order_id  NUMBER,
  createdate         VARCHAR2(20),
  status             NUMBER,
  remarks            VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PROCESSING_SINGLE_PRIMARY
  is '加工单_头表';
comment on column ERP.T_PROCESSING_SINGLE_PRIMARY.id
  is '主键';
comment on column ERP.T_PROCESSING_SINGLE_PRIMARY.processingsingleid
  is '加工单号';
comment on column ERP.T_PROCESSING_SINGLE_PRIMARY.purchase_order_id
  is '销售订单';
comment on column ERP.T_PROCESSING_SINGLE_PRIMARY.createdate
  is '创建日期';
comment on column ERP.T_PROCESSING_SINGLE_PRIMARY.status
  is '状态';
comment on column ERP.T_PROCESSING_SINGLE_PRIMARY.remarks
  is '描述';
alter table ERP.T_PROCESSING_SINGLE_PRIMARY
  add constraint PK_PROCESSING_SINGLE_PRIMARY primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCUREMENT_DEMAND_DETAIL
prompt ==========================================
prompt
create table ERP.T_PROCUREMENT_DEMAND_DETAIL
(
  id             NUMBER not null,
  procuremenid   NUMBER,
  productsid     NUMBER,
  demand_number  NUMBER,
  remarks        VARCHAR2(500),
  ismainproducts NUMBER default 0
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PROCUREMENT_DEMAND_DETAIL
  is '采购需求清单明细表';
comment on column ERP.T_PROCUREMENT_DEMAND_DETAIL.id
  is '主键';
comment on column ERP.T_PROCUREMENT_DEMAND_DETAIL.procuremenid
  is '采购需求头表ID';
comment on column ERP.T_PROCUREMENT_DEMAND_DETAIL.productsid
  is '产品编号';
comment on column ERP.T_PROCUREMENT_DEMAND_DETAIL.demand_number
  is '数量';
comment on column ERP.T_PROCUREMENT_DEMAND_DETAIL.remarks
  is '备注';
comment on column ERP.T_PROCUREMENT_DEMAND_DETAIL.ismainproducts
  is '是否主要材料';
alter table ERP.T_PROCUREMENT_DEMAND_DETAIL
  add constraint PK_T_PROCUREMENT_DEMAND_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCUREMENT_DEMAND_PRIMARY
prompt ===========================================
prompt
create table ERP.T_PROCUREMENT_DEMAND_PRIMARY
(
  id         NUMBER not null,
  createdate VARCHAR2(30),
  limitdate  VARCHAR2(30),
  userid     NUMBER,
  order_id   VARCHAR2(50),
  status     NUMBER default 0,
  remarks    VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PROCUREMENT_DEMAND_PRIMARY
  is '采购需求清单头表';
comment on column ERP.T_PROCUREMENT_DEMAND_PRIMARY.id
  is '主键';
comment on column ERP.T_PROCUREMENT_DEMAND_PRIMARY.createdate
  is '申请日期';
comment on column ERP.T_PROCUREMENT_DEMAND_PRIMARY.limitdate
  is '期限';
comment on column ERP.T_PROCUREMENT_DEMAND_PRIMARY.userid
  is '创建人';
comment on column ERP.T_PROCUREMENT_DEMAND_PRIMARY.order_id
  is '单据号';
comment on column ERP.T_PROCUREMENT_DEMAND_PRIMARY.status
  is '状态';
comment on column ERP.T_PROCUREMENT_DEMAND_PRIMARY.remarks
  is '备注';
alter table ERP.T_PROCUREMENT_DEMAND_PRIMARY
  add constraint PK_T_PROCUREMENT_DEMAND_PRIMAR primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PRODUCTIONSTORAGE_DETAIL
prompt =========================================
prompt
create table ERP.T_PRODUCTIONSTORAGE_DETAIL
(
  id                 NUMBER not null,
  processingsingleid NUMBER,
  products_id        NUMBER,
  processingnumber   FLOAT,
  warehouse_type     NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PRODUCTIONSTORAGE_DETAIL
  is '加工单入库_明细';
comment on column ERP.T_PRODUCTIONSTORAGE_DETAIL.id
  is '主键';
comment on column ERP.T_PRODUCTIONSTORAGE_DETAIL.processingsingleid
  is '加工单头表id';
comment on column ERP.T_PRODUCTIONSTORAGE_DETAIL.products_id
  is '物料';
comment on column ERP.T_PRODUCTIONSTORAGE_DETAIL.processingnumber
  is '数量';
comment on column ERP.T_PRODUCTIONSTORAGE_DETAIL.warehouse_type
  is '产品类型 0:成本，1为剩余物料（半成品）';
alter table ERP.T_PRODUCTIONSTORAGE_DETAIL
  add constraint PK_PRODUCTIONSTORAGE_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PRODUCTIONTASK
prompt ===============================
prompt
create table ERP.T_PRODUCTIONTASK
(
  id                 NUMBER not null,
  production_order   VARCHAR2(150),
  startdate          DATE,
  enddate            DATE,
  inventory_countid  NUMBER,
  processingsingleid VARCHAR2(50),
  status             NUMBER default 0
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PRODUCTIONTASK
  is '生产任务单';
comment on column ERP.T_PRODUCTIONTASK.id
  is '主键';
comment on column ERP.T_PRODUCTIONTASK.production_order
  is '生产单号';
comment on column ERP.T_PRODUCTIONTASK.startdate
  is '生产日期';
comment on column ERP.T_PRODUCTIONTASK.enddate
  is '结束日期';
comment on column ERP.T_PRODUCTIONTASK.inventory_countid
  is '加工单ID';
comment on column ERP.T_PRODUCTIONTASK.processingsingleid
  is '加工单编号';
comment on column ERP.T_PRODUCTIONTASK.status
  is '状态(1：领料   2：生产   3：验收   4：完成)';
alter table ERP.T_PRODUCTIONTASK
  add constraint PK_T_PRODUCTIONTASK primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PRODUCTIONTASK_DETAIL
prompt ======================================
prompt
create table ERP.T_PRODUCTIONTASK_DETAIL
(
  id               NUMBER not null,
  productiontaskid NUMBER,
  products_id      NUMBER,
  processingnumber FLOAT,
  processid        NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PRODUCTIONTASK_DETAIL
  is '生产任务单明细';
comment on column ERP.T_PRODUCTIONTASK_DETAIL.id
  is '主键';
comment on column ERP.T_PRODUCTIONTASK_DETAIL.productiontaskid
  is '生产任务单主表ID';
comment on column ERP.T_PRODUCTIONTASK_DETAIL.products_id
  is '物料';
comment on column ERP.T_PRODUCTIONTASK_DETAIL.processingnumber
  is '数量';
comment on column ERP.T_PRODUCTIONTASK_DETAIL.processid
  is '工序';
alter table ERP.T_PRODUCTIONTASK_DETAIL
  add constraint PK_T_PRODUCTIONTASK_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PRODUCTPROCESS
prompt ===============================
prompt
create table ERP.T_PRODUCTPROCESS
(
  id            NUMBER not null,
  bomprimary_id NUMBER,
  process_id    NUMBER,
  process_price FLOAT,
  process_cycle FLOAT,
  remarks       VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PRODUCTPROCESS
  is '物料工序维护';
comment on column ERP.T_PRODUCTPROCESS.id
  is '主键';
comment on column ERP.T_PRODUCTPROCESS.bomprimary_id
  is '产品结构ID';
comment on column ERP.T_PRODUCTPROCESS.process_id
  is '工序ID';
comment on column ERP.T_PRODUCTPROCESS.process_price
  is '价格';
comment on column ERP.T_PRODUCTPROCESS.process_cycle
  is '周期';
comment on column ERP.T_PRODUCTPROCESS.remarks
  is '备注';
alter table ERP.T_PRODUCTPROCESS
  add constraint PK_T_PRODUCTPROCESS primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PRODUCTS
prompt =========================
prompt
create table ERP.T_PRODUCTS
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
  safety_stock        NUMBER default 0,
  createdate          DATE,
  updatedate          DATE,
  userid              NUMBER,
  remarks             VARCHAR2(500),
  approval            VARCHAR2(1),
  position            NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PRODUCTS
  is '产品信息';
comment on column ERP.T_PRODUCTS.id
  is '产品编码';
comment on column ERP.T_PRODUCTS.name
  is '名称';
comment on column ERP.T_PRODUCTS.long_degree
  is '长度';
comment on column ERP.T_PRODUCTS.wide_degree
  is '宽度';
comment on column ERP.T_PRODUCTS.specifications
  is '规格';
comment on column ERP.T_PRODUCTS.surface_treatment
  is '表面处理';
comment on column ERP.T_PRODUCTS.paint
  is '颜色';
comment on column ERP.T_PRODUCTS.ispaint
  is '是否油漆';
comment on column ERP.T_PRODUCTS.measurement_company
  is '计量单位';
comment on column ERP.T_PRODUCTS.source_type
  is '来源,如采购，委外加工，自加工，';
comment on column ERP.T_PRODUCTS.approvaluserid
  is '审核用户';
comment on column ERP.T_PRODUCTS.product_type
  is '产品类型';
comment on column ERP.T_PRODUCTS.processing_fee
  is '成本';
comment on column ERP.T_PRODUCTS.estimated_price
  is '预估价';
comment on column ERP.T_PRODUCTS.sales_price
  is '销售价';
comment on column ERP.T_PRODUCTS.safety_stock
  is '安全库存数量';
comment on column ERP.T_PRODUCTS.createdate
  is '创建时间';
comment on column ERP.T_PRODUCTS.updatedate
  is '修改时间';
comment on column ERP.T_PRODUCTS.userid
  is '更新用户';
comment on column ERP.T_PRODUCTS.remarks
  is '备注';
comment on column ERP.T_PRODUCTS.approval
  is '是否审核';
comment on column ERP.T_PRODUCTS.position
  is '仓库位';
alter table ERP.T_PRODUCTS
  add constraint PK_T_PRODUCTS primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PRODUCT_STRUCTURE
prompt ==================================
prompt
create table ERP.T_PRODUCT_STRUCTURE
(
  id              NUMBER not null,
  productsid      NUMBER,
  sub_productsid  NUMBER,
  ismainproducts  NUMBER,
  group_id        NUMBER,
  ma_al_meterials NUMBER,
  products_number NUMBER,
  createdate      VARCHAR2(20),
  updatedate      VARCHAR2(20)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PRODUCT_STRUCTURE
  is '产品结构清单';
comment on column ERP.T_PRODUCT_STRUCTURE.id
  is '主键';
comment on column ERP.T_PRODUCT_STRUCTURE.productsid
  is '产品主键';
comment on column ERP.T_PRODUCT_STRUCTURE.sub_productsid
  is '子产品主键';
comment on column ERP.T_PRODUCT_STRUCTURE.ismainproducts
  is '是否主要产品';
comment on column ERP.T_PRODUCT_STRUCTURE.group_id
  is '组';
comment on column ERP.T_PRODUCT_STRUCTURE.ma_al_meterials
  is '主料或替代料';
comment on column ERP.T_PRODUCT_STRUCTURE.products_number
  is '数量';
comment on column ERP.T_PRODUCT_STRUCTURE.createdate
  is '创建时间';
comment on column ERP.T_PRODUCT_STRUCTURE.updatedate
  is '修改时间';
alter table ERP.T_PRODUCT_STRUCTURE
  add constraint PK_T_PRODUCT_STRUCTURE primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PURCHASEORDER_DETAIL
prompt =====================================
prompt
create table ERP.T_PURCHASEORDER_DETAIL
(
  id              NUMBER not null,
  purchaseorderid NUMBER,
  productsid      NUMBER,
  purchase_number NUMBER,
  price           FLOAT,
  remarks         VARCHAR2(500),
  procurementid   NUMBER,
  ordervalue      FLOAT
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PURCHASEORDER_DETAIL
  is '采购订单_明细';
comment on column ERP.T_PURCHASEORDER_DETAIL.id
  is '编号';
comment on column ERP.T_PURCHASEORDER_DETAIL.purchaseorderid
  is '采购订单头表ID';
comment on column ERP.T_PURCHASEORDER_DETAIL.productsid
  is '产品编号';
comment on column ERP.T_PURCHASEORDER_DETAIL.purchase_number
  is '数量';
comment on column ERP.T_PURCHASEORDER_DETAIL.price
  is '价格';
comment on column ERP.T_PURCHASEORDER_DETAIL.remarks
  is '备注';
comment on column ERP.T_PURCHASEORDER_DETAIL.procurementid
  is '对应需求清单明细ID';
comment on column ERP.T_PURCHASEORDER_DETAIL.ordervalue
  is '总价';
alter table ERP.T_PURCHASEORDER_DETAIL
  add constraint PK_T_PURCHASEORDER_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PURCHASEORDER_PRIMARY
prompt ======================================
prompt
create table ERP.T_PURCHASEORDER_PRIMARY
(
  id              NUMBER not null,
  purchaseorderid VARCHAR2(50),
  purchasedate    VARCHAR2(30),
  arrivaldate     VARCHAR2(30),
  customer_id     NUMBER,
  userid          NUMBER,
  warehouse_id    NUMBER,
  remarks         VARCHAR2(500),
  createdate      VARCHAR2(30),
  updatedate      VARCHAR2(30),
  status          NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_PURCHASEORDER_PRIMARY
  is '采购和销售订单_头表';
comment on column ERP.T_PURCHASEORDER_PRIMARY.id
  is '主键';
comment on column ERP.T_PURCHASEORDER_PRIMARY.purchaseorderid
  is '采购编号';
comment on column ERP.T_PURCHASEORDER_PRIMARY.purchasedate
  is '订单日期';
comment on column ERP.T_PURCHASEORDER_PRIMARY.arrivaldate
  is '到货日期';
comment on column ERP.T_PURCHASEORDER_PRIMARY.customer_id
  is '供应商';
comment on column ERP.T_PURCHASEORDER_PRIMARY.userid
  is '采购员';
comment on column ERP.T_PURCHASEORDER_PRIMARY.warehouse_id
  is '仓库';
comment on column ERP.T_PURCHASEORDER_PRIMARY.remarks
  is '备注';
comment on column ERP.T_PURCHASEORDER_PRIMARY.createdate
  is '创建时间';
comment on column ERP.T_PURCHASEORDER_PRIMARY.updatedate
  is '修改时间';
comment on column ERP.T_PURCHASEORDER_PRIMARY.status
  is '状态';
alter table ERP.T_PURCHASEORDER_PRIMARY
  add constraint PK_T_PURCHASEORDER_PRIMARY primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SALES_ORDER
prompt ============================
prompt
create table ERP.T_SALES_ORDER
(
  id             NUMBER not null,
  order_id       VARCHAR2(50),
  customer_id    NUMBER,
  payment_term   NUMBER,
  inspection     VARCHAR2(20),
  lrddate        VARCHAR2(20),
  container_type VARCHAR2(20),
  loading_port   VARCHAR2(50),
  discharge_port VARCHAR2(50),
  status         NUMBER default 0,
  price          FLOAT,
  createdate     VARCHAR2(20),
  updatedate     VARCHAR2(20),
  remarks        VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table ERP.T_SALES_ORDER
  is '销售订单';
comment on column ERP.T_SALES_ORDER.id
  is '主键';
comment on column ERP.T_SALES_ORDER.order_id
  is '销售订单';
comment on column ERP.T_SALES_ORDER.customer_id
  is '客户主键';
comment on column ERP.T_SALES_ORDER.payment_term
  is '付款方式';
comment on column ERP.T_SALES_ORDER.inspection
  is '检查日期';
comment on column ERP.T_SALES_ORDER.lrddate
  is '进港日期';
comment on column ERP.T_SALES_ORDER.container_type
  is '集装箱号';
comment on column ERP.T_SALES_ORDER.loading_port
  is '装货港口';
comment on column ERP.T_SALES_ORDER.discharge_port
  is '卸货港口';
comment on column ERP.T_SALES_ORDER.status
  is '订单状态';
comment on column ERP.T_SALES_ORDER.price
  is '总价';
comment on column ERP.T_SALES_ORDER.createdate
  is '创建时间';
comment on column ERP.T_SALES_ORDER.updatedate
  is '修改时间';
comment on column ERP.T_SALES_ORDER.remarks
  is '备注';
alter table ERP.T_SALES_ORDER
  add constraint PK_T_SALES_ORDER primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table T_SALES_ORDER_BOM
prompt ================================
prompt
create table ERP.T_SALES_ORDER_BOM
(
  id               NUMBER not null,
  order_id         VARCHAR2(50),
  products_id      NUMBER,
  qty              NUMBER,
  is_main_products NUMBER,
  main_products_id NUMBER,
  parent_id        NUMBER,
  tier             NUMBER,
  main_sub         VARCHAR2(1),
  source_type      NUMBER,
  create_date      VARCHAR2(20),
  update_date      VARCHAR2(20),
  products_bom_id  NUMBER,
  own_qty          NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_SALES_ORDER_BOM
  is '销售订单产品结构';
comment on column ERP.T_SALES_ORDER_BOM.id
  is '主键';
comment on column ERP.T_SALES_ORDER_BOM.order_id
  is '销售订单号';
comment on column ERP.T_SALES_ORDER_BOM.products_id
  is '产品编号';
comment on column ERP.T_SALES_ORDER_BOM.qty
  is '数量(计算后的)';
comment on column ERP.T_SALES_ORDER_BOM.is_main_products
  is '是否主要材料';
comment on column ERP.T_SALES_ORDER_BOM.main_products_id
  is '主料ID';
comment on column ERP.T_SALES_ORDER_BOM.parent_id
  is '父节点ID';
comment on column ERP.T_SALES_ORDER_BOM.tier
  is '层级';
comment on column ERP.T_SALES_ORDER_BOM.main_sub
  is '主料(Y),替代料(N),没有替代关系为空';
comment on column ERP.T_SALES_ORDER_BOM.source_type
  is '来源,如采购，委外加工，自加工，';
comment on column ERP.T_SALES_ORDER_BOM.create_date
  is '创建时间';
comment on column ERP.T_SALES_ORDER_BOM.update_date
  is '修改时间';
comment on column ERP.T_SALES_ORDER_BOM.products_bom_id
  is '产品结构编号';
comment on column ERP.T_SALES_ORDER_BOM.own_qty
  is '数量(计算后的)';
alter table ERP.T_SALES_ORDER_BOM
  add constraint PK_T_SALES_ORDER_BOM primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SALES_ORDER_DETAIL
prompt ===================================
prompt
create table ERP.T_SALES_ORDER_DETAIL
(
  id             NUMBER not null,
  sales_order_id VARCHAR2(20),
  products_id    NUMBER,
  position       NUMBER,
  storage_number NUMBER,
  unit_price     FLOAT,
  order_value    FLOAT,
  fsc_type       VARCHAR2(100),
  remarks        VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_SALES_ORDER_DETAIL
  is '销售订单_明细表';
comment on column ERP.T_SALES_ORDER_DETAIL.id
  is '主键';
comment on column ERP.T_SALES_ORDER_DETAIL.sales_order_id
  is '销售单号';
comment on column ERP.T_SALES_ORDER_DETAIL.products_id
  is '产品编号';
comment on column ERP.T_SALES_ORDER_DETAIL.position
  is '库位';
comment on column ERP.T_SALES_ORDER_DETAIL.storage_number
  is '销售数量';
comment on column ERP.T_SALES_ORDER_DETAIL.unit_price
  is '单价';
comment on column ERP.T_SALES_ORDER_DETAIL.order_value
  is '总价';
comment on column ERP.T_SALES_ORDER_DETAIL.fsc_type
  is '用途';
comment on column ERP.T_SALES_ORDER_DETAIL.remarks
  is '备注';
alter table ERP.T_SALES_ORDER_DETAIL
  add constraint PK_T_SALES_ORDER_DETAIL primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SALES_ORDER_PRIMARY
prompt ====================================
prompt
create table ERP.T_SALES_ORDER_PRIMARY
(
  id               NUMBER not null,
  order_id         VARCHAR2(50),
  customer_id      NUMBER,
  payment_term     NUMBER,
  inspection       VARCHAR2(20),
  lrddate          VARCHAR2(20),
  container_type   VARCHAR2(20),
  loading_port     VARCHAR2(50),
  discharge_port   VARCHAR2(50),
  status           NUMBER,
  price            FLOAT,
  createdate       VARCHAR2(20),
  updatedate       VARCHAR2(20),
  remarks          VARCHAR2(500),
  currency_payment NUMBER,
  contractnumber   VARCHAR2(50),
  userid           NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_SALES_ORDER_PRIMARY
  is '销售订单';
comment on column ERP.T_SALES_ORDER_PRIMARY.id
  is '主键';
comment on column ERP.T_SALES_ORDER_PRIMARY.order_id
  is '销售订单';
comment on column ERP.T_SALES_ORDER_PRIMARY.customer_id
  is '客户主键';
comment on column ERP.T_SALES_ORDER_PRIMARY.payment_term
  is '付款方式';
comment on column ERP.T_SALES_ORDER_PRIMARY.inspection
  is '检查日期';
comment on column ERP.T_SALES_ORDER_PRIMARY.lrddate
  is '进港日期';
comment on column ERP.T_SALES_ORDER_PRIMARY.container_type
  is '集装箱号';
comment on column ERP.T_SALES_ORDER_PRIMARY.loading_port
  is '装货港口';
comment on column ERP.T_SALES_ORDER_PRIMARY.discharge_port
  is '卸货港口';
comment on column ERP.T_SALES_ORDER_PRIMARY.status
  is '订单状态';
comment on column ERP.T_SALES_ORDER_PRIMARY.price
  is '总价';
comment on column ERP.T_SALES_ORDER_PRIMARY.createdate
  is '创建时间';
comment on column ERP.T_SALES_ORDER_PRIMARY.updatedate
  is '修改时间';
comment on column ERP.T_SALES_ORDER_PRIMARY.remarks
  is '备注';
comment on column ERP.T_SALES_ORDER_PRIMARY.currency_payment
  is '付款货币';
comment on column ERP.T_SALES_ORDER_PRIMARY.contractnumber
  is '合同单号';
comment on column ERP.T_SALES_ORDER_PRIMARY.userid
  is '创建用户';
alter table ERP.T_SALES_ORDER_PRIMARY
  add constraint PK_T_SALES_ORDER_PRIMARY primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_STOCK
prompt ======================
prompt
create table ERP.T_STOCK
(
  id           NUMBER not null,
  products_id  NUMBER,
  warehouse_id NUMBER,
  stock_number FLOAT default 0,
  position     NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_STOCK
  is '库存信息';
comment on column ERP.T_STOCK.id
  is '主键';
comment on column ERP.T_STOCK.products_id
  is '商品编号';
comment on column ERP.T_STOCK.warehouse_id
  is '所属仓库';
comment on column ERP.T_STOCK.stock_number
  is '库存数量';
comment on column ERP.T_STOCK.position
  is '库位';
alter table ERP.T_STOCK
  add constraint PK_T_STOCK primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_STORAGE_DETAIL
prompt ===============================
prompt
create table ERP.T_STORAGE_DETAIL
(
  id               NUMBER not null,
  storageprimaryid NUMBER,
  products_id      NUMBER,
  position         NUMBER,
  storage_number   NUMBER,
  use              VARCHAR2(100),
  remarks          VARCHAR2(500)
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_STORAGE_DETAIL
  is '入库信息_明细表';
comment on column ERP.T_STORAGE_DETAIL.id
  is '主键';
comment on column ERP.T_STORAGE_DETAIL.storageprimaryid
  is '入库单号';
comment on column ERP.T_STORAGE_DETAIL.products_id
  is '产品编号';
comment on column ERP.T_STORAGE_DETAIL.position
  is '库位';
comment on column ERP.T_STORAGE_DETAIL.storage_number
  is '入库数量';
comment on column ERP.T_STORAGE_DETAIL.use
  is '用途';
comment on column ERP.T_STORAGE_DETAIL.remarks
  is '备注';
alter table ERP.T_STORAGE_DETAIL
  add constraint PK_T_STORAGE_BODY primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_STORAGE_PRIMARY
prompt ================================
prompt
create table ERP.T_STORAGE_PRIMARY
(
  id                NUMBER not null,
  order_no_id       VARCHAR2(50),
  storage_date      VARCHAR2(20),
  purchase_order_id VARCHAR2(50),
  userid            NUMBER,
  warehouse_id      NUMBER,
  mount_meoey       FLOAT,
  remarks           VARCHAR2(500),
  customer_id       NUMBER,
  createdate        VARCHAR2(20),
  updatedate        VARCHAR2(20),
  status            NUMBER
)
tablespace EPRVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ERP.T_STORAGE_PRIMARY
  is '入库信息_主表';
comment on column ERP.T_STORAGE_PRIMARY.id
  is '主键';
comment on column ERP.T_STORAGE_PRIMARY.order_no_id
  is '入库单号';
comment on column ERP.T_STORAGE_PRIMARY.storage_date
  is '入库时间';
comment on column ERP.T_STORAGE_PRIMARY.purchase_order_id
  is '对应单据';
comment on column ERP.T_STORAGE_PRIMARY.userid
  is '收货人';
comment on column ERP.T_STORAGE_PRIMARY.warehouse_id
  is '收入仓库';
comment on column ERP.T_STORAGE_PRIMARY.mount_meoey
  is '金额';
comment on column ERP.T_STORAGE_PRIMARY.remarks
  is '备注';
comment on column ERP.T_STORAGE_PRIMARY.customer_id
  is '发货客户';
comment on column ERP.T_STORAGE_PRIMARY.createdate
  is '创建时间';
comment on column ERP.T_STORAGE_PRIMARY.updatedate
  is '修改时间';
comment on column ERP.T_STORAGE_PRIMARY.status
  is '是否入库';
alter table ERP.T_STORAGE_PRIMARY
  add constraint PK_T_STORAGE_HEADER primary key (ID)
  using index 
  tablespace EPRVIEW
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence SEQUENCE_POSITION
prompt ===================================
prompt
create sequence ERP.SEQUENCE_POSITION
minvalue 1
maxvalue 999999999
start with 42
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_PROCEDURE_ID
prompt =======================================
prompt
create sequence ERP.SEQUENCE_PROCEDURE_ID
minvalue 1
maxvalue 999999999
start with 31
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_AUTHORITIES
prompt ==========================================
prompt
create sequence ERP.SEQUENCE_SYS_AUTHORITIES
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_DEPT
prompt ===================================
prompt
create sequence ERP.SEQUENCE_SYS_DEPT
minvalue 1
maxvalue 999999999
start with 11
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_ENTERPRISE
prompt =========================================
prompt
create sequence ERP.SEQUENCE_SYS_ENTERPRISE
minvalue 1
maxvalue 99999999
start with 1
increment by 1
cache 5
order;

prompt
prompt Creating sequence SEQUENCE_SYS_FILEINFO
prompt =======================================
prompt
create sequence ERP.SEQUENCE_SYS_FILEINFO
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_MAIL_LIST
prompt ========================================
prompt
create sequence ERP.SEQUENCE_SYS_MAIL_LIST
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_MENU
prompt ===================================
prompt
create sequence ERP.SEQUENCE_SYS_MENU
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 5
order;

prompt
prompt Creating sequence SEQUENCE_SYS_NOTICE
prompt =====================================
prompt
create sequence ERP.SEQUENCE_SYS_NOTICE
minvalue 1
maxvalue 99999999
start with 6
increment by 1
cache 5
order;

prompt
prompt Creating sequence SEQUENCE_SYS_RESOURCEINFO
prompt ===========================================
prompt
create sequence ERP.SEQUENCE_SYS_RESOURCEINFO
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_ROLE
prompt ===================================
prompt
create sequence ERP.SEQUENCE_SYS_ROLE
minvalue 1
maxvalue 99999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_USER
prompt ===================================
prompt
create sequence ERP.SEQUENCE_SYS_USER
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_WAREHOUSE
prompt ========================================
prompt
create sequence ERP.SEQUENCE_SYS_WAREHOUSE
minvalue 1
maxvalue 999999999
start with 12
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_ACCEPTANCELIST
prompt ===========================================
prompt
create sequence ERP.SEQUENCE_T_ACCEPTANCELIST
minvalue 1
maxvalue 999999999
start with 151
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_BOM_DETAIL
prompt =======================================
prompt
create sequence ERP.SEQUENCE_T_BOM_DETAIL
minvalue 1
maxvalue 999999999
start with 101
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_BOM_PRIMARY
prompt ========================================
prompt
create sequence ERP.SEQUENCE_T_BOM_PRIMARY
minvalue 1
maxvalue 999999999
start with 31
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_BOM_SUB
prompt ====================================
prompt
create sequence ERP.SEQUENCE_T_BOM_SUB
minvalue 1
maxvalue 999999999
start with 51
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_CUSTOMER
prompt =====================================
prompt
create sequence ERP.SEQUENCE_T_CUSTOMER
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_CUTTING_SCHEME
prompt ===========================================
prompt
create sequence ERP.SEQUENCE_T_CUTTING_SCHEME
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_INVENTORY_DETAIL
prompt =============================================
prompt
create sequence ERP.SEQUENCE_T_INVENTORY_DETAIL
minvalue 1
maxvalue 999999999
start with 341
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_INVENTORY_PRIMARY
prompt ==============================================
prompt
create sequence ERP.SEQUENCE_T_INVENTORY_PRIMARY
minvalue 1
maxvalue 999999999
start with 11
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_LIBRARY_DETAIL
prompt ===========================================
prompt
create sequence ERP.SEQUENCE_T_LIBRARY_DETAIL
minvalue 1
maxvalue 999999999
start with 11
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_LIBRARY_PRIMARY
prompt ============================================
prompt
create sequence ERP.SEQUENCE_T_LIBRARY_PRIMARY
minvalue 1
maxvalue 999999999
start with 11
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_MATERIAL_DETAIL
prompt ============================================
prompt
create sequence ERP.SEQUENCE_T_MATERIAL_DETAIL
minvalue 1
maxvalue 999999999
start with 721
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_MATERIAL_PRIMARY
prompt =============================================
prompt
create sequence ERP.SEQUENCE_T_MATERIAL_PRIMARY
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PROCESS
prompt ====================================
prompt
create sequence ERP.SEQUENCE_T_PROCESS
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PROCESSING_DETAIL
prompt ==============================================
prompt
create sequence ERP.SEQUENCE_T_PROCESSING_DETAIL
minvalue 1
maxvalue 999999999
start with 101
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PROCESSING_PRIMARY
prompt ===============================================
prompt
create sequence ERP.SEQUENCE_T_PROCESSING_PRIMARY
minvalue 1
maxvalue 999999999
start with 51
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PROCUREMENT_DETAIL
prompt ===============================================
prompt
create sequence ERP.SEQUENCE_T_PROCUREMENT_DETAIL
minvalue 1
maxvalue 999999999
start with 31
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PROCUREMENT_PRIMARY
prompt ================================================
prompt
create sequence ERP.SEQUENCE_T_PROCUREMENT_PRIMARY
minvalue 1
maxvalue 999999999
start with 31
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PRODUCTIONSTORAGE
prompt ==============================================
prompt
create sequence ERP.SEQUENCE_T_PRODUCTIONSTORAGE
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PRODUCTIONTASK
prompt ===========================================
prompt
create sequence ERP.SEQUENCE_T_PRODUCTIONTASK
minvalue 1
maxvalue 999999999
start with 311
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PRODUCTION_DETAIL
prompt ==============================================
prompt
create sequence ERP.SEQUENCE_T_PRODUCTION_DETAIL
minvalue 1
maxvalue 999999999
start with 631
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PRODUCTPROCESS
prompt ===========================================
prompt
create sequence ERP.SEQUENCE_T_PRODUCTPROCESS
minvalue 1
maxvalue 999999999
start with 51
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PRODUCTS
prompt =====================================
prompt
create sequence ERP.SEQUENCE_T_PRODUCTS
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PURCHASE_DETAIL
prompt ============================================
prompt
create sequence ERP.SEQUENCE_T_PURCHASE_DETAIL
minvalue 1
maxvalue 999999999
start with 31
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PURCHASE_PRIMARY
prompt =============================================
prompt
create sequence ERP.SEQUENCE_T_PURCHASE_PRIMARY
minvalue 1
maxvalue 999999999
start with 41
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_SALES_ORDER_BOM
prompt ============================================
prompt
create sequence ERP.SEQUENCE_T_SALES_ORDER_BOM
minvalue 1
maxvalue 999999999
start with 10300
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_SALES_ORDER_DETAIL
prompt ===============================================
prompt
create sequence ERP.SEQUENCE_T_SALES_ORDER_DETAIL
minvalue 1
maxvalue 999999999
start with 71
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_SALES_ORDER_PRIMARY
prompt ================================================
prompt
create sequence ERP.SEQUENCE_T_SALES_ORDER_PRIMARY
minvalue 1
maxvalue 999999999
start with 61
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_STOCK
prompt ==================================
prompt
create sequence ERP.SEQUENCE_T_STOCK
minvalue 10000
maxvalue 999999999
start with 10410
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_STORAGE_DETAIL
prompt ===========================================
prompt
create sequence ERP.SEQUENCE_T_STORAGE_DETAIL
minvalue 1
maxvalue 999999999
start with 81
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_STORAGE_PRIMARY
prompt ============================================
prompt
create sequence ERP.SEQUENCE_T_STORAGE_PRIMARY
minvalue 1
maxvalue 999999999
start with 61
increment by 1
cache 10
order;

prompt
prompt Creating function GETPRODUCTS_STOCK_NUMBER
prompt ==========================================
prompt
create or replace function erp.getProducts_stock_Number(v_productId number)
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

prompt
prompt Creating function GETRELEASEBOMBYPRODUCTID
prompt ==========================================
prompt
create or replace function erp.getReleaseBOMByProductId(v_productId number)
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

prompt
prompt Creating function GETSALESORDERBOMPRODUCTNUMBER
prompt ===============================================
prompt
create or replace function erp.getSalesOrderBOMProductNumber(sales_order_bom_id number)
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

prompt
prompt Creating procedure EXPAND_PRODUCT_BOM
prompt =====================================
prompt
create or replace procedure erp.EXPAND_PRODUCT_BOM(V_SALES_ORDER_ID  IN NUMBER,
                                               V_PRODUCT_ID      IN NUMBER,
                                               V_IS_MAIN_PRODUCT IN NUMBER,
                                               V_TIER            IN NUMBER,
                                               V_QTY             IN NUMBER,
                                               V_PARENT_ID IN NUMBER) as
begin
  declare
    SALES_ORDER_ID  number; -- 销售订单编号
    PRODUCT_ID      number; -- 产品编号
    IS_MAIN_PRODUCT number; -- 是否主要产品（只展开第一成为准）
    TIER            number; -- 层级（产品本身为0）
    QTY             number; -- 数量
    PARENT_ID       number; -- 父类的id
    
    bom_qty        number; -- 数量
    bom_sub_qty    number; -- 数量
    scrap_factor   float; --损耗率
  
    SOURCE_TYPE    varchar2(50); -- 来源,如采购(120)，外加工(122)，自生产(121)
    insert_id      number; -- 产品id
    temp_parent_id number; -- 暂存的parent_id
  
    bom_primary_id number; -- 产品结构中的主表id
    
    bom_sub_primary_id number; -- 产品结构中的主表id
    
    sub_bom_primary_id number; -- 替代料的产品结构中的主表id
  
    sub_count number; -- 替代料的数量
  begin
    SALES_ORDER_ID  := V_SALES_ORDER_ID;
    PRODUCT_ID      := V_PRODUCT_ID;
    IS_MAIN_PRODUCT := V_IS_MAIN_PRODUCT;
    TIER            := V_TIER;
    QTY             := V_QTY;
    PARENT_ID := V_PARENT_ID;
  
    select t.source_type
      into SOURCE_TYPE
      from T_PRODUCTS t
     where t.id = PRODUCT_ID;
     
    select t.scrap_factor into scrap_factor from sys_param t ;
  
    dbms_output.put_line('EXPAND_PRODUCT_BOM');
    /**
    * 1、插入数据库,根据层级判断
    * 2、判断主料、替代料的关系
    * 3、判断产品来源是否是<自生产>，如果是，则递归调用自己
    *
    */
  
    -- 自生产的递归调用,考虑死循环的情况，如果层级大约100，则不继续递归
    if (SOURCE_TYPE is not null and SOURCE_TYPE = 121 and TIER < 100) then
      -- 根据产品编号找到结构主表的primary_id
      bom_primary_id := getReleaseBOMByProductId(PRODUCT_ID);
      --找到产品结构
      if (bom_primary_id is not null) then
        --迭代产品结构，进行指定的操作
        for p in (select t.id,
                         t.primary_id,
                         t.sub_products_id,
                         t.is_main_products,
                         t.qty
                    from t_bom_detail t
                   where t.primary_id = bom_primary_id) loop
        
          select decode(TIER, 1, p.is_main_products, IS_MAIN_PRODUCT)
            into IS_MAIN_PRODUCT
            from dual;
            
          select decode(TIER, 1, round(p.qty * QTY * (1+scrap_factor)), p.qty * QTY)
            into bom_qty
            from dual;
        
          -- dbms_output.put_line(p.id);
          -- 查找产品的来源,如采购(120)，外加工(122)，自生产(121)
          select t.source_type
            into SOURCE_TYPE
            from T_PRODUCTS t
           where t.id = p.sub_products_id;
          -- 需要插入的ID
          select SEQUENCE_T_SALES_ORDER_BOM.nextval
            into insert_id
            from dual;
        
          -- 查询是否有主料、替代料
          select count(1)
            into sub_count
            from T_BOM_SUB t
           where t.primary_id = p.primary_id
             and t.main_products_id = p.sub_products_id;
             
          --获取产品结构id
          bom_sub_primary_id := getReleaseBOMByProductId(p.sub_products_id);
          
           
        
          --层级为1的时候,需要获取[是否为主要材料]值,计算主料、替代料,parentId
          --继承[是否是主要材料],计算主料、替代料,parentId
          insert into T_SALES_ORDER_BOM
            (ID,
             ORDER_ID,
             PRODUCTS_ID,
             PRODUCTS_BOM_ID,
             OWN_QTY,
             QTY,
             TIER,
             SOURCE_TYPE,
             PARENT_ID,
             IS_MAIN_PRODUCTS,
             MAIN_SUB)
          values
            (insert_id,
             SALES_ORDER_ID,
             p.sub_products_id,
             bom_sub_primary_id,
             p.qty,
             bom_qty,
             TIER,
             SOURCE_TYPE,
             PARENT_ID,
             IS_MAIN_PRODUCT,
             decode(sub_count, 0, '', 'Y'));
          commit;
          --dbms_output.put_line(2);
        
          temp_parent_id := insert_id;
        
          --添加替代料
          if (sub_count is not null and sub_count > 0) then
            for sub in (select t.sub_products_id,
                               t.qty,
                               t.primary_id,
                               t.main_products_id
                          from T_BOM_SUB t
                         where t.primary_id = p.primary_id
                           and t.main_products_id = p.sub_products_id) loop
            
              -- 产品来源                  
              select t.source_type
                into SOURCE_TYPE
                from T_PRODUCTS t
               where t.id = sub.sub_products_id;
              -- 需要插入的ID
              select SEQUENCE_T_SALES_ORDER_BOM.nextval
                into insert_id
                from dual;
                
          select decode(TIER, 1, round(sub.qty * QTY * (1+scrap_factor)), sub.qty * QTY)
            into bom_sub_qty
            from dual;
            
            sub_bom_primary_id := getReleaseBOMByProductId(sub.sub_products_id);
            
              --插入替代料   
              insert into T_SALES_ORDER_BOM
                (ID,
                 ORDER_ID,
                 PRODUCTS_ID,
                 PRODUCTS_BOM_ID,
                 OWN_QTY,
                 QTY,
                 TIER,
                 SOURCE_TYPE,
                 PARENT_ID,
                 IS_MAIN_PRODUCTS,
                 MAIN_PRODUCTS_ID,
                 MAIN_SUB)
              values
                (insert_id,
                 SALES_ORDER_ID,
                 sub.sub_products_id,
                 sub_bom_primary_id,
                 sub.qty,
                 bom_sub_qty,
                 TIER,
                 SOURCE_TYPE,
                 PARENT_ID,
                 IS_MAIN_PRODUCT,
                 sub.main_products_id,
                 'N');
              commit;
            
            end loop;
          end if;
        
          --递归调用存储过程，展开产品
          EXPAND_PRODUCT_BOM(SALES_ORDER_ID,
                             p.sub_products_id,
                             IS_MAIN_PRODUCT,
                             TIER + 1,
                             bom_qty,
                             temp_parent_id);
        
        end loop;
      end if;
    
    end if;
  end;
end EXPAND_PRODUCT_BOM;
/

prompt
prompt Creating procedure EXPAND_SALES_ORDER_BOM
prompt =========================================
prompt
create or replace procedure erp.expand_sales_order_bom(sales_order_id in number) as
begin
  declare
    --count_products number;
    input_id    number;
    SOURCE_TYPE varchar2(50); -- 来源,如采购(120)，外加工(122)，自生产(121)
    insert_id   number; -- 产品id
    bom_primary_id number; -- 产品结构中的主表id
  begin
    input_id := sales_order_id;
    --查询销售订单中的产品明细
    for so in (select t.id,
                      t.sales_order_id, -- 销售订单id
                      t.products_id, -- 产品编号
                      t.storage_number --数量
                 from T_SALES_ORDER_DETAIL t
                where t.sales_order_id = input_id) loop
      dbms_output.put_line(so.id || ' : ' || so.sales_order_id || ' : ' ||
                           so.products_id);
    
      select SEQUENCE_T_SALES_ORDER_BOM.nextval into insert_id from dual;
    
      select t.source_type
        into SOURCE_TYPE
        from T_PRODUCTS t
       where t.id = so.products_id;
       
       bom_primary_id := getReleaseBOMByProductId(so.products_id);
       
      --插入顶级的产品
      insert into T_SALES_ORDER_BOM
        (ID, ORDER_ID, PRODUCTS_ID,PRODUCTS_BOM_ID, QTY, OWN_QTY, TIER, SOURCE_TYPE)
      values
        (insert_id,
         so.sales_order_id,
         so.products_id,
         bom_primary_id,
         so.storage_number,
         so.storage_number,
         0,
         SOURCE_TYPE);
       commit;  
      --展开的每个产品                       
      EXPAND_PRODUCT_BOM(so.sales_order_id,
                         so.products_id,
                         '',
                         1,
                         so.storage_number,
                         insert_id);
    end loop;
  end;
end expand_sales_order_bom;
/

prompt
prompt Creating procedure TASK_PRODUCTION_TASK
prompt =======================================
prompt
create or replace procedure erp.task_Production_task(v_ProcessingSingleID number) as
begin
declare
       procedure_id number;           --进程ID
       t_processingSingleID  number; -- 生产单id
       t_status number;          --生产单状态
       task_id number;           --生产任务主表ID
       task_detail_id number;    --生产任务单明细ID
       acceptanceList_id number; --验收单ID
       productionStorageID number;   --生产单入库ID
       t_dateChar char(8);
       bomPrimaryID number;   --销售订单产品结构ID
       order_id number;  --销售订单
       processingsingleid VARCHAR2(50); --加工单
       substitute_number FLOAT; --替代料数量
       main_product_number FLOAT;  --主产品数量
       Material_id number; --领料明细ID
       stock_Number FLOAT; --产品库存数量
       scrap_factor FLOAT; --损耗率
       cutting_number FLOAT;  --原材料数量
       isCutting    number;  --是否需要查找切割方案 (0 查找切割方案，不等于0的，直接查看结构子类)
       --processStr varcahr(500);
begin
        t_processingSingleID  := v_ProcessingSingleID;

    select t.status,purchase_order_id,processingsingleid  into t_status, order_id,processingsingleid from t_processing_single_primary t where t.id= t_processingSingleID;
    select to_char(sysdate,'yyyymmdd') into t_dateChar from dual;
        if(t_status = 1) then
           dbms_output.PUT_LINE('生成生产任务单');

           --损耗率
           select t.scrap_factor+1 into scrap_factor from sys_param t;

           --进程编号
            select SEQUENCE_procedure_id.nextval into procedure_id from dual;

           --加工单明细列表
           for sub in (select processingsingleid,startdate, enddate
  from t_processing_single_detail t left join T_SALES_ORDER_BOM b on t.salesorderbomid=b.id
 where t.processingsingleid =t_processingSingleID and t.PRODUCTIONMARK = 0
 group by processingsingleid, startdate, enddate) loop
             dbms_output.PUT_LINE(sub.startdate);

             --获取生产任务主表ID
             select SEQUENCE_T_ProductionTask.nextval into task_id from dual;

             --插入主表数据
             insert into T_ProductionTask (ID,Production_order,Inventory_countID,STARTDATE,ENDDATE,Processingsingleid) values (task_id,t_dateChar || task_id ,t_processingSingleID,sub.startdate,sub.enddate,processingsingleid);

             --获取指定开始和结束日期的加工明细列表
             for task in ( select t.products_id,processingnumber,T.SALESORDERBOMID,b.main_sub,b.tier  from t_processing_single_detail t left join T_SALES_ORDER_BOM b on t.salesorderbomid=b.id where t.processingsingleid=t_processingSingleID  and t.productionmark=0 and startdate=sub.startdate and enddate=sub.enddate  order by b.tier) loop
                 --初始化替代料总数0
                 substitute_number :=0;

                 --查看是否拥有替代料
                 if(task.main_sub='Y') then
                    --获取替代料信息
                    for substitute in (select t.products_id from  T_SALES_ORDER_BOM t  where t.order_id=order_id and t.main_sub='N' and t.tier=task.tier and t.main_products_id=task.products_id) loop

                       --替代料库存数量
                       substitute_number:=getProducts_stock_Number(substitute.products_id);
                       if (substitute_number != 0) then
                         --领料明细
                         select SEQUENCE_t_Material_DETAIL.nextval into Material_id from dual;
                         insert into t_Material_requisition_TEMP (ID,PROCEDURE_ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) values (Material_id,procedure_id,task_id,substitute.products_id,substitute_number*scrap_factor);
                         dbms_output.PUT_LINE('替代料库:' || task.products_id || '，领料生产数量：' || cutting_number);
                       end if;
                    end loop;
                 end if;

                 --获取产品库存数量
                 stock_Number := getProducts_stock_Number(task.products_id);
                 dbms_output.PUT_LINE('库存数量' || stock_Number);
                 --主产品需要生产的数量
                 main_product_number := getSalesOrderBOMProductNumber(task.SALESORDERBOMID);
                  dbms_output.PUT_LINE('结构ID：' || task.SALESORDERBOMID || '    生产数量' || main_product_number);
                 --库存数量大于需要生产的数量的时候，不需要进行生产
                 if(stock_Number < main_product_number) then

                                 --主产品实际需要生产的数量
                                 main_product_number := main_product_number - stock_Number;

                                 --获取生产任务明细表ID
                                 select SEQUENCE_T_Production_DETAIL.nextval into task_detail_id from dual;
                                 insert into T_PRODUCTIONTASK_DETAIL (id,productiontaskid,products_id,processingnumber)values(task_detail_id,task_id,task.products_id,task.processingnumber-substitute_number);

                                 --获取产品结构主键
                                 bomPrimaryID :=task.SALESORDERBOMID;

                                 for process in (select * from T_PRODUCTPROCESS pr left join t_process ce on pr.process_id = ce.id LEFT JOIN ( select id, bomP.Products_Id
               from t_bom_primary bomP where bomP.Eff_Status = '1' and bomP.Effdt =
                    (select Max(bomb.effdt) from t_bom_primary bomb where bomP.Eff_Status = bomb.eff_status)) bomA on bomA.id = pr.bomprimary_id
    where bomA.products_id=task.products_id) loop
                                    select SEQUENCE_T_AcceptanceList.nextval into acceptanceList_id from dual;
                                    insert into T_AcceptanceList (id,productiontaskid,products_id,processid,Isacceptance)values(acceptanceList_id,task_id,task.products_id,process.process_id,'0');
                                 end loop;

                                 --领料单数据初始化
                                 if(main_product_number > 0) then
                                        --判断当前产品是否拥有结构。没有的时候，去切割方案中获取原材料
                                        select count(id) into isCutting from t_sales_order_bom t where t.order_id=order_id and t.parent_id=task.salesorderbomid;
                                        if(isCutting > 0) then
                                               --获取结构子类的非自产产品
                                               for matreial in (select t.id,t.products_id,t.own_qty from t_sales_order_bom t where t.order_id=order_id and t.source_type ='120' and t.parent_id=task.salesorderbomid) loop
                                                    --领料明细
                                                   select SEQUENCE_t_Material_DETAIL.nextval into Material_id from dual;
                                                   select ceil(main_product_number*matreial.own_qty) into cutting_number from dual;
                                                   insert into t_Material_requisition_TEMP (ID,PROCEDURE_ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) values (Material_id,procedure_id,task_id,matreial.products_id,cutting_number);
                                                  --dbms_output.PUT_LINE('非自产产品:' || task.products_id || '，领料生产数量：' || main_product_number*matreial.own_qty);
                                               end loop;

                                        else
                                               --查找切割方案
                                               dbms_output.PUT_LINE('查找切割方案:');
                                               for cutting in (select * from t_cutting_scheme t where t.main_products=task.products_id and rownum=1) loop
                                                   cutting_number:= (main_product_number)/cutting.man_number;
                                                   select ceil(cutting_number) into cutting_number from dual;
                                                   dbms_output.PUT_LINE('产品:' || task.products_id || '，实际需要生产数量：' || main_product_number || '原材料数量:' || cutting_number);
                                                   --领料明细
                                                     select SEQUENCE_t_Material_DETAIL.nextval into Material_id from dual;
                                                     insert into t_Material_requisition_TEMP (ID,PROCEDURE_ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) values (Material_id,procedure_id,task_id,cutting.raw_materials,cutting_number);
                                                    dbms_output.PUT_LINE('切割产品:' || cutting.raw_materials || '，领料生产数量：' || cutting_number);

                                                    --生产入库单初始化(剩余料)
                                                    select SEQUENCE_t_productionStorage.nextval into productionStorageID from dual;
                                                    insert into t_productionStorage_DETAIL (id,processingsingleid,products_id,Processingnumber，warehouse_type) values(productionStorageID,t_processingSingleID,cutting.by_product,cutting_number*cutting.by_number,1);
                                               end loop;
                                        end if;

                                 end if;

                end if;
             end loop;
           end loop;

            --拷贝临时领料表到正式表
            Insert into T_MATERIAL_REQUISITION_DETAIL(ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER) select ID,ProductionTaskID,Products_ID,MATERIAL_NUMBER from t_Material_requisition_TEMP tem where tem.procedure_id=procedure_id;

            --生产入库单初始化(成品)
            for psdet in (select * from t_sales_order_bom where tier=0 and order_id=order_id) loop
              select SEQUENCE_t_productionStorage.nextval into productionStorageID from dual;
              insert into t_productionStorage_DETAIL (id,processingsingleid,products_id,Processingnumber，warehouse_type) values(productionStorageID,t_processingSingleID,psdet.products_id,psdet.qty,0);
            end loop;



            --delete from t_Material_requisition_TEMP;
        else
           dbms_output.PUT_LINE('已经存在生产任务单');
        end if;
        commit;
end;
end task_Production_task;
/

prompt
prompt Creating procedure TASK_PRODUCTION_DECOM
prompt ========================================
prompt
create or replace procedure erp.task_Production_Decom as
begin
declare
       isProd  number; -- 所有采购是否采购完成
begin
       --获取状态在处理中的所有采购需求头表数据
      for sub in (select * from t_processing_single_primary p where p.status=1 and exists (select 1 from T_ProductionTask t where p.id!=t.inventory_countid)) loop
        isProd  := 0;
        task_Production_task(sub.id);
      end loop;
end;
end task_Production_Decom;
/

prompt
prompt Creating procedure TASK_PURCHASING_DEMAND
prompt =========================================
prompt
create or replace procedure erp.task_Purchasing_demand as
begin
declare
       isProd  number; -- 所有采购是否采购完成
begin
       --获取状态在处理中的所有采购需求头表数据
      for sub in (select id from t_procurement_demand_primary where status = 1) loop
        isProd  := 0;
        dbms_output.PUT_LINE(isProd);
          for demandObject in (
         select p.order_id as orderID,
       s.ProductsID,
       isMainProducts,
       Demand_Number,
       nvl(sp.storageNumber,0) storageNumber
  from T_Procurement_Demand_DETAIL S
  LEFT JOIN t_Procurement_Demand_Primary p
    on s.productsid = p.id
  left join (select procurementid,
                    productsid,
                    nvl(sum(purchase_number),0) storageNumber
               from t_purchaseorder_detail pd
               left join t_purchaseorder_primary pp
                 on pd.purchaseorderid = pp.id
              where pp.status = 3
              group by procurementid, productsid) sp
    on s.id = sp.procurementid
 where ProcuremenID = sub.id ) loop
                   --处理数据
                 if(isProd = 0) then
                   if (demandObject.Demand_Number != demandObject.storageNumber) then
                     isProd  := 1;
                     dbms_output.PUT_LINE('未完成');
                     exit;
                   end if;
                 end if;
          end loop;
          if(isProd = 0) then
               --修改当前采购需求单状态
               update t_Procurement_Demand_Primary set status = 2 where id = sub.id;
                dbms_output.PUT_LINE('完成');
               commit;
          end if;
      end loop;
end;
end task_Purchasing_demand;
/

prompt
prompt Creating trigger LIBRARY_PRIMARY_T
prompt ==================================
prompt
CREATE OR REPLACE TRIGGER ERP.library_Primary_T
BEFORE DELETE OR INSERT OR UPDATE
ON t_library_Primary
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table t_library_Primary');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into createDate from dual;
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.CREATEDATE := createDate;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table t_library_Primary');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table t_library_Primary');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table t_library_Primary');
END;
/

prompt
prompt Creating trigger PRODUCT_STRUCTURE_T
prompt ====================================
prompt
CREATE OR REPLACE TRIGGER ERP.product_structure_T
BEFORE DELETE OR INSERT OR UPDATE
ON t_product_structure
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table t_product_structure');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into createDate from dual;
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.CREATEDATE := createDate;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table t_product_structure');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table t_product_structure');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table t_product_structure');
END;
/

prompt
prompt Creating trigger SALES_ORDER_PRIMARY_T
prompt ======================================
prompt
CREATE OR REPLACE TRIGGER ERP.SALES_ORDER_PRIMARY_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_SALES_ORDER_PRIMARY
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_SALES_ORDER_PRIMARY');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into createDate from dual;
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.CREATEDATE := createDate;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_SALES_ORDER_PRIMARY');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_SALES_ORDER_PRIMARY');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_SALES_ORDER_PRIMARY');
END;
/

prompt
prompt Creating trigger STORAGE_PRIMARY_T
prompt ==================================
prompt
CREATE OR REPLACE TRIGGER ERP.Storage_Primary_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_Storage_Primary
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_Storage_Primary');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into createDate from dual;
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.CREATEDATE := createDate;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_Storage_Primary');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_Storage_Primary');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_Storage_Primary');
END;
/

prompt
prompt Creating trigger SYS_FILEINFO_T
prompt ===============================
prompt
CREATE OR REPLACE TRIGGER ERP.SYS_FILEINFO_T
BEFORE DELETE OR INSERT OR UPDATE
ON SYS_FILEINFO
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table SYS_FILEINFO');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into createDate from dual;
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.CREATEDATE := createDate;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table SYS_FILEINFO');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table SYS_FILEINFO');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table SYS_FILEINFO');
END;
/

prompt
prompt Creating trigger SYS_NOTICE_T
prompt =============================
prompt
CREATE OR REPLACE TRIGGER ERP.SYS_NOTICE_T
BEFORE DELETE OR INSERT OR UPDATE
ON SYS_NOTICE
FOR EACH ROW
DECLARE
createDate    date;
modifyDate    date;
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table SYS_NOTICE');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select SYSDATE into createDate from dual;
    select SYSDATE into modifyDate from dual;
    :new.CREATEDATE := createDate;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table SYS_NOTICE');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select SYSDATE into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table SYS_NOTICE');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table SYS_NOTICE');
END;
/

prompt
prompt Creating trigger SYS_RESOURCEINFO_T
prompt ===================================
prompt
CREATE OR REPLACE TRIGGER ERP.SYS_RESOURCEINFO_T
BEFORE DELETE OR INSERT OR UPDATE
ON SYS_RESOURCEINFO
FOR EACH ROW
DECLARE
createDate    date;
modifyDate    date;
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table SYS_RESOURCEINFO');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select SYSDATE into createDate from dual;
    select SYSDATE into modifyDate from dual;
    :new.CREATETIME := createDate;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table SYS_RESOURCEINFO');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select SYSDATE into modifyDate from dual;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table SYS_RESOURCEINFO');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table SYS_RESOURCEINFO');
END;
/

prompt
prompt Creating trigger SYS_ROLE_T
prompt ===========================
prompt
CREATE OR REPLACE TRIGGER ERP.SYS_ROLE_T
BEFORE DELETE OR INSERT OR UPDATE
ON SYS_ROLE
FOR EACH ROW
DECLARE
createDate    date;
modifyDate    date;
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table SYS_ROLE');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select SYSDATE into createDate from dual;
    select SYSDATE into modifyDate from dual;
    :new.CREATETIME := createDate;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table SYS_ROLE');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select SYSDATE into modifyDate from dual;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table SYS_ROLE');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table SYS_ROLE');
END;
/

prompt
prompt Creating trigger SYS_USER_T
prompt ===========================
prompt
CREATE OR REPLACE TRIGGER ERP.SYS_USER_T
BEFORE DELETE OR INSERT OR UPDATE
ON SYS_USER
FOR EACH ROW
DECLARE
createDate    date;
modifyDate    date;
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table SYS_USER');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select SYSDATE into createDate from dual;
    select SYSDATE into modifyDate from dual;
    :new.CREATETIME := createDate;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table SYS_USER');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select SYSDATE into modifyDate from dual;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table SYS_USER');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table SYS_USER');
END;
/


spool off
