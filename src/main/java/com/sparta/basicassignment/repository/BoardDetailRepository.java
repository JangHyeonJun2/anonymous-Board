package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class BoardDetailRepository {
    private final EntityManager em;

    public BoardDetailRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public Board findDetailBoard(Long id) {
        return em.createQuery("select b from Board b where b.id = :id", Board.class).setParameter("id", id).getSingleResult();
    }

    public void deleteById(Long id) {
        Board board = em.createQuery("select b from Board b where b.id = :id", Board.class).setParameter("id", id).getSingleResult();
        em.remove(board);
    }
}
