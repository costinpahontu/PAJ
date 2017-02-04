package com.mycompany.myapp.domain;

import javax.persistence.*;

/**
 * Created by Costin on 20/12/2016.
 */
@Entity
@Table(name="Participanti")
public class Participanti {

    private Long id;
    private String nume;
    private String prenume;

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

    @Column(name="Prenume")
    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}
