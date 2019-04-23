package com.example.erp01.model;

public class EmbStore {

    private Integer embStoreID;

    private String embStoreLocation;

    private Integer embStoreCount;

    public EmbStore(Integer embStoreID, String embStoreLocation, Integer embStoreCount) {
        this.embStoreID = embStoreID;
        this.embStoreLocation = embStoreLocation;
        this.embStoreCount = embStoreCount;
    }

    public EmbStore(String embStoreLocation, Integer embStoreCount) {
        this.embStoreLocation = embStoreLocation;
        this.embStoreCount = embStoreCount;
    }

    public EmbStore() {
    }

    public Integer getEmbStoreID() {
        return embStoreID;
    }

    public void setEmbStoreID(Integer embStoreID) {
        this.embStoreID = embStoreID;
    }

    public String getEmbStoreLocation() {
        return embStoreLocation;
    }

    public void setEmbStoreLocation(String embStoreLocation) {
        this.embStoreLocation = embStoreLocation;
    }

    public Integer getEmbStoreCount() {
        return embStoreCount;
    }

    public void setEmbStoreCount(Integer embStoreCount) {
        this.embStoreCount = embStoreCount;
    }
}
