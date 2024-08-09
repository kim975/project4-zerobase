package com.zerobase.fastlms.history.dto;

import lombok.*;

import java.time.LocalDateTime;

public class LoginHistoryDto {

    @Getter
    @Builder
    public static class Response {
        private String clientIp;
        private String userAgent;
        private LocalDateTime loginDt;

        public static Response from(LoginHistoryOutput loginHistoryOutput) {
            return Response.builder()
                    .clientIp(loginHistoryOutput.getClientIp())
                    .userAgent(loginHistoryOutput.getUserAgent())
                    .loginDt(loginHistoryOutput.getLoginDt())
                    .build();
        }
    }
}
