package com.ensi.ilsi.myclinic.ConsultationService.repository;

import com.ensi.ilsi.myclinic.ConsultationService.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
