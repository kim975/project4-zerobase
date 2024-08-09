package com.zerobase.fastlms.history.dto;

import com.zerobase.fastlms.history.entity.LoginHistory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginHistoryInput {

    private String userId;
    private String clientIp;
    private String userAgent;

    public LoginHistory toEntity() {
        return LoginHistory.builder()
                .userId(userId)
                .clientIp(clientIp)
                .userAgent(userAgent)
                .build();
    }

}
