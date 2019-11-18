package com.alibaba.knative;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("contactinfo")
public interface ContactInfoInterface {

    @RequestMapping(value = "/api/contactinfo")
    String contactinfo();
}