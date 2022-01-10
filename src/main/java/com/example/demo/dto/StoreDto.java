package com.example.demo.dto;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class StoreDto {
    private int id;
    private String name;

    @OneToOne(mappedBy = "mark", cascade = CascadeType.REMOVE)
    private int mark_id;


    public StoreDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StoreDto(int id, String name, int mark_id) {
        this.id = id;
        this.name = name;
        this.mark_id = mark_id;
    }

    public StoreDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark_id() {
        return mark_id;
    }

    public void setMark_id(int mark_id) {
        this.mark_id = mark_id;
    }

    @Override
    public String toString() {
        return "StoreDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark_id=" + mark_id +
                '}';
    }
}

