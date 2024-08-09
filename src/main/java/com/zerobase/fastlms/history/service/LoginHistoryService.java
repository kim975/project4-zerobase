package com.zerobase.fastlms.history.service;

import com.zerobase.fastlms.history.dto.LoginHistoryInput;
import com.zerobase.fastlms.history.dto.LoginHistoryOutput;

import java.util.List;

public interface LoginHistoryService {
    boolean addLoginHistory(LoginHistoryInput loginHistoryInput);

    List<LoginHistoryOutput> searchLoginHistory(String userId);
}
