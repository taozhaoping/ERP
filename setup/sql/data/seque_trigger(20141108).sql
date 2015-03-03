---------------------------------------------
-- Export file for user OSFI               --
-- Created by 21829 on 2014/11/8, 15:22:27 --
---------------------------------------------

set define off
spool seque_trigger(20141108).log

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
prompt Creating sequence SEQUENCE_SYS_NOTICE
prompt =====================================
prompt
create sequence OSFI.SEQUENCE_SYS_NOTICE
minvalue 1
maxvalue 99999999
start with 11
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

prompt
prompt Creating sequence SEQUENCE_T_ACTIVITIES
prompt =======================================
prompt
create sequence OSFI.SEQUENCE_T_ACTIVITIES
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_ACTIVITIESUSER
prompt ===========================================
prompt
create sequence OSFI.SEQUENCE_T_ACTIVITIESUSER
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_CERTIFICATES
prompt =========================================
prompt
create sequence OSFI.SEQUENCE_T_CERTIFICATES
minvalue 1
maxvalue 999999999
start with 41
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_EXPRESS
prompt ====================================
prompt
create sequence OSFI.SEQUENCE_T_EXPRESS
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_FILEINFO
prompt =====================================
prompt
create sequence OSFI.SEQUENCE_T_FILEINFO
minvalue 1
maxvalue 999999999
start with 11
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_FINANCIALAFFAIRS
prompt =============================================
prompt
create sequence OSFI.SEQUENCE_T_FINANCIALAFFAIRS
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_FLIGHT
prompt ===================================
prompt
create sequence OSFI.SEQUENCE_T_FLIGHT
minvalue 1
maxvalue 999999999
start with 41
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_HOTEL
prompt ==================================
prompt
create sequence OSFI.SEQUENCE_T_HOTEL
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PERSONNEL
prompt ======================================
prompt
create sequence OSFI.SEQUENCE_T_PERSONNEL
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PERSONNEL_RECORD
prompt =============================================
prompt
create sequence OSFI.SEQUENCE_T_PERSONNEL_RECORD
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_PHYSICALEXAMINATION
prompt ================================================
prompt
create sequence OSFI.SEQUENCE_T_PHYSICALEXAMINATION
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_TECHNOLOGICAL
prompt ==========================================
prompt
create sequence OSFI.SEQUENCE_T_TECHNOLOGICAL
minvalue 1
maxvalue 999999999
start with 1000250
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_TRAINCOURSE
prompt ========================================
prompt
create sequence OSFI.SEQUENCE_T_TRAINCOURSE
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating sequence SEQUENCE_T_TRAININGOFPERSONNEL
prompt ================================================
prompt
create sequence OSFI.SEQUENCE_T_TRAININGOFPERSONNEL
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 10
order;

prompt
prompt Creating trigger ACTIVITIES_T
prompt =============================
prompt
CREATE OR REPLACE TRIGGER OSFI.ACTIVITIES_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_ACTIVITIES
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_ACTIVITIES');
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
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_ACTIVITIES');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_ACTIVITIES');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_ACTIVITIES');
END;
/

prompt
prompt Creating trigger CERTIFICATES_T
prompt ===============================
prompt
CREATE OR REPLACE TRIGGER OSFI.CERTIFICATES_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_CERTIFICATES
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_CERTIFICATES');
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
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_CERTIFICATES');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_CERTIFICATES');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_CERTIFICATES');
END;
/

prompt
prompt Creating trigger ENTRY_PROCESS_T
prompt ================================
prompt
CREATE OR REPLACE TRIGGER OSFI.ENTRY_PROCESS_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_ENTRY_PROCESS
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_ENTRY_PROCESS');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into createDate from dual;
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.CREATETIME := createDate;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_ENTRY_PROCESS');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_ENTRY_PROCESS');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_ENTRY_PROCESS');
END;
/

prompt
prompt Creating trigger FILEINFO_T
prompt ===========================
prompt
CREATE OR REPLACE TRIGGER OSFI.FILEINFO_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_FILEINFO
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_FILEINFO');
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
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_FILEINFO');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_FILEINFO');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_FILEINFO');
END;
/

prompt
prompt Creating trigger HOTEL_T
prompt ========================
prompt
CREATE OR REPLACE TRIGGER OSFI.HOTEL_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_HOTEL
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_HOTEL');
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
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_HOTEL');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_HOTEL');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_HOTEL');
END;
/

prompt
prompt Creating trigger SYS_NOTICE_T
prompt =============================
prompt
CREATE OR REPLACE TRIGGER OSFI.SYS_NOTICE_T
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
CREATE OR REPLACE TRIGGER OSFI.SYS_RESOURCEINFO_T
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
CREATE OR REPLACE TRIGGER OSFI.SYS_ROLE_T
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
CREATE OR REPLACE TRIGGER OSFI.SYS_USER_T
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

prompt
prompt Creating trigger TECHNOLOGICALPROCESS_T
prompt =======================================
prompt
CREATE OR REPLACE TRIGGER OSFI.TECHNOLOGICALPROCESS_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_TECHNOLOGICALPROCESS
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_TECHNOLOGICALPROCESS');
  END;
END IF;
IF INSERTING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into createDate from dual;
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.CREATETIME := createDate;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_TECHNOLOGICALPROCESS');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_TECHNOLOGICALPROCESS');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_TECHNOLOGICALPROCESS');
END;
/

prompt
prompt Creating trigger TRAINCOURSE_T
prompt ==============================
prompt
CREATE OR REPLACE TRIGGER OSFI.TRAINCOURSE_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_TRAINCOURSE
FOR EACH ROW
DECLARE
createDate    varchar2(20);
modifyDate    varchar2(20);
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_TRAINCOURSE');
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
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_TRAINCOURSE');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') into modifyDate from dual;
    :new.UPDATEDATE := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_TRAINCOURSE');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_TRAINCOURSE');
END;
/

prompt
prompt Creating trigger T_PERSONNEL_T
prompt ==============================
prompt
CREATE OR REPLACE TRIGGER OSFI.T_PERSONNEL_T
BEFORE DELETE OR INSERT OR UPDATE
ON T_PERSONNEL
FOR EACH ROW
DECLARE
createDate    date;
modifyDate    date;
BEGIN
IF DELETING THEN
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Trigger Operation in table T_PERSONNEL');
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
    DBMS_OUTPUT.PUT_LINE('Failed Insert Trigger Operation in table T_PERSONNEL');
  END;
END IF;
IF UPDATING THEN
  BEGIN
    select SYSDATE into modifyDate from dual;
    :new.UPDATETIME := modifyDate;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Failed Update Trigger Operation in table T_PERSONNEL');
  END;
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Failed Other Trigger Operation in table T_PERSONNEL');
END;
/


spool off
