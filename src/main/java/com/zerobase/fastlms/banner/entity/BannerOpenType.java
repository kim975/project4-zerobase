package com.zerobase.fastlms.banner.entity;

public enum BannerOpenType {

    BLANK("_blank"),
    SELF("_self");

    public final String openType;

    BannerOpenType(String openType) {
        this.openType = openType;
    }
}
