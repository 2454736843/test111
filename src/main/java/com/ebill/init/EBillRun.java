package com.ebill.init;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("com.ebill.gettopic")
@MapperScan("com/ebill/DBUtil")
@SpringBootApplication
@EnableAsync
public class EBillRun extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EBillRun.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(EBillRun.class);

    }
}
