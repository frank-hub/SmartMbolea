package com.example.frankline.smartmbolea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<Retro> programData;
    private Context context;

    public CustomAdapter (Context context){
        this.context =context;
        this.programData = new ArrayList<>();
    }

    public void updateView(List<Retro> body) {
        this.programData.clear();
        this.programData.addAll(body);
        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView farm_name,program_name , id;

        CustomViewHolder(View programView){
            super(programView);
            mView = programView;

            farm_name = mView.findViewById(R.id.fname);
            program_name = mView.findViewById(R.id.prog_name);
            id = mView.findViewById(R.id.id);

        }
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_fertilizer, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
//        customViewHolder.id.setText(programData.get(i).getId());
        customViewHolder.program_name.setText(programData.get(i).getProgram_name());
        customViewHolder.farm_name.setText(programData.get(i).getFarm_name());

    }

    @Override
    public int getItemCount() {
        return programData.size();
    }

}
