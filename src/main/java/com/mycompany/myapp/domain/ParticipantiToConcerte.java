package com.mycompany.myapp.domain;

import javax.persistence.*;

/**
 * Created by Costin on 20/12/2016.
 */
@Entity
@Table(name="participanti_to_concerte")
public class ParticipantiToConcerte {

    private Long id;
    private Concerte concerte;
    private Participanti participanti;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "FK_CONCERT", referencedColumnName = "ID", nullable = false)
    public Concerte getConcerte() {
        return concerte;
    }

    public void setConcerte(Concerte concerte) {
        this.concerte = concerte;
    }

    @ManyToOne
    @JoinColumn(name = "fk_participant", referencedColumnName = "ID", nullable = false)
    public Participanti getParticipanti() {
        return participanti;
    }

    public void setParticipanti(Participanti participanti) {
        this.participanti = participanti;
    }
}
