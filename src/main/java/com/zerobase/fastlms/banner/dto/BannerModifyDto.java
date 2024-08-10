package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.BannerOpenType;
import lombok.Data;

public class BannerModifyDto {

    @Data
    public static class Request {
        private Long id;
        private String title;
        private String linkUrl;
        private BannerOpenType openType;
        private Long orderNumber;
        private Boolean openYn;
        private String fileName;

        public BannerInput toBannerInput() {
            return BannerInput.builder()
                    .id(id)
                    .title(title)
                    .linkUrl(linkUrl)
                    .openType(openType)
                    .orderNumber(orderNumber)
                    .openYn(openYn)
                    .fileName(fileName)
                    .build();
        }


    }

}
