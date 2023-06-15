package com.example.myBoard.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.myBoard.dto.BoardDTO;
import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;

@Transactional
public interface BoardService {
     
    // List serivce
    PageResponseDTO<BoardDTO> boardList(PageRequestDTO requestDTO);

    // total serivce
    int total(PageRequestDTO requestDTO);

    // read serivce
    BoardDTO read(Long tno);

    // insert serivce
    int boardInsert(BoardDTO boardDTO);

    // delete serivce
    int boardDelete(Long tno);

    // update service
    int boardUpdate(BoardDTO boardDTO);

}
