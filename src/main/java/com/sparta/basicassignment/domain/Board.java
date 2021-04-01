package com.sparta.basicassignment.domain;

import com.sparta.basicassignment.dto.BoardDetailRequestDto;
import com.sparta.basicassignment.dto.BoardRequestDto;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
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

//    @JsonIgnore //이부분은 Comment랑 양방향으로 할려고 했는데 java.lang.IllegalStateException: Cannot call sendError() after the response has been committed 이 에러 땜에... 진짜
//    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER)//, fetch = FetchType.EAGER
//    @ToString.Exclude
//    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    public Board(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
    }

    public void update(BoardDetailRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
