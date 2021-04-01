package com.sparta.basicassignment.repository;

import com.sparta.basicassignment.domain.User;
import com.sparta.basicassignment.domain.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginRepositoryTest {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void checkDupl() {
        User user = new User("장이","123","123","efwjke@naver.com", UserRole.GUEST);
        userRepository.save(user);

        String name1 = "장이";
        String name2 = "장장이";

        long byusernameCount = loginRepository.findByusernameCount(name1);
        long byusernameCount1 = loginRepository.findByusernameCount(name2);

        System.out.println(byusernameCount + " " + byusernameCount1);


    }

}