package com.zerobase.fastlms.banner.service.impl;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.dto.BannerOutput;
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
}
