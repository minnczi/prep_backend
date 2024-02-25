package com.lgcns.tct_backend.controller;

import com.lgcns.tct_backend.dto.MzlistCreateRequestVO;
import com.lgcns.tct_backend.dto.MzlistResponseVO;
import com.lgcns.tct_backend.dto.MzlistUpdateRequestVO;
import com.lgcns.tct_backend.dto.SessionUserVO;
import com.lgcns.tct_backend.model.Mzlist;
import com.lgcns.tct_backend.service.MzlistService;
import com.lgcns.tct_backend.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mzlist")
public class MzlistController {

    private final MzlistService mzlistService;

    @GetMapping(path = "/v1/{listId}")
    public ResponseEntity<MzlistResponseVO> findMzlistByListId(@PathVariable String listId) {
        return new ResponseEntity<>(
                mzlistService.findMzlistByListId(Long.parseLong(listId)), HttpStatus.OK
        );
    }

    @GetMapping(path = "/v1")
    public ResponseEntity<List<MzlistResponseVO>> findMzlistByUserId(HttpSession session) {
        // TODO: session 관련된 공통 묘듈 만들기
        String userId = (String) session.getAttribute("userId");

        // TODO: error handling을 위한 별도 util class 또는 interceptor 만들기
        if (userId == null || userId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
            mzlistService.findMzlistByUserId(Long.parseLong(userId)), HttpStatus.OK
        );
    }

    @PostMapping(path = "/v1")
    public ResponseEntity<Long> createMzlist(@RequestBody MzlistCreateRequestVO mzlistCreateRequestVO) {
        return new ResponseEntity<>(
            mzlistService.createMzlist(mzlistCreateRequestVO), HttpStatus.OK
        );
    }

    @PutMapping(path = "/v1/{listId}")
    public ResponseEntity<Long> updateMzlist(@PathVariable String listId, @RequestBody MzlistUpdateRequestVO mzlistUpdateRequestVO) {
        return new ResponseEntity<>(
            mzlistService.updateMzlist(Long.parseLong(listId), mzlistUpdateRequestVO), HttpStatus.OK
        );
    }

    @DeleteMapping("/v1/{listId}")
    public ResponseEntity<Long> deleteMzlist(@PathVariable String listId) {
        return new ResponseEntity<>(
            mzlistService.deleteMzlist(Long.parseLong(listId)), HttpStatus.OK
        );
    }


}
