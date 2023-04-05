package com.example.mhlogfileanalyser.readfiles;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@Data
public class LogsFolderReader {

    /**
     * Reading the folder path and returns the list of log files
     *
     * @param folderPath
     * @return
     */
    public List<File> readLogsFolder(String folderPath) {
        File readFolderPath = new File(folderPath);
        File[] filesList = readFolderPath.listFiles();
        System.out.println(filesList);
        return List.of(filesList);
    }
}
