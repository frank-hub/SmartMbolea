package com.example.frankline.smartmbolea;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.frankline.smartmbolea.SoilAnalysisRetro.SoilRetro;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddSoilTest extends Fragment {

    ProgressDialog progressDialog;
    EditText farm_name,field_name,test_name,soil_lab,
    layer_depth,cec,ec,ph,date,bulk_density,avg_temp,soil_texture;
    EditText om,p,k,ca,mg,s,b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_soil_test,container,false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        farm_name = (EditText) rootView.findViewById(R.id.farm_name);
        field_name = (EditText) rootView.findViewById(R.id.field_name);
        test_name = (EditText) rootView.findViewById(R.id.soil_test_name);
        soil_lab = (EditText) rootView.findViewById(R.id.soil_lab);
        layer_depth = (EditText) rootView.findViewById(R.id.layer_depth);
        cec = (EditText) rootView.findViewById(R.id.cec);
        ec = (EditText) rootView.findViewById(R.id.ec);
        ph = (EditText) rootView.findViewById(R.id.ph);
        date = (EditText) rootView.findViewById(R.id.date);
        bulk_density = (EditText) rootView.findViewById(R.id.bulk_density);
        avg_temp = (EditText) rootView.findViewById(R.id.avg_temp);
        soil_texture = (EditText) rootView.findViewById(R.id.soil_texture);

        om = (EditText) rootView.findViewById(R.id.nitrogen);
        p = (EditText) rootView.findViewById(R.id.phos);
        k = (EditText) rootView.findViewById(R.id.potasium);
        ca = (EditText) rootView.findViewById(R.id.calcium);
        mg = (EditText) rootView.findViewById(R.id.mg);
        s = (EditText) rootView.findViewById(R.id.sulphur);
        b = (EditText) rootView.findViewById(R.id.boron);

        Button submit = (Button) rootView.findViewById(R.id.submit_soil_test);
        final GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer layer_d = Integer.parseInt(layer_depth.getText().toString());
                Integer ec_int = Integer.parseInt(ec.getText().toString());
                Integer cec_int = Integer.parseInt(cec.getText().toString());
                Integer ph_int = Integer.parseInt(ph.getText().toString());
                Integer bulk_density_int = Integer.parseInt(bulk_density.getText().toString());
                Integer avg_tem = Integer.parseInt(avg_temp.getText().toString());
                Integer om_int = Integer.parseInt(om.getText().toString());


                progressDialog.show();
                SoilRetro soilRetro = new SoilRetro();
                soilRetro.setFarm_name(farm_name.getText().toString());
                soilRetro.setSoil_test_name(test_name.getText().toString());
                soilRetro.setLayer_depth(layer_d);
                soilRetro.setEc(ec_int);
                soilRetro.setField_name(field_name.getText().toString());
                soilRetro.setSoil_lab(soil_lab.getText().toString());
                soilRetro.setCec(cec_int);
                soilRetro.setPh(ph_int);
                soilRetro.setTest_date(date.getText().toString());
                soilRetro.setBulk_density(bulk_density_int);
                soilRetro.setAvg_temp(avg_tem);
                soilRetro.setSoil_texture(soil_texture.getText().toString());
                soilRetro.setOm(om_int);

                sendSoilTest(soilRetro);
            }

            private void sendSoilTest(SoilRetro soilRetro) {
                Call<SoilRetro> call = service.saveSoilTest(soilRetro);
                call.enqueue(new Callback<SoilRetro>() {
                    @Override
                    public void onResponse(Call<SoilRetro> call, Response<SoilRetro> response) {
                        if (response.isSuccessful()){

                            Toast.makeText(getActivity(),"Soil Test Saved Successfully",Toast.LENGTH_SHORT).show();
                            Log.e("Vibe", ""+response.body().toString());
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<SoilRetro> call, Throwable t) {

                        Toast.makeText(getActivity(),"Unable to submit Try again",Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        return rootView;
    }
}