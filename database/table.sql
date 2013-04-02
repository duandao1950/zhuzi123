create table OPERATORS
(
  OPER_CODE     NUMBER(10) not null,
  OPER_ID       VARCHAR2(10) not null,
  OPER_NAME     VARCHAR2(128),
  IS_VALID      NUMBER(10) not null,
  PASSWORD      VARCHAR2(128) not null,
  REGISTER_TIME TIMESTAMP(6),
  LOGIN_TIME    TIMESTAMP(6),
  BELONG_TEAM   VARCHAR2(50),
  MOBILE_PHONE  VARCHAR2(50),
  FIRST_EMAIL   VARCHAR2(50),
  SECOND_EMAIL  VARCHAR2(50),
  NOTES_ID      VARCHAR2(50)
)

select * from operators;
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPERATORS
  add constraint PK_OPER_ID primary key (OPER_ID);

alter table operators drop column IS_VALID

alter table operators add IS_VALID number(10);

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
  is '��ɫ��';
-- Add comments to the columns 
comment on column OPER_ROLE.ROLE_ID
  is '��ɫID';
comment on column OPER_ROLE.ROLE_NAME
  is '��ɫ����';
comment on column OPER_ROLE.DESCRIPTION
  is '��ɫ����';
comment on column OPER_ROLE.CREATE_TIME
  is '��ɫ����ʱ��';
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
  is 'Ȩ�ޱ�';
-- Add comments to the columns 
comment on column OPER_PRIVILEGE.PRIVILEGE_ID
  is 'Ȩ��ID';
comment on column OPER_PRIVILEGE.PRIVILEGE_NAME
  is 'Ȩ������';
comment on column OPER_PRIVILEGE.DESCRIPTION
  is 'Ȩ������';
comment on column OPER_PRIVILEGE.PORDER
  is 'Ȩ�����';
comment on column OPER_PRIVILEGE.PARENT_PORDER
  is '��Ȩ�����';
comment on column OPER_PRIVILEGE.URL
  is 'Ȩ�޵�����';
-- Create/Recreate primary, unique and foreign key constraints 
alter table OPER_PRIVILEGE
  add constraint PK_OPER_PRIVILEGE primary key (PRIVILEGE_ID);

delete from OPER_PRIVILEGE;
commit;
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99992', 'Address.Detail', 'Address Detail', 'TR_0_9_0', 'TR_9_0', 'address_list.action', 99992, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99973', '�˵�', 'Privilege', 'TR_0_7_0', 'TR_0_7', 'privilege_list.action', 99972, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99974', '�û�', 'Operator Manage', 'TR_0_7_2', 'TR_0_7', 'operator_manage_list.action', 99974, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99991', 'Address', 'Address', 'TR_0_9', 'TR_0', null, 99991, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99971', 'ϵͳ����', 'System', 'TR_0_7', 'TR_0', null, 99971, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99972', '��ɫ', 'Role', 'TR_0_7_1', 'TR_0_7', 'roles_list.action', 99973, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M99975', '�˳�', 'Login out', 'TR_0_7_3', 'TR_0_7', 'logout.action', 99975, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40001', '�ۺ�ҵ�����', '�ۺ�ҵ�����', 'TR_0_3', 'TR_0', null, 40001, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40002', '�ʲ���Ϣ', '�ʲ���Ϣ', 'TR_0_3_0', 'TR_0_3', 'asset_query.action', 40002, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40003', '��ʵ��ͬ', '��ʵ��ͬ', 'TR_0_3_1', 'TR_0_3', 'realproject_list.action', 40003, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M40004', '��ͬ��Ŀ', '��ͬ��Ŀ', 'TR_0_3_2', 'TR_0_3', 'contractproject_list.action', 40004, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10001', 'Ա������', 'Ա������', 'TR_0_0', 'TR_0', null, 10001, 0);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10002', 'Ա����Ϣ', null, 'TR_0_0_0', 'TR_0_0', 'staff_query.action', 10002, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10003', 'ά���鼨Ч����', null, 'TR_0_0_1', 'TR_0_0', 'performanceOpt_query', 10003, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10004', '������Ϣ', null, 'TR_0_0_2', 'TR_0_0', 'work_record_query.action', 10004, 1);
insert into OPER_PRIVILEGE (PRIVILEGE_ID, PRIVILEGE_NAME, DESCRIPTION, PORDER, PARENT_PORDER, URL, ORDERNUMBER, PRIVILEGE_LEVEL)
values ('M10005', 'CRM�鼨Ч����', null, 'TR_0_0_3', 'TR_0_0', 'perCRM_query.action', 10005, 1);
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
  is '��ɫȨ�޹�����';
-- Add comments to the columns 
comment on column OPER_PRIVS.ROLE_ID
  is '��ɫID';
comment on column OPER_PRIVS.PRIVILEGE_ID
  is 'Ȩ��ID';
comment on column OPER_PRIVS.REMARK
  is '��ע';
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
  is '����Ա��ɫ������';
-- Add comments to the columns 
comment on column OPER_ROLES_RELATION.OPER_ID
  is '����ԱID';
comment on column OPER_ROLES_RELATION.ROLE_ID
  is '��ɫID';
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
values ('IN10000', 'DIC_CONTENT_KEY', '����', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('IN10001', 'DIC_CONTENT_KEY', '��', 'ZH');

insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INS0001', 'DIC_CONTENT_KEY', '��', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INS0002', 'DIC_CONTENT_KEY', 'Ů', 'ZH');
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

create sequence GOODS_SEQUENCE
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
values ('B0001', 'DIC_BELONG_TEAM', 'INB0001', null, null, 1);
insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('B0002', 'DIC_BELONG_TEAM', 'INB0002', null, null, 2);
insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('B0003', 'DIC_BELONG_TEAM', 'INB0003', null, null, 3);
insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('B0004', 'DIC_BELONG_TEAM', 'INB0004', null, null, 4);
insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('B0005', 'DIC_BELONG_TEAM', 'INB0005', null, null, 5);
insert into DIC_CONTENT_KEY (ID, INF_NAME, REMARK, EFF_DATE, EXP_DATE, ORDERNUMBER)
values ('B0006', 'DIC_BELONG_TEAM', 'INB0006', null, null, 6);
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
values ('IN10000', 'DIC_CONTENT_KEY', '����', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('IN10001', 'DIC_CONTENT_KEY', '��', 'ZH');

insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INB0001', 'DIC_CONTENT_KEY', 'ʵϰ or ����', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INB0002', 'DIC_CONTENT_KEY', '����', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INB0003', 'DIC_CONTENT_KEY', 'CRM', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INB0004', 'DIC_CONTENT_KEY', 'KPNI', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INB0005', 'DIC_CONTENT_KEY', 'ά��', 'ZH');
insert into DIC_REMARK_VALUE (ID, TABLE_NAME, REMARK, LANGUAGE)
values ('INB0006', 'DIC_CONTENT_KEY', '����', 'ZH');
commit;

select * from DIC_CONTENT_KEY;
select * from DIC_REMARK_VALUE;

select b.remark from DIC_CONTENT_KEY a,DIC_REMARK_VALUE b where a.remark=b.id and a.inf_name='DIC_SEX' and a.id='S0001';

 select b.remark
   from DIC_CONTENT_KEY a, DIC_REMARK_VALUE b
  where a.remark = b.id
    and a.inf_name = 'DIC_SEX'
    and a.id = 'S0001'
    and b.language = upper('zh')
  order by a.ordernumber

select a.*,rowid from address a;

select a.*,rowid from address a;

select a.*,rowid from OPERATORS a where oper_id='admin' and password='admin' and is_valid='10001';

select * from CONTRACT_PROJECT;
select * from INF_ASSET;
select * from INF_CONTRACT_STAFF;
select * from INF_PERFORMANCE_CRM;
select * from INF_PERFORMANCE_OPTIMIZE;
select a.*,rowid from oper_privilege a order by ordernumber;
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

insert into address values(ADDRESS_SEQUENCE.Nextval,'BBB','S0002','BBB','BBB@B.com','BBB','BBB','BBB','BBB','BBB','admin',sysdate);

mgrpm@crmtest09:~/tomcat/apache-tomcat-6.0.26/bin> ./startup.sh 
Using CATALINA_BASE:   /home/mgrpm/tomcat/apache-tomcat-6.0.26
Using CATALINA_HOME:   /home/mgrpm/tomcat/apache-tomcat-6.0.26
Using CATALINA_TMPDIR: /home/mgrpm/tomcat/apache-tomcat-6.0.26/temp
Using JRE_HOME:        /opt/bea/jdk150_04/jre
Using CLASSPATH:       /home/mgrpm/tomcat/apache-tomcat-6.0.26/bin/bootstrap.jar

��linux������tomcatʱJRE_HOME���ǲ��ԣ���catalina.sh�ļ���˵��Defaults to JAVA_HOME if empty
�����ǰ��profileû��Ч�����ǻ�ȥ��Ĭ�ϵ�JRE_HOME���ã�
��/home/mgrpmĿ¼����ls -la ����鿴.profile����. ./profileʹ��ǰ��profile��Ч

.profile�ļ��������£�
JAVA_HOME=/opt/bea/jdk150_04 
export JAVA_HOME
JRE_HOME=/opt/bea/jdk150_04/jre
export JRE_HOME
CLASSPATH=$CLASSPATH:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib
export CLASSPATH
export TOMCAT_HOME=/home/mgrpm/tomcat/apache-tomcat-6.0.26
export CATALINA_HOME=/home/mgrpm/tomcat/apache-tomcat-6.0.26
PATH=$PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin:$JRE_HOME/bin
export PATH




CREATE TABLE goods (
   id number(10) NOT NULL,
  name varchar(20) DEFAULT NULL,
  stand varchar(20) DEFAULT NULL,
  money number(10) DEFAULT NULL,
  leavings number(10) DEFAULT NULL,
  orders number(10) DEFAULT NULL
)

alter table goods
  add constraint PK_goods primary key (id);

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO goods VALUES ('4', '����', 'ÿ��27��', '99', '43', '3');
INSERT INTO goods VALUES ('5', '����', 'ÿ��28��', '10', '5', '4');
INSERT INTO goods VALUES ('6', '����', 'ÿ��29��', '11', '6', '5');
INSERT INTO goods VALUES ('8', '����', 'ÿ��31��', '13', '8', '66');
INSERT INTO goods VALUES ('9', 'ƻ��', 'ÿ��32��', '14', '9', '67');
INSERT INTO goods VALUES ('11', '�㽶', 'ÿ��34��', '16', '11', '69');
INSERT INTO goods VALUES ('12', '����', 'ÿ��35��', '17', '12', '70');
INSERT INTO goods VALUES ('13', '����', 'ÿ��36��', '6', '13', '0');
INSERT INTO goods VALUES ('14', '����', 'ÿ��37��', '7', '14', '1');
INSERT INTO goods VALUES ('15', 'ţ��', 'ÿ��38��', '8', '15', '2');
INSERT INTO goods VALUES ('16', '����', 'ÿ��39��', '9', '16', '3');
INSERT INTO goods VALUES ('17', 'ƻ��', 'ÿ��40��', '10', '17', '4');
INSERT INTO goods VALUES ('18', '����', 'ÿ��41��', '11', '18', '5');
INSERT INTO goods VALUES ('19', '�㽶', 'ÿ��42��', '12', '19', '65');
INSERT INTO goods VALUES ('20', '����', 'ÿ��43��', '13', '20', '66');
INSERT INTO goods VALUES ('21', '����', 'ÿ��44��', '14', '21', '67');
INSERT INTO goods VALUES ('22', '����', 'ÿ��45��', '15', '22', '68');
INSERT INTO goods VALUES ('23', 'ţ��', 'ÿ��46��', '16', '23', '69');
INSERT INTO goods VALUES ('24', '����', 'ÿ��47��', '17', '24', '70');
INSERT INTO goods VALUES ('25', 'ƻ��', 'ÿ��48��', '6', '25', '0');
INSERT INTO goods VALUES ('26', '����', 'ÿ��49��', '7', '26', '1');
INSERT INTO goods VALUES ('27', '�㽶', 'ÿ��50��', '8', '27', '2');
INSERT INTO goods VALUES ('28', '����', 'ÿ��51��', '9', '28', '3');
INSERT INTO goods VALUES ('30', '����', 'ÿ��53��', '11', '30', '5');
INSERT INTO goods VALUES ('31', 'ţ��', 'ÿ��54��', '12', '31', '65');
INSERT INTO goods VALUES ('32', '����', 'ÿ��55��', '13', '32', '66');
INSERT INTO goods VALUES ('33', 'ƻ��', 'ÿ��56��', '14', '33', '67');
INSERT INTO goods VALUES ('36', '����', 'ÿ��59��', '17', '36', '70');
INSERT INTO goods VALUES ('37', '����', 'ÿ��60��', '18', '37', '71');
INSERT INTO goods VALUES ('38', '����', 'ÿ��61��', '19', '38', '72');
INSERT INTO goods VALUES ('41', '�Ϲ�', 'ÿ��', '2', '123', '1');
INSERT INTO goods VALUES ('42', 'ʨ��', '1ֻ', '3333', '1', '0');
INSERT INTO goods VALUES ('44', '����', 'ÿ��37��', '7', '23', '1');
INSERT INTO goods VALUES ('45', '����', 'ÿ��27��', '99', '4', '3');
INSERT INTO goods VALUES ('46', '����', 'ÿ��', '12', '100', '2');


select * from goods;

select a.*,rowid from OPER_PRIVILEGE a;

select * from operators;

select * from address