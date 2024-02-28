package com.lgcns.tct_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MzlistResponseVO {
  private Long listId;
  private Long userId;
  private String mzlistName;
  private String mzlistDescription;
  private String mzlistIcon;
}
