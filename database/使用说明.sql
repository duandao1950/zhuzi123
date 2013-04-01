1.确认安装好oralce应用

2.通过Database Configuration Assistant创建EMG数据

3.创建users用户 zhuzi123
CREATE USER "zhuzi123" PROFILE "DEFAULT" IDENTIFIED BY "zhuzi123" DEFAULT TABLESPACE "USERS" TEMPORARY TABLESPACE 
"TEMP" ACCOUNT UNLOCK;

4.使用system用户 赋权
grant connect to zhuzi123;
grant resource to zhuzi123;

5.查看用户
select * from user_users;

6.加载DDL.sql创建表,如反复执行,可以先执行rollback_DDL.sql 回滚所有创建语句

7.创建所有sequence

8.加载basedata.sql,插入系统基础数据
