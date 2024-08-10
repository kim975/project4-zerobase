package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.BannerOpenType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

public class BannerListDto {

    @Data
    @Builder
    public static class Response {
        private Integer id;
        private String title;
        private String linkUrl;
        private BannerOpenType openType;
        private Long orderNumber;
        private Boolean openYn;
        private String fileFullPath;
        private LocalDateTime createDt;

        //추가컬럼
        long totalCount;
        long seq;

        public static Response from(BannerOutput bannerOutput) {
            return Response.builder()
                    .id(bannerOutput.getId())
                    .title(bannerOutput.getTitle())
                    .linkUrl(bannerOutput.getLinkUrl())
                    .openType(bannerOutput.getOpenType())
                    .orderNumber(bannerOutput.getOrderNumber())
                    .openYn(bannerOutput.getOpenYn())
                    .fileFullPath(bannerOutput.getFileFullPath())
                    .createDt(bannerOutput.getCreateDt())
                    .totalCount(bannerOutput.getTotalCount())
                    .seq(bannerOutput.getSeq())
                    .build();
        }
    }

}
