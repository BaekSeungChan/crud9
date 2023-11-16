package com.example.crud9.controller;

import com.example.crud9.payload.MyDto;
import com.example.crud9.service.MyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/my")
@Tag(name = "Mydata API's")
public class MyController {
    private MyService myService;

    public MyController(MyService myService){
        this.myService = myService;
    }

    @PostMapping
    @Operation(
            summary = "Create My",
            description = "Create My API"
    )
    public ResponseEntity<MyDto> createMy(@Valid @RequestBody MyDto myDto){
        return new ResponseEntity<>(myService.createMy(myDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "get my",
            description = "get my API"
    )
    public ResponseEntity<List<MyDto>> getAllMy(){
        return ResponseEntity.ok(myService.getAllMy());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "get id my",
            description = "get id my API"
    )
    public ResponseEntity<MyDto> getOneById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(myService.getMyById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMyById(@PathVariable(name = "id") long id){
        myService.deleteMyById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyDto> updateTwo(@PathVariable(name = "id")long id, @Valid @RequestBody MyDto myDto){
        MyDto myResponse = myService.updateMy(myDto, id);
        return new ResponseEntity<>(myResponse, HttpStatus.OK);
    }
}
