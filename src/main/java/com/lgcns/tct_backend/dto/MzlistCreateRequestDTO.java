package com.lgcns.tct_backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MzlistCreateRequestDTO {
  private String mzlistName;
  private String mzlistDescription;
  private String mzlistIcon;
}
