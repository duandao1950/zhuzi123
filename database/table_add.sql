

/*==============================================================*/
/* Table: inf_staff                                             */
/*==============================================================*/
create table inf_staffs 
(
    staff_id             varchar2(10),
    staff_name           varchar2(64),
    skill                varchar2(128),
    status_id            char(1),
    tel1                 varchar2(16),
    tel2                 varchar2(16),
    email1               varchar2(64),
    email2               varchar2(64),
    enter_com_date       timestamp,
    exit_com_date        timestamp,
    group_name           varchar2(64),
    work_years           numeric(2),
    remark               varchar2(128)
);
-- Add comments to the table 
comment on table inf_staffs 
  is 'Ա����Ϣ��';
-- Add comments to the columns 
comment on column inf_staffs.staff_id
  is 'Ա����';
comment on column inf_staffs.staff_name
  is 'Ա������';
comment on column inf_staffs.skill
  is '���ܷ���';
comment on column inf_staffs.status_id
  is 'Ա����ǰ״̬';
comment on column inf_staffs.tel1
  is '��һ��ϵ��ʽ';
comment on column inf_staffs.tel2
  is '�ڶ���ϵ��ʽ';
comment on column inf_staffs.email1
  is '��һ����';
comment on column inf_staffs.email2
  is '�ڶ�����';
comment on column inf_staffs.enter_com_date
  is '��ְʱ��';
comment on column inf_staffs.exit_com_date
  is '��ְʱ��';
comment on column inf_staffs.group_name
  is '������';
comment on column inf_staffs.work_years
  is '���빫˾ǰ��������';
comment on column inf_staffs.remark
  is '��ע';

/*==============================================================*/
/* Table: work_records                                          */
/*==============================================================*/
create table work_records 
(
    staff_id             varchar2(10),
    prog_team            varchar2(32),
    start_time           timestamp,
    end_time             timestamp,
    work_type            char(1),
    approve_flag         char(1),
    work_reason          varchar2(128),
    remark               varchar2(128)
);
-- Add comments to the table 
comment on table work_records 
  is '���ڱ�';
-- Add comments to the columns 
comment on column work_records.staff_id
  is 'Ա����';
comment on column work_records.prog_team
  is '������Ŀ��';
comment on column work_records.start_time
  is '�ϰ࿪ʼʱ��';
comment on column work_records.end_time
  is '�°�ʱ��';
comment on column work_records.work_type
  is '�Ƿ��ǼӰ�';
comment on column work_records.approve_flag
  is '�Ƿ�����';
comment on column work_records.work_reason 
  is '�Ӱ�ԭ��';
comment on column work_records.remark
  is '��ע';
/*==============================================================*/
/* Table: rewards                                               */
/*==============================================================*/
create table rewards 
(
    staff_id             varchar2(10),
    reward_type          char(1),
    sub_type             char(1),
    reward_time          timestamp,
    remark               varchar2(128)
);
-- Add comments to the table 
comment on table rewards 
  is '���ͱ�';
-- Add comments to the columns 
comment on column rewards.staff_id
  is 'Ա����';
comment on column rewards.reward_type
  is '��������';
comment on column rewards.sub_type
  is '������';
comment on column rewards.reward_time
  is '����ʱ��';
comment on column rewards.remark
  is '��ע';
/*==============================================================*/
/* Table: contract_project                                      */
/*==============================================================*/
create table contract_project 
(
    contract_no          varchar2(32),
    project_no           varchar2(32),
    project_name         varchar2(64),
    assign_date          date,
    open_date            date,
    plan_start_date      date,
    plan_end_date        date,
    real_start_date      date,
    real_end_date        date,
    our_intf_person      varchar2(8),
    other_intf_person    varchar2(8),
    contract_count_person numeric(4)
);
-- Add comments to the table 
comment on table contract_project 
  is '��ͬ��Ŀ��Ϣ��';
-- Add comments to the columns 
comment on column contract_project.contract_no
  is '��ͬ���';
comment on column contract_project.project_no
  is '��Ŀ���';
comment on column contract_project.project_name
  is '��Ŀ����';
comment on column contract_project.assign_date
  is '��ͬǩ��ʱ��';
comment on column contract_project.open_date
  is '����ʱ��';
comment on column contract_project.plan_start_date
  is 'Ԥ����ʼʱ��';
comment on column contract_project.plan_end_date
  is 'Ԥ������ʱ��';
comment on column contract_project.real_start_date
  is 'ʵ�ʿ�ʼʱ��';
comment on column contract_project.real_end_date
  is 'ʵ�ʽ���ʱ��';
comment on column contract_project.our_intf_person
  is '�ҷ��ӿ���';
comment on column contract_project.other_intf_person
  is '�׷��ӿ���';
comment on column contract_project.contract_count_person
  is '��ͬ����';
/*==============================================================*/
/* Table: rest_records                                          */
/*==============================================================*/
create table rest_records 
(
    staff_id             varchar2(10),
    prog_team            varchar2(32),
    start_time           timestamp,
    end_time             timestamp,
    reason               varchar2(128),
    rest_type            char(1),
    approve_flag         char(1),
    remark               varchar2(128)
);
-- Add comments to the table 
comment on table rest_records 
  is '���ݼ�¼';
-- Add comments to the columns 
comment on column rest_records.staff_id
  is 'Ա����';
comment on column rest_records.prog_team
  is '������Ŀ��';
comment on column rest_records.start_time
  is '��ʼʱ��';
comment on column rest_records.end_time
  is '����ʱ��';
comment on column rest_records.reason
  is '����ԭ��';
comment on column rest_records.rest_type
  is '�������ͣ�';
comment on column rest_records.approve_flag
  is '�Ƿ�����';
comment on column rest_records.remark
  is '��ע';

/*==============================================================*/
/* Table: inf_contract_staff                                    */
/*==============================================================*/
create table inf_contract_staff 
(
    contract_no          varchar2(32),
    staff_id             varchar2(10),
    enter_date           date,
    end_date             date
);
-- Add comments to the table 
comment on table inf_contract_staff 
  is '��ͬ��ĿԱ����Ϣ��';
-- Add comments to the columns 
comment on column inf_contract_staff.contract_no
  is '��ͬ��';
comment on column inf_contract_staff.staff_id
  is 'Ա����';
comment on column inf_contract_staff.enter_date
  is '��ʼʱ��';
comment on column inf_contract_staff.end_date
  is '����ʱ��';

/*==============================================================*/
/* Table: inf_asset                                             */
/*==============================================================*/
create table inf_asset 
(
    staff_id             varchar2(10),
    device_no            varchar2(32),
    com_display_no       varchar2(32),
    com_host_no          varchar2(32),
    ip_address           varchar2(32),
    device_address       varchar2(32)
);
-- Add comments to the table 
comment on table inf_asset 
  is 'Ա���ʲ���Ϣ��';
-- Add comments to the columns 
comment on column inf_asset.staff_id
  is 'Ա����';
comment on column inf_asset.device_no
  is '�豸��';
comment on column inf_asset.com_display_no
  is '��ʾ�����';
comment on column inf_asset.com_host_no
  is '�������';
comment on column inf_asset.ip_address
  is 'ip��ַ';
comment on column inf_asset.device_address
  is '�豸��ŵأ���Ϊ���д�����ͨ';
/*==============================================================*/
/* Table: inf_real_project                                      */
/*==============================================================*/
create table inf_real_project 
(
    project_no           varchar2(32),
    project_version      varchar2(32),
    project_name         varchar2(32),
    project_version_name varchar2(32),
    start_date           date,
    end_date             date,
    persons              numeric(4),
    remark               varchar2(128)
);
-- Add comments to the table 
comment on table inf_real_project 
  is '��ʵ��Ŀ��Ϣ��';
-- Add comments to the columns 
comment on column inf_real_project.project_no
  is '��Ŀ���';
comment on column inf_real_project.project_version
  is '��Ŀ�汾��';
comment on column inf_real_project.project_name
  is '��Ŀ����';
comment on column inf_real_project.project_version_name
  is '��Ŀ�汾����';
comment on column inf_real_project.start_date
  is '��ʼʱ��';
comment on column inf_real_project.end_date
  is '����ʱ��';
comment on column inf_real_project.persons
  is '��Ŀ����';
comment on column inf_real_project.remark
  is '��ע';
/*==============================================================*/
/* Table: inf_real_staff_project                                */
/*==============================================================*/
create table inf_real_staff_project 
(
    version_no           varchar2(32),
    staff_id             varchar2(10),
    enter_date           date,
    end_date             date,
    remark               varchar2(128)
);
-- Add comments to the table 
comment on table inf_real_staff_project 
  is '��ʵ��ĿԱ����Ϣ��';
-- Add comments to the columns 
comment on column inf_real_staff_project.version_no
  is '��Ŀ�汾��';
comment on column inf_real_staff_project.staff_id 
  is 'Ա����';
comment on column inf_real_staff_project.enter_date
  is '������Ŀʱ��';
comment on column inf_real_staff_project.end_date
  is '�뿪��Ŀʱ��';
comment on column inf_real_staff_project.remark
  is '��ע';
