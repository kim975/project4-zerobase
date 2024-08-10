package com.zerobase.fastlms.util.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static String STORED_URL = "D:\\zerobase\\project4-zerobase-file\\";

    public static void storedFile (MultipartFile file) throws IOException {

        String fullPath = null;
        if (!file.isEmpty()) {
            fullPath = STORED_URL + file.getOriginalFilename();
            file.transferTo(new File(fullPath));
        }

    }

}
