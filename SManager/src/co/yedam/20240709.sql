--�л�����(�л���ȣ, �̸�, ����ó, �ּ�, �������)
--tbl_student ���̺��.

create table tbl_student (
    std_no varchar2(10) primary key,
    std_name varchar2(100) not null,
    std_phone varchar2(20), -- 010-1111-2222
    address varchar2(100),
    birth_date date,
    creation_date date default sysdate
);

--���� ������ �Է�
insert into tbl_student (std_no, std_name, std_phone)
values('S2024-01', 'ȫ�浿', '010-1234-5678');
insert into tbl_student (std_no, std_name, std_phone, address)
values('S2024-02', '��浿', '010-3344-5678', '�뱸 40����');
insert into tbl_student (std_no, std_name, std_phone, address)
values('S2024-03', '��浿', '010-1134-5678', '���ֵ� 20����');

--����
update tbl_student
set std_name = '��â��'
where std_no = 'S2024-05';

update tbl_student
set address = '���ֵ� 20����'
where std_no = 'S2024-03';

update tbl_student
set address = '���� 10����'
where std_no = 'S2024-01';

--������ �߰�
insert into tbl_student (std_no, std_name, std_phone)
values('S2024-04', 'ȫ��', '010-0000-1115');

delete from tbl_student
where std_no = '2024-04';

--����, �ּ� ����.
update tbl_student
set    birth_date = to_date('1992-10-13', 'yyyy-mm-dd')
      ,std_name = '���氪'
      ,std_phone = '���氪'
      ,address = '���� 20����'
where std_no = 'S2024-02';



update tbl_student
set address = '��⵵ �����'
where std_no = 'S2024-04';


select *
from tbl_student;

commit;
rollback;