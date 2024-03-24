package com.lgcns.tct_backend.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionUserDTO {
  private Long userId;

  private String userName;

  private String nickname;

  private Date userBirthday;

  private String gender;

  private String authorityCode;

  private String useYn;
}
