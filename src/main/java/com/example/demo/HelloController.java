package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(path = "/second-service")
@RequiredArgsConstructor
public class HelloController {

    private final Environment env;

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
    public String check(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());
        return String.format("Check 1 on PORT %s", env.getProperty("local.server.port"));
    }
}
