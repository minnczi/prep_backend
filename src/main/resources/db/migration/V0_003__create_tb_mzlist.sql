CREATE TABLE `tb_mzlist` (
     `mzlist_id` BIGINT	PRIMARY KEY AUTO_INCREMENT COMMENT '맛집리스트 id',
     `user_id`	BIGINT	NOT NULL COMMENT ' 사용자 id',
     `mzlist_name`	VARCHAR(40)	NOT NULL COMMENT '맛집리스트 이름',
     `mzlist_description`	VARCHAR(100) NULL COMMENT '맛집리스트 설명',
     `mzlist_icon`	VARCHAR(40)	NULL COMMENT '맛집리스트 아이콘'
) COMMENT = '맛집리스트' ENGINE=InnoDB;