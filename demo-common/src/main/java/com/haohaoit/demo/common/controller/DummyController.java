package com.haohaoit.demo.common.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dummy")
@Slf4j
public class DummyController {

    @GetMapping("ping")
    @ResponseBody
    public String ping() {
        log.info("test");
        return "pong";
    }
}
