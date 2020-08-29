package com.qiqi.demo.service;

import com.qiqi.demo.domain.DemoDto;

import java.util.List;

public interface DemoService {

    DemoDto getById(Integer id);

    List<DemoDto> getAll();

    void insertDemo(DemoDto demoDto);

    void updateDemoById(DemoDto demoDto);

    void deleteById(Integer id);

}
