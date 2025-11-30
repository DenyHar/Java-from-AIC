package org.example.pwt_lab5;

import jakarta.persistence.*;
enum CoverType {
    HARD,
    SOFT
}
enum PageType {
    BLANK,
    LINE,
    CELL
}
@Entity
@Table
public class Notepad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String publisher;
    protected String name;
    protected int pages;
    protected CoverType cover;
    protected String country;
    protected long circulation;
    protected PageType page;

    public Notepad() {
    }
    public Notepad(String publisher, String name,int pages, CoverType cover, String country, long circulation, PageType page) {
        this.publisher = publisher;
        this.name = name;
        this.pages = pages;
        this.cover = cover;
        this.country = country;
        this.circulation = circulation;
        this.page = page;
    }

    public Notepad(long id, String publisher, String name, int pages, CoverType cover, String country, int circulation, PageType page) {
        this.id = id;
        this.publisher = publisher;
        this.name = name;
        this.pages = pages;
        this.cover = cover;
        this.country = country;
        this.circulation = circulation;
        this.page = page;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getPublisher() {return publisher;}
    public void setPublisher(String publisher) {this.publisher = publisher;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPages() {return pages;}
    public void setPages(int pages) {this.pages = pages;}
    public CoverType getCover() {return cover;}
    public void setCover(CoverType cover) {this.cover = cover;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public long getCirculation() {return circulation;}
    public void setCirculation(long circulation) {this.circulation = circulation;}
    public PageType getPage() {return page;}
    public void setPage(PageType page) {this.page = page;}

    public String toString(){
        return publisher + "; " + country  + "; " + pages + "; " + page.toString().toLowerCase() + "; " + cover.toString().toLowerCase();
    }
}

