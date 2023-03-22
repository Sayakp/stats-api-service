package com.sykp.statsapiservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private List<NewsArticle> articles;

    @JsonCreator
    public NewsResponse(@JsonProperty("status") String status,
                        @JsonProperty("totalResults") int totalResults,
                        @JsonProperty("articles") List<NewsArticle> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<NewsArticle> getArticles() {
        return articles;
    }
}
