package com.sparta.basicassignment.service;

import com.sparta.basicassignment.domain.Board;
import com.sparta.basicassignment.dto.BoardRequestDto;
import com.sparta.basicassignment.repository.BoardRepository;
import com.sparta.basicassignment.utils.CreateUUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) //기본적으로 readOnly가 먹힌다. 하지만 join메서드와 같이 다시 @Transactional를 써주게 되면 readOnly가 풀린다. 조회나 검색은 readOnly로 하면 최적화가 되지만
                                //join과 같은 데이터 변경이 일어나는 메서드에 readOnly를 사용하면 데이터가 변경이 일어나지 않는다.
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public void createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        CreateUUID createUUID = new CreateUUID();
        board.setUuid(createUUID.makeUUID());
        boardRepository.svae(board);
    }
}
