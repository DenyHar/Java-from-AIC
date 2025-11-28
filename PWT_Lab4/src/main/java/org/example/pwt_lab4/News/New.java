package org.example.pwt_lab4.News;

import java.util.List;

public class New {
    private String name;
    private String date;
    private String description;
    private List<String> photo_urls;

    public New(String name, String date, String description, List<String> photo_urls) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.photo_urls = photo_urls;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getPhoto_urls() {
        return photo_urls;
    }
    public void setPhoto_urls(List<String> photo_urls) {
        this.photo_urls = photo_urls;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", photo_urls=" + photo_urls +
                '}';
    }

}
