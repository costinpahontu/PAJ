package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Concerte;
import com.mycompany.myapp.domain.Participanti;
import com.mycompany.myapp.domain.ParticipantiToConcerte;
import com.mycompany.myapp.repository.ConcerteRepository;
import com.mycompany.myapp.repository.ParticipantiRepository;
import com.mycompany.myapp.repository.ParticipantiToConcerteRepository;
import com.mycompany.myapp.service.ConcerteService;
import com.mycompany.myapp.service.PArticipantoToConcerteService;
import com.mycompany.myapp.web.rest.dto.ConcerteDTO;
import com.mycompany.myapp.web.rest.dto.ParticipantiDTO;
import com.mycompany.myapp.web.rest.dto.ParticipantitoConcerteDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Costin on 1/13/2016.
 */
@Service
@Transactional
public class PArticipantoToConcerteServiceImpl implements PArticipantoToConcerteService {


    @Inject
    private ParticipantiToConcerteRepository participantiToConcerteRepository;

    @Inject
    private ParticipantiRepository participantiRepository;



    @Override
    public List<ParticipantitoConcerteDTO> findByPartiipantsByConcertId(String concertId) {
        List<ParticipantiToConcerte> participantiToConcertes =  participantiToConcerteRepository.findAllByFK_Concert(new Long(concertId));


        List<ParticipantiDTO> participantis1 = new ArrayList<>();
        List<ParticipantitoConcerteDTO> participantitoConcerteDTOs = new ArrayList<>();


        for(ParticipantiToConcerte participantiToConcerte : participantiToConcertes){

           List<Participanti> participantis =  participantiRepository.findParticipantbyId(participantiToConcerte.getParticipanti().getId());

            participantis1.add( new ParticipantiDTO(participantis.get(0)));
        }

        participantitoConcerteDTOs.add(new ParticipantitoConcerteDTO(concertId, participantis1));
        return participantitoConcerteDTOs;
    }
}
