package com.example.mhlogfileanalyser.readfiles;

import com.example.mhlogfileanalyser.utils.PropertiesFileReader;
import com.example.mhlogfileanalyser.utils.PropertiesKeyEnum;
import com.example.mhlogfileanalyser.writefiles.LogFileWriter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Data
public class LogFileReader {

    private final LogFileWriter logFileWriter;

    public LogFileReader(LogFileWriter logFileWriter) {
        this.logFileWriter = logFileWriter;
    }

    public void performRead(List<File> listOfLogFiles) {
        TreeMap<String, String> mergedContentOfAllFiles = new TreeMap<>();
        for (File filePath : listOfLogFiles) {
            if (mergedContentOfAllFiles.isEmpty()) {
                mergedContentOfAllFiles = performRead(filePath);
            }
            mergedContentOfAllFiles.putAll(performRead(filePath));
        }
        logFileWriter.ContentToFile(mergedContentOfAllFiles);
    }

    private TreeMap performRead(File filePath) {
        StringBuilder fileContents = new StringBuilder();
        TreeMap contentMap = new TreeMap<>();
        List<String> contentOfEachFile = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineText;
            while ((lineText = bufferedReader.readLine()) != null) {
                contentOfEachFile.add(lineText);
                fileContents.append(lineText);
            }
            contentMap = createTimeStamp(filePath, contentOfEachFile);
            contentOfEachFile.clear();
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println(" Something went wrong!The file name is Incorrect,The file '" + fileContents + "' does not exist.");
        }
        // System.out.println(contentOfEachFile);
        return contentMap;
    }

    private TreeMap createTimeStamp(File filePath, List<String> contentOfEachFile) {
        File fileName = new File(filePath.getName());
        Matcher dateAndTimePatternMatcher;
        String dateAndTimeString;
        Long timeStamp = null;
        Date dateAndTime;
        SimpleDateFormat dateFormat;
        TreeMap<Long, String> contentOfAllFiles = new TreeMap<>();
        String perLineContentOfEachFile;
        for (String perLineString : contentOfEachFile) {
            perLineContentOfEachFile = perLineString;
            try {
                if (fileName.toString().toLowerCase().startsWith(PropertiesFileReader.getMessage(PropertiesKeyEnum.APP_FILES.getKey()))) {
                    dateAndTimePatternMatcher = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.APP_DATE_AND_TIME_pattern.getKey())).matcher(perLineContentOfEachFile);
                    dateFormat = new SimpleDateFormat(PropertiesFileReader.getMessage(PropertiesKeyEnum.APP_DATE_AND_TIME_FORMAT.getKey()));
                    if (dateAndTimePatternMatcher.find()) {
                        dateAndTimeString = dateAndTimePatternMatcher.group();
                        dateAndTime = dateFormat.parse(dateAndTimeString);
                        timeStamp = dateAndTime.getTime();
                        perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTimeString, "");
                        contentOfAllFiles.put(timeStamp, perLineContentOfEachFile);
                    }

                }
                if (fileName.toString().toLowerCase().equals(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIP_FILES.getKey()))) {
                    dateAndTimePatternMatcher = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIP_DATE_AND_TIME_pattern.getKey())).matcher(perLineContentOfEachFile);
                    dateFormat = new SimpleDateFormat(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIP_DATE_AND_TIME_FORMAT.getKey()));
                    if (dateAndTimePatternMatcher.find()) {
                        dateAndTimeString = dateAndTimePatternMatcher.group();
                        dateAndTime = dateFormat.parse(dateAndTimeString);
                        timeStamp = dateAndTime.getTime();
                        perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTimeString, "");
                        contentOfAllFiles.put(timeStamp, perLineContentOfEachFile);
                    }
                    if (!dateAndTimePatternMatcher.find()) {
                        contentOfAllFiles.put(contentOfAllFiles.lastEntry().getKey(), contentOfAllFiles.lastEntry().getValue() + perLineContentOfEachFile);
                    }


                }
                if (fileName.toString().startsWith(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIPIS_FILES.getKey()))) {
                    dateAndTimePatternMatcher = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIPIS_DATE_AND_TIME_pattern.getKey())).matcher(perLineContentOfEachFile);
                    dateFormat = new SimpleDateFormat(PropertiesFileReader.getMessage(PropertiesKeyEnum.SIPIS_DATE_AND_TIME_FORMAT.getKey()));
                    if (dateAndTimePatternMatcher.find()) {
                        dateAndTimeString = dateAndTimePatternMatcher.group();
                        dateAndTime = dateFormat.parse(dateAndTimeString);
                        timeStamp = dateAndTime.getTime();
                        perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTimeString, "");
                        contentOfAllFiles.put(timeStamp, perLineContentOfEachFile);
                    }
                    if (!dateAndTimePatternMatcher.find()) {
                        contentOfAllFiles.put(contentOfAllFiles.lastEntry().getKey(), contentOfAllFiles.lastEntry().getValue() + perLineContentOfEachFile);
                    }

                }
                if (fileName.toString().toLowerCase().startsWith(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOCALPUSH_FILES.getKey()))) {
                    dateAndTimePatternMatcher = Pattern.compile(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOCAL_PUSH_DATE_AND_TIME_pattern.getKey())).matcher(perLineContentOfEachFile);
                    dateFormat = new SimpleDateFormat(PropertiesFileReader.getMessage(PropertiesKeyEnum.LOCAL_PUSH_DATE_AND_TIME_FORMAT.getKey()));
                    if (dateAndTimePatternMatcher.find()) {
                        dateAndTimeString = dateAndTimePatternMatcher.group();
                        dateAndTime = dateFormat.parse(dateAndTimeString);
                        timeStamp = dateAndTime.getTime();
                        perLineContentOfEachFile = perLineContentOfEachFile.replace(dateAndTimeString, "");
                        contentOfAllFiles.put(timeStamp, perLineContentOfEachFile);
                    }
                    if (!dateAndTimePatternMatcher.find()) {
                        contentOfAllFiles.put(contentOfAllFiles.lastEntry().getKey(), contentOfAllFiles.lastEntry().getValue() + perLineContentOfEachFile);
                    }


                }
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }

        return contentOfAllFiles;
    }
}
