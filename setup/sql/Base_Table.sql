alter table SYS_BASI_TYPE drop primary key cascade;
ALTER TABLE SYS_DICTIONARY DROP PRIMARY KEY CASCADE;
alter table sys_Warehouse drop primary key cascade;

drop table sys_Warehouse cascade constraints;
DROP TABLE SYS_DICTIONARY CASCADE CONSTRAINTS;
drop table SYS_BASI_TYPE cascade constraints;

drop sequence SEQUENCE_sys_Warehouse;


create sequence SEQUENCE_sys_Warehouse
start with 1
 maxvalue 999999999
 minvalue 1
 cache 10
order;

/*==============================================================*/
/* Table: 基础类型资料                                          */
/*==============================================================*/
CREATE TABLE SYS_BASI_TYPE
(
   ID                   NUMBER               NOT NULL,
   NAME                 VARCHAR(50)
);

COMMENT ON TABLE SYS_BASI_TYPE IS
'基础分类';

COMMENT ON COLUMN SYS_BASI_TYPE.ID IS
'主键';

COMMENT ON COLUMN SYS_BASI_TYPE.NAME IS
'名称';

ALTER TABLE SYS_BASI_TYPE
   ADD CONSTRAINT PK_SYS_BASI_TYPE PRIMARY KEY (ID);


/*==============================================================*/
/* TABLE: 数据库字典                                          */
/*==============================================================*/
CREATE TABLE SYS_DICTIONARY 
(
   KEY                NUMBER               NOT NULL,
   VALUE              VARCHAR(50),
   BASI_TYPE_ID       NUMBER
);

COMMENT ON TABLE SYS_DICTIONARY IS
'数据库字典';

COMMENT ON COLUMN SYS_DICTIONARY.KEY IS
'KEY';

COMMENT ON COLUMN SYS_DICTIONARY.VALUE IS
'名称';

COMMENT ON COLUMN SYS_DICTIONARY.BASI_TYPE_ID IS
'类型';

ALTER TABLE SYS_DICTIONARY
   ADD CONSTRAINT PK_SYS_DICTIONARY PRIMARY KEY (KEY);
   
   CREATE TABLE SYS_WAREHOUSE 
(
   ID                   NUMBER               NOT NULL,
   NAME               VARCHAR(30),
   ADDRESS            VARCHAR(100),
   STATE              NUMBER
);

COMMENT ON TABLE SYS_WAREHOUSE IS
'仓库管理';

COMMENT ON COLUMN SYS_WAREHOUSE.ID IS
'主键';

COMMENT ON COLUMN SYS_WAREHOUSE.NAME IS
'仓库名称';

COMMENT ON COLUMN SYS_WAREHOUSE.ADDRESS IS
'仓库地址';

ALTER TABLE SYS_WAREHOUSE
   ADD CONSTRAINT PK_SYS_WAREHOUSE PRIMARY KEY (ID);

