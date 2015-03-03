-- create 
CREATE TABLESPACE OUTSOURCINGVIEW
LOGGING
DATAFILE 'E:\oracle\oradata\orcl\OUTSOURCING_DATA01.DBF' 
SIZE 300M 
AUTOEXTEND ON 
NEXT 100M MAXSIZE UNLIMITED
EXTENT MANAGEMENT LOCAL;
CREATE USER OSFI IDENTIFIED BY agile932 DEFAULT TABLESPACE OUTSOURCINGVIEW;
-- Grant/Revoke system privileges 
ALTER USER OSFI QUOTA UNLIMITED ON OUTSOURCINGVIEW;
grant create any sequence to OSFI;
grant create session to OSFI;
grant create table to OSFI;
grant create trigger to OSFI;
grant drop any table to OSFI;
grant insert any table to OSFI;
grant update any table to OSFI;