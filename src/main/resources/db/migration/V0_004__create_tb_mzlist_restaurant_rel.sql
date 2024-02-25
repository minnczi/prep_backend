CREATE TABLE `tb_mzlist_restaurant_rel` (
    `restaurant_id`	BIGINT NOT NULL COMMENT '음식점 id',
    `mzlist_id`	BIGINT NOT NULL COMMENT '맛집리스트 id',
    `restaurant_memo` TEXT NULL COMMENT '맛집리스트 내에 있는 음식점에 대한 사용자의 코멘트',
    `restaurant_nickname` VARCHAR(40) NULL COMMENT '음식점 별명',
    PRIMARY KEY (restaurant_id, mzlist_id)
) COMMENT = '맛집리스트 레스토랑 관계' ENGINE=InnoDB;
