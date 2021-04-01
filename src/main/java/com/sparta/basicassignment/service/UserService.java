package com.sparta.basicassignment.service;

import com.sparta.basicassignment.domain.User;
import com.sparta.basicassignment.dto.SignupRequestDto;
import com.sparta.basicassignment.repository.UserRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkName(SignupRequestDto requestDto) {
        String pattern = "^[a-zA-Z0-9]{3,20}$";
        String username = requestDto.getUsername();

        if(username.isEmpty()) {
            throw new IllegalArgumentException("닉네임을 입력해 주세요.");
        }

        Matcher matcher = Pattern.compile(pattern).matcher(username);
        if (!matcher.find()) {
            throw  new IllegalStateException("숫자와 영문자 조합으로 3~20자리를 사용해야 합니다.");
        }
    }


    public void checkPassword(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = signupRequestDto.getPassword();
        String passwordConfirm = signupRequestDto.getPasswordconfirm();

        String pattern = "^.*(?=^.{4,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";


        if (password.isEmpty()) {
            throw new IllegalArgumentException("패스워드를 입력해 주세요.");
        }

        if (password.contains(username)) {
            throw new IllegalArgumentException("비밀번호에 닉네임을 포함할 수 없습니다.");
        }

        Matcher matcher = Pattern.compile(pattern).matcher(password);
        if (!matcher.find()) {
            throw  new IllegalStateException("숫자와 영문자,특수문자 조합으로 4~15자리를 사용해야 합니다.");
        }

        if (!password.equals(passwordConfirm)) {
            throw  new IllegalStateException("패스워드가 일치하지 않습니다..");
        }
    }

    public void validateDuplicateMember(SignupRequestDto requestDto) {
        List<User> findeMembers = userRepository.findByName(requestDto.getUsername());
        if (!findeMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        System.out.println(findeMembers.size());
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
