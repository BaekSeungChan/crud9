package com.example.crud9.service;

import com.example.crud9.payload.YouDto;

import java.util.List;

public interface YouService {

    YouDto createYou(YouDto youDto);

    List<YouDto> getAllYou();

    YouDto getYouById(long id);

}
