package com.zerobase.fastlms.history.service.impl;

import com.zerobase.fastlms.history.dto.LoginHistoryInput;
import com.zerobase.fastlms.history.dto.LoginHistoryOutput;
import com.zerobase.fastlms.history.entity.LoginHistory;
import com.zerobase.fastlms.history.repository.LoginHistoryRepository;
import com.zerobase.fastlms.history.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginHistoryImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public boolean addLoginHistory(LoginHistoryInput loginHistoryInput) {

        loginHistoryRepository.save(loginHistoryInput.toEntity());

        return true;
    }

    @Override
    public List<LoginHistoryOutput> searchLoginHistory(String userId) {
        List<LoginHistory> loginHistoryList = loginHistoryRepository.findAllByUserId(userId);

        return loginHistoryList.stream()
                .map(LoginHistoryOutput::fromEntity)
                .collect(Collectors.toList());
    }


}
