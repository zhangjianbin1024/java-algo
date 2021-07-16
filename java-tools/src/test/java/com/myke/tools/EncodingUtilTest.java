package com.myke.tools;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class EncodingUtilTest {

    @Test
    public void convertUtf8() {
        String directoryPath = "E:\\git_project\\java-algo\\java-hanshuping\\src";
        List<String> allFile = EncodingUtil.getAllFile(directoryPath, true);
        allFile.forEach(file -> {
            log.info("path:[{}]", file);
        });

    }

}