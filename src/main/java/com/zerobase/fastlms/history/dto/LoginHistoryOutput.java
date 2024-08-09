package com.zerobase.fastlms.history.dto;

import com.zerobase.fastlms.history.entity.LoginHistory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginHistoryOutput {

    private String userId;
    private String clientIp;
    private String userAgent;
    private LocalDateTime loginDt;

    public static LoginHistoryOutput fromEntity(LoginHistory loginHistory) {
        return LoginHistoryOutput.builder()
                .userId(loginHistory.getUserId())
                .clientIp(loginHistory.getClientIp())
                .userAgent(loginHistory.getUserAgent())
                .loginDt(loginHistory.getLoginDt())
                .build();
    }


}
