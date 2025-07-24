package com.example.form_dang_nhap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FormDangNhapApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormDangNhapApplication.class, args);
    }

}
