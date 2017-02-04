package com.mycompany.myapp.service;

import com.mycompany.myapp.web.rest.dto.ConcerteDTO;
import com.mycompany.myapp.web.rest.dto.ParticipantitoConcerteDTO;

import java.util.List;

/**
 * Created by Costin on 1/13/2016.
 */
public interface PArticipantoToConcerteService {

    List<ParticipantitoConcerteDTO> findByPartiipantsByConcertId(String concertId);

}
