package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/second-service")
@Slf4j
public class HelloController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello 2";
    }

    @GetMapping(path = "/messages")
    public String messages(@RequestHeader("second-request") String header) {
        log.info("header:{}",header);
        return "Messages 2";
    }

    @GetMapping(path = "/check")
    public String check() {
        return "Check 2";
    }
}
