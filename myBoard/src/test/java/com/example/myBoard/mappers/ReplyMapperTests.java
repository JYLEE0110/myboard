package com.example.myBoard.mappers;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.ReplyDTO;

import lombok.extern.log4j.Log4j2;
import net.bytebuddy.implementation.bytecode.Remainder;

@SpringBootTest
@Log4j2
public class ReplyMapperTests {

    @Autowired
    private ReplyMapper replyMapper;
    

    @Test
    @Commit
    @Transactional
    public void insertTest(){

        ReplyDTO replyDTO = ReplyDTO.builder()
                                .tno(2L)
                                .reply("HI")
                                .replyer("권성준")
                                .build();

        int insertCount = replyMapper.insertReply(replyDTO);

        Assertions.assertEquals(insertCount,1);

        if(insertCount != 1){

            throw new RuntimeException("입력 실패");

        }

        Long rno = replyDTO.getRno();

        log.info(rno);

        replyMapper.updateGno(rno);

    }

    @Test
    @Commit
    @Transactional
    public void insertReplyChild(){

        ReplyDTO replyDTO = ReplyDTO.builder()
                               .tno(2L)
                                .reply("HI")
                                .replyer("권성준")
                                .gno(2L)
                                .build();

        int insertCount = replyMapper.insertReplyChild(replyDTO);

        log.info(replyDTO.getGno());

        Assertions.assertEquals(insertCount,1);


    }

    // 댓글 읽기

    @Test
    public void readReply(){

        ReplyDTO replyDTO = replyMapper.readReply(1L);
        log.info(replyDTO);

    }

    // 댓글 리스트
    @Test
    public void replyList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        
        Long tno = 2L;
        List<ReplyDTO> list = replyMapper.replyList(pageRequestDTO,tno);

        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i));
        }
    }

    // 댓글 삭제
    @Test
    @Commit
    @Transactional
    public void replyDelete(){

        replyMapper.replyDelete(5L);

    }

    // 댓글 업데이트
    @Test
    @Commit
    @Transactional
    public void updateReply(){

        ReplyDTO replyDTO = ReplyDTO.builder()
        .reply("안녕")
        .replyer("안녕")
        .rno(4L)
        .build();

        replyMapper.updateReply(replyDTO);
        log.info(replyMapper.updateReply(replyDTO));
    }




}
