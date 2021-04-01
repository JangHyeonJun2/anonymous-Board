package com.sparta.basicassignment.controller;

import com.sparta.basicassignment.dto.LoginDuplicateCheckRequestDto;
import com.sparta.basicassignment.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login/duplicateCheck")
    public String usernameDuplicateCheck(@RequestBody LoginDuplicateCheckRequestDto requestDto) {
        int result = loginService.usernameDuplCheck(requestDto);

        if (result != 0) {
            return "fail"; //중복 아이디 존재
        }else
            return "success"; //중복 아이디 없음
    }
}
