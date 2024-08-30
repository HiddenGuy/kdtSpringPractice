package com.example.springdemo.test.domain.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CommentRequestDTO {
    
    private String content ;
    private Integer bbsid;
}
