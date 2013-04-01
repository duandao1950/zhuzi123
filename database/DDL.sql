
create table CONTRACT_PROJECT
(
  ID                    NUMBER(10) not null,
  CONTRACT_NO           VARCHAR2(32),
  PROJECT_NO            VARCHAR2(32),
  PROJECT_NAME          VARCHAR2(64),
  ASSIGN_DATE           DATE,
  OPEN_DATE             DATE,
  PLAN_START_DATE       DATE,
  PLAN_END_DATE         DATE,
  REAL_START_DATE       DATE,
  REAL_END_DATE         DATE,
  OUR_INTF_PERSON       VARCHAR2(8),
  OTHER_INTF_PERSON     VARCHAR2(8),
  CONTRACT_COUNT_PERSON NUMBER(4)
);


create table INF_ASSET
(
  ID             NUMBER(10) not null,
  STAFF_ID       VARCHAR2(10),
  DEVICE_NO      VARCHAR2(32),
  COM_DISPLAY_NO VARCHAR2(32),
  COM_HOST_NO    VARCHAR2(32),
  IP_ADDRESS     VARCHAR2(32),
  DEVICE_ADDRESS VARCHAR2(32),
  STATUS         VARCHAR2(2),
  REMARK         VARCHAR2(128)
);


create table INF_CONTRACT_STAFF
(
  CONTRACT_NO VARCHAR2(32),
  STAFF_ID    VARCHAR2(10),
  ENTER_DATE  DATE,
  END_DATE    DATE
);

-- Add comments to the table 
comment on table INF_CONTRACT_STAFF
  is '��ͬ��ĿԱ����Ϣ��';
-- Add comments to the columns 
comment on column INF_CONTRACT_STAFF.CONTRACT_NO
  is '��ͬ��';
comment on column INF_CONTRACT_STAFF.STAFF_ID
  is 'Ա����';
comment on column INF_CONTRACT_STAFF.ENTER_DATE
  is '��ʼʱ��';
comment on column INF_CONTRACT_STAFF.END_DATE
  is '����ʱ��';


create table INF_PERFORMANCE_CRM
(
  STAFF_ID           VARCHAR2(20) not null,
  STAFF_NAME         VARCHAR2(64),
  REQUIRMENT_ANALYZE NUMBER(4),
  CODING             NUMBER(4),
  PROBLEM_COUNTS     NUMBER(4),
  CHECK_CODE         NUMBER(4),
  CODE_CONFIRM       NUMBER(4),
  WORK_ATTITUDE      NUMBER(4),
  TRAINING           NUMBER(4),
  TEAM_CONTRIBUTE    NUMBER(4),
  DAILY_WORK         NUMBER(4),
  IN_MONTH           VARCHAR2(6),
  OTHER              NUMBER(4)
);

-- Add comments to the table 
comment on table INF_PERFORMANCE_CRM
  is 'CRM�鼨Ч��';
-- Add comments to the columns 
comment on column INF_PERFORMANCE_CRM.STAFF_ID
  is 'Ա��ID';
comment on column INF_PERFORMANCE_CRM.STAFF_NAME
  is 'Ա������';
comment on column INF_PERFORMANCE_CRM.REQUIRMENT_ANALYZE
  is '�������';
comment on column INF_PERFORMANCE_CRM.CODING
  is '����';
comment on column INF_PERFORMANCE_CRM.PROBLEM_COUNTS
  is '�������ⵥ';
comment on column INF_PERFORMANCE_CRM.CHECK_CODE
  is '���롢��̬��顢ע��';
comment on column INF_PERFORMANCE_CRM.CODE_CONFIRM
  is '�����߲�';
comment on column INF_PERFORMANCE_CRM.WORK_ATTITUDE
  is '����̬��';
comment on column INF_PERFORMANCE_CRM.TRAINING
  is '��ѵ';
comment on column INF_PERFORMANCE_CRM.TEAM_CONTRIBUTE
  is '�Ŷӹ���';
comment on column INF_PERFORMANCE_CRM.DAILY_WORK
  is '�ճ�����';
comment on column INF_PERFORMANCE_CRM.IN_MONTH
  is '�·�';
comment on column INF_PERFORMANCE_CRM.OTHER
  is '����';


-- Create table
create table INF_PERFORMANCE_OPTIMIZE
(
  STAFF_ID        VARCHAR2(20),
  STAFF_NAME      VARCHAR2(64),
  WORK_ATTENDENCE NUMBER(4),
  LAY_PBC         NUMBER(4),
  WRITE_LOG       NUMBER(4),
  REGULAR_MEETING NUMBER(4),
  SITES           NUMBER(4),
  SITES_BAK       NUMBER(4),
  PROBLEMS_COUNTS NUMBER(4),
  SOLVE_PROBLEMS  NUMBER(4),
  CODING          NUMBER(4),
  PRAISE_LETTER   NUMBER(4),
  CUST_COMPLAIN   NUMBER(4),
  SITE_COMPLAIN   NUMBER(4),
  CUST_APPRAISE   NUMBER(4),
  IN_MONTH        VARCHAR2(6),
  TRAINING        NUMBER(4),
  OTHER           NUMBER(4)
);

-- Add comments to the table 
comment on table INF_PERFORMANCE_OPTIMIZE
  is 'ά���鼨Ч��';
-- Add comments to the columns 
comment on column INF_PERFORMANCE_OPTIMIZE.STAFF_ID
  is 'Ա��ID';
comment on column INF_PERFORMANCE_OPTIMIZE.STAFF_NAME
  is 'Ա������';
comment on column INF_PERFORMANCE_OPTIMIZE.WORK_ATTENDENCE
  is '����';
comment on column INF_PERFORMANCE_OPTIMIZE.LAY_PBC
  is '�ƶ�PBC';
comment on column INF_PERFORMANCE_OPTIMIZE.WRITE_LOG
  is '��־��д';
comment on column INF_PERFORMANCE_OPTIMIZE.REGULAR_MEETING
  is '�ճ�����';
comment on column INF_PERFORMANCE_OPTIMIZE.SITES
  is '�ֵ㸺��';
comment on column INF_PERFORMANCE_OPTIMIZE.SITES_BAK
  is '�ֵ㱸��';
comment on column INF_PERFORMANCE_OPTIMIZE.PROBLEMS_COUNTS
  is '¼��ֵ�ƽ̨������';
comment on column INF_PERFORMANCE_OPTIMIZE.SOLVE_PROBLEMS
  is '��ԣ���Э�����������';
comment on column INF_PERFORMANCE_OPTIMIZE.CODING
  is '����';
comment on column INF_PERFORMANCE_OPTIMIZE.PRAISE_LETTER
  is '������';
comment on column INF_PERFORMANCE_OPTIMIZE.CUST_COMPLAIN
  is '�ͻ�Ͷ��';
comment on column INF_PERFORMANCE_OPTIMIZE.SITE_COMPLAIN
  is 'һ��Ͷ��';
comment on column INF_PERFORMANCE_OPTIMIZE.CUST_APPRAISE
  is '�ͻ�����';
comment on column INF_PERFORMANCE_OPTIMIZE.IN_MONTH
  is '�·�';
comment on column INF_PERFORMANCE_OPTIMIZE.TRAINING
  is '��ѵ';
comment on column INF_PERFORMANCE_OPTIMIZE.OTHER
  is '����';


-- Create table
create table INF_PRIVILEGE
(
  PRIVILEGE_ID   VARCHAR2(8),
  PRIVILEGE_NAME VARCHAR2(128),
  DESCRIPTION    VARCHAR2(64),
  PORDER         VARCHAR2(5),
  PARENT_PORDER  VARCHAR2(5),
  URL            VARCHAR2(256)
);

-- Add comments to the table 
comment on table INF_PRIVILEGE
  is 'Ȩ�ޱ�';
-- Add comments to the columns 
comment on column INF_PRIVILEGE.PRIVILEGE_ID
  is 'Ȩ��ID';
comment on column INF_PRIVILEGE.PRIVILEGE_NAME
  is 'Ȩ������';
comment on column INF_PRIVILEGE.DESCRIPTION
  is 'Ȩ������';
comment on column INF_PRIVILEGE.PORDER
  is 'Ȩ�����';
comment on column INF_PRIVILEGE.PARENT_PORDER
  is '��Ȩ�����';
comment on column INF_PRIVILEGE.URL
  is 'Ȩ�޵�����';


create table INF_REAL_PROJECT
(
  ID                   NUMBER(10) not null,
  PROJECT_NO           VARCHAR2(32),
  PROJECT_VERSION      VARCHAR2(32),
  PROJECT_NAME         VARCHAR2(32),
  PROJECT_VERSION_NAME VARCHAR2(32),
  START_DATE           DATE,
  END_DATE             DATE,
  PERSONS              NUMBER(4),
  REMARK               VARCHAR2(128)
);


create table INF_REAL_STAFF_PROJECT
(
  VERSION_NO VARCHAR2(32),
  STAFF_ID   VARCHAR2(10),
  ENTER_DATE DATE,
  END_DATE   DATE,
  REMARK     VARCHAR2(128)
);

-- Add comments to the table 
comment on table INF_REAL_STAFF_PROJECT
  is '��ʵ��ĿԱ����Ϣ��';
-- Add comments to the columns 
comment on column INF_REAL_STAFF_PROJECT.VERSION_NO
  is '��Ŀ�汾��';
comment on column INF_REAL_STAFF_PROJECT.STAFF_ID
  is 'Ա����';
comment on column INF_REAL_STAFF_PROJECT.ENTER_DATE
  is '������Ŀʱ��';
comment on column INF_REAL_STAFF_PROJECT.END_DATE
  is '�뿪��Ŀʱ��';
comment on column INF_REAL_STAFF_PROJECT.REMARK
  is '��ע';


-- Create table
create table INF_ROLE
(
  ROLE_ID     VARCHAR2(8),
  ROLE_NAME   VARCHAR2(128),
  DESCRIPTION VARCHAR2(128),
  CREATE_TIME TIMESTAMP(6),
  OPER_ID     VARCHAR2(10)
);

-- Add comments to the table 
comment on table INF_ROLE
  is '��ɫ��';
-- Add comments to the columns 
comment on column INF_ROLE.ROLE_ID
  is '��ɫID';
comment on column INF_ROLE.ROLE_NAME
  is '��ɫ����';
comment on column INF_ROLE.DESCRIPTION
  is '��ɫ����';
comment on column INF_ROLE.CREATE_TIME
  is '��ɫ����ʱ��';
comment on column INF_ROLE.OPER_ID
  is '�����ý�ɫ�Ĳ���ԱID';


-- Create table
create table INF_ROLE_PRIVS
(
  ROLE_ID      VARCHAR2(8),
  PRIVILEGE_ID VARCHAR2(8),
  REMARK       VARCHAR2(128)
);

-- Add comments to the table 
comment on table INF_ROLE_PRIVS
  is '��ɫȨ�޹�����';
-- Add comments to the columns 
comment on column INF_ROLE_PRIVS.ROLE_ID
  is '��ɫID';
comment on column INF_ROLE_PRIVS.PRIVILEGE_ID
  is 'Ȩ��ID';
comment on column INF_ROLE_PRIVS.REMARK
  is '��ע';


-- Create table
create table INF_STAFF
(
  STAFF_ID       VARCHAR2(10),
  STAFF_NAME     VARCHAR2(64),
  SKILL          VARCHAR2(128),
  STATUS_ID      CHAR(1),
  TEL1           VARCHAR2(16),
  TEL2           VARCHAR2(16),
  EMAIL1         VARCHAR2(64),
  EMAIL2         VARCHAR2(64),
  ENTER_COM_DATE DATE,
  EXIT_COM_DATE  DATE,
  GROUP_NAME     VARCHAR2(64),
  WORK_YEARS     NUMBER(2),
  REMARK         VARCHAR2(128)
);

-- Add comments to the table 
comment on table INF_STAFF
  is 'Ա����Ϣ��';
-- Add comments to the columns 
comment on column INF_STAFF.STAFF_ID
  is 'Ա����';
comment on column INF_STAFF.STAFF_NAME
  is 'Ա������';
comment on column INF_STAFF.SKILL
  is '���ܷ���';
comment on column INF_STAFF.STATUS_ID
  is 'Ա����ǰ״̬';
comment on column INF_STAFF.TEL1
  is '��һ��ϵ��ʽ';
comment on column INF_STAFF.TEL2
  is '�ڶ���ϵ��ʽ';
comment on column INF_STAFF.EMAIL1
  is '��һ����';
comment on column INF_STAFF.EMAIL2
  is '�ڶ�����';
comment on column INF_STAFF.ENTER_COM_DATE
  is '��ְʱ��';
comment on column INF_STAFF.EXIT_COM_DATE
  is '��ְʱ��';
comment on column INF_STAFF.GROUP_NAME
  is '������';
comment on column INF_STAFF.WORK_YEARS
  is '���빫˾ǰ��������';
comment on column INF_STAFF.REMARK
  is '��ע';

alter table INF_STAFF
  add primary key (STAFF_ID);

-- Create table
create table REST_RECORDS
(
  STAFF_ID     VARCHAR2(10),
  PROG_TEAM    VARCHAR2(32),
  START_TIME   TIMESTAMP(6),
  END_TIME     TIMESTAMP(6),
  REASON       VARCHAR2(128),
  REST_TYPE    CHAR(1),
  APPROVE_FLAG CHAR(1),
  REMARK       VARCHAR2(128)
);

-- Add comments to the table 
comment on table REST_RECORDS
  is '���ݼ�¼';
-- Add comments to the columns 
comment on column REST_RECORDS.STAFF_ID
  is 'Ա����';
comment on column REST_RECORDS.PROG_TEAM
  is '������Ŀ��';
comment on column REST_RECORDS.START_TIME
  is '��ʼʱ��';
comment on column REST_RECORDS.END_TIME
  is '����ʱ��';
comment on column REST_RECORDS.REASON
  is '����ԭ��';
comment on column REST_RECORDS.REST_TYPE
  is '�������ͣ�';
comment on column REST_RECORDS.APPROVE_FLAG
  is '�Ƿ�����';
comment on column REST_RECORDS.REMARK
  is '��ע';


-- Create table
create table REWARDS
(
  STAFF_ID    VARCHAR2(10),
  REWARD_TYPE CHAR(1),
  SUB_TYPE    CHAR(1),
  REWARD_TIME TIMESTAMP(6),
  REMARK      VARCHAR2(128)
);

-- Add comments to the table 
comment on table REWARDS
  is '���ͱ�';
-- Add comments to the columns 
comment on column REWARDS.STAFF_ID
  is 'Ա����';
comment on column REWARDS.REWARD_TYPE
  is '��������';
comment on column REWARDS.SUB_TYPE
  is '������';
comment on column REWARDS.REWARD_TIME
  is '����ʱ��';
comment on column REWARDS.REMARK
  is '��ע';


create table USERS
(
  ID       NUMBER(10) not null,
  USERNAME VARCHAR2(50),
  EMAIL    VARCHAR2(50),
  PASSWORD VARCHAR2(50),
  OTHERUSER    VARCHAR2(50)
);


create table WORK_RECORDS
(
  ID               NUMBER(10) not null,
  STAFF_ID         VARCHAR2(10),
  PROG_TEAM        VARCHAR2(32),
  START_TIME       TIMESTAMP(6),
  END_TIME         TIMESTAMP(6),
  WORK_TYPE        NUMBER(10),
  APPROVE_FLAG     NUMBER(10),
  WORK_REASON      VARCHAR2(128),
  REMARK           VARCHAR2(128),
  APPROVE_STAFF_ID VARCHAR2(10)
);


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


create table DIC_REMARK_VALUE
(
  ID         VARCHAR2(32),
  TABLE_NAME VARCHAR2(32),
  REMARK     VARCHAR2(32),
  LANGUAGE   VARCHAR2(10)
);


-- Create table
create table DIC_CONTENT_KEY
(
  ID          VARCHAR2(32) not null,
  INF_NAME    VARCHAR2(32) not null,
  REMARK      VARCHAR2(32),
  EFF_DATE    DATE,
  EXP_DATE    DATE,
  ORDERNUMBER NUMBER(10)
);

-- Create/Recreate primary, unique and foreign key constraints 
alter table DIC_CONTENT_KEY
  add primary key (ID, INF_NAME);

create table OPERATORS
(
  OPER_CODE     NUMBER(10) not null,
  OPER_ID       VARCHAR2(10) not null,
  OPER_NAME     VARCHAR2(128),
  IS_VALID      NUMBER(10),
  PASSWORD      VARCHAR2(128) not null,
  REGISTER_TIME TIMESTAMP(6),
  LOGIN_TIME    TIMESTAMP(6),
  BELONG_TEAM   VARCHAR2(50),
  MOBILE_PHONE  VARCHAR2(50),
  FIRST_EMAIL   VARCHAR2(50),
  SECOND_EMAIL  VARCHAR2(50),
  NOTES_ID      VARCHAR2(50)
);

-- Create/Recreate primary, unique and foreign key constraints 
alter table OPERATORS
  add constraint PK_OPER_ID primary key (OPER_ID);


-- Create table
create table OPER_ROLE
(
  ROLE_ID     NUMBER(10) not null,
  ROLE_NAME   VARCHAR2(128),
  DESCRIPTION VARCHAR2(128),
  CREATE_TIME TIMESTAMP(6),
  IS_VALID    CHAR(1) default '1',
  ORDERNUMBER NUMBER(10)
);

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

-- Create table
create table OPER_ROLES_RELATION
(
  OPER_ROLES_ID NUMBER(10) not null,
  OPER_ID       VARCHAR2(10),
  ROLE_ID       NUMBER(10)
);

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
);

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

-- Create table
create table OPER_PRIVS
(
  OPER_PRIVS_ID NUMBER(10) not null,
  ROLE_ID       NUMBER(10),
  PRIVILEGE_ID  VARCHAR2(8),
  REMARK        VARCHAR2(128)
);

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




