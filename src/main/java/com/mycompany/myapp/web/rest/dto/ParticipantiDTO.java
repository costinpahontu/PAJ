package com.mycompany.myapp.web.rest.dto;

import com.mycompany.myapp.domain.Participanti;

/**
 * Created by Costin on 20/12/2016.
 */
public class ParticipantiDTO {

    public Long id;
    public String name;
    public String prenume;

    public ParticipantiDTO(){}

    public ParticipantiDTO(Participanti participanti) {
        this.id = participanti.getId();
        this.name = participanti.getNume();
        this.prenume = participanti.getPrenume();
    }

    public ParticipantiDTO(Long id, String name, String prenume) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}
