package com.lgcns.tct_backend.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MzlistResponseDTO {
  private Long mzListId;
  private Long userId;
  private String mzlistName;
  private String mzlistDescription;
  private String mzlistIcon;
}
