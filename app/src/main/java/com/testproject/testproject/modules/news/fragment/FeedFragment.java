package com.testproject.testproject.modules.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testproject.testproject.R;
import com.testproject.testproject.core.models.NewsModel;
import com.testproject.testproject.modules.news.NewsInteractor;
import com.testproject.testproject.modules.news.adapter.NewsAdapter;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class FeedFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsInteractor.Callback {

    //Штука для рефреша, когда тянем вниз
    private SwipeRefreshLayout refreshLayout;

    //Адаптер для списка новостей
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_feed, null);
        if (view != null) {
            refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
            refreshLayout.setOnRefreshListener(this);

            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            final RecyclerView newsList = (RecyclerView) view.findViewById(R.id.newsListView);

            newsAdapter = new NewsAdapter(getActivity());

            newsList.setAdapter(newsAdapter);
            newsList.setLayoutManager(llm);
        }
        return view;
    }


    //Используем обновление при onResume, чтобы каждый раз когда открывался фрагмент показывалась свежая инфа
    @Override
    public void onResume() {
        super.onResume();
        updateNews();
    }

    //Listener для SwipeRefreshLayout (когда тянем вниз, запускаем обновление базы данных)
    @Override
    public void onRefresh() {
        NewsInteractor.updateNews(getActivity(), this);
    }

    //Пришел ответ с ошибкой из NewsInteractor
    @Override
    public void onFailure(String error) {
        refreshLayout.setRefreshing(false);
        //Show error to user
    }

    //Все ок, пришли новости, обновляем список
    @Override
    public void onSuccess() {
        refreshLayout.setRefreshing(false);
        updateNews();
    }

    //Метод обновляет список (достает из Realm, туда уже записаны новости)
    private void updateNews() {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<NewsModel> news = realm.where(NewsModel.class).findAllSorted("publishedAt", Sort.DESCENDING);
        newsAdapter.updateData(news);
    }
}
