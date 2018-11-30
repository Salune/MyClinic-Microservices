package com.ensi.ilsi.myclinic.ConsultationService.service;
import com.ensi.ilsi.myclinic.ConsultationService.domain.Consultation;
import com.ensi.ilsi.myclinic.ConsultationService.domain.Hospitalization;
import com.ensi.ilsi.myclinic.ConsultationService.repository.ConsultationRepository;
import com.ensi.ilsi.myclinic.ConsultationService.repository.HospitalizationRepository;
import com.ensi.ilsi.myclinic.commons.dto.HospitalizationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class HospitalizationService {

    private final Logger log = LoggerFactory.getLogger(HospitalizationService.class);

    private final HospitalizationRepository hospitalizationRepository;
    private final ConsultationRepository consultationRepository;
    public List<HospitalizationDto> findAll() {
        log.debug("Request to get all Hospitalizations");
        return this.hospitalizationRepository.findAll()
                .stream()
                .map(HospitalizationService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public HospitalizationDto findById(Long id) {
        log.debug("Request to get Hospitalization : {}", id);
        return this.hospitalizationRepository.findById(id).map(HospitalizationService::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }

    public HospitalizationDto create(HospitalizationDto hospitalizationDto,Long consultationId) {
        log.debug("Request to create Hopitalization : {}", hospitalizationDto);
        
        Consultation consultation = this.consultationRepository.findById(consultationId).
                orElseThrow(() -> new IllegalStateException("The Consultation does not exist!"));
                
        
        return mapToDto(this.hospitalizationRepository.save(new Hospitalization(
                        hospitalizationDto.getStartDate(),
                        hospitalizationDto.getEndDate(),
                        consultation
                        
                )
        ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Hopitalization : {}", id);
        this.hospitalizationRepository.deleteById(id);
    }

    public static HospitalizationDto mapToDto(Hospitalization hospitalization) {
        if (hospitalization != null) {
            return new HospitalizationDto(
                    hospitalization.getId(),
                    hospitalization.getStartDate(),
                    hospitalization.getEndDate(),
                    ConsultationService.mapToDto(hospitalization.getConsultation())
            );
        }
        return null;
    }

}
