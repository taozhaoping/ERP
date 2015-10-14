--采购助理菜单
insert into SYS_MENU (ID, NAME, NAMESPACE, ACTION, URL, I18N_KEY, ENABLED, PARENTID, REORDER)
values (26, '采购助理', 'business', 'purchasingAssistant', 'purchasingAssistant.jspa', null, '0', 20, 6);

insert into SYS_ROLE_TO_MENU (MENU_ID, ROLE_ID)
values (26, 1);