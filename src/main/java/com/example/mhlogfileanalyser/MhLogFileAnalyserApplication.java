package com.example.mhlogfileanalyser;

import com.example.mhlogfileanalyser.readfiles.LogFileReader;
import com.example.mhlogfileanalyser.readfiles.LogsFolderReader;
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
import java.util.Scanner;

@SpringBootApplication
public class MhLogFileAnalyserApplication {

    private final LogsFolderReader logsFolderReader;
    private final LogFileReader logFileReader;
    Scanner userPromptInput = new Scanner(System.in);

    public MhLogFileAnalyserApplication(LogsFolderReader logsFolderReader, LogFileReader logFileReader) {
        this.logsFolderReader = logsFolderReader;
        this.logFileReader = logFileReader;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(MhLogFileAnalyserApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext configurableApplicationContext) {
        String promptInput;
        do {
            System.out.println("Please press Y to merge files and X to terminate");
            promptInput = userPromptInput.nextLine();
        } while (!promptInput.equalsIgnoreCase("Y") && !promptInput.equalsIgnoreCase("X"));
        if (promptInput.equalsIgnoreCase("X")) {
            userPromptInput.close();
            System.exit(SpringApplication.exit(configurableApplicationContext, () -> 11));
        }
        doFileMerge();
        return args -> {
            System.out.println();
        };
    }

    private void doFileMerge() {
        List<File> listOfLogFiles = logsFolderReader.readLogsFolder(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOG_FILES_FOLDER_PATH.getKey()));
        logFileReader.performRead(listOfLogFiles);
        System.out.println("File is created successfully with the content.");
    }
}
