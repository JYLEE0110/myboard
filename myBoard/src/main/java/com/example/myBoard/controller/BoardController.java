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
    
    // 의존성 주입 
    private final BoardService boardService;


    // BoardList
    @GetMapping("list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        log.info("GET | /board/list");
        log.info(pageRequestDTO);
        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.boardList(pageRequestDTO); 
        log.info(pageResponseDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

    }


    // BoardRead
    @GetMapping("read/{tno}")
    public String getReadPage(@PathVariable("tno") Long tno, Model model){
        log.info("GET | /board/read");
        BoardDTO boardDTO = boardService.read(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "board/read";
    }


    // Get : BoardRegist
    @GetMapping("regist")
    public void getRegistPage(){
        log.info("GET | /board/regist");
    }


    // Post : BoardRegist 
    @PostMapping("regist")
    public String postRegistPage(BoardDTO boardDTO) {
        log.info("POST | /board/regist");
        boardService.boardInsert(boardDTO);
        return "redirect:/board/list";
    }

    
    // Post : BoardUpdate
    @GetMapping("modify/{tno}")
    public String getModifyPage(@PathVariable("tno") Long tno, Model model){
        BoardDTO boardDTO = boardService.read(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/modify";
    }


    // Post : BoardUpdate 
    @PostMapping("modify")
    public String postModifyPage(BoardDTO boardDTO){
        log.info("POST /board/modfiy");
        boardService.boardUpdate(boardDTO);
        log.info(boardDTO.getTno());
        return "redirect:/board/read/" + boardDTO.getTno();

    }


    // Post : BoardDelete
    @PostMapping("delete/{tno}")
    public String postDeletePage(@PathVariable("tno") Long tno) {
        log.info("POST | /board/delete");
        boardService.boardDelete(tno);
        return "redirect:/board/list";
    }
}
