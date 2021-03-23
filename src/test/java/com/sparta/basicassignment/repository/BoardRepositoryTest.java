package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.Board;
import com.sparta.basicassignment.dto.BoardRequestDto;
import com.sparta.basicassignment.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardService boardService;

    @Test
    public void findListBoards() {
        BoardRequestDto boardRequestDto1 = new BoardRequestDto();
        BoardRequestDto boardRequestDto2 = new BoardRequestDto();
        BoardRequestDto boardRequestDto3 = new BoardRequestDto();
        boardRequestDto1.setTitle("Member1");
        boardRequestDto1.setContents("ddddddd");
        boardRequestDto2.setTitle("Member2");
        boardRequestDto2.setContents("ddddddd");
        boardRequestDto3.setTitle("Member3");
        boardRequestDto3.setContents("ddddddd");



        boardService.createBoard(boardRequestDto1);
        boardService.createBoard(boardRequestDto2);
        boardService.createBoard(boardRequestDto3);

        List<Board> allBoards = boardService.findAllBoards();
        for (int i=0; i<allBoards.size(); i++) {
            System.out.println(allBoards.get(i).getModifiedAt());

        }
    }

}