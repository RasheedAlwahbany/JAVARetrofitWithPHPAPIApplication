package com.sgs.javaretrofitproject.API;

import com.google.gson.annotations.SerializedName;

public class DataServiceRow {
    @SerializedName("id")
    Integer id;

    @SerializedName("name")
    String name;

    @SerializedName("description")
    String description;

    public DataServiceRow(Integer id, String name, String descrition) {
        this.id = id;
        this.name = name;
        this.description = descrition;
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
}
