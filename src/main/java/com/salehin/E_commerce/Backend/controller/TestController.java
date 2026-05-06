package com.salehin.E_commerce.Backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TestController {

    @GetMapping()
    public String randomTest(){
        log.info("randomTest");
        return "Random Test";

    }
    @GetMapping("/working")
    public String working(){
        log.info("working");
        return "yes";
    }
}
