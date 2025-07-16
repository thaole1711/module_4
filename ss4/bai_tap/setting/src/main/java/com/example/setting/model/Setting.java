package com.example.setting.model;

public class Setting {
    private String language;
    private int pageSize;
    private boolean spam;
    private String signature;

    public Setting() {
    }

    public Setting(String language, int pageSize, boolean spam, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spam = spam;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
