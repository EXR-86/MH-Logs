package com.example.mhlogfileanalyser.service;

import com.example.mhlogfileanalyser.readfiles.LogsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class MhLogService {
    @Autowired
    private LogsReader logsReader;

    @Bean
    public Integer listOfFiles() {
        List<File> allLogs = logsReader.readLogsFolder();
        System.out.println(logsReader.readLogsFolder());
        return allLogs.size();
    }
}
