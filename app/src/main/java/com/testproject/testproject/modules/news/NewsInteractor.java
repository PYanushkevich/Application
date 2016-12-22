package com.testproject.testproject.modules.news;

import android.content.Context;

import com.testproject.testproject.core.models.ResponseModel;
import com.testproject.testproject.core.rest.NewsService;
import com.testproject.testproject.core.rest.RetrofitAbstractBuilder;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Response;



// Класс, осуществляющий взаимодействие с news.api с помощью Retrofit (REST-библиотека для Android)
public class NewsInteractor {

    //Callback. Извещает FeedFragment о том, что база новостей была обновлена
    public interface Callback {
        void onSuccess();
        void onFailure(final String error);
    }


    public static void updateNews(final Context context, final Callback callback) {

        final RetrofitAbstractBuilder builder  = new RetrofitAbstractBuilder(context);
        final NewsService service = builder.getNewsService();

        service.getNews().enqueue(new retrofit2.Callback<ResponseModel>() {
            @Override
            public void onResponse(final Call<ResponseModel> call, final Response<ResponseModel> response) {
                //Сохраняем все в реалм
                final Realm realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        // Говорим фрагменту что можно обновлять список новостей, база обновлена
                        realm.copyToRealmOrUpdate(response.body().getArticles());
                        callback.onSuccess();
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                //Если вдруг пришла ошибка, говорим фрагменту что нужно показать ошибку
                callback.onFailure(t.getMessage());
            }
        });

    }
}
