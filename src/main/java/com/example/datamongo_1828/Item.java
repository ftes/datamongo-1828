package com.example.datamongo_1828;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Item {
    @Id
    private int id;
    private List<String> tags;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item id(final int id) {
        this.id = id;
        return this;
    }

    public Item tags(final List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Item name(final String name) {
        this.name = name;
        return this;
    }
}
