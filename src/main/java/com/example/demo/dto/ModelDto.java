package com.example.demo.dto;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ModelDto {
    private int id;
    private String name;
    @JoinColumn (name = "mark")
    @ManyToOne (cascade = CascadeType.REMOVE)
    private int mark_id;

    public ModelDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getMark_id() {
        return mark_id;
    }

    public void setMark_id(int mark_id) {
        this.mark_id = mark_id;
    }

    public ModelDto(int id, String name, int mark_id) {
        this.id = id;
        this.name = name;
        this.mark_id = mark_id;
    }

    public ModelDto() {
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

    @Override
    public String toString() {
        return "ModelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
