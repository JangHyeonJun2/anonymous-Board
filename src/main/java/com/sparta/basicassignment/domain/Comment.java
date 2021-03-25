package com.sparta.basicassignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
        board.getComments().add(this);
    }
}
