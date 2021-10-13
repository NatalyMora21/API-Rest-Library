package com.sofka.biblioteca.dtos;

import com.sofka.biblioteca.collections.values.Thematic;
import com.sofka.biblioteca.collections.values.Type;

import java.util.Date;

public class ResourceDTO {

    private String id;
    private String title;
    private Type type;
    private Thematic thematic;
    private Boolean available;
    private Date date;

    public ResourceDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Thematic getThematic() {
        return thematic;
    }

    public void setThematic(Thematic thematic) {
        this.thematic = thematic;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
