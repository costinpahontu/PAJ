package com.mycompany.myapp.domain;

import javax.persistence.*;

/**
 * Created by Costin on 20/12/2016.
 */
@Entity
@Table(name="CONCERTE")
public class Concerte {

    private Long id;
    private String nume;
    private String location;
    private String data;
    private String description;
    private String attendants;
    private String picture;
    private int rating;
    private String concert_type;




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="NUME")
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Column(name="rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Column(name="LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name="DATA")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="ATTENDANTS")
    public String getAttendants() {
        return attendants;
    }

    public void setAttendants(String attendants) {
        this.attendants = attendants;
    }

    @Column(name="PICTURE")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name="concert_type")
    public String getConcert_type() {
        return concert_type;
    }

    public void setConcert_type(String concert_type) {
        this.concert_type = concert_type;
    }
}
