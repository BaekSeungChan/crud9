package com.example.crud9.controller;

import com.example.crud9.payload.YouDto;
import com.example.crud9.service.YouService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<YouDto>> getAllYou(){
        return new ResponseEntity<>(youService.getAllYou(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<YouDto> getYouById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(youService.getYouById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTouById(@PathVariable(name = "id") long id){
        youService.deleteTouById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<YouDto> updateTwo(@PathVariable(name = "id")long id, @Valid @RequestBody YouDto youDto){
        YouDto youResponse = youService.updateYou(youDto, id);
        return new ResponseEntity<>(youResponse, HttpStatus.OK);
    }

}
