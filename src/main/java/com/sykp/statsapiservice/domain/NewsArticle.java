package com.sykp.statsapiservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsArticle {

    private NewsSource source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    @JsonCreator
    public NewsArticle(@JsonProperty("source") NewsSource source,
                       @JsonProperty("author") String author,
                       @JsonProperty("title") String title,
                       @JsonProperty("description") String description,
                       @JsonProperty("url") String url,
                       @JsonProperty("urlToImage") String urlToImage,
                       @JsonProperty("publishedAt") String publishedAt,
                       @JsonProperty("content") String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public NewsSource getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }
}

