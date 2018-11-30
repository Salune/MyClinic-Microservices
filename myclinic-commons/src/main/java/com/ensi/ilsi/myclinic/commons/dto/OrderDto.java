
package com.ensi.ilsi.myclinic.commons.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String observation;
    private String title;
    private String treatment;
    private LocalDateTime date;
    private ConsultationDto consultation;
   
	
}
