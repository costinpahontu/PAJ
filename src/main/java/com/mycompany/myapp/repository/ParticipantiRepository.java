package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Participanti;
import com.mycompany.myapp.domain.ParticipantiToConcerte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */
public interface ParticipantiRepository extends JpaRepository<Participanti,Long> {

    @Query("select c from Participanti c where c.id =:id")
    List<Participanti> findParticipantbyId(@Param("id") Long id);

}
