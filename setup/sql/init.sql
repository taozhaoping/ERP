insert into SYS_MENU (ID, NAME, ACTION, URL, I18N_KEY, ENABLED, PARENTID, REORDER, NAMESPACE)
values (1, '系统配置', 'sysConfig', null, null, '0', 0, 1, null);

insert into SYS_MENU (ID, NAME, ACTION, URL, I18N_KEY, ENABLED, PARENTID, REORDER, NAMESPACE)
values (3, '用户列表', 'userInfo', 'userInfo.jspa', null, '0', 1, 2, 'home');

insert into SYS_MENU (ID, NAME, ACTION, URL, I18N_KEY, ENABLED, PARENTID, REORDER, NAMESPACE)
values (4, '参数配置', 'param', 'param.jspa', null, '0', 1, 3, 'home');

insert into SYS_MENU (ID, NAME, ACTION, URL, I18N_KEY, ENABLED, PARENTID, REORDER, NAMESPACE)
values (5, '角色列表', 'role', 'role.jspa', null, '0', 1, 4, 'home');

insert into SYS_MENU (ID, NAME, ACTION, URL, I18N_KEY, ENABLED, PARENTID, REORDER, NAMESPACE)
values (2, '企业列表', 'enterprise', 'enterprise.jspa', null, '0', 1, 1, 'home');

insert into SYS_MENU (ID, NAME, ACTION, URL, I18N_KEY, ENABLED, PARENTID, REORDER, NAMESPACE)
values (6, '系统公告', 'notice', 'notice.jspa', null, '0', 1, 5, 'home');
commit;


insert into SYS_ROLE_TO_MENU (MENU_ID, ROLE_ID)
values (1, 1);

insert into SYS_ROLE_TO_MENU (MENU_ID, ROLE_ID)
values (3, 1);

insert into SYS_ROLE_TO_MENU (MENU_ID, ROLE_ID)
values (4, 1);

insert into SYS_ROLE_TO_MENU (MENU_ID, ROLE_ID)
values (5, 1);

insert into SYS_ROLE_TO_MENU (MENU_ID, ROLE_ID)
values (2, 1);

insert into SYS_ROLE_TO_MENU (MENU_ID, ROLE_ID)
values (6, 1);
commit;

insert into SYS_AUTHORITIES (id, name, enabled, module)
values (1, '测试', 0, 'main');
commit;


insert into SYS_ROLE (ID, NAME, CREATETIME, UPDATETIME, DESCRIBE)
values (1, '超级管理员', to_date('10-07-2014', 'dd-mm-yyyy'), to_date('06-02-2015 10:53:25', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
commit;


insert into SYS_ENTERPRISE (id, name, address, phonecall, enabled)
values (1, '测试公司', '测试公司', null, 0);
commit;



insert into SYS_USER (ID, LOGINNAME, USERPASSWORD, NAME, ENABLED, USERTYPE, ROLE_ID, ENTERPRISE_ID, EMAIL, AGE, SEX, PHONE, QQ, MOBILE_NUMBER, ENTRYTIME, ADDRESS, EDUCATION_BACKGROUND, CREATETIME, UPDATETIME, NONCE)
values (1, 'admin', '$2a$12$d4HH3RR2y9uYMbcXLcXMx.9prcpbjH65X7cnVUxcAbErCp3jPLP3m', '超级管理员', '0', '0', 1, 1, 'taozhaoping@gmail.com', to_date('21-11-2014', 'dd-mm-yyyy'), '1', '0577-67587398', '222924361', '18758084122', to_date('01-07-2014', 'dd-mm-yyyy'), '浙江大学家里蹲专业', '0', to_date('14-07-2014', 'dd-mm-yyyy'), to_date('27-02-2015 11:49:01', 'dd-mm-yyyy hh24:mi:ss'), 'E0wJwd0m2BhuaTzrKB0q+A==');

insert into SYS_USER (ID, LOGINNAME, USERPASSWORD, NAME, ENABLED, USERTYPE, ROLE_ID, ENTERPRISE_ID, EMAIL, AGE, SEX, PHONE, QQ, MOBILE_NUMBER, ENTRYTIME, ADDRESS, EDUCATION_BACKGROUND, CREATETIME, UPDATETIME, NONCE)
values (15, 'caiyingying', '$2a$12$pZ0sTnONlgDsKGBuNSOmM..x3rdRJx69PrqDNrUNX0bSQXX6BODeW', 'sd', '1', null, 17, 1, 'caiyingying@gmail.com', to_date('10-07-2014', 'dd-mm-yyyy'), '0', null, null, '18758087122', to_date('03-07-2014', 'dd-mm-yyyy'), null, '0', to_date('17-07-2014', 'dd-mm-yyyy'), to_date('01-09-2014 19:24:47', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into SYS_USER (ID, LOGINNAME, USERPASSWORD, NAME, ENABLED, USERTYPE, ROLE_ID, ENTERPRISE_ID, EMAIL, AGE, SEX, PHONE, QQ, MOBILE_NUMBER, ENTRYTIME, ADDRESS, EDUCATION_BACKGROUND, CREATETIME, UPDATETIME, NONCE)
values (12, 'taozhaoping', '$2a$12$AJHnqyLxa/7bPObtQd384ucog9odagXkY5EW8kYPDPfodeD35PYRe', '陶照平', '0', null, 1, 1, 'taozhaoping@gmail.com', to_date('16-07-2014', 'dd-mm-yyyy'), '1', '112111', '1112312', '18758084122', to_date('24-07-2014', 'dd-mm-yyyy'), '1', '1', to_date('16-07-2014', 'dd-mm-yyyy'), to_date('19-12-2014 14:54:16', 'dd-mm-yyyy hh24:mi:ss'), null);


insert into SYS_RESOURCEINFO (id, name, value, type, createtime, updatetime, enabled)
values (1, '男', '1', 'sex', to_date('16-07-2014', 'dd-mm-yyyy'), null, 0);
insert into SYS_RESOURCEINFO (id, name, value, type, createtime, updatetime, enabled)
values (2, '女', '2', 'sex', to_date('16-07-2014', 'dd-mm-yyyy'), null, 0);
insert into SYS_RESOURCEINFO (id, name, value, type, createtime, updatetime, enabled)
values (3, '大专', '1', 'education', null, null, 0);
insert into SYS_RESOURCEINFO (id, name, value, type, createtime, updatetime, enabled)
values (4, '未知', '0', 'sex', to_date('16-07-2014', 'dd-mm-yyyy'), null, 0);
commit;

insert into SYS_PARAM (id, emailservice, emailform, emailusername, emailpassword, emailisauth, emailurlpassword)
values (1, 'smtp.163.com', 'noreplay101@163.com', 'noreplay101', '123qwe!@#', '0', '');
commit;

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (1, '企业列表查看', null, 0, null, 'enterprise:view');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (2, '企业列表新增', null, 0, null, 'enterprise:add');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (3, '企业列表编辑', null, 0, null, 'enterprise:edit');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (4, '企业列表删除', null, 0, null, 'enterprise:delete');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (5, '用户列表查看', null, 0, null, 'user:view');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (6, '用户列表新增', null, 0, null, 'user:add');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (7, '用户列表编辑', null, 0, null, 'user:edit');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (8, '用户列表删除', null, 0, null, 'user:delete');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (9, '角色列表查看', null, 0, null, 'role:view');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (10, '角色列表新增', null, 0, null, 'role:add');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (11, '角色列表编辑', null, 0, null, 'role:edit');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (12, '角色列表删除', null, 0, null, 'role:delete');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (13, '参数配置查看', null, 0, null, 'param:view');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (14, '参数配置编辑', null, 0, null, 'param:edit');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (15, '系统公告查看', null, 0, null, 'notice:view');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (16, '系统公告新增', null, 0, null, 'notice:add');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (17, '系统公告编辑', null, 0, null, 'notice:edit');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (18, '系统公告删除', null, 0, null, 'notice:delete');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (19, '部门配置查看', null, 0, null, 'dept:view');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (20, '部门配置新增', null, 0, null, 'dept:add');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (21, '部门配置编辑', null, 0, null, 'dept:edit');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (22, '部门配置删除', null, 0, null, 'dept:delete');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (23, '仓库配置查看', null, 0, null, 'warehouse:view');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (24, '仓库配置新增', null, 0, null, 'warehouse:add');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (25, '仓库配置编辑', null, 0, null, 'warehouse:edit');

insert into SYS_AUTHORITIES (ID, NAME, DESCRIPTION, ENABLED, MODULE, PERMISSION)
values (26, '仓库配置删除', null, 0, null, 'warehouse:delete');
commit;

insert into SYS_ROLE_TO_AUTHORITIES (ROLE_ID, AUTHORITIES_ID)
values (1, 9);

insert into SYS_ROLE_TO_AUTHORITIES (ROLE_ID, AUTHORITIES_ID)
values (1, 10);

insert into SYS_ROLE_TO_AUTHORITIES (ROLE_ID, AUTHORITIES_ID)
values (1, 11);

insert into SYS_ROLE_TO_AUTHORITIES (ROLE_ID, AUTHORITIES_ID)
values (1, 12);

commit;