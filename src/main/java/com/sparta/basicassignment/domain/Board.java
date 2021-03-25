package com.sparta.basicassignment.domain;

import com.sparta.basicassignment.dto.BoardDetailRequestDto;
import com.sparta.basicassignment.dto.BoardRequestDto;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    @Lob
    private String contents;

    private String uuid;

    @OneToMany(mappedBy = "board")//, fetch = FetchType.EAGER
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();


    public Board(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
    }

    public void update(BoardDetailRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
