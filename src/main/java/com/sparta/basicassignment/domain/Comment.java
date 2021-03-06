package com.sparta.basicassignment.domain;

import com.sparta.basicassignment.dto.CommentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long id;

    private String title;

    @Lob
    private String contents;

    private String uuid;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    //편의 메서드
    public void changeBoard(Board board) {
        this.board = board;
//        board.getComments().add(this);
    }

    public Comment(CommentRequestDto commentRequestDto) {
        this.title = commentRequestDto.getTitle();
        this.contents = commentRequestDto.getContents();
    }
}
