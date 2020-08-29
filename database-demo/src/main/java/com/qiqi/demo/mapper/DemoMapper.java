package com.qiqi.demo.mapper;

import com.qiqi.demo.domain.DemoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemoMapper {

    DemoDto getById(@Param("id") Integer id);

    List<DemoDto> getAll();

    void insertDemo(DemoDto demoDto);

    void updateDemoById(DemoDto demoDto);

    void deleteById(@Param("id") Integer id);

}
