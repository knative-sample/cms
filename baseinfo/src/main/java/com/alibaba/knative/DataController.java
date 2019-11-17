package com.alibaba.knative;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Scanner;

@RestController
public class DataController {

    @RequestMapping(value = "/api/baseinfo")
    public String baseinfo() throws InterruptedException {

        InputStream inputStream = DataController.class.getClassLoader().getResourceAsStream("baseinfo.json");
        StringBuilder sb = new StringBuilder();

        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        Thread.sleep(600);

        return sb.toString();
    }

}