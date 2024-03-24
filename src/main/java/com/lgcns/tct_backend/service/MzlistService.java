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
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MzlistService {

  private final ModelMapper modelMapper;
  private final MzlistRepository mzlistRepository;

  public MzlistResponseDTO findMzlistByListId(Long listId) {
    // 아이디의 유효성 체크
    Mzlist mzlist = mzlistRepository.findById(listId).orElseThrow();

    return modelMapper.map(mzlist, MzlistResponseDTO.class);
  }

  public List<MzlistResponseDTO> findMzlistByUserId(Long userId) {
    List<Mzlist> mzlist = mzlistRepository.findAllByUserId(userId);
    return modelMapper.map(mzlist, new TypeToken<List<MzlistResponseDTO>>() {}.getType());
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

  public Long updateMzlist(Long mzlistId, MzlistUpdateRequestDTO mzlistUpdateRequestDTO) {
    Mzlist mzlist = mzlistRepository.findById(mzlistId).orElseThrow();
    mzlist.updateMzlist(mzlistUpdateRequestDTO.getMzlistName(),
                        mzlistUpdateRequestDTO.getMzlistDescription(),
                        mzlistUpdateRequestDTO.getMzlistIcon());
    mzlistRepository.save(mzlist);
    return mzlistId;
  }

  public Long deleteMzlist(Long mzlistId) {
    Mzlist mzlist = mzlistRepository.findById(mzlistId).orElseThrow();
    mzlistRepository.delete(mzlist);
    return mzlistId;
  }
}
