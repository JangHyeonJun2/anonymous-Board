package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BoardRepository {
    private final EntityManager em;

    public BoardRepository(EntityManager em) {
        this.em = em;
    }

    public void svae(Board board) {
        em.persist(board);
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b",Board.class).getResultList();
    }

}
