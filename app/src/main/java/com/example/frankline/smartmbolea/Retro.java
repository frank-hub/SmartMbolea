package com.example.frankline.smartmbolea;

import com.google.gson.annotations.SerializedName;

public class Retro {
    @SerializedName("id")
    private Integer id;
    @SerializedName("program_name")
    private String program_name;
    @SerializedName("farm_name")
    private String farm_name;

    public Retro(Integer id,String program_name,String farm_name){
        this.id = id;
        this.program_name = program_name;
        this.farm_name = farm_name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getFarm_name() {
        return farm_name;
    }

    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }


}
