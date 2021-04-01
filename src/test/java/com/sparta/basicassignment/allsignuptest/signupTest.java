package com.sparta.basicassignment.allsignuptest;


import com.sparta.basicassignment.dto.SignupRequestDto;
import com.sparta.basicassignment.repository.UserRepository;
import com.sparta.basicassignment.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class signupTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @Test
    @DisplayName("회원가입 username,password validation 체크")
    void allSignupTest() {
        SignupRequestDto requestDto = new SignupRequestDto(
                "ep",
                "epfvkdlxj11!",
                "epfvkdlxj11!",
                "epfvkdlxj@naverc.om"
        );

//        Assertions.assertThat(userService.checkName(requestDto)).isEqualTo("숫자와 영문자 조합으로 3~20자리를 사용해야 합니다.");


    }
}
