package com.ensi.ilsi.myclinic.commons.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private LocalDateTime birthDate;
    private String gender;
    private Long consultationId;
    private Boolean enabled;
    private Long doctorId;
        
}
