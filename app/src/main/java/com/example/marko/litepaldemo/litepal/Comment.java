package com.example.marko.litepaldemo.litepal;

import org.litepal.crud.LitePalSupport;

/**
 * @author Marko
 * @date 2018/7/13
 */

public class Comment extends LitePalSupport{

    private Book book;
    private int id;
    private String name;

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

}
