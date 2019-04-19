package com.example.frankline.smartmbolea;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FertilizerPrograms extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_programs);

        generateDataList(new ArrayList<Retro>());
        progressDialog = new ProgressDialog(FertilizerPrograms.this);
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Retro>> call = service.getAllProgram();
        call.enqueue(new Callback<List<Retro>>() {
            @Override
            public void onResponse(Call<List<Retro>> call, Response<List<Retro>> response) {
                progressDialog.dismiss();
                Log.e("Vibe",""+response.toString());
                setData(response.body());
            }

            @Override
            public void onFailure(Call<List<Retro>> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("LostVibe", t.getLocalizedMessage());
                Toast.makeText(FertilizerPrograms.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setData(List<Retro> body) {
        adapter.updateView(body);
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Retro> programList){
        recyclerView = findViewById(R.id.program_recycler);
        adapter = new CustomAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FertilizerPrograms.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(FertilizerPrograms.this));

    }
}
