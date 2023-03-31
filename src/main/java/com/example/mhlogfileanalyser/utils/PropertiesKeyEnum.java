package com.example.mhlogfileanalyser.utils;

import lombok.Getter;

@Getter
public enum PropertiesKeyEnum {
    ENTITY_PATHFILE("entity.pathfile"),
    LOG_FILES_FOLDER_PATH("logfiles.folder.path");
    private final String key;

    PropertiesKeyEnum(String key) {
        this.key = key;
    }
}
