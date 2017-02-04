package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Concerte;
import com.mycompany.myapp.web.rest.dto.ConcerteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */

public interface  ConcerteRepository extends JpaRepository<Concerte,Long> {

    @Query("select c from Concerte c where c.nume =:nume")
    List<Concerte> findConcertByNume(@Param("nume") String nume);

   @Query("select c from Concerte c where c.id =:id")
    List<Concerte> findConcertById(@Param("id") Long id);


    @Query("SELECT c FROM Concerte c WHERE c.concert_type =:concertType AND c.rating > 7 ")
    List<Concerte> findXConcertsByConcertType(@Param("concertType") String concertType);


    @Query("SELECT c FROM Concerte c WHERE c.concert_type =:concertType AND c.rating > 4 ")
    List<Concerte> findXConcertsByConcertTypeRating4(@Param("concertType") String concertType);



}
