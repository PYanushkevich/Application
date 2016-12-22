package com.testproject.testproject.core.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.Date;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;


//Модель новости
//Аннотация для Realm
@RealmClass

// Аннотация для LoganSquare (он он сам парсит JSON в эту модельку)
@JsonObject
public class NewsModel implements RealmModel {

    @PrimaryKey private long id;
    @JsonField
    private String author;
    @JsonField
    private String title;
    @JsonField
    private String description;
    @JsonField
    private String url;
    @JsonField
    private String urlToImage;
    @JsonField
    private Date publishedAt;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;

        // WARNING генерируем сами уникальный ключ из дескрипшна, т.к. news.api не дает его.
        // ключ нужен для того, чтобы при обновлении одинаковые новости не дублировались.
        // Решение так себе :)
        this.id = description.hashCode();
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
