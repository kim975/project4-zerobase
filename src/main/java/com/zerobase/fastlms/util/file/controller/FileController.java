package com.zerobase.fastlms.util.file.controller;

import com.zerobase.fastlms.util.file.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class FileController {

    @GetMapping("/display")
    public ResponseEntity<byte[]> getImage(
            @RequestParam("fileName") String fileName
    ) {
        File file = new File(FileUtils.STORED_URL + fileName);
        ResponseEntity<byte[]> result = null;

        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
