package com.assign.assignment;

import com.assign.assignment.model.FactsResponse;
import com.assign.assignment.model.Row;
import com.assign.assignment.webservices.ApiClient;
import com.assign.assignment.webservices.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.presenterInterface {
    private ApiInterface apiService;
    ArrayList<Row> mListData;

    MainContract.viewInterface view;
    private String TAG = "MainPresenter";

    public MainPresenter(MainContract.viewInterface view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getListofdata() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<FactsResponse> call = apiService.getFactsResponse();

        call.enqueue(new Callback<FactsResponse>() {
            @Override
            public void onResponse(Call<FactsResponse> call, Response<FactsResponse> response) {
                if (response.code() == 200) {
                    if (response.body().getRows() != null) {
                      //  mListData.addAll(response.body().getRows());
                        view.getListofArray(response);

                    }
                }
            }

            @Override
            public void onFailure(Call<FactsResponse> call, Throwable t) {

            }
        });

    }
}
