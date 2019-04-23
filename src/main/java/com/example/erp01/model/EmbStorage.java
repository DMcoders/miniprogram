package com.example.erp01.model;

public class EmbStorage {

    private Integer embStorageID;

    private String embStoreLocation;

    private String tailorQcode;

    private Integer embStorageState;

    private Integer embStoreCount;

    private Integer embStorageQueryCount;

    public Integer getEmbStorageQueryCount() {
        return embStorageQueryCount;
    }

    public void setEmbStorageQueryCount(Integer embStorageQueryCount) {
        this.embStorageQueryCount = embStorageQueryCount;
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

    public EmbStorage(String embStoreLocation, Integer embStorageState, Integer embStoreCount) {
        this.embStoreLocation = embStoreLocation;
        this.embStorageState = embStorageState;
        this.embStoreCount = embStoreCount;
    }


    public EmbStorage(String embStoreLocation, Integer embStorageState) {
        this.embStoreLocation = embStoreLocation;
        this.embStorageState = embStorageState;
    }

    public Integer getEmbStorageState() {
        return embStorageState;
    }

    public void setEmbStorageState(Integer embStorageState) {
        this.embStorageState = embStorageState;
    }

    public EmbStorage(String embStoreLocation, String tailorQcode) {
        this.embStoreLocation = embStoreLocation;
        this.tailorQcode = tailorQcode;
    }

    public EmbStorage(Integer embStorageID, String embStoreLocation, String tailorQcode) {
        this.embStorageID = embStorageID;
        this.embStoreLocation = embStoreLocation;
        this.tailorQcode = tailorQcode;
    }

    public EmbStorage() {
    }

    public Integer getEmbStorageID() {
        return embStorageID;
    }

    public void setEmbStorageID(Integer embStorageID) {
        this.embStorageID = embStorageID;
    }


    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
