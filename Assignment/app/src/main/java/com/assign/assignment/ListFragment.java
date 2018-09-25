package com.assign.assignment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assign.assignment.adapter.DataLodingAdapter;
import com.assign.assignment.model.FactsResponse;
import com.assign.assignment.model.Row;

import java.util.ArrayList;

import retrofit2.Response;

public class ListFragment extends Fragment implements MainContract.viewInterface, SwipeRefreshLayout.OnRefreshListener {
    View rootView;
    private RecyclerView recyclerView;
    private DataLodingAdapter adapter;
    private MainContract.presenterInterface presenter;
    ArrayList<Row> mListData;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        // refreshing the list on pull
        swipeRefreshLayout = rootView.findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        mListData = new ArrayList<>();
        this.presenter = new MainPresenter(this);
        presenter.getListofdata();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void getListofArray(Response<FactsResponse> response) {

        if (response != null) {
            adapter = new DataLodingAdapter(getActivity(), response.body().getRows());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
            ;
        } else {
        }

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);

    }

}
