package com.example.springdemo.test.ctrl;
import java.util.HashMap;
import java.util.List ;
import java.util.Map;
import java.util.Optional ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.test.domain.BbsRequestDTO;
import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.domain.comment.CommentRequestDTO;
import com.example.springdemo.test.service.BbsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
// user : http://localhost:7777/api/bbs
@RequestMapping("api/bbs")
@Tag(name="BBS API", description = "게시글 관련 API 목록")
public class BbsController {
    
    @Autowired
    private BbsService bbsService ;

    @GetMapping("/test")
    public ResponseEntity<BbsResponseDTO> test() {
        // BbsResponseDTO response = BbsResponseDTO.builder()
        //                                     .id(1)
        //                                     .title("test")
        //                                     .content("teset")
        //                                     .build() ;
        // return new ResponseEntity<>(response, HttpStatus.OK) ;
        return null;
    }

    /*
        parameter로 전달되는 id에 대해 해당하는 데이터를 삭제한다면?
        service - mapper 연동을 통한 삭제 구현
        */

        @DeleteMapping("/delete/{id}")
        @Operation(summary = "게시글 삭제", description = "게시글을 삭제하는 코드")
        public ResponseEntity<String> delete(@PathVariable(name="id") Integer id) {
        System.out.println("debug >>> bbs controller client path /delete ");
        System.out.println("debug >>> id param value: " + id);
        Map<String, Integer> response = new HashMap<>() ;
        response.put("id", id) ;

        bbsService.delete(response) ;
        return new ResponseEntity<String>(id + "번째 데이터 삭제", HttpStatus.OK);
        }

        @GetMapping("/list")
        public ResponseEntity<List<BbsResponseDTO>> getList() {
            System.out.println("debug >>> bbs controller client path ");
            List<BbsResponseDTO> list = bbsService.list() ;
            return new ResponseEntity<>(list, HttpStatus.OK) ;
        }

        @GetMapping("/refer/{id}")
        public ResponseEntity<Object> getRefer(@PathVariable(name="id") Integer id) {
            System.out.println("debug >>> bbs controller client path /refer ");
            System.out.println("debug >>> id param value: " + id);
            Map<String, Integer> map = new HashMap<>() ;
            map.put("id", id) ;

        Optional<BbsResponseDTO> response = bbsService.refer(map);

        if ( response.isPresent() ) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }
            

        }

        /*
        Bbs 새 글을 작성
        user endpoint : http://localhost:7777/api/bbs/post?title=xxxx&content=xxxx 
        */
        /*
        @PostMapping("/post")
        public ResponseEntity<String> save( @RequestParam("title") String title, 
                                            @RequestParam("content") String content) {
            BbsRequestDTO params = BbsRequestDTO.builder()
                                        .title(title)
                                        .content(content)
                                        .build() ;
            System.out.println(">>> request dto is " + params);
            return null;
        }
        */
        

        @PostMapping("/post")
        public ResponseEntity<Void> save(BbsRequestDTO params) {
            System.out.println(">>> request dto is " + params);

            bbsService.save(params) ;
            
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ;
        }

        ////////////comment
        /*
        Bbs 새 글을 작성
        user endpoint : http://localhost:7777/api/bbs/comment/post?content=xxxx&bbsid=xxxx
        */

        @PostMapping("/comment/save")
        public ResponseEntity<String> comment(CommentRequestDTO params) {
        System.out.println("debug >> bbs controller client path /comment/post");
        System.out.println(">>> request dto is " + params);
        bbsService.commentSave(params) ;

        return new ResponseEntity<String>(params.getBbsid() + "에 타임라인 등록완료!!", HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity<Void> update(BbsRequestDTO params) {
            System.out.println("debug >>> update" + params);
            bbsService.update(params);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
      

}
