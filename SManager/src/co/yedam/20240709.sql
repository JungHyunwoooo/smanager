--학생정보(학생번호, 이름, 연락처, 주소, 생년월일)
--tbl_student 테이블명.

create table tbl_student (
    std_no varchar2(10) primary key,
    std_name varchar2(100) not null,
    std_phone varchar2(20), -- 010-1111-2222
    address varchar2(100),
    birth_date date,
    creation_date date default sysdate
);

--샘플 데이터 입력
insert into tbl_student (std_no, std_name, std_phone)
values('S2024-01', '홍길동', '010-1234-5678');
insert into tbl_student (std_no, std_name, std_phone, address)
values('S2024-02', '김길동', '010-3344-5678', '대구 40번지');
insert into tbl_student (std_no, std_name, std_phone, address)
values('S2024-03', '장길동', '010-1134-5678', '제주도 20번지');

--수정
update tbl_student
set std_name = '구창모'
where std_no = 'S2024-05';

update tbl_student
set address = '제주도 20번지'
where std_no = 'S2024-03';

update tbl_student
set address = '서울 10번지'
where std_no = 'S2024-01';

--데이터 추가
insert into tbl_student (std_no, std_name, std_phone)
values('S2024-04', '홍명보', '010-0000-1115');

delete from tbl_student
where std_no = '2024-04';

--생일, 주소 변경.
update tbl_student
set    birth_date = to_date('1992-10-13', 'yyyy-mm-dd')
      ,std_name = '변경값'
      ,std_phone = '변경값'
      ,address = '경주 20번지'
where std_no = 'S2024-02';



update tbl_student
set address = '경기도 시흥시'
where std_no = 'S2024-04';


select *
from tbl_student;

commit;
rollback;