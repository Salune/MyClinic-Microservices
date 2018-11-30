package com.ensi.ilsi.myclinic.commons.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class HospitalizationDto {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ConsultationDto consultation;
    
   
}
