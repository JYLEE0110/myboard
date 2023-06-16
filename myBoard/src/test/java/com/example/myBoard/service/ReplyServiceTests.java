package com.example.myBoard.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;
import com.example.myBoard.dto.ReplyDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ReplyServiceTests {
    
    // 의존성 주입 
    @Autowired
    private ReplyService replyService;

    // 댓글 inserTestService
    @Test
    @Commit
    @Transactional
    public void insertTestService() {
        ReplyDTO replyDTO = ReplyDTO.builder()
        .tno(2L)
        .reply("replyTestService")
        .replyer("replyTestServiceReplyer")
        .build();
        replyService.insertReply(replyDTO);
    }

    
    // 대댓글 inserTestService
    @Test
    @Commit
    @Transactional
    public void insertChildTestService() {
         ReplyDTO replyDTO = ReplyDTO.builder()
        .tno(2L)
        .reply("replyTestService")
        .replyer("replyTestServiceReplyer")
        .gno(6L)
        .build();
        replyService.insertReply(replyDTO);
    }


    // list service 
    @Test
    public void listTestService() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        Long tno = 2L;
        PageResponseDTO<ReplyDTO> list = replyService.replyList(pageRequestDTO, tno);
        log.info(list.getList());
    }


    // read service 
    @Test
    @Commit
    @Transactional
    public void readTestServce() {
        log.info(replyService.readReply(2L));
    }


    // update Test Service
    @Test
    @Commit
    @Transactional
    public void updateTestService() {
         ReplyDTO replyDTO = ReplyDTO.builder()
        .tno(2L)
        .reply("replyTestService")
        .replyer("replyTestServiceReplyer")
        .rno(1L)
        .build();
        replyService.insertReply(replyDTO);
    }
}
