package com.assign.assignment.webservices;

import com.assign.assignment.model.FactsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("facts.json")
    Call<FactsResponse> getFactsResponse();
}
