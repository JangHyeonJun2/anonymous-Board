package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CommentRepository {
    private final EntityManager em;

    public CommentRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Comment comment) {
        em.persist(comment);
    }

}
