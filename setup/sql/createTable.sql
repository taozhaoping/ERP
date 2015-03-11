/*
 * 系统数据表
 */
/*
alter table sys_role_to_authorities
   drop constraint FK_SYS_ROLE_REFERENCE_SYS_ROLE;

alter table sys_role_to_authorities
   drop constraint FK_SYS_ROLE_REFERENCE_SYS_AUTH;

alter table sys_role_to_menu
   drop constraint FK_SYS_ROLE_REFERENCE_SYS_MENU;

alter table sys_role_to_menu
   drop constraint FK_SYS_MENU_REFERENCE_SYS_ROLE;

alter table sys_user
   drop constraint FK_SYS_USER_REFERENCE_SYS_ROLE;

alter table sys_user
   drop constraint FK_SYS_USER_REFERENCE_SYS_ENTE;
*/
drop table sys_FileInfo cascade constraints;

drop table sys_Mail_list cascade constraints;

drop table SYS_AUTHORITIES cascade constraints;

drop table SYS_ENTERPRISE cascade constraints;

drop table SYS_MENU cascade constraints;

drop table SYS_RESOURCEINFO cascade constraints;

drop table SYS_ROLE cascade constraints;

drop table SYS_ROLE_TO_AUTHORITIES cascade constraints;

drop table SYS_ROLE_TO_MENU cascade constraints;

drop table SYS_PARAM cascade constraints;

drop index USER_LOGINNAME_INDEX;

drop table SYS_USER cascade constraints;

drop table SYS_NOTICE cascade constraints;

drop sequence SEQUENCE_sys_FileInfo;

drop sequence SEQUENCE_sys_Mail_list;

drop sequence SEQUENCE_SYS_AUTHORITIES;

drop sequence SEQUENCE_SYS_ENTERPRISE;

drop sequence SEQUENCE_SYS_MENU;

drop sequence SEQUENCE_SYS_RESOURCEINFO;

drop sequence SEQUENCE_SYS_ROLE;

drop sequence SEQUENCE_SYS_USER;

drop sequence SEQUENCE_SYS_NOTICE;

create sequence SEQUENCE_SYS_AUTHORITIES
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_SYS_ENTERPRISE
start with 1
 maxvalue 99999999
 minvalue 1
 cache 5
order;

create sequence SEQUENCE_SYS_MENU
start with 1
 maxvalue 999999999
 minvalue 1
 cache 5
order;

create sequence SEQUENCE_SYS_RESOURCEINFO
start with 1
 maxvalue 9999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_SYS_ROLE
start with 1
 maxvalue 99999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_SYS_USER
start with 1
 maxvalue 999999999
 minvalue 1
order
 cache 10;
 
 
create sequence SEQUENCE_SYS_NOTICE
start with 1
 maxvalue 99999999
 minvalue 1
 cache 5
order;


create sequence SEQUENCE_sys_Mail_list
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

create sequence SEQUENCE_sys_FileInfo
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;


/*==============================================================*/
/* Table: SYS_AUTHORITIES                                       */
/*==============================================================*/
create table SYS_AUTHORITIES 
(
   id                 NUMBER not null,
   name               VARCHAR2(25), --名称
   description        VARCHAR2(50), --描述
   permission 		  VARCHAR2(100), --权限
   enabled            NUMBER default '0',-- 是否启用 0启动 1:停用
   module             VARCHAR2(25)  --模块
);

alter table SYS_AUTHORITIES
  add constraint PK_SYS_AUTHORITIES_ID primary key (id);

comment on table SYS_AUTHORITIES is '权限表';
comment on column SYS_AUTHORITIES.NAME is '名称';
comment on column SYS_AUTHORITIES.DESCRIPTION is '描述';
comment on column SYS_AUTHORITIES.PERMISSION is '权限';
comment on column SYS_AUTHORITIES.ENABLED is '是否启用 0启动 1:停用';
comment on column SYS_AUTHORITIES.MODULE is '模块';

/*==============================================================*/
/* Table: sys_enterprise                                      */
/*==============================================================*/
create table SYS_ENTERPRISE 
(
   id                 NUMBER               not null,
   name               VARCHAR2(100), --企业名称
   address            VARCHAR2(150), --企业地址
   phoneCall          VARCHAR2(25),  --企业电话
   enabled            NUMBER default '0'  -- 是否启用 0启动 1:停用
);

alter table SYS_ENTERPRISE
  add constraint PK_SYS_ENTERPRISE_ID primary key (id);

comment on table SYS_ENTERPRISE is
'企业信息表';

/*==============================================================*/
/* Table: sys_menu                                            */
/*==============================================================*/
create table SYS_MENU 
(
   id                 NUMBER	not null,
   name               VARCHAR2(150), --菜单名称
   NAMESPACE          VARCHAR2(30), --NAMESPACE
   action             VARCHAR2(150), --菜单action
   url                VARCHAR2(150), --url地址
   i18n_key           VARCHAR2(100), --国际化
   enabled            VARCHAR2(1) default '0',-- 是否启用 0启动 1:停用
   parentID           NUMBER, --父类id
   reorder            NUMBER --排序
);

alter table SYS_MENU
  add constraint PK_SYS_MENU_ID primary key (id);
  
comment on table SYS_MENU is
'菜单表';

/*==============================================================*/
/* Table: sys_resourceInfo                                    */
/*==============================================================*/
create table SYS_RESOURCEINFO 
(
   id                 NUMBER               not null,
   name               VARCHAR2(30), --资源名称
   value              VARCHAR2(30), --资源属性
   type               VARCHAR2(20), --资源类别
   createTime         DATE,
   updateTime         DATE,
   enabled            NUMBER default '0'-- 是否启用 0启动 1:停用
);

alter table SYS_RESOURCEINFO
  add constraint PK_SYS_RESOURCEINFO_ID primary key (id);

comment on table SYS_RESOURCEINFO is
'资源信息表';

/*==============================================================*/
/* Table: sys_role                                            */
/*==============================================================*/
create table SYS_ROLE 
(
   id                 NUMBER               not null,
   name               VARCHAR2(50), --角色名称
   describe           VARCHAR2(100), --描述
   createTime         DATE,
   updateTime         DATE
);

alter table SYS_ROLE
  add constraint PK_SYS_ROLE_ID primary key (id);

comment on table SYS_ROLE is '角色信息表';
comment on column SYS_ROLE.NAME is '角色名称';
comment on column SYS_ROLE.DESCRIBE is '角色描述';
comment on column SYS_ROLE.CREATETIME is '创建时间';
comment on column SYS_ROLE.UPDATETIME is '更新时间';

/*==============================================================*/
/* Table: sys_role_to_authorities                             */
/*==============================================================*/
create table SYS_ROLE_TO_AUTHORITIES 
(
   role_id            NUMBER,
   authorities_id     NUMBER
);

/*==============================================================*/
/* Table: sys_role_to_menu                                    */
/*==============================================================*/
create table SYS_ROLE_TO_MENU 
(
   menu_id            NUMBER,
   role_id            NUMBER
);

comment on table SYS_ROLE_TO_MENU is
'角色和菜单中间表（一对多）';

/*==============================================================*/
/* Table: sys_system                                           */
/*==============================================================*/
create table SYS_PARAM
(
  id                 NUMBER	not null,
  emailService       VARCHAR2(50),--邮箱服务器地址
  emailForm          VARCHAR2(50),--服务器邮箱名
  emailUserName      VARCHAR2(50),--邮箱账号
  emailPassword      VARCHAR2(50), --邮箱密码
  emailisAuth        VARCHAR2(1),--是否验证 0:验证，1不验证
  emailUrlPassword   VARCHAR2(30)    -- url秘钥
);

alter table SYS_PARAM
  add constraint PK_SYS_PARAM_ID primary key (id);
  
/*==============================================================*/
/* Table: sys_user                                            */
/*==============================================================*/
create table SYS_USER 
(
   id                 NUMBER	not null,
   loginName          VARCHAR2(20)	not null, --登录账号
   userPassword       VARCHAR2(100)	not null, --登录密码
   name               VARCHAR2(20), --姓名
   enabled            VARCHAR2(1)	default '0',-- 是否启用 0启动 1:停用
   userType           VARCHAR2(1), --用户类型
   role_id            NUMBER, --角色id
   enterprise_id      NUMBER, --企业id
   email              VARCHAR2(25), --电子邮件
   age                DATE, --出生日期
   sex                VARCHAR2(1),--性别
   phone              VARCHAR2(20), -- 座机号码
   qq                 VARCHAR2(20), --qq号码
   mobile_number      VARCHAR2(20), --手机号码
   entryTime          DATE, -- 入职时间
   address            VARCHAR2(100), --家庭住址
   education_background VARCHAR2(1),
   createTime         DATE, --创建时间
   updateTime         DATE, --修改时间
   nonce			  VARCHAR2(50) --Email重置密码保存的随机数
);


alter table SYS_USER
  add constraint PK_SYS_USER_ID primary key (id);

/*==============================================================*/
/* Index: user_loginName_index                                */
/*==============================================================*/
create index USER_LOGINNAME_INDEX on SYS_USER (
   loginName ASC
);

/*==============================================================*/
/* Table: 公司公告                                            */
/*==============================================================*/
create table SYS_NOTICE 
(
   ID                   NUMBER               not null,
   TITLE                VARCHAR(60),
   CONTENT              VARCHAR(200),
   USERID               NUMBER,
   CREATEDATE           DATE,
   UPDATEDATE           DATE,
   ENABLED              NUMBER default '0',-- 是否启用 0启动 1:停用
   constraint PK_SYS_NOTICE primary key (ID)
);

comment on table SYS_NOTICE is
'公司公告';

comment on column SYS_NOTICE.ID is
'ID';

comment on column SYS_NOTICE.TITLE is
'标题';

comment on column SYS_NOTICE.CONTENT is
'内容';

comment on column SYS_NOTICE.USERID is
'创建人';

comment on column SYS_NOTICE.CREATEDATE is
'创建时间';

comment on column SYS_NOTICE.UPDATEDATE is
'修改时间';

comment on column SYS_NOTICE.ENABLED is
'是否启用';

/*==============================================================*/
/* Table: FileInfo                                            */
/* Table: 文件信息                                            */
/*==============================================================*/
create table sys_FileInfo 
(
   id                 		NUMBER	not null,
   name               		VARCHAR(100),        --文件名
   nameType           		VARCHAR(10),        --文件类型
   TYPE               		VARCHAR(100),       --种类
   Descr              		VARCHAR(100),       --描述
   createDate         		VARCHAR(30),        --创建时间
   updateDate         		VARCHAR(30),        --修改时间
   state             		VARCHAR(2),         --状态
   TechnologicalProcessID 	NUMBER,
   constraint PK_FILEINFO primary key (id)
);

/*注释*/
COMMENT ON table sys_FileInfo IS '文件信息 ';
comment on column sys_FileInfo.name is '文件名';
comment on column sys_FileInfo.nameType is '文件类型';
comment on column sys_FileInfo.TYPE is '种类';
comment on column sys_FileInfo.Descr is '描述';
comment on column sys_FileInfo.state is '状态';


/*==============================================================*/
/* Table: sys_Mail_list                                      */
/* Table: 通讯录                                                                                                                                                     */
/*==============================================================*/
create table sys_Mail_list
(
   id                 NUMBER               not null,
   createDate         VARCHAR(20),  --创建时间
   updateDate         VARCHAR(20),  --修改时间
   phone              VARCHAR(20),  --电话号码
   name               VARCHAR(25),  --姓名
   franchiseeId       NUMBER,       --加盟商ID
  constraint PK_Mail_list primary key (id)
);
/*注释*/
COMMENT ON table sys_Mail_list IS '加盟商信息';
COMMENT on column sys_Mail_list.id is '主键';
COMMENT on column sys_Mail_list.createDate is '创建时间';
COMMENT on column sys_Mail_list.updateDate is '修改时间';
COMMENT on column sys_Mail_list.name is '姓名';
COMMENT on column sys_Mail_list.phone is '电话号码';
COMMENT on column sys_Mail_list.franchiseeId is '加盟商ID';



/*
alter table sys_role_to_authorities
   add constraint FK_SYS_ROLE_REFERENCE_SYS_ROLE foreign key (role_id)
      references sys_role (id);

alter table sys_role_to_authorities
   add constraint FK_SYS_ROLE_REFERENCE_SYS_AUTH foreign key (authorities_id)
      references SYS_AUTHORITIES (id);

alter table sys_role_to_menu
   add constraint FK_SYS_ROLE_REFERENCE_SYS_MENU foreign key (menu_id)
      references sys_menu (id);

alter table sys_role_to_menu
   add constraint FK_SYS_MENU_REFERENCE_SYS_ROLE foreign key (role_id)
      references sys_role (id);

alter table sys_user
   add constraint FK_SYS_USER_REFERENCE_SYS_ROLE foreign key (role_id)
      references sys_role (id);

alter table sys_user
   add constraint FK_SYS_USER_REFERENCE_SYS_ENTE foreign key (enterprise_id)
      references sys_enterprise (id);
*/

commit;