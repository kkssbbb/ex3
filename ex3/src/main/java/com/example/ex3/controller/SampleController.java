package com.example.ex3.controller;

import com.example.ex3.dto.SampleDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2

public class SampleController {


    @GetMapping("/ex1")
    public void ex(){
        log.info("ex 로그");
    }


    @GetMapping("/ex2")
    public void exModel(Model model1){
        log.info("ex2 로그");
        List<SampleDto> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i ->{
            SampleDto sampleDto = SampleDto.builder()
                    .sno(i)
                    .first("첫번쨰"+i)
                    .last("마지막"+i)
                    .time(LocalDateTime.now())
                    .build();
            return sampleDto;
        }).collect(Collectors.toList());

        model1.addAllAttributes(list);

    }

}
