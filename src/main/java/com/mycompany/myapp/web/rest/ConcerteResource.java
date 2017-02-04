package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.domain.Concerte;
import com.mycompany.myapp.repository.ParticipantiToConcerteRepository;
import com.mycompany.myapp.service.ConcerteService;
import com.mycompany.myapp.web.rest.dto.ConcerteDTO;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */
@RestController
@RequestMapping("/api")
public class ConcerteResource {

    @Inject
    private ConcerteService concerteService;


    @RequestMapping(value = "/concerte",
        method = RequestMethod.GET,
        produces =  MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ConcerteDTO>> all(){
        List<ConcerteDTO> all = concerteService.findAll();
        return new ResponseEntity<List<ConcerteDTO>>(all, HttpStatus.OK);
    }


    @RequestMapping(value = "/concerte/name/{name}",
            method = RequestMethod.GET,
            produces =  MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ConcerteDTO>> findByName(@PathVariable("name") String name){
        List<ConcerteDTO> all = concerteService.findConcertByName(name);
        return new ResponseEntity<List<ConcerteDTO>>(all, HttpStatus.OK);
    }


    @RequestMapping(value = "/concertebyConcertType/{concertType}",
            method = RequestMethod.GET,
            produces =  MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ConcerteDTO>> findByConcetType(@PathVariable("concertType") String concertType){
        List<ConcerteDTO> all = concerteService.findtopXconcertsByConcertType(concertType);
        return new ResponseEntity<List<ConcerteDTO>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/concert/{id}",
            method = RequestMethod.GET,
            produces =  MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ConcerteDTO>> findConcertById(@PathVariable("id") String concertId){
        List<ConcerteDTO> all = concerteService.findConcertById(concertId);
        return new ResponseEntity<List<ConcerteDTO>>(all, HttpStatus.OK);
    }


    @RequestMapping(value = "/generateRaport/{idGen}/{idPref}",
            method = RequestMethod.GET,
            produces =  MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ConcerteDTO>> getListOfConcertsforAllYear(@PathVariable("idGen") String idGen, @PathVariable("idPref") String idPref){
        List<ConcerteDTO> all = new ArrayList<>();
        List<ConcerteDTO> combo1;
        List<ConcerteDTO> combo2;

        if(idGen == idPref){
            all = concerteService.getConcertsByTypeForAllYear(idGen);

        }else{
            combo1 = concerteService.getConcertsByTypeForAllYear(idGen);
            combo2 = concerteService.getConcertsByTypeForAllYear(idPref);
            all.addAll(combo1);
            all.addAll(combo2);


        }


        return new ResponseEntity<List<ConcerteDTO>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/concert",
            method = RequestMethod.POST,
            produces =  MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<String> updateRating(@RequestBody ConcerteDTO concerteDTO ){

        String result = concerteService.updateRatiing(concerteDTO.getId(), concerteDTO.getRating());
        System.out.println(result);
        if( result != null){
            return  new ResponseEntity<String>(HttpStatus.OK);
        }else {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }


}
