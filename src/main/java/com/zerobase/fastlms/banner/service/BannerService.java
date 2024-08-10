package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.dto.BannerOutput;

import java.util.List;

public interface BannerService {
    List<BannerOutput> bannerAllList(CommonParam param);
}
