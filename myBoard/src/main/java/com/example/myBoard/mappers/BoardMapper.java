package com.example.myBoard.mappers;

import java.util.List;

import com.example.myBoard.dto.BoardDTO;
import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;

public interface BoardMapper {
    
    // List 
    List<BoardDTO> boardList(PageRequestDTO requestDTO);

    // total 
    int total(PageRequestDTO requestDTO);

    // read 
    BoardDTO read(Long tno);

    // insert
    int boardInsert(BoardDTO boardDTO);

    // delete 786407
    int boardDelete(Long tno);

    // update
    int boardUpdate(BoardDTO boardDTO);
    
}
