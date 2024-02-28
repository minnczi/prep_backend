package com.lgcns.tct_backend.service;

import com.lgcns.tct_backend.dto.MzlistCreateRequestVO;
import com.lgcns.tct_backend.dto.MzlistResponseVO;
import com.lgcns.tct_backend.dto.MzlistUpdateRequestVO;
import com.lgcns.tct_backend.dto.SessionUserVO;
import com.lgcns.tct_backend.model.Mzlist;
import com.lgcns.tct_backend.repository.MzlistRepository;
import com.lgcns.tct_backend.util.SessionUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MzlistService {

  private final MzlistRepository mzlistRepository;

  public MzlistResponseVO findMzlistByListId(Long listId) {
    // 아이디의 유효성 체크
    Mzlist mzlist = mzlistRepository.findById(listId).orElseThrow();

    MzlistResponseVO responseVO =
        MzlistResponseVO.builder()
            .listId(mzlist.getMzlistId())
            .userId(mzlist.getUserId())
            .mzlistName(mzlist.getMzlistName())
            .mzlistDescription(mzlist.getMzlistDescription())
            .mzlistIcon(mzlist.getMzlistIcon())
            .build();
    return responseVO;
  }

  public List<MzlistResponseVO> findMzlistByUserId(Long listId) {
    return null;
  }

  public Long createMzlist(MzlistCreateRequestVO mzlistCreateRequestVO) {
    SessionUserVO user = SessionUtil.getSessionUser();

    Mzlist mzlist =
        Mzlist.builder()
            .userId(user.getUserId())
            .mzlistName(mzlistCreateRequestVO.getMzlistName())
            .mzlistDescription(mzlistCreateRequestVO.getMzlistDescription())
            .mzlistIcon(mzlistCreateRequestVO.getMzlistIcon())
            .build();

    Mzlist savedList = mzlistRepository.save(mzlist);
    return savedList.getMzlistId();
  }

  public Long updateMzlist(Long listId, MzlistUpdateRequestVO mzlistUpdateRequestVO) {
    return null;
  }

  public Long deleteMzlist(Long listId) {
    return null;
  }
}
