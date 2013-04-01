create table OPERATORS
(
  OPER_CODE     NUMBER(10) not null,
  OPER_ID       VARCHAR2(10) not null,
  OPER_NAME     VARCHAR2(128),
  IS_VALID      CHAR(1) default '1' not null,
  PASSWORD      VARCHAR2(128) not null,
  REGISTER_TIME TIMESTAMP(6),
  LOGIN_TIME    TIMESTAMP(6),
  BELONG_TEAM   VARCHAR2(50),
  MOBILE_PHONE  VARCHAR2(50),
  FIRST_EMAIL   VARCHAR2(50),
  SECOND_EMAIL  VARCHAR2(50),
  NOTES_ID      VARCHAR2(50)
)

-- Create/Recreate primary, unique and foreign key constraints 
alter table OPERATORS
  add constraint PK_OPER_ID primary key (OPER_ID);

delete from OPERATORS;
commit;
insert into OPERATORS (OPER_CODE, OPER_ID, OPER_NAME, IS_VALID, PASSWORD, REGISTER_TIME, LOGIN_TIME, BELONG_TEAM, MOBILE_PHONE, FIRST_EMAIL, SECOND_EMAIL, NOTES_ID)
values (1, 'admin', 'admin', '1', 'admin', null, null, null, null, null, null, null);
commit;


-- Create table
create table OPER_ROLE
(
  ROLE_ID     NUMBER(10) not null,
  ROLE_NAME   VARCHAR2(128),
  DESCRIPTION VARCHAR2(128),
  CREATE_TIME TIMESTAMP(6),
  IS_VALID    CHAR(1) default '1',
  ORDERNUMBER NUMBER(10)
)

-- Add comments to the table 
comment on table OPER_ROLE
  is '角色表';
-- Add comments to the columns 
comment on column OPER_ROLE.ROLE_ID
  is '角色ID';
comment on column OPER_ROLE.ROLE_NAME
  is '角色名称';
comment on column OPER_ROLE.DESCRIPTION
  is '角色描述';
comment on column OPER_ROLE.CREATE_TIME
  is '角色创建时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPER_ROLE
  add constraint PK_OPER_ROLE primary key (ROLE_ID);

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

-- Create table
create table OPER_PRIVILEGE
(
  PRIVILEGE_ID    VARCHAR2(20) not null,
  PRIVILEGE_NAME  VARCHAR2(128),
  DESCRIPTION     VARCHAR2(64),
  PORDER          VARCHAR2(20),
  PARENT_PORDER   VARCHAR2(20),
  URL             VARCHAR2(256),
  ORDERNUMBER     NUMBER(10),
  PRIVILEGE_LEVEL NUMBER(10)
)

-- Add comments to the table 
comment on table OPER_PRIVILEGE
  is '权限表';
-- Add comments to the columns 
comment on column OPER_PRIVILEGE.PRIVILEGE_ID
  is '权限ID';
comment on column OPER_PRIVILEGE.PRIVILEGE_NAME
  is '权限名称';
comment on column OPER_PRIVILEGE.DESCRIPTION
  is '权限描述';
comment on column OPER_PRIVILEGE.PORDER
  is '权限序号';
comment on column OPER_PRIVILEGE.PARENT_PORDER
  is '父权限序号';
comment on column OPER_PRIVILEGE.URL
  is '权限的连接';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPER_PRIVILEGE
  add constraint PK_OPER_PRIVILEGE primary key (PRIVILEGE_ID);

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

-- Create table
create table OPER_PRIVS
(
  OPER_PRIVS_ID NUMBER(10) not null,
  ROLE_ID       NUMBER(10),
  PRIVILEGE_ID  VARCHAR2(8),
  REMARK        VARCHAR2(128)
)

-- Add comments to the table 
comment on table OPER_PRIVS
  is '角色权限关联表';
-- Add comments to the columns 
comment on column OPER_PRIVS.ROLE_ID
  is '角色ID';
comment on column OPER_PRIVS.PRIVILEGE_ID
  is '权限ID';
comment on column OPER_PRIVS.REMARK
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPER_PRIVS
  add constraint PK_OPER_PRIVS primary key (OPER_PRIVS_ID);
alter table OPER_PRIVS
  add constraint FK_PRIVS_REFERENCE_PRIVILEGE foreign key (PRIVILEGE_ID)
  references OPER_PRIVILEGE (PRIVILEGE_ID);
alter table OPER_PRIVS
  add constraint FK_PRIVS_REFERENCE_ROLE foreign key (ROLE_ID)
  references OPER_ROLE (ROLE_ID);

-- Create table
create table OPER_ROLES_RELATION
(
  OPER_ROLES_ID NUMBER(10) not null,
  OPER_ID       VARCHAR2(10),
  ROLE_ID       NUMBER(10)
)

-- Add comments to the table 
comment on table OPER_ROLES_RELATION
  is '操作员角色关联表';
-- Add comments to the columns 
comment on column OPER_ROLES_RELATION.OPER_ID
  is '操作员ID';
comment on column OPER_ROLES_RELATION.ROLE_ID
  is '角色ID';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPER_ROLES_RELATION
  add constraint PK_OPER_ROLES_RELATION primary key (OPER_ROLES_ID);
alter table OPER_ROLES_RELATION
  add constraint FK_REFERENCE_OPERATORS foreign key (OPER_ID)
  references OPERATORS (OPER_ID);
alter table OPER_ROLES_RELATION
  add constraint FK_REFERENCE_ROLE foreign key (ROLE_ID)
  references OPER_ROLE (ROLE_ID);
  
  
-- Create table
create table DIC_CONTENT_KEY
(
  ID          VARCHAR2(32) not null,
  INF_NAME    VARCHAR2(32) not null,
  REMARK      VARCHAR2(32),
  EFF_DATE    DATE,
  EXP_DATE    DATE,
  ORDERNUMBER NUMBER(10)
)

-- Create/Recreate primary, unique and foreign key constraints 
alter table DIC_CONTENT_KEY
  add primary key (ID, INF_NAME);

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

-- Create table
create table DIC_REMARK_VALUE
(
  ID         VARCHAR2(32),
  TABLE_NAME VARCHAR2(32),
  REMARK     VARCHAR2(32),
  LANGUAGE   VARCHAR2(10)
)

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

create sequence ADDRESS_SEQUENCE
minvalue 1
maxvalue 99999;

create sequence ASSET_SEQUENCE
minvalue 1
maxvalue 99999;

create sequence OPERATORS_SEQUENCE
minvalue 1
maxvalue 99999;

create sequence OPER_ROLES_SEQUENCE
minvalue 1
maxvalue 99999;

create sequence ROLEPRIVILEGE_SEQUENCE
minvalue 1
maxvalue 99999;

create sequence ROLES_SEQUENCE
minvalue 1
maxvalue 99999;

create sequence USERS_SEQUENCE
minvalue 1
maxvalue 99999;

create sequence WORKRECORD_SEQUENCE
minvalue 1
maxvalue 99999;

create table ADDRESS
(
  ID         NUMBER(10) not null,
  NAME       VARCHAR2(50) not null,
  SEX        VARCHAR2(10),
  MOBILE     VARCHAR2(20),
  EMAIL      VARCHAR2(50),
  QQ         VARCHAR2(20),
  COMPANY    VARCHAR2(100),
  ADDRESS    VARCHAR2(100),
  POSTCODE   VARCHAR2(10),
  FILEPATH   VARCHAR2(500),
  USERNAME   VARCHAR2(20),
  UPDATEDATE DATE
);

-- Create/Recreate primary, unique and foreign key constraints 
alter table ADDRESS
  add constraint PK_ADDRESS primary key (ID);

select a.*,rowid from address a;

select a.*,rowid from OPERATORS a;

select * from CONTRACT_PROJECT;
select * from INF_ASSET;
select * from INF_CONTRACT_STAFF;

select * from INF_PERFORMANCE_CRM;
select * from INF_PERFORMANCE_OPTIMIZE;
select a.*,rowid from oper_privilege a;
select * from INF_PRIVILEGE;
select * from INF_REAL_PROJECT;
select * from INF_REAL_STAFF_PROJECT;
select * from INF_ROLE;
select * from INF_ROLE_PRIVS;
select * from INF_STAFF;
select * from RECEIVABLES;
select * from REST_RECORDS;
select * from REWARDS;
select * from USERS;
select * from WORK_RECORDS;
