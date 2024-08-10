package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.BannerOpenType;
import lombok.Data;

public class BannerCreateDto {

    @Data
    public static class Request {
        private String title;
        private String linkUrl;
        private BannerOpenType openType;
        private Long orderNumber;
        private Boolean openYn;


        public BannerInput toBannerInput(String fileName) {
            return BannerInput.builder()
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
