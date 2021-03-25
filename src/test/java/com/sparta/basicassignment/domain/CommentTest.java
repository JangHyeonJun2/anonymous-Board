package com.sparta.basicassignment.domain;

import com.sparta.basicassignment.dto.BoardRequestDto;
import com.sparta.basicassignment.repository.BoardRepository;
import com.sparta.basicassignment.repository.CommentRepository;
import com.sparta.basicassignment.service.BoardService;
import com.sparta.basicassignment.service.CommentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class CommentTest {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    @Test
//    @Transactional
    public void showRelation() {
//        BoardRequestDto boardDto = new BoardRequestDto();
//        boardDto.setTitle("board1");
//        boardDto.setContents("boardContents1");
//        boardService.createBoard(boardDto);
//
//        Comment comment = new Comment();
//        comment.setTitle("comment1");
//        comment.setContents("commentContents1");
//        Board byId = boardService.findById(1L);
//        comment.setBoard(byId);
//        commentRepository.save(comment);
//        System.out.println("=============");
//        System.out.println(comment.getBoard().getTitle());
//        System.out.println(byId.getComments().get(0).getTitle());
        System.out.println("=============");


        BoardRequestDto boardDto = new BoardRequestDto();
        boardDto.setTitle("board1");
        boardDto.setContents("boardContents1");
        boardService.createBoard(boardDto);


        Comment comment = new Comment();
        comment.setTitle("comment1");
        comment.setContents("commentContents1");
        Board byId = boardService.findById(1L);
        comment.setBoard(byId);
        commentRepository.save(comment);

        System.out.println(comment.getBoard().getTitle());

        Assertions.assertThat(comment.getBoard().getTitle()).isEqualTo("board1");
    }
}