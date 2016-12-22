package com.testproject.testproject.core.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

// Модель для получения ответа с news.api
@JsonObject
public class ResponseModel {
    @JsonField
    private String status;
    @JsonField
    private String source;
    @JsonField
    private String sortBy;

    // Список новостей
    @JsonField
    private List<NewsModel> articles;

    public void setArticles(List<NewsModel> articles) {
        this.articles = articles;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NewsModel> getArticles() {
        return articles;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSource() {
        return source;
    }

    public String getStatus() {
        return status;
    }
}
