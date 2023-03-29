package com.example.mhlogfileanalyser.readfiles;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@Data
public class LogsReader {

    public List<File> readLogsFolder() {
        File folderPath = new File("C:\\Users\\ashutosh.palai\\Downloads\\logfiles");
        File filesList[] = folderPath.listFiles();
        return List.of(filesList);
    }
}

