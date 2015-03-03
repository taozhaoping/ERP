--------------------------------------------
-- Export file for user OSFI              --
-- Created by 21829 on 2014/8/13, 9:45:50 --
--------------------------------------------

set define off
spool init(2014-08-13).log

prompt
prompt Creating table ACT_HI_TASKINST
prompt ==============================
prompt
create table OSFI.ACT_HI_TASKINST
(
  id_             NVARCHAR2(64) not null,
  proc_def_id_    NVARCHAR2(64),
  task_def_key_   NVARCHAR2(255),
  proc_inst_id_   NVARCHAR2(64),
  execution_id_   NVARCHAR2(64),
  parent_task_id_ NVARCHAR2(64),
  name_           NVARCHAR2(255),
  description_    NVARCHAR2(2000),
  owner_          NVARCHAR2(255),
  assignee_       NVARCHAR2(255),
  start_time_     TIMESTAMP(6) not null,
  claim_time_     TIMESTAMP(6),
  end_time_       TIMESTAMP(6),
  duration_       NUMBER(19),
  delete_reason_  NVARCHAR2(2000),
  priority_       INTEGER,
  due_date_       TIMESTAMP(6),
  form_key_       NVARCHAR2(255),
  category_       NVARCHAR2(255),
  tenant_id_      NVARCHAR2(255) default ''
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.ACT_HI_TASKINST
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table ACT_HI_VARINST
prompt =============================
prompt
create table OSFI.ACT_HI_VARINST
(
  id_                NVARCHAR2(64) not null,
  proc_inst_id_      NVARCHAR2(64),
  execution_id_      NVARCHAR2(64),
  task_id_           NVARCHAR2(64),
  name_              NVARCHAR2(255) not null,
  var_type_          NVARCHAR2(100),
  rev_               INTEGER,
  bytearray_id_      NVARCHAR2(64),
  double_            NUMBER(*,10),
  long_              NUMBER(19),
  text_              NVARCHAR2(2000),
  text2_             NVARCHAR2(2000),
  create_time_       TIMESTAMP(6),
  last_updated_time_ TIMESTAMP(6)
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_HI_PROCVAR_NAME_TYPE on OSFI.ACT_HI_VARINST (NAME_, VAR_TYPE_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_HI_PROCVAR_PROC_INST on OSFI.ACT_HI_VARINST (PROC_INST_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_HI_VARINST
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table ACT_ID_GROUP
prompt ===========================
prompt
create table OSFI.ACT_ID_GROUP
(
  id_   NVARCHAR2(64) not null,
  rev_  INTEGER,
  name_ NVARCHAR2(255),
  type_ NVARCHAR2(255)
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.ACT_ID_GROUP
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table ACT_ID_INFO
prompt ==========================
prompt
create table OSFI.ACT_ID_INFO
(
  id_        NVARCHAR2(64) not null,
  rev_       INTEGER,
  user_id_   NVARCHAR2(64),
  type_      NVARCHAR2(64),
  key_       NVARCHAR2(255),
  value_     NVARCHAR2(255),
  password_  BLOB,
  parent_id_ NVARCHAR2(255)
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.ACT_ID_INFO
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table ACT_ID_USER
prompt ==========================
prompt
create table OSFI.ACT_ID_USER
(
  id_         NVARCHAR2(64) not null,
  rev_        INTEGER,
  first_      NVARCHAR2(255),
  last_       NVARCHAR2(255),
  email_      NVARCHAR2(255),
  pwd_        NVARCHAR2(255),
  picture_id_ NVARCHAR2(64)
)
tablespace OUTSOURCINGVIEW
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
alter table OSFI.ACT_ID_USER
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
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
prompt Creating table ACT_ID_MEMBERSHIP
prompt ================================
prompt
create table OSFI.ACT_ID_MEMBERSHIP
(
  user_id_  NVARCHAR2(64) not null,
  group_id_ NVARCHAR2(64) not null
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_MEMB_GROUP on OSFI.ACT_ID_MEMBERSHIP (GROUP_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_MEMB_USER on OSFI.ACT_ID_MEMBERSHIP (USER_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_ID_MEMBERSHIP
  add primary key (USER_ID_, GROUP_ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_ID_MEMBERSHIP
  add constraint ACT_FK_MEMB_GROUP foreign key (GROUP_ID_)
  references OSFI.ACT_ID_GROUP (ID_);
alter table OSFI.ACT_ID_MEMBERSHIP
  add constraint ACT_FK_MEMB_USER foreign key (USER_ID_)
  references OSFI.ACT_ID_USER (ID_);

prompt
prompt Creating table ACT_RE_DEPLOYMENT
prompt ================================
prompt
create table OSFI.ACT_RE_DEPLOYMENT
(
  id_          NVARCHAR2(64) not null,
  name_        NVARCHAR2(255),
  category_    NVARCHAR2(255),
  tenant_id_   NVARCHAR2(255) default '',
  deploy_time_ TIMESTAMP(6)
)
tablespace OUTSOURCINGVIEW
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
alter table OSFI.ACT_RE_DEPLOYMENT
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
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
prompt Creating table ACT_RE_MODEL
prompt ===========================
prompt
create table OSFI.ACT_RE_MODEL
(
  id_                           NVARCHAR2(64) not null,
  rev_                          INTEGER,
  name_                         NVARCHAR2(255),
  key_                          NVARCHAR2(255),
  category_                     NVARCHAR2(255),
  create_time_                  TIMESTAMP(6),
  last_update_time_             TIMESTAMP(6),
  version_                      INTEGER,
  meta_info_                    NVARCHAR2(2000),
  deployment_id_                NVARCHAR2(64),
  editor_source_value_id_       NVARCHAR2(64),
  editor_source_extra_value_id_ NVARCHAR2(64),
  tenant_id_                    NVARCHAR2(255) default ''
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_MODEL_DEPLOYMENT on OSFI.ACT_RE_MODEL (DEPLOYMENT_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_MODEL_SOURCE on OSFI.ACT_RE_MODEL (EDITOR_SOURCE_VALUE_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_MODEL_SOURCE_EXTRA on OSFI.ACT_RE_MODEL (EDITOR_SOURCE_EXTRA_VALUE_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RE_MODEL
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RE_MODEL
  add constraint ACT_FK_MODEL_DEPLOYMENT foreign key (DEPLOYMENT_ID_)
  references OSFI.ACT_RE_DEPLOYMENT (ID_);
alter table OSFI.ACT_RE_MODEL
  add constraint ACT_FK_MODEL_SOURCE foreign key (EDITOR_SOURCE_VALUE_ID_)
  references OSFI.ACT_GE_BYTEARRAY (ID_);
alter table OSFI.ACT_RE_MODEL
  add constraint ACT_FK_MODEL_SOURCE_EXTRA foreign key (EDITOR_SOURCE_EXTRA_VALUE_ID_)
  references OSFI.ACT_GE_BYTEARRAY (ID_);

prompt
prompt Creating table ACT_RE_PROCDEF
prompt =============================
prompt
create table OSFI.ACT_RE_PROCDEF
(
  id_                 NVARCHAR2(64) not null,
  rev_                INTEGER,
  category_           NVARCHAR2(255),
  name_               NVARCHAR2(255),
  key_                NVARCHAR2(255) not null,
  version_            INTEGER not null,
  deployment_id_      NVARCHAR2(64),
  resource_name_      NVARCHAR2(2000),
  dgrm_resource_name_ VARCHAR2(4000),
  description_        NVARCHAR2(2000),
  has_start_form_key_ NUMBER(1),
  suspension_state_   INTEGER,
  tenant_id_          NVARCHAR2(255) default ''
)
tablespace OUTSOURCINGVIEW
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
alter table OSFI.ACT_RE_PROCDEF
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
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
alter table OSFI.ACT_RE_PROCDEF
  add constraint ACT_UNIQ_PROCDEF unique (KEY_, VERSION_, TENANT_ID_)
  using index 
  tablespace OUTSOURCINGVIEW
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
alter table OSFI.ACT_RE_PROCDEF
  add check (HAS_START_FORM_KEY_ IN (1,0));

prompt
prompt Creating table ACT_RU_EXECUTION
prompt ===============================
prompt
create table OSFI.ACT_RU_EXECUTION
(
  id_               NVARCHAR2(64) not null,
  rev_              INTEGER,
  proc_inst_id_     NVARCHAR2(64),
  business_key_     NVARCHAR2(255),
  parent_id_        NVARCHAR2(64),
  proc_def_id_      NVARCHAR2(64),
  super_exec_       NVARCHAR2(64),
  act_id_           NVARCHAR2(255),
  is_active_        NUMBER(1),
  is_concurrent_    NUMBER(1),
  is_scope_         NUMBER(1),
  is_event_scope_   NUMBER(1),
  suspension_state_ INTEGER,
  cached_ent_state_ INTEGER,
  tenant_id_        NVARCHAR2(255) default ''
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_EXEC_BUSKEY on OSFI.ACT_RU_EXECUTION (BUSINESS_KEY_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_EXE_PARENT on OSFI.ACT_RU_EXECUTION (PARENT_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_EXE_PROCDEF on OSFI.ACT_RU_EXECUTION (PROC_DEF_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_EXE_PROCINST on OSFI.ACT_RU_EXECUTION (PROC_INST_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_EXE_SUPER on OSFI.ACT_RU_EXECUTION (SUPER_EXEC_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_EXECUTION
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_EXECUTION
  add constraint ACT_FK_EXE_PARENT foreign key (PARENT_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);
alter table OSFI.ACT_RU_EXECUTION
  add constraint ACT_FK_EXE_PROCDEF foreign key (PROC_DEF_ID_)
  references OSFI.ACT_RE_PROCDEF (ID_);
alter table OSFI.ACT_RU_EXECUTION
  add constraint ACT_FK_EXE_PROCINST foreign key (PROC_INST_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);
alter table OSFI.ACT_RU_EXECUTION
  add constraint ACT_FK_EXE_SUPER foreign key (SUPER_EXEC_)
  references OSFI.ACT_RU_EXECUTION (ID_);
alter table OSFI.ACT_RU_EXECUTION
  add check (IS_ACTIVE_ IN (1,0));
alter table OSFI.ACT_RU_EXECUTION
  add check (IS_CONCURRENT_ IN (1,0));
alter table OSFI.ACT_RU_EXECUTION
  add check (IS_SCOPE_ IN (1,0));
alter table OSFI.ACT_RU_EXECUTION
  add check (IS_EVENT_SCOPE_ IN (1,0));

prompt
prompt Creating table ACT_RU_EVENT_SUBSCR
prompt ==================================
prompt
create table OSFI.ACT_RU_EVENT_SUBSCR
(
  id_            NVARCHAR2(64) not null,
  rev_           INTEGER,
  event_type_    NVARCHAR2(255) not null,
  event_name_    NVARCHAR2(255),
  execution_id_  NVARCHAR2(64),
  proc_inst_id_  NVARCHAR2(64),
  activity_id_   NVARCHAR2(64),
  configuration_ NVARCHAR2(255),
  created_       TIMESTAMP(6) not null,
  proc_def_id_   NVARCHAR2(64),
  tenant_id_     NVARCHAR2(255) default ''
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_EVENT_SUBSCR on OSFI.ACT_RU_EVENT_SUBSCR (EXECUTION_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_EVENT_SUBSCR_CONFIG_ on OSFI.ACT_RU_EVENT_SUBSCR (CONFIGURATION_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_EVENT_SUBSCR
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_EVENT_SUBSCR
  add constraint ACT_FK_EVENT_EXEC foreign key (EXECUTION_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);

prompt
prompt Creating table ACT_RU_TASK
prompt ==========================
prompt
create table OSFI.ACT_RU_TASK
(
  id_               NVARCHAR2(64) not null,
  rev_              INTEGER,
  execution_id_     NVARCHAR2(64),
  proc_inst_id_     NVARCHAR2(64),
  proc_def_id_      NVARCHAR2(64),
  name_             NVARCHAR2(255),
  parent_task_id_   NVARCHAR2(64),
  description_      NVARCHAR2(2000),
  task_def_key_     NVARCHAR2(255),
  owner_            NVARCHAR2(255),
  assignee_         NVARCHAR2(255),
  delegation_       NVARCHAR2(64),
  priority_         INTEGER,
  create_time_      TIMESTAMP(6),
  due_date_         TIMESTAMP(6),
  category_         NVARCHAR2(255),
  suspension_state_ INTEGER,
  tenant_id_        NVARCHAR2(255) default ''
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_TASK_CREATE on OSFI.ACT_RU_TASK (CREATE_TIME_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_TASK_EXEC on OSFI.ACT_RU_TASK (EXECUTION_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_TASK_PROCDEF on OSFI.ACT_RU_TASK (PROC_DEF_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_TASK_PROCINST on OSFI.ACT_RU_TASK (PROC_INST_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_TASK
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_TASK
  add constraint ACT_FK_TASK_EXE foreign key (EXECUTION_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);
alter table OSFI.ACT_RU_TASK
  add constraint ACT_FK_TASK_PROCDEF foreign key (PROC_DEF_ID_)
  references OSFI.ACT_RE_PROCDEF (ID_);
alter table OSFI.ACT_RU_TASK
  add constraint ACT_FK_TASK_PROCINST foreign key (PROC_INST_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);

prompt
prompt Creating table ACT_RU_IDENTITYLINK
prompt ==================================
prompt
create table OSFI.ACT_RU_IDENTITYLINK
(
  id_           NVARCHAR2(64) not null,
  rev_          INTEGER,
  group_id_     NVARCHAR2(255),
  type_         NVARCHAR2(255),
  user_id_      NVARCHAR2(255),
  task_id_      NVARCHAR2(64),
  proc_inst_id_ NVARCHAR2(64),
  proc_def_id_  NVARCHAR2(64)
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_ATHRZ_PROCEDEF on OSFI.ACT_RU_IDENTITYLINK (PROC_DEF_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_IDENT_LNK_GROUP on OSFI.ACT_RU_IDENTITYLINK (GROUP_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_IDENT_LNK_USER on OSFI.ACT_RU_IDENTITYLINK (USER_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_IDL_PROCINST on OSFI.ACT_RU_IDENTITYLINK (PROC_INST_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_TSKASS_TASK on OSFI.ACT_RU_IDENTITYLINK (TASK_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_IDENTITYLINK
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_IDENTITYLINK
  add constraint ACT_FK_ATHRZ_PROCEDEF foreign key (PROC_DEF_ID_)
  references OSFI.ACT_RE_PROCDEF (ID_);
alter table OSFI.ACT_RU_IDENTITYLINK
  add constraint ACT_FK_IDL_PROCINST foreign key (PROC_INST_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);
alter table OSFI.ACT_RU_IDENTITYLINK
  add constraint ACT_FK_TSKASS_TASK foreign key (TASK_ID_)
  references OSFI.ACT_RU_TASK (ID_);

prompt
prompt Creating table ACT_RU_JOB
prompt =========================
prompt
create table OSFI.ACT_RU_JOB
(
  id_                  NVARCHAR2(64) not null,
  rev_                 INTEGER,
  type_                NVARCHAR2(255) not null,
  lock_exp_time_       TIMESTAMP(6),
  lock_owner_          NVARCHAR2(255),
  exclusive_           NUMBER(1),
  execution_id_        NVARCHAR2(64),
  process_instance_id_ NVARCHAR2(64),
  proc_def_id_         NVARCHAR2(64),
  retries_             INTEGER,
  exception_stack_id_  NVARCHAR2(64),
  exception_msg_       NVARCHAR2(2000),
  duedate_             TIMESTAMP(6),
  repeat_              NVARCHAR2(255),
  handler_type_        NVARCHAR2(255),
  handler_cfg_         NVARCHAR2(2000),
  tenant_id_           NVARCHAR2(255) default ''
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_JOB_EXCEPTION on OSFI.ACT_RU_JOB (EXCEPTION_STACK_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_JOB
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_JOB
  add constraint ACT_FK_JOB_EXCEPTION foreign key (EXCEPTION_STACK_ID_)
  references OSFI.ACT_GE_BYTEARRAY (ID_);
alter table OSFI.ACT_RU_JOB
  add check (EXCLUSIVE_ IN (1,0));

prompt
prompt Creating table ACT_RU_VARIABLE
prompt ==============================
prompt
create table OSFI.ACT_RU_VARIABLE
(
  id_           NVARCHAR2(64) not null,
  rev_          INTEGER,
  type_         NVARCHAR2(255) not null,
  name_         NVARCHAR2(255) not null,
  execution_id_ NVARCHAR2(64),
  proc_inst_id_ NVARCHAR2(64),
  task_id_      NVARCHAR2(64),
  bytearray_id_ NVARCHAR2(64),
  double_       NUMBER(*,10),
  long_         NUMBER(19),
  text_         NVARCHAR2(2000),
  text2_        NVARCHAR2(2000)
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
create index OSFI.ACT_IDX_VARIABLE_TASK_ID on OSFI.ACT_RU_VARIABLE (TASK_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_VAR_BYTEARRAY on OSFI.ACT_RU_VARIABLE (BYTEARRAY_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_VAR_EXE on OSFI.ACT_RU_VARIABLE (EXECUTION_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
create index OSFI.ACT_IDX_VAR_PROCINST on OSFI.ACT_RU_VARIABLE (PROC_INST_ID_)
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_VARIABLE
  add primary key (ID_)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;
alter table OSFI.ACT_RU_VARIABLE
  add constraint ACT_FK_VAR_BYTEARRAY foreign key (BYTEARRAY_ID_)
  references OSFI.ACT_GE_BYTEARRAY (ID_);
alter table OSFI.ACT_RU_VARIABLE
  add constraint ACT_FK_VAR_EXE foreign key (EXECUTION_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);
alter table OSFI.ACT_RU_VARIABLE
  add constraint ACT_FK_VAR_PROCINST foreign key (PROC_INST_ID_)
  references OSFI.ACT_RU_EXECUTION (ID_);

prompt
prompt Creating table SYS_AUTHORITIES
prompt ==============================
prompt
create table OSFI.SYS_AUTHORITIES
(
  id      NUMBER not null,
  name    VARCHAR2(25),
  enabled NUMBER default '0',
  module  VARCHAR2(25)
)
tablespace OUTSOURCINGVIEW
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
comment on table OSFI.SYS_AUTHORITIES
  is '权限表';
alter table OSFI.SYS_AUTHORITIES
  add constraint PK_SYS_AUTHORITIES_ID primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
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
create table OSFI.SYS_ENTERPRISE
(
  id        NUMBER not null,
  name      VARCHAR2(100),
  address   VARCHAR2(150),
  phonecall VARCHAR2(25),
  enabled   NUMBER default '0'  -- 是否启用 0启动 1:停用
)
tablespace OUTSOURCINGVIEW
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
comment on table OSFI.SYS_ENTERPRISE
  is '企业信息表';
alter table OSFI.SYS_ENTERPRISE
  add constraint PK_SYS_ENTERPRISE_ID primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
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
create table OSFI.SYS_MENU
(
  id       NUMBER not null,
  name     VARCHAR2(150),
  action   VARCHAR2(150),
  url      VARCHAR2(150),
  i18n_key VARCHAR2(100),
  enabled  VARCHAR2(1) default '0',
  parentid NUMBER,
  reorder  NUMBER
)
tablespace OUTSOURCINGVIEW
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
comment on table OSFI.SYS_MENU
  is '菜单表';
alter table OSFI.SYS_MENU
  add constraint PK_SYS_MENU_ID primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
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
create table OSFI.SYS_PARAM
(
  id               NUMBER not null,
  emailservice     VARCHAR2(50),
  emailform        VARCHAR2(50),
  emailusername    VARCHAR2(50),
  emailpassword    VARCHAR2(50),
  emailisauth      VARCHAR2(1),
  emailurlpassword VARCHAR2(30)
)
tablespace OUTSOURCINGVIEW
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
alter table OSFI.SYS_PARAM
  add constraint PK_SYS_PARAM_ID primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
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
create table OSFI.SYS_RESOURCEINFO
(
  id         NUMBER not null,
  name       VARCHAR2(30),
  value      VARCHAR2(30),
  type       VARCHAR2(20),
  createtime DATE,
  updatetime DATE,
  enabled    NUMBER default '0'-- 是否启用 0启动 1:停用
)
tablespace OUTSOURCINGVIEW
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
comment on table OSFI.SYS_RESOURCEINFO
  is '资源信息表';
alter table OSFI.SYS_RESOURCEINFO
  add constraint PK_SYS_RESOURCEINFO_ID primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
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
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table OSFI.SYS_ROLE
(
  id         NUMBER not null,
  name       VARCHAR2(50),
  createtime DATE,
  updatetime DATE,
  describe   VARCHAR2(100)
)
tablespace OUTSOURCINGVIEW
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
comment on table OSFI.SYS_ROLE
  is '角色信息表';
alter table OSFI.SYS_ROLE
  add constraint PK_SYS_ROLE_ID primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
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
create table OSFI.SYS_ROLE_TO_AUTHORITIES
(
  role_id        NUMBER,
  authorities_id NUMBER
)
tablespace OUTSOURCINGVIEW
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
create table OSFI.SYS_ROLE_TO_MENU
(
  menu_id NUMBER,
  role_id NUMBER
)
tablespace OUTSOURCINGVIEW
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
comment on table OSFI.SYS_ROLE_TO_MENU
  is '角色和菜单中间表（一对多）';

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
create table OSFI.SYS_USER
(
  id                   NUMBER not null,
  loginname            VARCHAR2(20) not null,
  userpassword         VARCHAR2(100) not null,
  name                 VARCHAR2(20),
  enabled              VARCHAR2(1) default '0',
  usertype             VARCHAR2(1),
  role_id              NUMBER,
  enterprise_id        NUMBER,
  email                VARCHAR2(25),
  age                  DATE,
  sex                  VARCHAR2(1),
  phone                VARCHAR2(20),
  qq                   VARCHAR2(20),
  mobile_number        VARCHAR2(20),
  entrytime            DATE,
  address              VARCHAR2(100),
  education_background VARCHAR2(1),
  createtime           DATE,
  updatetime           DATE,
  nonce                VARCHAR2(50)
)
tablespace OUTSOURCINGVIEW
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
create index OSFI.USER_LOGINNAME_INDEX on OSFI.SYS_USER (LOGINNAME)
  tablespace OUTSOURCINGVIEW
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
alter table OSFI.SYS_USER
  add constraint PK_SYS_USER_ID primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
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
prompt Creating table T_ACTIVITIES
prompt ===========================
prompt
create table OSFI.T_ACTIVITIES
(
  id           NUMBER not null,
  name         VARCHAR2(20),
  description  VARCHAR2(50),
  scheduledate DATE,
  settime      VARCHAR2(10),
  setplace     VARCHAR2(20),
  scheduletime VARCHAR2(10),
  userid       NUMBER,
  telephone    VARCHAR2(15),
  createdate   VARCHAR2(20),
  updatedate   VARCHAR2(20)
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.T_ACTIVITIES
  add constraint PK_ACTIVITIES primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table T_ACTIVITIESUSER
prompt ===============================
prompt
create table OSFI.T_ACTIVITIESUSER
(
  id           NUMBER not null,
  activitiesid NUMBER,
  userid       NUMBER
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.T_ACTIVITIESUSER
  add constraint PK_ACTIVITIESUSER primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table T_CERTIFICATES
prompt =============================
prompt
create table OSFI.T_CERTIFICATES
(
  id                     NUMBER not null,
  workflowid             VARCHAR2(10),
  name                   VARCHAR2(30),
  handledate             DATE,
  receivedate            DATE,
  validstartdate         DATE,
  validenddate           DATE,
  type                   VARCHAR2(3),
  createdate             VARCHAR2(20),
  updatedate             VARCHAR2(20),
  status                 VARCHAR2(2),
  technologicalprocessid NUMBER
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.T_CERTIFICATES
  add constraint PK_CERTIFICATES primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table T_EXPRESS
prompt ========================
prompt
create table OSFI.T_EXPRESS
(
  id                     NUMBER not null,
  expressnumber          VARCHAR2(30),
  company                VARCHAR2(30),
  telephone              VARCHAR2(15),
  delivergoodsdate       DATE,
  arrivedate             DATE,
  technologicalprocessid NUMBER
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.T_EXPRESS
  add constraint PK_EXPRESS primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table T_FILEINFO
prompt =========================
prompt
create table OSFI.T_FILEINFO
(
  id                     NUMBER not null,
  name                   VARCHAR2(30),
  nametype               VARCHAR2(10),
  type                   VARCHAR2(20),
  descr                  VARCHAR2(100),
  createdate             VARCHAR2(30),
  updatedate             VARCHAR2(30),
  state                  VARCHAR2(2),
  technologicalprocessid NUMBER
)
tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OSFI.T_FILEINFO
  add constraint PK_FILEINFO primary key (ID)
  using index 
  tablespace OUTSOURCINGVIEW
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating sequence SEQUENCE_SYS_AUTHORITIES
prompt ==========================================
prompt
create sequence OSFI.SEQUENCE_SYS_AUTHORITIES
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
create sequence OSFI.SEQUENCE_SYS_ENTERPRISE
minvalue 1
maxvalue 99999999
start with 22
increment by 1
cache 5
order;

prompt
prompt Creating sequence SEQUENCE_SYS_MENU
prompt ===================================
prompt
create sequence OSFI.SEQUENCE_SYS_MENU
minvalue 1
maxvalue 999999999
start with 6
increment by 1
cache 5
order;

prompt
prompt Creating sequence SEQUENCE_SYS_RESOURCEINFO
prompt ===========================================
prompt
create sequence OSFI.SEQUENCE_SYS_RESOURCEINFO
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
create sequence OSFI.SEQUENCE_SYS_ROLE
minvalue 1
maxvalue 99999999
start with 19
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_SYS_USER
prompt ===================================
prompt
create sequence OSFI.SEQUENCE_SYS_USER
minvalue 1
maxvalue 999999999
start with 29
increment by 1
cache 10
order;


spool off
