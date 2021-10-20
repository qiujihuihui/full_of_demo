package com.module.base.ktdemo;

import java.util.List;

/**
 * @author Shenhui
 * @version 1.0
 * @since 2021/3/15  14:01
 */
public class Article
{
    private String title;
    private String author;
    private List<String> tags;
    private int pageSize;

    public Article() {
    }

    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
