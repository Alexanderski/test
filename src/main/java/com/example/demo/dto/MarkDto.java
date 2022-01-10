package com.example.demo.dto;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class MarkDto {
    private String name;
    private int id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model",orphanRemoval=true)
    private List<ModelDto> models;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "store",orphanRemoval=true)
    private List<StoreDto> stores;

    public MarkDto(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public List<ModelDto> getModels() {
        return models;
    }

    public void setModels(List<ModelDto> models) {
        this.models = models;
    }

    public MarkDto() {
        models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<StoreDto> getStores() {
        return stores;
    }

    public void setStores(List<StoreDto> stores) {
        this.stores = stores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MarkDto{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", models=" + models +
                '}';
    }
}
