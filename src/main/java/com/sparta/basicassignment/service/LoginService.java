package com.sparta.basicassignment.service;

import com.sparta.basicassignment.dto.LoginDuplicateCheckRequestDto;
import com.sparta.basicassignment.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public int usernameDuplCheck(LoginDuplicateCheckRequestDto requestDto) {
        return loginRepository.findByusernameCount(requestDto.getUsername());
    }
}
