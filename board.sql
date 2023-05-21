SELECT *FROM tbl_board tb ;
SELECT *FROM tbl_member tm ;
SELECT *FROM tbl_reply tr ;


UPDATE tbl_member 
set auth = 'ADMIN'
WHERE account = 'admin';


ALTER table tbl_member
add profile_image VARCHAR(200);


alter table tbl_reply 
add account VARCHAR(50) not null;

update tbl_reply 
set account = 'abcd';

DELETE FROM tbl_board 
WHERE board_no = '605';

UPDATE tbl_member 
SET name = '김이이이'
WHERE account ='yesprofile';

select A.reply_no, A.reply_text,
	A.account, B.name , B.profile_image 
from tbl_reply A
left join tbl_member B 
on A.account = B.account 
where board_no = 606;



alter table tbl_member 
add login_method VARCHAR(20);


update tbl_member 
set profile_image = concat('/local', profile_image)
where profile_image is not null 
   and login_method is null;




