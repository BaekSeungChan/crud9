package com.example.crud9.service.Impl;

import com.example.crud9.entity.MyData;
import com.example.crud9.entity.YouData;
import com.example.crud9.payload.MyDto;
import com.example.crud9.repository.MyRepository;
import com.example.crud9.service.MyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<MyDto> getAllMy(){
        List<MyData> myDatas = myRepository.findAll();
        return myDatas.stream().map((myData)-> modelMapper.map(myData, MyDto.class)).collect(Collectors.toList());
    }

    @Override
    public MyDto getMyById(long id){
        MyData myData = myRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(myData, MyDto.class);
    }

    @Override
    public void deleteMyById(long id){
        MyData myData = myRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        myRepository.delete(myData);
    }

    @Override
    public MyDto updateMy(MyDto myDto, long id){
        MyData myData = myRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        myData.setName(myDto.getName());
        myData.setPhonenumber(myDto.getPhonenumber());

        MyData savemy = myRepository.save(myData);

        return modelMapper.map(savemy, MyDto.class);
    }

}
