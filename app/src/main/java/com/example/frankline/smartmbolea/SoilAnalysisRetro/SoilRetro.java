package com.example.frankline.smartmbolea.SoilAnalysisRetro;

import com.google.gson.annotations.SerializedName;

public class SoilRetro {

    //    '','soil_test_name','layer_depth','ec','field_name','soil_lab',
//            'cec','ph','test_date','bulk_density','avg_temp','soil_texture','om'
    @SerializedName("farm_name")
    private String farm_name;
    @SerializedName("soil_test_name")
    private String soil_test_name;
    @SerializedName("layer_depth")
    private Integer layer_depth;
    @SerializedName("ec")
    private Integer ec;
    @SerializedName("field_name")
    private String field_name;
    @SerializedName("soil_lab")
    private String soil_lab;
    @SerializedName("cec")
    private Integer cec;
    @SerializedName("ph")
    private Integer ph;
    @SerializedName("test_date")
    private String test_date;
    @SerializedName("bulk_density")
    private Integer bulk_density;
    @SerializedName("avg_temp")
    private Integer avg_temp;
    @SerializedName("soil_texture")
    private String soil_texture;
    @SerializedName("om")
    private Integer om;

    public SoilRetro(){

    }

    public SoilRetro(String farm_name,String soil_test_name,Integer layer_depth,
                     Integer ec,String field_name,String soil_lab,Integer cec,
                     Integer ph,String test_date,Integer bulk_density,Integer avg_temp,String soil_texture,
                     Integer om){
        this.farm_name = farm_name;
        this.soil_test_name = soil_test_name;
        this.layer_depth = layer_depth;
        this.ec = ec;
        this.field_name = field_name;
        this.soil_lab = soil_lab;
        this.cec = cec;
        this.ph = ph;
        this.test_date = test_date;
        this.bulk_density = bulk_density;
        this.avg_temp = avg_temp;
        this.soil_texture = soil_texture;
    }


    public String getFarm_name() {
        return farm_name;
    }

    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }

    public String getSoil_test_name() {
        return soil_test_name;
    }

    public void setSoil_test_name(String soil_test_name) {
        this.soil_test_name = soil_test_name;
    }

    public Integer getLayer_depth() {
        return layer_depth;
    }

    public void setLayer_depth(Integer layer_depth) {
        this.layer_depth = layer_depth;
    }

    public Integer getEc() {
        return ec;
    }

    public void setEc(Integer ec) {
        this.ec = ec;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getSoil_lab() {
        return soil_lab;
    }

    public void setSoil_lab(String soil_lab) {
        this.soil_lab = soil_lab;
    }

    public Integer getCec() {
        return cec;
    }

    public void setCec(Integer cec) {
        this.cec = cec;
    }

    public Integer getPh() {
        return ph;
    }

    public void setPh(Integer ph) {
        this.ph = ph;
    }

    public String getTest_date() {
        return test_date;
    }

    public void setTest_date(String test_date) {
        this.test_date = test_date;
    }

    public Integer getBulk_density() {
        return bulk_density;
    }

    public void setBulk_density(Integer bulk_density) {
        this.bulk_density = bulk_density;
    }

    public Integer getAvg_temp() {
        return avg_temp;
    }

    public void setAvg_temp(Integer avg_temp) {
        this.avg_temp = avg_temp;
    }

    public String getSoil_texture() {
        return soil_texture;
    }

    public void setSoil_texture(String soil_texture) {
        this.soil_texture = soil_texture;
    }

    public Integer getOm() {
        return om;
    }

    public void setOm(Integer om) {
        this.om = om;
    }

}
