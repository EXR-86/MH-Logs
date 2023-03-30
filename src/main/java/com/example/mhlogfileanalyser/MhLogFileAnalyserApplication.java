package com.example.mhlogfileanalyser;

import com.example.mhlogfileanalyser.readfiles.LogsReader;
import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class MhLogFileAnalyserApplication {

    private final LogsReader logsReader;

    public MhLogFileAnalyserApplication(LogsReader logsReader) {
        this.logsReader = logsReader;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MhLogFileAnalyserApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
      List<File> listOfLogFiles = logsReader.readLogsFolder(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOG_FILES_FOLDER_PATH.getKey()));
        return args -> {
            System.out.println(listOfLogFiles);
        };
    }
}
