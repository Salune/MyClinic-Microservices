package com.ensi.ilsi.myclinic.ConsultationService.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import com.ensi.ilsi.myclinic.ConsultationService.domain.Consultation;
import com.ensi.ilsi.myclinic.ConsultationService.repository.ConsultationRepository;
import com.ensi.ilsi.myclinic.commons.dto.ConsultationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    public List<ConsultationDto> findAll() {
        log.debug("Request to get all Consultations");
        return this.consultationRepository.findAll()
                .stream()
                .map(ConsultationService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ConsultationDto findById(Long id) {
        log.debug("Request to get Consultation : {}", id);
        return this.consultationRepository.findById(id).map(ConsultationService::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }

    public ConsultationDto create(ConsultationDto consultationDto) {
        log.debug("Request to create Consultation : {}", consultationDto);
        return mapToDto(this.consultationRepository.save(new Consultation(
                        consultationDto.getStartDate(),
                        consultationDto.getEndDate(),
                        consultationDto.getPatientId(),
                       null,
                        null,
                        null
                        
                )
        ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Hopitalization : {}", id);
        this.consultationRepository.deleteById(id);
    }

    public static ConsultationDto mapToDto(Consultation consultation) {
        if (consultation != null) {
            return new ConsultationDto(
                    consultation.getId(),
                    consultation.getStartDate(),
                    consultation.getEndDate(),
                    consultation.getPatientId(),
                    HospitalizationService.mapToDto(consultation.getHospitalization()),
                    OrderService.mapToDto(consultation.getOrder()),
                    PaymentService.mapToDto(consultation.getPayment())
            );
        }
        return null;
    }

}
