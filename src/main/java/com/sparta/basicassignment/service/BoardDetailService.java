package com.sparta.basicassignment.service;

import com.sparta.basicassignment.domain.Board;
import com.sparta.basicassignment.repository.BoardDetailRepository;
import com.sparta.basicassignment.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardDetailService {
    private final BoardDetailRepository boardDetailRepository;

    public BoardDetailService(BoardDetailRepository boardDetailRepository) {
        this.boardDetailRepository = boardDetailRepository;
    }

    public Board findAllDetailBoard(Long id) {
        return boardDetailRepository.findDetailBoard(id);
    }
}
