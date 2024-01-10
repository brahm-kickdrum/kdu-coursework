package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerFile {
    private static final Logger log = LoggerFactory.getLogger(LoggerFile.class);

    public void logInfo(String message) {
        log.info(message);
    }

}

