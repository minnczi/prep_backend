CREATE TABLE `tb_user` (
   `user_id` BIGINT	PRIMARY KEY AUTO_INCREMENT COMMENT '사용자 id',
   `user_name` VARCHAR(20)	NOT NULL COMMENT '사용자명',
   `nickname` VARCHAR(20)	NOT NULL COMMENT '별명',
   `password`	VARCHAR(64)	NOT NULL COMMENT '비밀번호',
   `user_birthday`	DATE NULL COMMENT '사용자 생년월일',
   `gender`	VARCHAR(1)	NULL COMMENT '성별(M-남성/F-여성)',
   `authority_code`	VARCHAR(20)	NOT NULL COMMENT '사용자 권한 코드',
   `use_yn`	VARCHAR(1)	NOT NULL COMMENT '사용 여부(Y-사용중/N-휴먼계정)'
) COMMENT = '사용자' ENGINE=InnoDB;