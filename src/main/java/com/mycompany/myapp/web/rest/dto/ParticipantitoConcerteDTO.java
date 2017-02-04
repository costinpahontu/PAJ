package com.mycompany.myapp.web.rest.dto;

import com.mycompany.myapp.domain.Concerte;
import com.mycompany.myapp.domain.Participanti;

import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */
public class ParticipantitoConcerteDTO {

    public String concertId;
    public Concerte concerte;
    public List<ParticipantiDTO> participantiDTOs;

    public ParticipantitoConcerteDTO(String concertId) {
        this.concertId = concertId;
    }

    public ParticipantitoConcerteDTO(Concerte concerte) {
        this.concerte = concerte;
    }

    public ParticipantitoConcerteDTO(String concertId, List<ParticipantiDTO> participantiDTOs) {
        this.concertId = concertId;
        this.participantiDTOs = participantiDTOs;
    }

    public String getConcertId() {
        return concertId;
    }

    public void setConcertId(String concertId) {
        this.concertId = concertId;
    }

    public Concerte getConcerte() {
        return concerte;
    }

    public void setConcerte(Concerte concerte) {
        this.concerte = concerte;
    }

    public List<ParticipantiDTO> getParticipantiDTOs() {
        return participantiDTOs;
    }

    public void setParticipantiDTOs(List<ParticipantiDTO> participantiDTOs) {
        this.participantiDTOs = participantiDTOs;
    }
}
