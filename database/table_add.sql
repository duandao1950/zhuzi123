

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
  is '员工信息表';
-- Add comments to the columns 
comment on column inf_staffs.staff_id
  is '员工号';
comment on column inf_staffs.staff_name
  is '员工姓名';
comment on column inf_staffs.skill
  is '技能方向';
comment on column inf_staffs.status_id
  is '员工当前状态';
comment on column inf_staffs.tel1
  is '第一联系方式';
comment on column inf_staffs.tel2
  is '第二联系方式';
comment on column inf_staffs.email1
  is '第一邮箱';
comment on column inf_staffs.email2
  is '第二邮箱';
comment on column inf_staffs.enter_com_date
  is '入职时间';
comment on column inf_staffs.exit_com_date
  is '离职时间';
comment on column inf_staffs.group_name
  is '所属组';
comment on column inf_staffs.work_years
  is '进入公司前工作年限';
comment on column inf_staffs.remark
  is '备注';

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
  is '考勤表';
-- Add comments to the columns 
comment on column work_records.staff_id
  is '员工号';
comment on column work_records.prog_team
  is '所在项目组';
comment on column work_records.start_time
  is '上班开始时间';
comment on column work_records.end_time
  is '下班时间';
comment on column work_records.work_type
  is '是否是加班';
comment on column work_records.approve_flag
  is '是否审批';
comment on column work_records.work_reason 
  is '加班原因';
comment on column work_records.remark
  is '备注';
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
  is '奖惩表';
-- Add comments to the columns 
comment on column rewards.staff_id
  is '员工号';
comment on column rewards.reward_type
  is '奖惩类型';
comment on column rewards.sub_type
  is '子类型';
comment on column rewards.reward_time
  is '奖惩时间';
comment on column rewards.remark
  is '备注';
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
  is '合同项目信息表';
-- Add comments to the columns 
comment on column contract_project.contract_no
  is '合同编号';
comment on column contract_project.project_no
  is '项目编号';
comment on column contract_project.project_name
  is '项目名称';
comment on column contract_project.assign_date
  is '合同签订时间';
comment on column contract_project.open_date
  is '立项时间';
comment on column contract_project.plan_start_date
  is '预定开始时间';
comment on column contract_project.plan_end_date
  is '预定结束时间';
comment on column contract_project.real_start_date
  is '实际开始时间';
comment on column contract_project.real_end_date
  is '实际结束时间';
comment on column contract_project.our_intf_person
  is '乙方接口人';
comment on column contract_project.other_intf_person
  is '甲方接口人';
comment on column contract_project.contract_count_person
  is '合同人数';
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
  is '调休记录';
-- Add comments to the columns 
comment on column rest_records.staff_id
  is '员工号';
comment on column rest_records.prog_team
  is '所在项目组';
comment on column rest_records.start_time
  is '开始时间';
comment on column rest_records.end_time
  is '结束时间';
comment on column rest_records.reason
  is '调休原因';
comment on column rest_records.rest_type
  is '调休类型，';
comment on column rest_records.approve_flag
  is '是否审批';
comment on column rest_records.remark
  is '备注';

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
  is '合同项目员工信息表';
-- Add comments to the columns 
comment on column inf_contract_staff.contract_no
  is '合同号';
comment on column inf_contract_staff.staff_id
  is '员工号';
comment on column inf_contract_staff.enter_date
  is '开始时间';
comment on column inf_contract_staff.end_date
  is '结束时间';

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
  is '员工资产信息表';
-- Add comments to the columns 
comment on column inf_asset.staff_id
  is '员工号';
comment on column inf_asset.device_no
  is '设备号';
comment on column inf_asset.com_display_no
  is '显示器编号';
comment on column inf_asset.com_host_no
  is '主机编号';
comment on column inf_asset.ip_address
  is 'ip地址';
comment on column inf_asset.device_address
  is '设备存放地，华为，中创，软通';
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
  is '真实项目信息表';
-- Add comments to the columns 
comment on column inf_real_project.project_no
  is '项目编号';
comment on column inf_real_project.project_version
  is '项目版本号';
comment on column inf_real_project.project_name
  is '项目名称';
comment on column inf_real_project.project_version_name
  is '项目版本名称';
comment on column inf_real_project.start_date
  is '开始时间';
comment on column inf_real_project.end_date
  is '结束时间';
comment on column inf_real_project.persons
  is '项目人数';
comment on column inf_real_project.remark
  is '备注';
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
  is '真实项目员工信息表';
-- Add comments to the columns 
comment on column inf_real_staff_project.version_no
  is '项目版本号';
comment on column inf_real_staff_project.staff_id 
  is '员工号';
comment on column inf_real_staff_project.enter_date
  is '进入项目时间';
comment on column inf_real_staff_project.end_date
  is '离开项目时间';
comment on column inf_real_staff_project.remark
  is '备注';
