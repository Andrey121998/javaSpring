package ru.nnov.nntu.vst.demo.models.contentauthor;

import jakarta.persistence.Entity;

@Entity
public class Books extends Content{
    private int pagecount;

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
}
