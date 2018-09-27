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
import android.widget.Toast;

import com.assign.assignment.adapter.DataLodingAdapter;
import com.assign.assignment.model.FactsResponse;
import com.assign.assignment.model.Row;
import com.assign.assignment.utils.AppConstants;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

public class ListFragment extends Fragment implements MainContract.viewInterface, SwipeRefreshLayout.OnRefreshListener {
    View rootView;
   // private RecyclerView recyclerView;
    private DataLodingAdapter adapter;
    private MainContract.presenterInterface presenter;
    ArrayList<Row> mListData;
   // private SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    // refreshing the list on pull
    @BindView(R.id.refresh)
    public SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //handling configuration chnaged
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view, container, false);
        ButterKnife.bind(this, rootView);
        mInit();
        return rootView;
    }

    public void mInit(){
        swipeRefreshLayout.setOnRefreshListener(this);
        mListData = new ArrayList<>();
        this.presenter = new MainPresenter(this);
        //checking internet connect availability
        if (AppConstants.INSTANCE.isNetworkAvailable(getActivity())) {
            presenter.getListofdata();
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.internet_connection), Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }
    }

    @Override
    public void getListofArray(Response<FactsResponse> response) {
        if (response != null) {
            adapter = new DataLodingAdapter(getActivity(), response.body().getRows());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void onRefresh() {
        if (AppConstants.INSTANCE.isNetworkAvailable(getActivity())) {
            presenter.getListofdata();
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.internet_connection), Toast.LENGTH_SHORT).show();
        }
        swipeRefreshLayout.setRefreshing(false);


    }

}
