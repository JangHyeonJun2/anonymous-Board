package com.sparta.basicassignment.controller;

import com.sparta.basicassignment.dto.CommentRequestDto;
import com.sparta.basicassignment.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/api/comment/{id}")
    public void createComment(@PathVariable Long id, @RequestBody CommentRequestDto commentReuqestDto) {
        commentService.save(id,commentReuqestDto);
    }
}
