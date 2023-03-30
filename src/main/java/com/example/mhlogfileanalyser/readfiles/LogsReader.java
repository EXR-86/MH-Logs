package com.example.mhlogfileanalyser.readfiles;

import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Component
@Data
public class LogsReader {

    /**
     * Reading the folder path and returns the list of log files
     * @param folderPath
     * @return
     */
    public List<File> readLogsFolder(String folderPath) {
        File readFolderPath = new File(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOG_FILES_FOLDER_PATH.getKey()));
        File[] filesList = readFolderPath.listFiles();
        System.out.println(filesList);
        return List.of(filesList);
    }
}

