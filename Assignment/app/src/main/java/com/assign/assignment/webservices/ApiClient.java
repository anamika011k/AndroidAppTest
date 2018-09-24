package com.assign.assignment.webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        //if(retrofit != null) {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // }
        return retrofit;
    }

}
