package com.example.springdemo.test.mapper;

import java.util.ArrayList ;
import java.util.List;
import java.util.Map;
import java.util.Optional ;

import org.apache.ibatis.annotations.Mapper;

import com.example.springdemo.test.domain.BbsRequestDTO;
import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.domain.comment.CommentRequestDTO;
import com.example.springdemo.test.domain.comment.CommentResponseDTO;

@Mapper
public interface BbsMapper {

    public void saveRow(BbsRequestDTO params);

    public List<BbsResponseDTO> selectRow() ;

    public Optional<BbsResponseDTO> getRow(Map<String, Integer> map) ;

    public void deleteRow(Map<String, Integer> map) ;

    public void updateRow(BbsRequestDTO params) ;

    public void commentSaveRow(CommentRequestDTO params) ;
    public ArrayList<CommentResponseDTO> commentSelectRow(Map<String, Integer> map) ;
}
