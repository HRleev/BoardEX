package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")

public class BoardController {
    @Autowired
    private BoardService boardService;

    //글쓰기 화면 요청
    @GetMapping("/save")
    public String saveForm() {
        return "boardPages/save";
    }

    //글쓰기 처리
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boolean result = boardService.save(boardDTO);
        if (result) {
            return "redirect:/board/findAll";
        } else {
            return "save-fail";
        }
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/list";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/detail";
    }

    @GetMapping("/passwordCheck")
    public String passwordCheck(@RequestParam("id") long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/passwordCheck";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        boardService.delete(id);
        return "redirect:/board/findAll";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id")long id,Model model){
        BoardDTO boardDTO=boardService.findById(id);
        model.addAttribute("boardUpdate",boardDTO);
        return "boardPages/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO){
        boardService.update(boardDTO);
        return "redirect:/board/detail?id="+boardDTO.getId();

    }
    @GetMapping("/saveFile")
    public String saveFileForm(){
        return "boardPages/saveFile";
    }
    @PostMapping("/saveFile")
    public String saveFile(@ModelAttribute BoardDTO boardDTO)throws IOException {
        boardService.saveFile(boardDTO);
        return "redirect:/board/findAll";
    }
    @GetMapping("/paging")
    public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page,
                         Model model) {
        List<BoardDTO> boardList = boardService.pagingList(page);
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "boardPages/pagingList";
    }
}
