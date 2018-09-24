package com.assign.assignment;

import com.assign.assignment.model.FactsResponse;

import retrofit2.Response;

public interface  MainContract {

    interface presenterInterface {
        void onDestroy();
        void getListofdata();
    }

    interface viewInterface{
        void showProgress();
        void hideProgress();
        void getListofArray(FactsResponse response);

        void getListofArray(Response<FactsResponse> response);
    }
}
