package com.example.datamongo_1828;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Item {
    @Id
    private int id;
    private List<String> tags;

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

    public Item id(final int id) {
        this.id = id;
        return this;
    }

    public Item tags(final List<String> tags) {
        this.tags = tags;
        return this;
    }
}
