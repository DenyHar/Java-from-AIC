package org.example.pwt_lab5;

import jakarta.persistence.*;
import org.hibernate.annotations.*;

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
@FilterDefs({
    @FilterDef(name = "pageType", parameters = @ParamDef(name = "pPageType", type = String.class)),
    @FilterDef(name = "pages", parameters = @ParamDef(name = "pPages", type = Integer.class)),
    @FilterDef(name = "circulation", parameters = @ParamDef(name = "pCirculation", type = Long.class))
})
@Filters({
    @Filter(name = "pageType", condition = "page = :pPageType"),
    @Filter(name = "pages", condition = "pages >= :pPages"),
    @Filter(name = "circulation", condition = "circulation >= :pCirculation")
})

public class Notepad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String publisher;
    protected String name;
    protected int pages;
    protected String cover;
    protected String country;
    protected long circulation;
    protected String page;

    public Notepad() {
    }
    public Notepad(String publisher, String name,int pages, String cover, String country, long circulation, String page) {
        this.publisher = publisher;
        this.name = name;
        this.pages = pages;
        this.cover = cover;
        this.country = country;
        this.circulation = circulation;
        this.page = page;
    }

    public Notepad(long id, String publisher, String name, int pages, String cover, String country, int circulation, String page) {
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
    public String getCover() {return cover;}
    public void setCover(String cover) {this.cover = cover;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public long getCirculation() {return circulation;}
    public void setCirculation(long circulation) {this.circulation = circulation;}
    public String getPage() {return page;}
    public void setPage(String page) {this.page = page;}

    public String toString(){
        return publisher + "; " + country  + "; " + pages + "; " + page + "; " + cover + "; " + circulation;
    }
}

