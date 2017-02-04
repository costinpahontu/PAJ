package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.ConcerteService;
import com.mycompany.myapp.service.PArticipantoToConcerteService;
import com.mycompany.myapp.web.rest.dto.ConcerteDTO;
import com.mycompany.myapp.web.rest.dto.ParticipantitoConcerteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ParticipantsResource {

    @Inject
    private ConcerteService concerteService;

    @Inject
    private PArticipantoToConcerteService pArticipantoToConcerteService;


    @RequestMapping(value = "/participantiLaConcert/{id}",
        method = RequestMethod.GET,
        produces =  MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ParticipantitoConcerteDTO>> findByPartiipantsByConcertId(@PathVariable("id") String concertId){
        List<ParticipantitoConcerteDTO> all = pArticipantoToConcerteService.findByPartiipantsByConcertId(concertId);
        return new ResponseEntity<List<ParticipantitoConcerteDTO>>(all, HttpStatus.OK);
    }
}
