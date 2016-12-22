package com.testproject.testproject.core.rest;

import android.content.Context;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;
import com.testproject.testproject.R;

import retrofit2.Retrofit;



//RetrofitBuilder. Содержит в себе на данный момент newsService. Использование смотри в NewsInteractor.
public class RetrofitAbstractBuilder {
    private Retrofit retrofit;
    private NewsService newsService;

    public RetrofitAbstractBuilder(final Context context) {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(LoganSquareConverterFactory.create()).baseUrl(context.getString(R.string.base_url))
                .build();
        newsService = retrofit.create(NewsService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public NewsService getNewsService() {
        return  newsService;
    }
}
