package com.example.marko.litepaldemo.litepal;


import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko
 * @date 2018/7/12
 * 新版本继承自LitePalSupport，老版本继承自DataSupport
 */

public class Book extends LitePalSupport{
    /**
     * 在Book类中得到一个对应的Introduction的实例，那么它们之间就是一对一关系了
     */
    private Introduction introduction;

    /**
     * Comment和Book是多对一的关系，因此Book中应该包含多个Comment，而Comment中应该只有一个Book
     * 先使用一个泛型为Comment的List集合来表示Book中包含多个Comment，然后在Comment类中声明一个Book的实例
     */
    private List<Comment> commentList = new ArrayList<>();

    /**
     * 同时在Book类和Category类中声明一个集合，表示Book和Category是多对多的关系
     */
    private List<Category> categoryList = new ArrayList<>();
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;

    //新增press（出版社），用于升级数据库
    private String press;

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
