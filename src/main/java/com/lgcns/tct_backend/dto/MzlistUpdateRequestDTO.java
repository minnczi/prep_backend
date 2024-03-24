package com.lgcns.tct_backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MzlistUpdateRequestDTO {
  private String mzlistName;
  private String mzlistDescription;
  private String mzlistIcon;
}
