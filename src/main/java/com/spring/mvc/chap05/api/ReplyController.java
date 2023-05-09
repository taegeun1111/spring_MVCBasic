package com.spring.mvc.chap05.api;

import com.spring.mvc.chap05.dto.Page.Page;
import com.spring.mvc.chap05.dto.ReplyListResponseDTO;
import com.spring.mvc.chap05.dto.ReplyModifyRequestDTO;
import com.spring.mvc.chap05.dto.ReplyPostRequestDTO;
import com.spring.mvc.chap05.entity.Reply;
import com.spring.mvc.chap05.repository.ReplyMapper;
import com.spring.mvc.chap05.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/replies")
@Slf4j
//클라이언트의 접근을 어떤 app에서만 혀용할 것인가
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class ReplyController {

    private final ReplyService replyService;

    // 댓글 목록 조회 요청
    // URL : /api/v1/replies/3/page/1
    //          3번 게시물 댓글목록 1페이지 내놔
    @GetMapping("/{boardNo}/page/{pageNo}")
    public ResponseEntity<?> list(
            @PathVariable long boardNo,
            @PathVariable int pageNo
    ) {
        log.info("/api/v1/replies/{}/page/{} : GET!!", boardNo, pageNo);

        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(10);

        ReplyListResponseDTO replyList
                = replyService.getList(boardNo, page);

        return ok().body(replyList);
    }

    //댓글 등록 요청
    //@RequestBody 요청 메세지 body에 JOSN 전송
    //@Validated : dto에 있는 @Notblank 검증
    @PostMapping
    public ResponseEntity<?> create(
            @Validated @RequestBody ReplyPostRequestDTO dto
            , BindingResult result
    ) {
        //입력값 검증에 걸리면 4xx 상태코드 리턴
        if (result.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(result.toString());
        }
        log.info("/api/v1/replies : POST!");
        log.info("param : {}", dto);

        //서비스에 비즈니스 로직 처리 위임
        try {
            ReplyListResponseDTO responseDTO = replyService.register(dto);
            //성공 시 클라이언트에 응답하기
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            log.warn("500 Status code response!! caused by : {}", e.getMessage());
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }

    }

    //댓글 삭제 요청
    @DeleteMapping("/{replyNo}")
    public ResponseEntity<?> remove(
            @PathVariable Long replyNo
    ) {
        if (replyNo == null) {
            return ResponseEntity
                    .badRequest()
                    .body("댓글 번호 미입력");
        }

        log.info("/api/v1/replies/{} DELETE!", replyNo);

        try {
            ReplyListResponseDTO responseDTO = replyService.delete(replyNo);
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }
    }

    //댓글 수정 요청
    @PutMapping("/{replyNo}/")
//    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<?> modify(
            @Validated @RequestBody ReplyModifyRequestDTO dto
            , BindingResult result
    ) {
        if (result.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(result.toString());
        }

        log.info("/api/v1/replies PUT!");
        try {
            ReplyListResponseDTO responseDTO = replyService.modify(dto);
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


}
