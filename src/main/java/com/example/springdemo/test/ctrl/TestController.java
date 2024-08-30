package com.example.springdemo.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springdemo.test.domain.BbsResponseDTO;



@Controller //객체 생성을 의미 
// spring controller는 TestController testController = new TestController() ; 
public class TestController {
    @RequestMapping("/index.kdt") //2번째 parameter는 get, post 결정
    public String index(Model model) {
        System.out.println("debug >> test controller index client path : /index.kdt");
        model.addAttribute("msg", "처음으로 만나는 스프링 부트");
        return "index" ;
    }

    @RequestMapping(value = "/api/bbs/ctrl/test", method = RequestMethod.GET) 
    @ResponseBody //Json화 시켜주는 annotation
    public BbsResponseDTO test() { //@RequestParam String param
        // BbsResponseDTO response = BbsResponseDTO.builder()
        //                                     .id(1)
        //                                     .title("test")
        //                                     .content("teset")
        //                                     .build() ;
        // return response ;
        return null;
    }
    
    
}
