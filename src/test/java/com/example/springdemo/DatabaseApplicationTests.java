package com.example.springdemo;


import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
public class DatabaseApplicationTests {
    
    @Autowired
    private SqlSessionFactory factory ;

    @Autowired
    private ApplicationContext context ;

    @Test
    public void testByFactory() {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>> factory");
            System.out.println( factory.toString());
            // System.out.println( context.getBean("kdt"));
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
