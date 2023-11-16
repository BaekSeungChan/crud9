package com.example.crud9.service.Impl;

import com.example.crud9.entity.YouData;
import com.example.crud9.payload.YouDto;
import com.example.crud9.repository.YouRepository;
import com.example.crud9.service.YouService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YouServiceImpl implements YouService {
    private YouRepository youRepository;
    private ModelMapper modelMapper;

    public YouServiceImpl(YouRepository youRepository, ModelMapper modelMapper){
        this.youRepository = youRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public YouDto createYou(YouDto youDto){
        YouData youData = modelMapper.map(youDto, YouData.class);
        YouData saveYouData = youRepository.save(youData);

        return modelMapper.map(saveYouData, YouDto.class);

    }

    @Override
    public List<YouDto> getAllYou(){
        List<YouData> yous = youRepository.findAll();

        return yous.stream().map((you) -> modelMapper.map(you, YouDto.class)).collect(Collectors.toList());
    }

    @Override
    public YouDto getYouById(long id){
        YouData youData = youRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(youData, YouDto.class);
    }

    @Override
    public void deleteTouById(long id){
        YouData youData = youRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        youRepository.delete(youData);
    }

    @Override
    public YouDto updateYou(YouDto youDto, long id){
        YouData youData = youRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        youData.setName(youDto.getName());
        youData.setPhonenumber(youDto.getPhonenumber());

        YouData saveYou = youRepository.save(youData);

        return modelMapper.map(saveYou, YouDto.class);
    }

}
