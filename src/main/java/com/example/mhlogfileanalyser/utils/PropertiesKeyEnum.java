package com.example.mhlogfileanalyser.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum PropertiesKeyEnum {
    LOG_FILES_FOLDER_PATH("logfiles.folder.path");

    private final String key;
    PropertiesKeyEnum(String key) {
       this.key = key;
    }
}
