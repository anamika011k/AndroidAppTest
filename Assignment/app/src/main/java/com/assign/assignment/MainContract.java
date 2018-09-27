package com.assign.assignment;

import com.assign.assignment.model.FactsResponse;

import retrofit2.Response;

public interface  MainContract {

    interface presenterInterface {
        void getListofdata();
    }

    interface viewInterface{
        void getListofArray(Response<FactsResponse> response);
    }
}
