package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepository {

    private final EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        em.persist(user);
    }

    public List<User> findByName(String name) {
        return em.createQuery("select m from User m where m.username = :name", User.class)
                .setParameter("name", name)
                .getResultList();
    }
}
