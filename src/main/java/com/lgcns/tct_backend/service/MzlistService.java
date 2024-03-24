package com.lgcns.tct_backend.service;

import com.lgcns.tct_backend.dto.MzlistCreateRequestDTO;
import com.lgcns.tct_backend.dto.MzlistResponseDTO;
import com.lgcns.tct_backend.dto.MzlistUpdateRequestDTO;
import com.lgcns.tct_backend.dto.SessionUserDTO;
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

  public MzlistResponseDTO findMzlistByListId(Long listId) {
    // 아이디의 유효성 체크
    Mzlist mzlist = mzlistRepository.findById(listId).orElseThrow();

    return MzlistResponseDTO.builder()
            .listId(mzlist.getMzlistId())
            .userId(mzlist.getUserId())
            .mzlistName(mzlist.getMzlistName())
            .mzlistDescription(mzlist.getMzlistDescription())
            .mzlistIcon(mzlist.getMzlistIcon())
            .build();
  }

  public List<MzlistResponseDTO> findMzlistByUserId(Long listId) {
    return null;
  }

  public Long createMzlist(MzlistCreateRequestDTO mzlistCreateRequestDTO) {
    SessionUserDTO user = SessionUtil.getSessionUser();

    Mzlist mzlist =
        Mzlist.builder()
            .userId(user.getUserId())
            .mzlistName(mzlistCreateRequestDTO.getMzlistName())
            .mzlistDescription(mzlistCreateRequestDTO.getMzlistDescription())
            .mzlistIcon(mzlistCreateRequestDTO.getMzlistIcon())
            .build();

    Mzlist savedList = mzlistRepository.save(mzlist);
    return savedList.getMzlistId();
  }

  public Long updateMzlist(Long listId, MzlistUpdateRequestDTO mzlistUpdateRequestDTO) {
    return null;
  }

  public Long deleteMzlist(Long listId) {
    return null;
  }
}
