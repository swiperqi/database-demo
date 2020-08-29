package com.qiqi.demo.congtroller;

import com.qiqi.demo.domain.DemoDto;
import com.qiqi.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/getById/{id}")
    public DemoDto getById(@PathVariable("id") Integer id) {
        return demoService.getById(id);
    }

    @GetMapping("/getAll")
    public List<DemoDto> getAll() {
        return demoService.getAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public Boolean deleteById(@PathVariable("id") Integer id) {
        try {
            demoService.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/updateDemo")
    public Boolean updateDemo(@RequestBody DemoDto demoDto) {
        try {
            demoService.updateDemoById(demoDto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PutMapping("/insertDemo")
    public Boolean insertDemo(@RequestBody DemoDto demoDto) {
        try {
            demoService.insertDemo(demoDto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
