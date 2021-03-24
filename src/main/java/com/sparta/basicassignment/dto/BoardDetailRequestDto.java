package com.sparta.basicassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDetailRequestDto {
    private String title;
    private String contents;
}
