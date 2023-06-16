package com.example.myBoard.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;
import com.example.myBoard.dto.ReplyDTO;

@Transactional
public interface ReplyService {

    // reply insert service 
    Long insertReply(ReplyDTO replyDTO);

    // reply read service 
    ReplyDTO readReply(Long rno);

    // reply list service 
    PageResponseDTO<ReplyDTO> replyList(@Param("page") PageRequestDTO requestDTO, @Param("tno") Long tno );

    // reply delete service 
    int replyDelete(Long rno);

    // reply update serivce 
    int updateReply(ReplyDTO replyDTO);
}
