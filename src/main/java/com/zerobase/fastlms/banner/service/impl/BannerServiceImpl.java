package com.zerobase.fastlms.banner.service.impl;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.dto.BannerInput;
import com.zerobase.fastlms.banner.dto.BannerOutput;
import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.mapper.BannerMapper;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import com.zerobase.fastlms.banner.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public List<BannerOutput> bannerAllList(CommonParam param) {
        long totalCount = bannerMapper.selectListCount(param);
        List<BannerOutput> bannerOutputList = bannerMapper.selectList(param);

        if (!CollectionUtils.isEmpty(bannerOutputList)) {
            int i = 0;
            for(BannerOutput x : bannerOutputList) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - param.getPageStart() - i);
                i++;
            }
        }

        return bannerOutputList;
    }

    @Override
    public boolean addBanner(BannerInput bannerInput) {
        bannerRepository.save(bannerInput.toEntity());
        return true;
    }

    @Override
    public BannerOutput findBanner(Long id) {
        Banner banner = bannerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banner not found"));

        return BannerOutput.from(banner);

    }

    @Override
    public boolean modifyBanner(BannerInput bannerInput) {

        Banner banner = bannerRepository.findById(bannerInput.getId())
                .orElseThrow(() -> new RuntimeException("Banner not found"));

        banner.setTitle(bannerInput.getTitle());
        banner.setFileName(bannerInput.getFileName());
        banner.setLinkUrl(bannerInput.getLinkUrl());
        banner.setOpenType(bannerInput.getOpenType());
        banner.setOpenYn(bannerInput.getOpenYn());
        banner.setOrderNumber(bannerInput.getOrderNumber());

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean removeBanners(List<Long> idList) {

        bannerRepository.deleteAllById(idList);

        return true;
    }
}
