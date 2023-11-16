package com.example.crud9.controller;

import com.example.crud9.payload.MyDto;
import com.example.crud9.service.MyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<MyDto>> getAllMy(){
        return ResponseEntity.ok(myService.getAllMy());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyDto> getOneById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(myService.getMyById(id));
    }

}
