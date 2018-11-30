package com.ensi.ilsi.myclinic.commons.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ConsultationDto {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long patientId; 
    private HospitalizationDto hospitalizationDto;
    private OrderDto orderDto;
    private PaymentDto paymentDto;
}
