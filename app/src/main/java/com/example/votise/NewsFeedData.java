package com.example.votise;

public class NewsFeedData {
    private String newsTitle;
    private String newsContent;
    private String newsProvider;
    private String imageUrl;
    private String newsUrl;

    public NewsFeedData(String newsTitle, String newsContent, String newsProvider, String imageUrl, String newsUrl) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsProvider = newsProvider;
        this.imageUrl = imageUrl;
        this.newsUrl = newsUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsProvider() {
        return newsProvider;
    }

    public void setNewsProvider(String newsProvider) {
        this.newsProvider = newsProvider;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }
}
