package com.example.myBoard.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.myBoard.dto.BoardDTO;
import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardServiceTests {
    
    @Autowired
    private BoardService boardService;


    // Service testList
    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        PageResponseDTO<BoardDTO> list = boardService.boardList(pageRequestDTO);
        log.info(list.getList());
        
    }

    // Service testInsert 
    @Test
    @Commit
    @Transactional
    public void testInsert() {
        BoardDTO boardDTO = BoardDTO.builder()
        .title("TestContent")
        .content("TestContentService")
        .writer("TestServiceUser")
        .build();

        boardService.boardInsert(boardDTO);
    }


    // Service testRead
    @Test
    public void testRead() {
        log.info( boardService.read(1L));
    }


    // Service testDelete
    @Test
    @Commit
    @Transactional
    public void testDelete() {
        boardService.boardDelete(786408L);
    }

    
    // Service testUpdate
    @Test
    @Commit
    @Transactional
    public void testUpdate() {
        BoardDTO boardDTO = BoardDTO.builder()
        .tno(786409L)
        .title("UpdateTestServiceTitle")
        .content("UpdateTestService")
        .writer("updateTestServiceWriter")
        .build();

        boardService.boardUpdate(boardDTO);
    }
}
