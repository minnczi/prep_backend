package com.lgcns.tct_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SessionUserVO {
    private Long userId;

    private String userName;

    private String nickname;

    private Date userBirthday;

    private String gender;

    private String authorityCode;

    private String useYn;
}
