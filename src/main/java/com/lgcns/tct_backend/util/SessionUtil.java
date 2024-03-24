package com.lgcns.tct_backend.util;

import com.lgcns.tct_backend.dto.SessionUserDTO;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil {
  public static SessionUserDTO getSessionUser() {
    return SessionUserDTO.builder().userId(1L).userName("민지").nickname("chloe").build();
  }
}
