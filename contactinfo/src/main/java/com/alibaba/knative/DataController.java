package com.alibaba.knative;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author caogu.wyp
 * @version $Id: caogu.wyp.java, v 0.1 2019年11月15日 上午2:45 Exp $
 */
@RestController
public class DataController {

    @RequestMapping(value = "/api/contactinfo")
    public String contactinfo() throws InterruptedException {

        InputStream inputStream = DataController.class.getClassLoader().getResourceAsStream("contact.json");
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