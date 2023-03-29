package com.example.mhlogfileanalyser;

import com.example.mhlogfileanalyser.service.MhLogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MhLogFileAnalyserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MhLogFileAnalyserApplication.class, args);
        MhLogService mhLogService = new MhLogService();
    }

}
