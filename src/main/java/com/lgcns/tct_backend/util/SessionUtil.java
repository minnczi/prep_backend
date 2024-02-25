package com.lgcns.tct_backend.util;

import com.lgcns.tct_backend.dto.SessionUserVO;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil {
    public static SessionUserVO getSessionUser() {
        return SessionUserVO.builder()
                .userId(1L)
                .userName("민지")
                .nickname("chloe")
                .build();
    }
}
