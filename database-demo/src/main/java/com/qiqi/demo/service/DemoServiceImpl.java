package com.qiqi.demo.service;

import com.qiqi.demo.domain.DemoDto;
import com.qiqi.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public DemoDto getById(Integer id) {
        return demoMapper.getById(id);
    }

    @Override
    public List<DemoDto> getAll() {
        return demoMapper.getAll();
    }

    @Override
    public void insertDemo(DemoDto demoDto) {
        demoMapper.insertDemo(demoDto);
    }

    @Override
    public void updateDemoById(DemoDto demoDto) {
        demoMapper.updateDemoById(demoDto);
    }

    @Override
    public void deleteById(Integer id) {
        demoMapper.deleteById(id);
    }
}
