package com.ensi.ilsi.myclinic.DoctorService.service;


import com.ensi.ilsi.myclinic.commons.dto.DoctorDto;
import com.ensi.ilsi.myclinic.commons.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@FeignClient(name = "patient-service")
public interface PatientServiceClient {

    @RequestMapping(value = "/api/patients", method = POST)
    PatientDto create(DoctorDto doctorDto);

}

