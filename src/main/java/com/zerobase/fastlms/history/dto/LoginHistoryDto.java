package com.zerobase.fastlms.history.dto;

import lombok.*;

import java.time.LocalDateTime;

public class LoginHistoryDto {

    @Getter
    @Builder
    public static class Response {
        private LocalDateTime loginDt;
        private String clientIp;
        private String userAgent;
    }
}
