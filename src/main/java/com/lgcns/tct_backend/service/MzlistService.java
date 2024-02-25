package com.lgcns.tct_backend.service;

import com.lgcns.tct_backend.dto.MzlistCreateRequestVO;
import com.lgcns.tct_backend.dto.MzlistResponseVO;
import com.lgcns.tct_backend.dto.MzlistUpdateRequestVO;
import com.lgcns.tct_backend.dto.SessionUserVO;
import com.lgcns.tct_backend.model.Mzlist;
import com.lgcns.tct_backend.repository.MzlistRepository;
import com.lgcns.tct_backend.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MzlistService {

    @Autowired
    public MzlistRepository mzlistRepository;

    public MzlistResponseVO findMzlistByListId(Long listId) {
        Mzlist mzlist = mzlistRepository.findById(listId).get();
        MzlistResponseVO responseVO = MzlistResponseVO.builder()
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

        Mzlist mzlist = Mzlist.builder()
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
