package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

/*
    LocalDate date = LocalDate.of(2015, 8, 11);
    TypedQuery query = this.em.createQuery("SELECT e FROM MyEntity e WHERE date BETWEEN :start AND :end", MyEntity.class);
    query.setParameter("start", date.minusDays(2));
    query.setParameter("end", date.plusDays(7));
    MyEntity e = query.getSingleResult();
 */


@Repository
public class BoardRepository  {
    private final EntityManager em;

    public BoardRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Board board) {
        em.persist(board);
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b",Board.class).getResultList();
    }

    public List<Board> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime startTime, LocalDateTime endTime){
        List<Board> resultList = em.createQuery("SELECT b FROM Board b where b.modifiedAt  BETWEEN :startTime AND :endTime ORDER BY b.modifiedAt DESC", Board.class)
                .setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();

        return resultList;
    }
    public Board findById(Long id) {
        return em.createQuery("select b from Board b where b.id = :id", Board.class).setParameter("id", id).getSingleResult();
    }

}
