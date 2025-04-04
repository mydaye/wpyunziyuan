package com.heycolor.yunziyuanbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 确保添加此注解
public class YunziyuanBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunziyuanBackEndApplication.class, args);
        System.out.print("Hello World!");
    }

}
