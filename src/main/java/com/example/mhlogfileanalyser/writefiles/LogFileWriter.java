package com.example.mhlogfileanalyser.writefiles;

import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
@Data
public class LogFileWriter {

    public void ContentToFile(TreeMap contentOfAllFiles) {
        String text;
        List<String> lines = new ArrayList<>();
        try {
            for (Object key : contentOfAllFiles.keySet()) {
                text = (String) key + contentOfAllFiles.get(key);
                lines.add(text);
                Files.write(Paths.get(PropertiesFileReader.getMessage(PropertiesKeyEnum.NEW_MERGED_FILE.getKey())), lines, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}


