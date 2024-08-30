package com.example.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdemo.test.service.BbsService;

@SpringBootTest
public class ServiceApplicationTests {
    
    @Autowired
    private BbsService bbsService ;

    @Test
    public void saveService() {
        System.out.println("debug >>> junit service save " + bbsService);
        // BbsRequestDTO request = BbsRequestDTO.builder()
        //                             .title("제목")
        //                             .content("문서123456")
        //                             .build() ;
        // bbsService.save(request) ;
        System.out.println("debug >>> save Ok");
    }

    /*
    테이블에 있는 기본키값으로 title, content 수정하고 싶다
    1.BbsRequestDTO 타입으로 더미데이터 생성
    2.bbsService.update(BbsRequestDTO) 메서드의 인자로 전달
    3.update() 메서드에서 mapper에 updateRow() 정의하고 전달받은 BbsRequestDTO 전달
    4.BbsMapper.xml 에 update 태그를 추가

    bbsService.update() ;
     */
    @Test
    public void updateService() {
        System.out.println("debug >>> junit service save " + bbsService);
        // BbsRequestDTO request = BbsRequestDTO.builder()
        //                             .id(3)
        //                             .title("수정된 수정된 제목")
        //                             .content("서문")
        //                             .build() ;
        // bbsService.update(request) ;
        System.out.println("debug >>> update Ok");
    }

    @Test
    public void deleteService() {
        System.out.println("Debug >> junit service delete " + bbsService);
        
    }
}
