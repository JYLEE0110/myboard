package com.example.myBoard.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.ReplyDTO;

public interface ReplyMapper {
    
    // reply insert 
    int insertReply(ReplyDTO replyDTO);

    // reply inserChild
    int insertReplyChild(ReplyDTO replyDTO);

    // 댓글 대댓글 구분하기 위한 gno update
    int updateGno(Long gno);

    // reply read 
    ReplyDTO readReply(Long rno);

    // reply list 
    List<ReplyDTO> replyList(@Param("page") PageRequestDTO requestDTO, @Param("tno") Long tno );

    // total 
    int total(Long tno);

    // reply delete 
    int replyDelete(Long rno);

    // reply update 
    int updateReply(ReplyDTO replyDTO);

    
}
