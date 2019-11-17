package com.alibaba.knative;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("baseinfo")
public interface BaseInfoInterface {

    @RequestMapping(value = "/api/baseinfo")
    String baseinfo();
}