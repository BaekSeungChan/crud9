package com.example.crud9.service;

import com.example.crud9.payload.MyDto;

import java.util.List;

public interface MyService {
    MyDto createMy(MyDto myDto);

    List<MyDto> getAllMy();

    MyDto getMyById(long id);

    void deleteMyById(long id);

    MyDto updateMy(MyDto myDto, long id);
}
