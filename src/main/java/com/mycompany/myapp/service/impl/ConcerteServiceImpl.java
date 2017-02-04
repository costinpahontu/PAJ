package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Concerte;
import com.mycompany.myapp.repository.ConcerteRepository;
import com.mycompany.myapp.service.ConcerteService;
import com.mycompany.myapp.web.rest.dto.ConcerteDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */
@Service
@Transactional
public class ConcerteServiceImpl implements ConcerteService {

    @Inject
    private ConcerteRepository concerteRepository;

    @Override
    public List<ConcerteDTO> findAll() {
        List<Concerte> concertes =  concerteRepository.findAll();
        List<ConcerteDTO> concerteDTOs = new ArrayList<>();
        System.out.println(concertes);
        for(Concerte concerte : concertes){
            concerteDTOs.add(new ConcerteDTO(concerte.getId(),concerte.getNume(),concerte.getLocation(), concerte.getData(), concerte.getDescription(),
                concerte.getAttendants(), concerte.getPicture(),concerte.getRating(),concerte.getConcert_type()));
        }
        return concerteDTOs;
    }


    @Override
    public List<ConcerteDTO> findtopXconcertsByConcertType(String concertType) {
        List<Concerte> concertes =  concerteRepository.findXConcertsByConcertType(concertType);
        List<ConcerteDTO> concerteDTOs = new ArrayList<>();
        for(Concerte concerte : concertes){
            concerteDTOs.add(new ConcerteDTO(concerte.getId(),concerte.getNume(),concerte.getLocation(), concerte.getData(), concerte.getDescription(),
                concerte.getAttendants(), concerte.getPicture(),concerte.getRating(),concerte.getConcert_type()));
        }
        return concerteDTOs;
    }

    @Override
    public List<ConcerteDTO> findConcertByName(String name) {
        List<Concerte> concertes =  concerteRepository.findConcertByNume(name);
        List<ConcerteDTO> concerteDTOs = new ArrayList<>();
        for(Concerte concerte : concertes){
            concerteDTOs.add(new ConcerteDTO(concerte.getId(),concerte.getNume(),concerte.getLocation(), concerte.getData(), concerte.getDescription(),
                concerte.getAttendants(), concerte.getPicture(),concerte.getRating(),concerte.getConcert_type()));
        }
        return concerteDTOs;
    }

    @Override
    public List<ConcerteDTO> findConcertById(String concertId) {
        List<Concerte> concertes =  concerteRepository.findConcertById(new Long(concertId));
        List<ConcerteDTO> concerteDTOs = new ArrayList<>();
        for(Concerte concerte : concertes){
            concerteDTOs.add(new ConcerteDTO(concerte.getId(),concerte.getNume(),concerte.getLocation(), concerte.getData(), concerte.getDescription(),
                concerte.getAttendants(), concerte.getPicture(),concerte.getRating(),concerte.getConcert_type()));
        }
        return concerteDTOs;
    }

    @Override
    public List<ConcerteDTO> getConcertsByTypeForAllYear(String concertId) {
        List<Concerte> concertes =  concerteRepository.findXConcertsByConcertTypeRating4(concertId);
        List<ConcerteDTO> concerteDTOs = new ArrayList<>();
        for(Concerte concerte : concertes){
            concerteDTOs.add(new ConcerteDTO(concerte.getId(),concerte.getNume(),concerte.getLocation(), concerte.getData(), concerte.getDescription(),
                concerte.getAttendants(), concerte.getPicture(),concerte.getRating(),concerte.getConcert_type()));
        }
        return concerteDTOs;
    }

    @Override
    public String updateRatiing(Long id, int rating) {

        Concerte concerte = concerteRepository.findOne(id);
        concerte.setRating((rating + concerte.getRating()) / 2);

        try {
            concerteRepository.save(concerte);
        } catch (Exception e) {
            return null;
        }

        return "ok";

    }
}
