package com.ensi.ilsi.myclinic.DoctorService.service;



import com.ensi.ilsi.myclinic.DoctorService.domain.Doctor;
import com.ensi.ilsi.myclinic.DoctorService.repository.DoctorRepository;
import com.ensi.ilsi.myclinic.commons.dto.DoctorDto;

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
public class DoctorService {
    private final Logger log = LoggerFactory.getLogger(DoctorService.class);

    private final DoctorRepository doctorRepository;

   
    public DoctorDto create(DoctorDto doctorDto) {
        log.debug("Request to create Doctor : {}", doctorDto);
        return mapToDto(
                this.doctorRepository.save(
                        new Doctor(
                                        doctorDto.getId(),
                        		doctorDto.getFirstName(),
                        		doctorDto.getLastName(),
                        		doctorDto.getEmail(),
                        		doctorDto.getTelephone(),
                        		doctorDto.getSpeciality(),
                                        doctorDto.getPatientId()
                               
                        )
                )
        );
    }

    public List<DoctorDto> findAll() {
        log.debug("Request to get all Doctors");
        return this.doctorRepository.findAll()
                .stream()
                .map(DoctorService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DoctorDto findById(Long id) {
        log.debug("Request to get Doctor : {}", id);
        return this.doctorRepository.findById(id).map(DoctorService::mapToDto).orElse(null);
    }

    public List<DoctorDto> findAllBySpeciality(String speciality) {
        log.debug("Request to get all Doctors");
        return this.doctorRepository.findAllBySpeciality(speciality)
                .stream()
                .map(DoctorService::mapToDto)
                .collect(Collectors.toList());
    }


    public void delete(Long id) {
        log.debug("Request to delete Doctor : {}", id);

        Doctor doctor = this.doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Doctor with id " + id));

        
        this.doctorRepository.save(doctor);
    }

    public static DoctorDto mapToDto(Doctor doctor) {
        if (doctor != null) {
            return new DoctorDto(
            		doctor.getId(),
            		doctor.getFirstName(),
            		doctor.getLastName(),
            		doctor.getEmail(),
            		doctor.getTelephone(),
            		doctor.getSpeciality(),
                        doctor.getPatientId()
            		 );
        }
        return null;
    }

}
