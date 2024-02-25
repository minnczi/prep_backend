CREATE TABLE `tb_restaurant` (
     `restaurant_id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '음식점 id',
     `restaurant_name`	VARCHAR(40)	NOT NULL COMMENT '음식점명',
     `restaurant_address`	VARCHAR(100) NULL COMMENT '음식점 주소',
     `restaurant_category`	VARCHAR(20)	NULL COMMENT '음식점 카테고리',
     `open_status`	VARCHAR(10)	NOT NULL COMMENT '음식점 영업 상태 (OPEN-영업중, CLOSED-휴점,폐점)'
) COMMENT = '음식점' ENGINE=InnoDB;
