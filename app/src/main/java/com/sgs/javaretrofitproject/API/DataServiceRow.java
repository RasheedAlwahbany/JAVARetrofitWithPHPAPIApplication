package com.sgs.javaretrofitproject.API;

import android.telecom.Call;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataServiceRow {
    @SerializedName("News")
    List<DataServiceRow> data;

    @SerializedName("id")
    Integer id;

    @SerializedName("name")
    String name;

    @SerializedName("description")
    String description;

    @SerializedName("Manager")
    String Manager;

    @SerializedName("response")
    String response;

    public DataServiceRow(String manager) {
        this.Manager = manager;
    }

    public DataServiceRow(Integer id, String name, String descrition, String manager) {
        this.id = id;
        this.name = name;
        this.description = descrition;
        this.Manager=manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DataServiceRow> getData() {
        return data;
    }

    public void setData(List<DataServiceRow> data) {
        this.data = data;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
