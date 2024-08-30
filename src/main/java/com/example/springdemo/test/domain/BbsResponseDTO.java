package com.example.springdemo.test.domain;

import java.util.ArrayList ;

import com.example.springdemo.test.domain.comment.CommentResponseDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BbsResponseDTO {
    private int id;
    private String title ;
    private String content;

    private ArrayList<CommentResponseDTO> comments ;
}
