package com.example.mhlogfileanalyser.utils;

import lombok.Getter;

@Getter
public enum PropertiesKeyEnum {
    APP_FILES("com.mhcure.logfiles.APP.files"),
    SIP_FILES("com.mhcure.logfiles.SIP.files"),
    SIPIS_FILES("com.mhcure.logfiles.SIPS.files"),
    LOCALPUSH_FILES("com.mhcure.logfiles.LOCALPUSH.files"),
    APP_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.APP.log.dateTime.format"),
    LOCAL_PUSH_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.LOCALPUSH.log.dateTime.format"),
    SIP_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.SIP.log.dateTime.format"),
    SIPIS_DATE_AND_TIME_FORMAT("com.mhcure.logfiles.SIPIS.log.dateTime.format"),
    APP_DATE_AND_TIME_pattern("com.mhcure.logfiles.APP.log.dateTime.pattern"),
    LOCAL_PUSH_DATE_AND_TIME_pattern("com.mhcure.logfiles.LOCALPUSH.log.dateTime.pattern"),
    SIP_DATE_AND_TIME_pattern("com.mhcure.logfiles.SIP.log.dateTime.pattern"),
    SIPIS_DATE_AND_TIME_pattern("com.mhcure.logfiles.SIPIS.log.dateTime.pattern"),

    SIMPLE_DATE_AND_TIME_FORMAT_FOR_MERGED_FILE("com.mhcure.simple.date.and.time.format"),

    LOG_FILES_FOLDER_PATH("com.mhcure.logfiles.folder.path"),

    NEW_MERGED_FILE("com.mhcure.logfiles.Mergedfiles");
    private final String key;

    PropertiesKeyEnum(String key) {

        this.key = key;
    }
}
