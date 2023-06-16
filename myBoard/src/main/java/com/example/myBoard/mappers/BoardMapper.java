package com.example.myBoard.mappers;

import java.util.List;

import com.example.myBoard.dto.BoardDTO;
import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;

public interface BoardMapper {
    
    // List mapper
    List<BoardDTO> boardList(PageRequestDTO requestDTO);

    // total mapper
    int total(PageRequestDTO requestDTO);

    // read mapper
    BoardDTO read(Long tno);

    // insert mapper
    int boardInsert(BoardDTO boardDTO);

    // delete mapper
    int boardDelete(Long tno);

    // update mapper
    int boardUpdate(BoardDTO boardDTO);
    
}
