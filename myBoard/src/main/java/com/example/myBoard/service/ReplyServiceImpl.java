package com.example.myBoard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;
import com.example.myBoard.dto.ReplyDTO;
import com.example.myBoard.mappers.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    // 의존성 주입 
    private final ReplyMapper replyMapper;


    // reply insert Impl & reply insert child Impl  
    @Override
    public Long insertReply(ReplyDTO replyDTO) {

        Long result = null;
        Long gno = replyDTO.getGno();
        
        if(gno == 0L) {
            int count = replyMapper.insertReply(replyDTO);

            if(count != 1) {
                throw new RuntimeException("Error");
            }
            Long rno = replyDTO.getRno();
            replyMapper.updateGno(rno);
            result = rno;
        }
        else { 
            int count = replyMapper.insertReplyChild(replyDTO);
            if(count != 1) {
                throw new RuntimeException("insert error child");
            }
            result = replyDTO.getRno();
        }
        return result;
    }


    // reply read Impl 
    @Override
    public ReplyDTO readReply(Long rno) {
        return replyMapper.readReply(rno);
    }


    // reply delete Impl 
    @Override
    public int replyDelete(Long rno) {
       return replyMapper.replyDelete(rno);
    }

    
    // reply update Impl 
    @Override
    public int updateReply(ReplyDTO replyDTO) {
        return replyMapper.updateReply(replyDTO);
    }


    // reply list Impl
    @Override
    public PageResponseDTO<ReplyDTO> replyList(PageRequestDTO requestDTO, Long tno) {
      requestDTO.setSize(100);

      log.info(requestDTO);
      List<ReplyDTO> list = replyMapper.replyList(requestDTO, tno);
      log.info(tno);
      log.info(list);
      int total = replyMapper.total(tno);
      log.info(total);

      return PageResponseDTO.<ReplyDTO>withAll()
      .list(list)
      .total(total)
      .build();

    }
    
}
