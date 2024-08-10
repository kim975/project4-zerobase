package com.zerobase.fastlms.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BannerDisplayDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private String fileName;
        private String linkUrl;
        private String openType;

    }

}
