package com.example.crud9.service.Impl;

import com.example.crud9.entity.MyData;
import com.example.crud9.payload.MyDto;
import com.example.crud9.repository.MyRepository;
import com.example.crud9.service.MyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    private MyRepository myRepository;
    private ModelMapper modelMapper;

    public MyServiceImpl(MyRepository myRepository, ModelMapper modelMapper){
        this.myRepository = myRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MyDto createMy(MyDto myDto){
        MyData myData = modelMapper.map(myDto, MyData.class);
        MyData saveMy =myRepository.save(myData);

        return  modelMapper.map(saveMy, MyDto.class);
    }
}
