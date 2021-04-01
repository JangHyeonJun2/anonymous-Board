package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.User;
import com.sparta.basicassignment.dto.LoginDuplicateCheckRequestDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LoginRepository {
    private final EntityManager em;

    public LoginRepository(EntityManager em) {
        this.em = em;
    }

    public int findByusernameCount(String username) {
        List<User> username1 = em.createQuery("select u from User u where u.username = :username", User.class).setParameter("username", username).getResultList();
        return username1.size();
    }
}
