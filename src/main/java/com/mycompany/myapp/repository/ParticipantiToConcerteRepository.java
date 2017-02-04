package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Concerte;
import com.mycompany.myapp.domain.ParticipantiToConcerte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Costin on 20/12/2016.
 */
public interface ParticipantiToConcerteRepository extends JpaRepository<ParticipantiToConcerte,Long> {

    @Query("select c from ParticipantiToConcerte c where c.concerte.id =:id")
    List<ParticipantiToConcerte> findAllByFK_Concert(@Param("id") Long id);

}
