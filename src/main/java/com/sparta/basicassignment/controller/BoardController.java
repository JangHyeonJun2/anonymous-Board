package com.sparta.basicassignment.controller;

import com.sparta.basicassignment.domain.Board;
import com.sparta.basicassignment.dto.BoardRequestDto;
import com.sparta.basicassignment.repository.BoardRepository;
import com.sparta.basicassignment.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/api/board")
    public void makeBoard(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.createBoard(boardRequestDto);
    }
}
