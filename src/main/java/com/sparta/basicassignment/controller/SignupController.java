package com.sparta.basicassignment.controller;

import com.sparta.basicassignment.domain.User;
import com.sparta.basicassignment.domain.UserRole;
import com.sparta.basicassignment.dto.SignupRequestDto;
import com.sparta.basicassignment.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignupController {
    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/user/adduser")
    public String createUserAndValidation(SignupRequestDto signupRequestDto) {
        userService.checkName(signupRequestDto);
        userService.checkPassword(signupRequestDto);
        userService.validateDuplicateMember(signupRequestDto);


        //모든 Validation이 통과되면 저장
        User user = new User(signupRequestDto.getUsername(),signupRequestDto.getPassword(), signupRequestDto.getPasswordconfirm(),signupRequestDto.getEmail(), UserRole.GUEST);
        userService.save(user);
        return "redirect:/";
    }
}
