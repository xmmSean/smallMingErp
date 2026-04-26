package com.smallming.erp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HealthController
 * @Description TODO
 * @Author smallming
 * @Date 2026/4/26 21:03
 **/
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "smallMingErp is running";
    }

}
