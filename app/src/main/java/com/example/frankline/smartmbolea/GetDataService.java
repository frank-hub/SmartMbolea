package com.example.frankline.smartmbolea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("api/programs")
    Call<List<Retro>> getAllProgram();
}
