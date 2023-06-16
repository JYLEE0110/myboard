package com.example.myBoard.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;
import com.example.myBoard.dto.ReplyDTO;
import com.example.myBoard.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/")
public class ReplyRestController {

    // 의존성 주입 
    private final ReplyService replyService;


    // ReplyList
    @GetMapping("{tno}/list")
    public PageResponseDTO<ReplyDTO> getlist(@PathVariable("tno") Long tno, PageRequestDTO requestDTO){
        return replyService.replyList(requestDTO, tno);
    }


    // ReplyAdd & RepllyChildAdd
    @PostMapping("{tno}/new")
    public Map<String, Long> insert(@PathVariable("tno") Long tno, @RequestBody ReplyDTO replyDTO){
        replyDTO.setTno(tno);

        Long rno = replyService.insertReply(replyDTO);

        return Map.of("result", rno);
    }


    // ReplyRead
    @GetMapping("{rno}")
    public ReplyDTO read(@PathVariable("rno") Long rno){
        ReplyDTO replyDTO = replyService.readReply(rno);
        return replyDTO;
    }


    // ReplyDelete
    @DeleteMapping("{rno}")
    public Map<String, Integer> delete(@PathVariable("rno") Long rno){
        int result = replyService.replyDelete(rno);
        return Map.of("result", result);
    }

    /// ReplyUpdate
    @PutMapping("modify")
    public Map<String, Integer> modify(@RequestBody ReplyDTO replyDTO){
        log.info("=======");
        log.info("=======");
        log.info(replyDTO);
        log.info("=======");
        log.info("=======");
        int result = replyService.updateReply(replyDTO);
        return Map.of("result", result);
    }
}