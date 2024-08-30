package com.example.springdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional ;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.mapper.BbsMapper;

@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
    private BbsMapper bbsMapper ;

    @Test
    public void saveTest() {
        System.out.println("debug mapper SaveTest >>> " + bbsMapper);
        // BbsRequestDTO request = BbsRequestDTO.builder()
        //                             .title("제목")
        //                             .content("문서12345")
        //                             .build() ;

        // bbsMapper.saveRow(request);
        System.out.println("debug >>> save Success");
    }

    @Test
    public void selectTest() {
        System.out.println("debug mapper SelectTest >>>>" + bbsMapper);
        List<BbsResponseDTO> list = bbsMapper.selectRow() ;
        for (BbsResponseDTO dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void selectOne() {
        System.out.println("debug mapper SelectOne >>>" + bbsMapper);
        Map<String, Integer> map = new HashMap<>() ;
        map.put("id", 2);
        Optional<BbsResponseDTO>  response = bbsMapper.getRow(map);
        System.out.println("debug >> select  One"  + response.get());
    }

    @Test
    public void deleteTest() {
        System.out.println("debug mapper DeleteTest >>> " + bbsMapper);
        Map<String, Integer> map = new HashMap<>() ;
        map.put("id", 11);
        bbsMapper.deleteRow(map);
        System.out.println("debug >>> delete Completed");
    }

    

    
}
