1.ȷ�ϰ�װ��oralceӦ��

2.ͨ��Database Configuration Assistant����EMG����

3.����users�û� zhuzi123
CREATE USER "zhuzi123" PROFILE "DEFAULT" IDENTIFIED BY "zhuzi123" DEFAULT TABLESPACE "USERS" TEMPORARY TABLESPACE 
"TEMP" ACCOUNT UNLOCK;

4.ʹ��system�û� ��Ȩ
grant connect to zhuzi123;
grant resource to zhuzi123;

5.�鿴�û�
select * from user_users;

6.����DDL.sql������,�練��ִ��,������ִ��rollback_DDL.sql �ع����д������

7.��������sequence

8.����basedata.sql,����ϵͳ��������
