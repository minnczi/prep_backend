package com.lgcns.tct_backend.dto;

import lombok.Data;

@Data
public class MzlistCreateRequestDTO {
  private String mzlistName;
  private String mzlistDescription;
  private String mzlistIcon;
}
