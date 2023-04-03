package com.example.mhlogfileanalyser.utils;

import lombok.Getter;

@Getter
public enum PropertiesKeyEnum {
    APP_FILES("com.mhcure.logfiles.APP.files"),
    SIP_FILES("com.mhcure.logfiles.SIP.files"),
    SIPS_FILES("com.mhcure.logfiles.SIPS.files"),
    LOCALPUSH_FILES("com.mhcure.logfiles.LOCALPUSH.files"),
    APP_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.APP.log.dateTime.format"),
    LOCAL_PUSH_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.LOCALPUSH.log.dateTime.format"),
    SIP_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.SIP.log.dateTime.format"),
    SIPS_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.SIPIS.log.dateTime.format"),
    APP_DATE_AND_TIME_pattern("com.mhcure.logfiles.APP.log.dateTime.pattern"),
    LOCAL_PUSH_DATE_AND_TIME_pattern("com.mhcure.logfiles.LOCALPUSH.log.dateTime.pattern"),
    SIP_DATE_AND_TIME_pattern("com.mhcure.logfiles.SIP.log.dateTime.pattern"),
    SIPS_DATE_AND_TIME_pattern("com.mhcure.logfiles.SIPIS.log.dateTime.pattern"),

    SIMPLE("com.mhcure.simple.date.and.time.format"),

    LOG_FILES_FOLDER_PATH("com.mhcure.logfiles.folder.path");


    private final String key;

    PropertiesKeyEnum(String key) {
        this.key = key;
    }
}
