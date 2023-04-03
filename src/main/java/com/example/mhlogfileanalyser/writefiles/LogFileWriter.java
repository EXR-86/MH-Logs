package com.example.mhlogfileanalyser.writefiles;

import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

@Component
@Data
public class LogFileWriter {

    public void ContentToFile(HashMap contentOfAllFiles) {
        String text;
        try {
            FileWriter fileWriter = new FileWriter(PropertiesFileReader.getMessage(PropertiesKeyEnum.NEW_MERGED_FILE.getKey()));
            for (Object key: contentOfAllFiles.keySet()) {
                text = (String) key + contentOfAllFiles.get(key);
                fileWriter.write( text);
               System.out.println(text);
                fileWriter.close();
            }

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}


