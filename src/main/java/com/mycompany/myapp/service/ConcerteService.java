package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Concerte;
import com.mycompany.myapp.web.rest.dto.ConcerteDTO;

import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */
public interface ConcerteService {

    List<ConcerteDTO> findConcertByName(String name);

    List<ConcerteDTO> findtopXconcertsByConcertType(String concertType);

    List<ConcerteDTO> findConcertById(String concertId);

    List<ConcerteDTO> getConcertsByTypeForAllYear(String concerType);


    List<ConcerteDTO> findAll();

    String updateRatiing(Long id, int rating);

}
