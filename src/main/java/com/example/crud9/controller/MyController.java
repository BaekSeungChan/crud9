package com.example.crud9.controller;

import com.example.crud9.payload.MyDto;
import com.example.crud9.service.MyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/my")
public class MyController {
    private MyService myService;

    public MyController(MyService myService){
        this.myService = myService;
    }

    @PostMapping
    public ResponseEntity<MyDto> createMy(@Valid @RequestBody MyDto myDto){
        return new ResponseEntity<>(myService.createMy(myDto), HttpStatus.OK);
    }
}
