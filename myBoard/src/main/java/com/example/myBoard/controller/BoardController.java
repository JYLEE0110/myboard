package com.example.myBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myBoard.dto.BoardDTO;
import com.example.myBoard.dto.PageRequestDTO;
import com.example.myBoard.dto.PageResponseDTO;
import com.example.myBoard.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {
    
    
    private final BoardService boardService;


    // 전체 리스트
    @GetMapping("list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        log.info("GET | /board/list");
        log.info(pageRequestDTO);
        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.boardList(pageRequestDTO); 
        log.info(pageResponseDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

    }


    // 상세페이지
    @GetMapping("read/{tno}")
    public String getReadPage(@PathVariable("tno") Long tno, Model model){
        log.info("GET | /board/read");
        BoardDTO boardDTO = boardService.read(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "board/read";
    }


    // 등록페이지
    @GetMapping("regist")
    public void getRegistPage(){
        log.info("GET | /board/regist");
    }


    // 등록페이지
    @PostMapping("regist")
    public String postRegistPage(BoardDTO boardDTO) {
        log.info("POST | /board/regist");
        boardService.boardInsert(boardDTO);
        return "redirect:/board/list";
    }

    
    // 업데이트 페이지 
    @GetMapping("modify/{tno}")
    public String getModifyPage(@PathVariable("tno") Long tno, Model model){
        BoardDTO boardDTO = boardService.read(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/modify";
    }

    @PostMapping("modify")
    public String postModifyPage(BoardDTO boardDTO){
        log.info("POST /board/modfiy");
        boardService.boardUpdate(boardDTO);
        log.info(boardDTO.getTno());
        return "redirect:/board/read/" + boardDTO.getTno();

    }

    // Post 삭제 
    @PostMapping("delete/{tno}")
    public String postDeletePage(@PathVariable("tno") Long tno) {
        log.info("POST | /board/delete");
        boardService.boardDelete(tno);
        return "redirect:/board/list";
    }


}
