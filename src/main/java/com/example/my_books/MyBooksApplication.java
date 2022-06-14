package com.example.my_books;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@MapperScan("com.example.my_books.mapper")
@ServletComponentScan
@SpringBootApplication
public class MyBooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBooksApplication.class, args);
    }

}
