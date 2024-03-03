CREATE TABLE `tb_user_mzlist_rel` (
    `user_id` BIGINT NOT NULL COMMENT '사용자 id',
    `mzlist_id` BIGINT NOT NULL COMMENT '맛집리스트 id',
    `mzlist_management_role` VARCHAR(20) NULL COMMENT '리스트 관리 역할(WRITE-수정가능/READ-읽기전용/ADMIN)',
    PRIMARY KEY (user_id, mzlist_id)
) COMMENT = '사용자 맛집리스트 관계' ENGINE=InnoDB;