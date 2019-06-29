package com.cssl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan("com.cssl.Listener")
@MapperScan("com.cssl.com.cssl.dao")
@SpringBootApplication
public class app {

    public static void main(String[] args){
          SpringApplication.run(app.class,args);
    }
}
