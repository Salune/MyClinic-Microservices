
package com.ensi.ilsi.myclinic.commons.dto;


import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String speciality;
    private Long patientId;
    
    
}
