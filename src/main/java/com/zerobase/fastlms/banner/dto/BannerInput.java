package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.entity.BannerOpenType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BannerInput {

    private String title;
    private String linkUrl;
    private BannerOpenType openType;
    private Long orderNumber;
    private Boolean openYn;
    private String fileFullPath;

    public Banner toEntity() {
        return Banner.builder()
                .title(title)
                .linkUrl(linkUrl)
                .openType(openType)
                .orderNumber(orderNumber)
                .openYn(openYn)
                .fileFullPath(fileFullPath)
                .build();
    }

}
