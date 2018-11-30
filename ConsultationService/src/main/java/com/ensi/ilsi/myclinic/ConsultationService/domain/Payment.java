package com.ensi.ilsi.myclinic.ConsultationService.domain;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ensi.ilsi.myclinic.ConsultationService.enumeration.PaymentStatus;
import com.ensi.ilsi.myclinic.commons.domain.AbstractEntity;

import java.util.Objects;
import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "payment")
public class Payment extends AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Column(name = "creditcard_payment_id")
    private String creditcardPaymentId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @OneToOne
    @JoinColumn(unique = true)
    private Consultation consultation;

    public Payment() {
        // JPA
    }
   

    public Payment(String creditcardPaymentId, @NotNull PaymentStatus status, BigDecimal totalPrice, Consultation consultation) {
        this.creditcardPaymentId = creditcardPaymentId;
        this.status = status;
        this.totalPrice= totalPrice;
        this.consultation = consultation;
    }
    
}
