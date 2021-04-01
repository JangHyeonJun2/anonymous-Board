package com.sparta.basicassignment.domain;

import com.sparta.basicassignment.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Setter
@Getter
@Entity
@NoArgsConstructor
public class User extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "USER_ID")
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordConfirm;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column(nullable = true)
    private Long kakaoId;

    public User(String username, String password, String passwordconfirm, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordconfirm;
        this.email = email;
        this.role = role;
        this.kakaoId = null;
    }

    public User(String username, String password, String email, UserRole role, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.kakaoId = kakaoId;
    }

}
