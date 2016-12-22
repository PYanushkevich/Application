package com.testproject.testproject.core.rest;


import com.testproject.testproject.core.models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


//Сервис для получение новостей. Содержит в себе описание запросов к серверу news.api. Использование смотри в NewsInteractor

public interface NewsService {
    @GET("articles?source=bloomberg&apiKey=e486c9fa05814ed79ef90e009b799a89")
    public Call<ResponseModel> getNews();
}
