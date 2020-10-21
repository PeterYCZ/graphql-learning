package com.graphql.learning.controller;

import com.graphql.learning.eneity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @ResponseBody
    @PutMapping("")
    public String insertBooks(@RequestBody Book book){
        redisTemplate.opsForSet().add("book",book);
        return "success";
    }

}
