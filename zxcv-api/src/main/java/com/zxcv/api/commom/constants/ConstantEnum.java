package com.zxcv.api.commom.constants;

public enum ConstantEnum {
    INDEX_URL("http://localhost:63342/boot-cloud-pages/micro-website-master/zxcv_index/index.html");

    private String key;

    ConstantEnum(String key) {
        this.key = key;
    }

    public String key() {
        return this.key;
    }
}
