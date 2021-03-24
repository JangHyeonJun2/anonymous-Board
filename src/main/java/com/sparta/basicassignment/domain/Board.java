package com.sparta.basicassignment.domain;

import com.sparta.basicassignment.dto.BoardDetailRequestDto;
import com.sparta.basicassignment.dto.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String contents;

    private String uuid;

    public Board(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
    }

    public void update(BoardDetailRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
