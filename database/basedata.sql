

delete from OPERATORS;
commit;
insert into OPERATORS (OPER_CODE, OPER_ID, OPER_NAME, IS_VALID, PASSWORD, REGISTER_TIME, LOGIN_TIME, BELONG_TEAM, MOBILE_PHONE, FIRST_EMAIL, SECOND_EMAIL, NOTES_ID)
values (1, 'admin', 'admin', '10001', 'admin', null, null, null, null, null, null, null);
commit;

delete from OPER_ROLE;
commit;
insert into OPER_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION, CREATE_TIME, IS_VALID, ORDERNUMBER)
values (30, 'PL', 'PL', to_timestamp('27-04-2011 11:28:52.652000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 1003);
insert into OPER_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION, CREATE_TIME, IS_VALID, ORDERNUMBER)
values (32, 'SE', 'SE', to_timestamp('21-04-2011 13:01:46.560000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 1001);
insert into OPER_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION, CREATE_TIME, IS_VALID, ORDERNUMBER)
values (33, 'Employee', 'Employee', to_timestamp('21-04-2011 13:04:20.797000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 1000);
insert into OPER_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION, CREATE_TIME, IS_VALID, ORDERNUMBER)
values (34, 'TPM', 'TPM', to_timestamp('21-04-2011 13:04:34.468000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 1004);
insert into OPER_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION, CREATE_TIME, IS_VALID, ORDERNUMBER)
values (1, 'Admin', 'Admin', null, '1', 9999);
insert into OPER_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION, CREATE_TIME, IS_VALID, ORDERNUMBER)
values (2, 'PM', 'PM', to_timestamp('20-04-2011 21:45:55.352000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 1002);
commit;

delete from OPER_PRIVILEGE;
commit;
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99992', 'Address.Detail', 'Address Detail', 'TR_0_9_0', 'TR_9_0', 'address_list.action', 99992, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99973', '菜单', 'Privilege', 'TR_0_7_0', 'TR_0_7', 'privilege_list.action', 99972, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99974', '用户', 'Operator Manage', 'TR_0_7_2', 'TR_0_7', 'operator_manage_list.action', 99974, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99991', 'Address', 'Address', 'TR_0_9', 'TR_0', null, 99991, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99971', '系统管理', 'System', 'TR_0_7', 'TR_0', null, 99971, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99972', '角色', 'Role', 'TR_0_7_1', 'TR_0_7', 'roles_list.action', 99973, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99975', '退出', 'Login out', 'TR_0_7_3', 'TR_0_7', 'logout.action', 99975, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40001', '综合业务管理', '综合业务管理', 'TR_0_3', 'TR_0', null, 40001, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40002', '资产信息', '资产信息', 'TR_0_3_0', 'TR_0_3', 'asset_query.action', 40002, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40003', '真实合同', '真实合同', 'TR_0_3_1', 'TR_0_3', 'realproject_list.action', 40003, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40004', '合同项目', '合同项目', 'TR_0_3_2', 'TR_0_3', 'contractproject_list.action', 40004, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10001', '员工管理', '员工管理', 'TR_0_0', 'TR_0', null, 10001, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10002', '员工信息', null, 'TR_0_0_0', 'TR_0_0', 'staff_query.action', 10002, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10003', '维优组绩效管理', null, 'TR_0_0_1', 'TR_0_0', 'performanceOpt_query', 10003, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10004', '考勤信息', null, 'TR_0_0_2', 'TR_0_0', 'work_record_query.action', 10004, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10005', 'CRM组绩效管理', null, 'TR_0_0_3', 'TR_0_0', 'perCRM_query.action', 10005, 1);
commit;

delete from DIC_CONTENT_KEY;
commit;

insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('10001', 'DIC_IS_VALID', 'IN10000', null, null, 1);
insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('10002', 'DIC_IS_VALID', 'IN10001', null, null, 2);

insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('S0001', 'DIC_SEX', 'INS0001', null, null, 1);
insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('S0002', 'DIC_SEX', 'INS0002', null, null, 2);
commit;

delete from DIC_REMARK_VALUE;
commit;

insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('IN10000', 'DIC_CONTENT_KEY', 'No', 'EN');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('IN10001', 'DIC_CONTENT_KEY', 'Yes', 'EN');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('IN10000', 'DIC_CONTENT_KEY', '不是', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('IN10001', 'DIC_CONTENT_KEY', '是', 'ZH');

insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INS0001', 'DIC_CONTENT_KEY', '男', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INS0002', 'DIC_CONTENT_KEY', '女', 'ZH');
commit;

delete from INF_STAFF;
commit;

insert into INF_STAFF (STAFF_ID, STAFF_NAME, SKILL, STATUS_ID, TEL1, TEL2, EMAIL1, EMAIL2, ENTER_COM_DATE, EXIT_COM_DATE, GROUP_NAME, WORK_YEARS, REMARK)
values ('zyh001', 'xxx', 'java', '1', '15112345678', '18998765432', 'zhy001@sohu.com', 'zhy001@sina.com', to_date('07-03-2011', 'dd-mm-yyyy'), to_date('12-05-2102', 'dd-mm-yyyy'), '交互一组', 1, '较好');
insert into INF_STAFF (STAFF_ID, STAFF_NAME, SKILL, STATUS_ID, TEL1, TEL2, EMAIL1, EMAIL2, ENTER_COM_DATE, EXIT_COM_DATE, GROUP_NAME, WORK_YEARS, REMARK)
values ('zxb001', 'yyy', 'java', '1', '12198766789', '13112344321', 'zxb001@gmai.com', 'zxb001@hotmail.com', to_date('17-05-2011', 'dd-mm-yyyy'), to_date('22-05-2014', 'dd-mm-yyyy'), '交互一组', 3, '好');
insert into INF_STAFF (STAFF_ID, STAFF_NAME, SKILL, STATUS_ID, TEL1, TEL2, EMAIL1, EMAIL2, ENTER_COM_DATE, EXIT_COM_DATE, GROUP_NAME, WORK_YEARS, REMARK)
values ('1', '1', '1', '1', '1', '1', '1', '', to_date('17-05-2011', 'dd-mm-yyyy'), null, '', null, '');
commit;
