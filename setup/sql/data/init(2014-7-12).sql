prompt PL/SQL Developer import file
prompt Created on 2014年7月12日 by 26078
set feedback off
set define off
prompt Disabling triggers for SYS_AUTHORITIES...
alter table SYS_AUTHORITIES disable all triggers;
prompt Disabling triggers for SYS_ENTERPRISE...
alter table SYS_ENTERPRISE disable all triggers;
prompt Disabling triggers for SYS_MENU...
alter table SYS_MENU disable all triggers;
prompt Disabling triggers for SYS_RESOURCEINFO...
alter table SYS_RESOURCEINFO disable all triggers;
prompt Disabling triggers for SYS_ROLE...
alter table SYS_ROLE disable all triggers;
prompt Disabling triggers for SYS_ROLE_TO_AUTHORITIES...
alter table SYS_ROLE_TO_AUTHORITIES disable all triggers;
prompt Disabling triggers for SYS_ROLE_TO_MENU...
alter table SYS_ROLE_TO_MENU disable all triggers;
prompt Disabling triggers for SYS_USER...
alter table SYS_USER disable all triggers;
prompt Deleting SYS_USER...
delete from SYS_USER;
commit;
prompt Deleting SYS_ROLE_TO_MENU...
delete from SYS_ROLE_TO_MENU;
commit;
prompt Deleting SYS_ROLE_TO_AUTHORITIES...
delete from SYS_ROLE_TO_AUTHORITIES;
commit;
prompt Deleting SYS_ROLE...
delete from SYS_ROLE;
commit;
prompt Deleting SYS_RESOURCEINFO...
delete from SYS_RESOURCEINFO;
commit;
prompt Deleting SYS_MENU...
delete from SYS_MENU;
commit;
prompt Deleting SYS_ENTERPRISE...
delete from SYS_ENTERPRISE;
commit;
prompt Deleting SYS_AUTHORITIES...
delete from SYS_AUTHORITIES;
commit;
prompt Loading SYS_AUTHORITIES...
insert into SYS_AUTHORITIES (id, name, enabled, module)
values (1, '测试', 0, '测试3');
insert into SYS_AUTHORITIES (id, name, enabled, module)
values (2, 'p3p', 0, '测试3');
commit;
prompt 2 records loaded
prompt Loading SYS_ENTERPRISE...
insert into SYS_ENTERPRISE (id, name, address, phonecall, enabled)
values (3, '测试公司', '测试地址', '电话', 0);
insert into SYS_ENTERPRISE (id, name, address, phonecall, enabled)
values (4, '测试企业', '测试地址', '88888888', 0);
insert into SYS_ENTERPRISE (id, name, address, phonecall, enabled)
values (5, '测试公司2', '测试公司2', null, 0);
insert into SYS_ENTERPRISE (id, name, address, phonecall, enabled)
values (6, '12', '12', '12', 0);
commit;
prompt 4 records loaded
prompt Loading SYS_MENU...
insert into SYS_MENU (id, name, action, url, i18n_key, enabled, parentid, reorder)
values (1, '系统配置', 'sysConfig', null, null, '0', 0, null);
insert into SYS_MENU (id, name, action, url, i18n_key, enabled, parentid, reorder)
values (3, '用户列表', 'userInfo', 'userInfo.jspa', null, '0', 1, 2);
insert into SYS_MENU (id, name, action, url, i18n_key, enabled, parentid, reorder)
values (4, '参数配置', 'sysItem', 'sysItem.jspa', null, '0', 1, 3);
insert into SYS_MENU (id, name, action, url, i18n_key, enabled, parentid, reorder)
values (5, '角色列表', 'role', 'role.jspa', null, '0', 1, 4);
insert into SYS_MENU (id, name, action, url, i18n_key, enabled, parentid, reorder)
values (2, '企业列表', 'enterprise', 'enterprise.jspa', null, '0', 1, 1);
commit;
prompt 5 records loaded
prompt Loading SYS_RESOURCEINFO...
prompt Table is empty
prompt Loading SYS_ROLE...
insert into SYS_ROLE (id, name, createtime, updatetime)
values (1, '超级管理员', to_date('10-07-2014', 'dd-mm-yyyy'), null);
commit;
prompt 1 records loaded
prompt Loading SYS_ROLE_TO_AUTHORITIES...
insert into SYS_ROLE_TO_AUTHORITIES (role_id, authorities_id)
values (1, 1);
commit;
prompt 1 records loaded
prompt Loading SYS_ROLE_TO_MENU...
insert into SYS_ROLE_TO_MENU (menu_id, role_id)
values (2, 1);
insert into SYS_ROLE_TO_MENU (menu_id, role_id)
values (1, 1);
insert into SYS_ROLE_TO_MENU (menu_id, role_id)
values (3, 1);
insert into SYS_ROLE_TO_MENU (menu_id, role_id)
values (4, 1);
insert into SYS_ROLE_TO_MENU (menu_id, role_id)
values (5, 1);
commit;
prompt 5 records loaded
prompt Loading SYS_USER...
insert into SYS_USER (id, loginname, userpassword, name, enabled, usertype, role_id, enterprise_id, email, age, sex, phone, qq, mobile_number, entrytime, address, education_background, createtime, updatetime)
values (1, 'admin', '$2a$12$HE1p3lcWDgqT3MbCnt7qy.wefrXI5a9PThbHa266nZxJhZsEMKI.O', '超级管理员', '0', '0', 1, 1, null, null, null, null, null, null, null, null, null, null, null);
commit;
prompt 1 records loaded
prompt Enabling triggers for SYS_AUTHORITIES...
alter table SYS_AUTHORITIES enable all triggers;
prompt Enabling triggers for SYS_ENTERPRISE...
alter table SYS_ENTERPRISE enable all triggers;
prompt Enabling triggers for SYS_MENU...
alter table SYS_MENU enable all triggers;
prompt Enabling triggers for SYS_RESOURCEINFO...
alter table SYS_RESOURCEINFO enable all triggers;
prompt Enabling triggers for SYS_ROLE...
alter table SYS_ROLE enable all triggers;
prompt Enabling triggers for SYS_ROLE_TO_AUTHORITIES...
alter table SYS_ROLE_TO_AUTHORITIES enable all triggers;
prompt Enabling triggers for SYS_ROLE_TO_MENU...
alter table SYS_ROLE_TO_MENU enable all triggers;
prompt Enabling triggers for SYS_USER...
alter table SYS_USER enable all triggers;
set feedback on
set define on
prompt Done.
