package com.ensi.ilsi.myclinic.ConsultationService.repository;

import com.ensi.ilsi.myclinic.ConsultationService.domain.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
}
