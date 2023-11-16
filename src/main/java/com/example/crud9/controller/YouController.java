package com.example.crud9.controller;

import com.example.crud9.payload.YouDto;
import com.example.crud9.service.YouService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/you")
public class YouController {
    private YouService youService;

    public YouController(YouService youService){
        this.youService = youService;
    }

    @PostMapping
    public ResponseEntity<YouDto> createYou(@Valid @RequestBody YouDto youDto){
        return new ResponseEntity<>(youService.createYou(youDto), HttpStatus.OK);
    }
}
