package com.ensi.ilsi.myclinic.ConsultationService.domain;

import com.ensi.ilsi.myclinic.commons.domain.AbstractEntity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.*;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "hospitalization")
public class Hospitalization extends AbstractEntity {
    
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "endDate", nullable = false)
    private LocalDateTime endDate ;
    
    @OneToOne
    @JoinColumn(unique = true)
    private Consultation consultation;


    public Hospitalization() {
        // JPA
    }

    public Hospitalization(@NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate, Consultation consultation) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.consultation = consultation;
    }

}  