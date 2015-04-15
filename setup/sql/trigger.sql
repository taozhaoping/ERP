---------------------------------------------
-- Export file for user OSFI               --
-- Created by 21829 on 2014/9/11, 19:09:36 --
---------------------------------------------

--set define off
--spool trigger.log

--
-- Creating trigger SYS_FILEINFO_T
-- ===========================
--
CREATE OR REPLACE TRIGGER SYS_FILEINFO_T
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

--
-- Creating trigger SYS_RESOURCEINFO_T
-- ===================================
--
CREATE OR REPLACE TRIGGER SYS_RESOURCEINFO_T
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

--
-- Creating trigger SYS_ROLE_T
-- ===========================
--
CREATE OR REPLACE TRIGGER SYS_ROLE_T
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

--
-- Creating trigger SYS_USER_T
-- ===========================
--
CREATE OR REPLACE TRIGGER SYS_USER_T
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

--
-- Creating trigger SYS_NOTICE_T
-- ==============================
--
CREATE OR REPLACE TRIGGER SYS_NOTICE_T
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

--
-- Creating trigger t_product_structure
-- =============================
--
--
CREATE OR REPLACE TRIGGER product_structure_T
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

--
-- Creating trigger T_Storage_header
-- ===========================
--
CREATE OR REPLACE TRIGGER Storage_Primary_T
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

--
-- Creating trigger 
-- ===========================
--
CREATE OR REPLACE TRIGGER library_Primary_T
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
--spool off
