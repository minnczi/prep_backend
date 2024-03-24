package com.lgcns.tct_backend.dto;

import lombok.Data;

@Data
public class MzlistUpdateRequestDTO {
  private String mzlistName;
  private String mzlistDescription;
  private String mzlistIcon;
}
