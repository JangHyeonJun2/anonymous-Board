package com.sparta.basicassignment.controller;

import com.sparta.basicassignment.domain.Board;
import com.sparta.basicassignment.dto.BoardDetailRequestDto;
import com.sparta.basicassignment.service.BoardDetailService;
import com.sparta.basicassignment.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardDetailController {

    private final BoardDetailService boardDetailService;

    public BoardDetailController(BoardDetailService boardDetailService) {
        this.boardDetailService = boardDetailService;
    }

    @GetMapping("/api/detail/board/{id}")
    public Board getDetailBoard(@PathVariable Long id) {
        return boardDetailService.findAllDetailBoard(id);
    }

    @PutMapping("/api/detail/board/{id}")
    public void putDetailBoard(@PathVariable Long id, @RequestBody BoardDetailRequestDto requestDto) {
        boardDetailService.update(id,requestDto);
    }

}
