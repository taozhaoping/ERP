alter table SYS_BASI_TYPE drop primary key cascade;
ALTER TABLE SYS_DICTIONARY DROP PRIMARY KEY CASCADE;

DROP TABLE SYS_DICTIONARY CASCADE CONSTRAINTS;
drop table SYS_BASI_TYPE cascade constraints;


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
