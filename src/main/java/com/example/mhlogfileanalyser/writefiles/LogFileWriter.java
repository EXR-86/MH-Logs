package com.example.mhlogfileanalyser.writefiles;

import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

@Component
@Data
public class LogFileWriter {

    public void ContentToFile(TreeMap contentOfAllFiles) {
        String text;
        List<String> lines = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIMPLE_DATE_AND_TIME_FORMAT_FOR_MERGED_FILE.getKey()));
        try {
            for (Object key : contentOfAllFiles.keySet()) {
                text = dateFormat.format(new Date((Long) key)) + contentOfAllFiles.get(key);
                lines.add(text);
                Files.write(Paths.get(PropertiesFileReader.getMessage(PropertiesKeyEnum.NEW_MERGED_FILE.getKey())), lines, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}


