package com.example.frankline.smartmbolea;

import com.example.frankline.smartmbolea.SoilAnalysisRetro.SoilRetro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {
    @GET("api/programs")
    Call<List<Retro>> getAllProgram();

    @POST("api/save_soil_test")
    Call<SoilRetro> saveSoilTest(@Body SoilRetro soilRetro);

    @GET("api/soil_tests")
    Call<List<SoilRetro>> getAllSoilTest();
}
