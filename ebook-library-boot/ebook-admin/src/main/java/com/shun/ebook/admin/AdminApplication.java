package com.shun.ebook.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cxshun@gmail.com
 * 2019-08-07 10-11
 **/
@SpringBootApplication
@ComponentScan("com.shun.ebook")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
