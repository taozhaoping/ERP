--创建数据库
CREATE TABLESPACE ERP_ORCL
LOGGING
DATAFILE 'F:\oracle\oradata\orcl\ERP_DATA01.DBF' 
SIZE 300M 
AUTOEXTEND ON 
NEXT 100M MAXSIZE UNLIMITED
EXTENT MANAGEMENT LOCAL;
--创建用户
create user ERP identified by agile932
  default tablespace ERP_ORCL
  temporary tablespace TEMP
  profile DEFAULT
  password expire
  quota unlimited on erp_orcl;
grant create any job to ERP;
grant create any procedure to ERP;
grant create any sequence to ERP;
grant create session to ERP;
grant create table to ERP;
grant create trigger to ERP;
grant create view to ERP;
grant drop any procedure to ERP;
grant drop any sequence to ERP;
grant drop any table to ERP;
grant drop any view to ERP;
grant insert any table to ERP;
grant update any table to ERP;
grant debug any procedure to ERP;
grant debug connect session to ERP;
