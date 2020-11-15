package com.oc.p12.Bean.Dto.PublicTransport.Stations;

public class Station {

    public String name;

    public String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }
}
