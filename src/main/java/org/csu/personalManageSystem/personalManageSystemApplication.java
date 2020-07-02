package org.csu.personalManageSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.csu.personalManageSystem.persistence")

public class personalManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run (personalManageSystemApplication.class, args);
    }

}
