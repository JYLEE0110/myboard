package com.example.myBoard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myBoard.dto.BoardDTO;
import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;
import com.example.myBoard.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    
    private final BoardMapper boardMapper;

    // List Impl
    @Override
    public PageResponseDTO<BoardDTO> boardList(PageRequestDTO requestDTO) {
      
      List<BoardDTO> list = boardMapper.boardList(requestDTO);
      int total = boardMapper.total(requestDTO);

        return PageResponseDTO.<BoardDTO>withAll()
        .list(list)
        .total(total)
        .build();
    }


    @Override
    public int total(PageRequestDTO requestDTO) {
       return 0;
    }


    // Read Impl
    @Override
    public BoardDTO read(Long tno) {
        return boardMapper.read(tno);
    }

    // insert Impl
    @Override
    public int boardInsert(BoardDTO boardDTO) {
        return boardMapper.boardInsert(boardDTO);
    }

    // delete Impl
    @Override
    public int boardDelete(Long tno) {
        return boardMapper.boardDelete(tno);
    }

    // update Impl
    @Override
    public int boardUpdate(BoardDTO boardDTO) {
         return boardMapper.boardUpdate(boardDTO);
    }
    
}
