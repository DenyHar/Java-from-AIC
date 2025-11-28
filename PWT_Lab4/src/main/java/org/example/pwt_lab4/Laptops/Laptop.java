package org.example.pwt_lab4.Laptops;

import java.util.List;

public class Laptop {
    private String name;
    private String description;
    private String cpu;
    private String ram;
    private String storage;
    private List<String> photo_urls;

     public Laptop(String name, String description, String cpu, String ram, String storage, List<String> photo_urls) {
         this.name = name;
         this.description = description;
         this.cpu = cpu;
         this.ram = ram;
         this.storage = storage;
         this.photo_urls = photo_urls;
     }
     public String getName() {
         return name;
     }
     public void setName(String name) {
         this.name = name;
     }
     public String getDescription() {
         return description;
     }
     public void setDescription(String description) {
         this.description = description;
     }
     public String getCpu() {
         return cpu;
     }
     public void setCpu(String cpu) {
         this.cpu = cpu;
     }
     public String getRam() {
         return ram;
     }
     public void setRam(String ram) {
         this.ram = ram;
     }
     public String getStorage() {
         return storage;
     }
     public void setStorage(String storage) {
         this.storage = storage;
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
                 ", description='" + description + '\'' +
                 ", CPU='" + cpu + '\'' +
                 ", RAM='" + ram + '\'' +
                 ", photo_urls=" + photo_urls +
                 '}';
     }
}
