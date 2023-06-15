package com.example.myBoard.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.myBoard.dto.BoardDTO;
import com.example.myBoard.dto.PageRequestDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardMapperTests {

    //  의존주입 
    @Autowired
    private BoardMapper boardMapper;

    // Board List Test 
    @Test
    public void listTest() {
        PageRequestDTO requestDTO = PageRequestDTO.builder().build();
        log.info("isOkTestList");
        log.info(boardMapper.boardList(requestDTO));

    }

    // Board Read Test 
    @Test
    public void readTest() {
        BoardDTO boardDTO = boardMapper.read(9L);
        
    }

    // Board Insert Test
    @Test
    public void insertTest(){
        BoardDTO boardDTO = BoardDTO.builder()
        .title("TestInsert")
        .content("안녕하세요")
        .writer("user98")
        .build();

        int count = boardMapper.boardInsert(boardDTO);
        Assertions.assertEquals(count, 1);

    log.info("====================");
    log.info(boardDTO.getTno());
    log.info("====================");
        
    }

    // Board Delete Test
    @Commit
    @Test
    @Transactional
    public void deleteTest(){
        log.info(boardMapper.boardDelete(2L));
    }

    // Board Update Test
    @Commit
    @Transactional
    @Test
    public void updateTest(){
        BoardDTO boardDTO = BoardDTO.builder()
        .tno(1L)
        .title("updateTest")
        .content("contentTest")
        .writer("updateWriter")
        .build();

        boardMapper.boardUpdate(boardDTO);

        log.info("성공");
    }

    /// Total Test 
    @Transactional
    @Test
    public void dbTest(){
        PageRequestDTO requestDTO = PageRequestDTO.builder().build();
        log.info(boardMapper.total(requestDTO));
    }

}
