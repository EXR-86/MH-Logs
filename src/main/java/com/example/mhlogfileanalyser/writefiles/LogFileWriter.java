package com.example.mhlogfileanalyser.writefiles;

import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@Data
public class LogFileWriter {

    public void ContentToFile(TreeMap contentOfAllFiles) {
        String text;
        List<String> lines = new ArrayList<>();
        LocalDateTime dateAndTimeOfLogs;
        DateTimeFormatter mergedFileDateTimeFormat = DateTimeFormatter.ofPattern(PropertiesFileReader
                .getMessage(PropertiesKeyEnum.SIMPLE_DATE_AND_TIME_FORMAT_FOR_MERGED_FILE.getKey()));
        try {
            for (Object key : contentOfAllFiles.keySet()) {
                dateAndTimeOfLogs =  LocalDateTime.ofInstant(Instant.ofEpochMilli((Long) key),
                        TimeZone.getDefault().toZoneId());
                text = dateAndTimeOfLogs.format(mergedFileDateTimeFormat) + contentOfAllFiles.get(key);
                lines.add(text);
                Files.write(Paths.get(PropertiesFileReader.getMessage(PropertiesKeyEnum
                        .NEW_MERGED_FILE.getKey())), lines, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
