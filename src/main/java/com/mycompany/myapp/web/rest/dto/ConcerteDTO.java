package com.mycompany.myapp.web.rest.dto;

import com.mycompany.myapp.domain.Participanti;

import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */
public class ConcerteDTO {


    public Long id;
    public String nume;
    public String location;
    public String data;
    public String description;
    public String attendants;
    public String picture;
    public int rating;
    public String concert_type;

    public ConcerteDTO(){}

    public ConcerteDTO(Long id, String nume, String location, String data, String description, String attendants, String picture, int rating, String concert_type) {
        this.id = id;
        this.nume = nume;
        this.location = location;
        this.data = data;
        this.description = description;
        this.attendants = attendants;
        this.picture = picture;
        this.rating = rating;
        this.concert_type = concert_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttendants() {
        return attendants;
    }

    public void setAttendants(String attendants) {
        this.attendants = attendants;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getConcert_type() {
        return concert_type;
    }

    public void setConcert_type(String concert_type) {
        this.concert_type = concert_type;
    }
}
