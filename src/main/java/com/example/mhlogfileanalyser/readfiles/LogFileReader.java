package com.example.mhlogfileanalyser.readfiles;

import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                createTimeStamp(filePath, lineText);
                fileContents.append(lineText);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println(" Something went wrong!The file name is Incorrect,The file '" + fileContents + "' does not exist.");
        }
    }

    private void createTimeStamp(File filePath, String perLineContentOfEachFile) {
        File fileName = new File(filePath.getName());
        Matcher dateAndTimePatternMatcher;
        Pattern dateAndTimePatternOfIndividualFile;
        String dateAndTime;
        HashMap<String, String> contentOfAllFiles = new HashMap<>();
        if (fileName.toString().toLowerCase().startsWith(PropertiesFileReader.getMessage(PropertiesKeyEnum.APP_FILES.getKey()))) {
            dateAndTimePatternOfIndividualFile = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.APP_DATE_AND_TIME_pattern.getKey()));
            dateAndTimePatternMatcher = dateAndTimePatternOfIndividualFile.matcher(perLineContentOfEachFile);
            if (dateAndTimePatternMatcher.find()) {
                dateAndTime = dateAndTimePatternMatcher.group();
                perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTime, "");
                contentOfAllFiles.put(dateAndTime, perLineContentOfEachFile);
                System.out.println(contentOfAllFiles);

            }
        }
        if (fileName.toString().toLowerCase().startsWith(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIP_FILES.getKey()))) {
            dateAndTimePatternOfIndividualFile = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIP_DATE_AND_TIME_pattern.getKey()));
            dateAndTimePatternMatcher = dateAndTimePatternOfIndividualFile.matcher(perLineContentOfEachFile);
            if (dateAndTimePatternMatcher.find()) {
                dateAndTime = dateAndTimePatternMatcher.group();
                perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTime, "");
                contentOfAllFiles.put(dateAndTime, perLineContentOfEachFile);
                System.out.println(contentOfAllFiles);
            }
        }
        if (fileName.toString().toLowerCase().startsWith(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIPS_FILES.getKey()))) {
            dateAndTimePatternOfIndividualFile = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIPS_DATE_AND_TIME_pattern.getKey()));
            dateAndTimePatternMatcher = dateAndTimePatternOfIndividualFile.matcher(perLineContentOfEachFile);
            if (dateAndTimePatternMatcher.find()) {
                dateAndTime = dateAndTimePatternMatcher.group();
                perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTime, "");
                contentOfAllFiles.put(dateAndTime, perLineContentOfEachFile);
                System.out.println(contentOfAllFiles);
            }
        }
        if (fileName.toString().toLowerCase().startsWith(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOCALPUSH_FILES.getKey()))) {
            dateAndTimePatternOfIndividualFile = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOCAL_PUSH_DATE_AND_TIME_pattern.getKey()));
            dateAndTimePatternMatcher = dateAndTimePatternOfIndividualFile.matcher(perLineContentOfEachFile);
            if (dateAndTimePatternMatcher.find()) {
                dateAndTime = dateAndTimePatternMatcher.group();
                perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTime, "");
                contentOfAllFiles.put(dateAndTime, perLineContentOfEachFile);
                System.out.println(contentOfAllFiles);

            }
        }

    }
}



