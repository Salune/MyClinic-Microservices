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
@Table(name = "consultation")
public class Consultation extends AbstractEntity {
    
    
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
    private Hospitalization hospitalization;
    
    
    @OneToOne
    @JoinColumn(unique = true)
    private Order order;
    
    
    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

        
    private Long patientId;
    
    public Consultation() {
        // JPA
    }

    public Consultation(LocalDateTime startDate, @NotNull LocalDateTime endDate, Long patientId, Hospitalization hospitalization, Order order, Payment payment) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.patientId = patientId;
        this.hospitalization = hospitalization;
        this.order = order;
        this.payment = payment;
    }

}