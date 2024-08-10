package com.zerobase.fastlms.banner.mapper;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.dto.BannerOutput;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    long selectListCount(CommonParam parameter);
    List<BannerOutput> selectList(CommonParam parameter);

}
