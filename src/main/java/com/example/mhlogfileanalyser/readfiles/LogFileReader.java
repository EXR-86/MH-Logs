package com.example.mhlogfileanalyser.readfiles;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
@Data
public class LogFileReader {

    public void performRead(List<File> listOfLogFiles) {
        for (File filePath : listOfLogFiles) {
            performRead(filePath);
        }
    }

    private void performRead(File filePath) {
        StringBuilder fileContents = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineText;
            while ((lineText = bufferedReader.readLine()) != null) {
                System.out.println(lineText);
                fileContents.append(lineText);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println(" Something went wrong!The file name is Incorrect,The file '" + fileContents + "' does not exist.");
        }
    }
}
