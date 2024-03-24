package com.lgcns.tct_backend.controller;

import com.lgcns.tct_backend.dto.MzlistCreateRequestDTO;
import com.lgcns.tct_backend.dto.MzlistResponseDTO;
import com.lgcns.tct_backend.dto.MzlistUpdateRequestDTO;
import com.lgcns.tct_backend.service.MzlistService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: class 단위에서 requestmapping을 쓰는것에 대한 문제점이 있을 수 있으니 검토 필요 (interceptor 관련?)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mzlist")
public class MzlistController {

  private final MzlistService mzlistService;

  // TODO: v1을 꼭 써야할지?
  // 1. 버전관리는 이미 git으로 되고 있음
  // 2. uri가 바뀜에 따라 영향도가 있음 (ex. 프론트엔드에서 호출할때)
  // 3. 우리 프로젝트의 목적에 버전 관리가 필요할지 검토 필요
  // 4. Swagger에 설명으로 기입하는것도 좋은것 같다
  @GetMapping(path = "/{listId}")
  public ResponseEntity<MzlistResponseDTO> findMzlistByListId(@PathVariable String listId) {
    return new ResponseEntity<>(
        mzlistService.findMzlistByListId(Long.parseLong(listId)), HttpStatus.OK);
  }

  @GetMapping(path = "")
  public ResponseEntity<List<MzlistResponseDTO>> findMzlistByUserId(HttpSession session) {
    // TODO: session 관련된 공통 묘듈 만들기
    String userId = (String) session.getAttribute("userId");

    // TODO: error handling을 위한 별도 util class 또는 interceptor 만들기
    if (userId == null || userId.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(
        mzlistService.findMzlistByUserId(Long.parseLong(userId)), HttpStatus.OK);
  }

  @PostMapping(path = "")
  public ResponseEntity<Long> createMzlist(
      @RequestBody MzlistCreateRequestDTO mzlistCreateRequestDTO) {
    return new ResponseEntity<>(mzlistService.createMzlist(mzlistCreateRequestDTO), HttpStatus.OK);
  }

  @PutMapping(path = "/{listId}")
  public ResponseEntity<Long> updateMzlist(
      @PathVariable String listId, @RequestBody MzlistUpdateRequestDTO mzlistUpdateRequestDTO) {
    return new ResponseEntity<>(
        mzlistService.updateMzlist(Long.parseLong(listId), mzlistUpdateRequestDTO), HttpStatus.OK);
  }

  @DeleteMapping("/{listId}")
  public ResponseEntity<Long> deleteMzlist(@PathVariable String listId) {
    return new ResponseEntity<>(mzlistService.deleteMzlist(Long.parseLong(listId)), HttpStatus.OK);
  }
}
