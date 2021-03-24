package com.sparta.basicassignment.service;

import com.sparta.basicassignment.domain.Board;
import com.sparta.basicassignment.dto.BoardDetailRequestDto;
import com.sparta.basicassignment.repository.BoardDetailRepository;
import com.sparta.basicassignment.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //기본적으로 readOnly가 먹힌다. 하지만 join메서드와 같이 다시 @Transactional를 써주게 되면 readOnly가 풀린다. 조회나 검색은 readOnly로 하면 최적화가 되지만join과 같은 데이터 변경이 일어나는 메서드에 readOnly를 사용하면 데이터가 변경이 일어나지 않는다.
public class BoardDetailService {
    private final BoardDetailRepository boardDetailRepository;

    public BoardDetailService(BoardDetailRepository boardDetailRepository) {
        this.boardDetailRepository = boardDetailRepository;
    }

    public Board findAllDetailBoard(Long id) {
        return boardDetailRepository.findDetailBoard(id);
    }
    @Transactional
    public void update(Long id, BoardDetailRequestDto requestDto) {
        Board findDetailBoard = boardDetailRepository.findDetailBoard(id);
        findDetailBoard.update(requestDto);
    }
}
