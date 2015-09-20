-- Create the user 
create user ERP
  default tablespace ERP_ORCL
  temporary tablespace TEMP
  profile DEFAULT
  password expire
  quota unlimited on erp_orcl;
-- Grant/Revoke system privileges 
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
