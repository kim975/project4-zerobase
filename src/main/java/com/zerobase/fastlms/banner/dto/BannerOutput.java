package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.entity.BannerOpenType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerOutput {

    private Integer id;
    private String title;
    private String linkUrl;
    private BannerOpenType openType;
    private Long orderNumber;
    private Boolean openYn;
    private String fileName;
    private LocalDateTime createDt;

    //추가컬럼
    long totalCount;
    long seq;

    public static BannerOutput from(Banner banner) {
        return BannerOutput.builder()
                .id(banner.getId())
                .title(banner.getTitle())
                .linkUrl(banner.getLinkUrl())
                .openType(banner.getOpenType())
                .orderNumber(banner.getOrderNumber())
                .openYn(banner.getOpenYn())
                .fileName(banner.getFileName())
                .createDt(banner.getCreateDt())
                .build();
    }
}
