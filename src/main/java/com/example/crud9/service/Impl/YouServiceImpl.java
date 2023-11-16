package com.example.crud9.service.Impl;

import com.example.crud9.entity.YouData;
import com.example.crud9.payload.YouDto;
import com.example.crud9.repository.YouRepository;
import com.example.crud9.service.YouService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

}
