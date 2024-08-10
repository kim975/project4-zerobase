package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.dto.BannerInput;
import com.zerobase.fastlms.banner.dto.BannerOutput;

import java.util.List;

public interface BannerService {
    List<BannerOutput> bannerAllList(CommonParam param);

    boolean addBanner(BannerInput bannerInput);

    BannerOutput findBanner(Long id);

    boolean modifyBanner(BannerInput bannerInput);

    boolean removeBanners(List<Long> idList);
}
