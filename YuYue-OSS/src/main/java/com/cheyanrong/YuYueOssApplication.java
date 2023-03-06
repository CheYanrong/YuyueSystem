package com.cheyanrong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement

public class YuYueOssApplication {
    public static void main(String[] args) {
        SpringApplication.run(YuYueOssApplication.class, args);
    }

}
