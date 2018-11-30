/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.myclinic.DoctorService.web;



import com.ensi.ilsi.myclinic.DoctorService.service.DoctorService;
import com.ensi.ilsi.myclinic.commons.dto.DoctorDto;
import static com.ensi.ilsi.myclinic.commons.utils.Web.API;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@RequestMapping(API + "/doctors")
public class DoctorResource {

    private final DoctorService doctorService;

    public DoctorResource(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> findAll() {
        return this.doctorService.findAll();
    }

    @GetMapping("/{id}")
    public DoctorDto findById(@PathVariable Long id) {
        return this.doctorService.findById(id);
    }

    

    @GetMapping("/speciality")
    public List<DoctorDto> findAllInactive(String speciality) {
        return this.doctorService.findAllBySpeciality(speciality);
    }

    @PostMapping
    public DoctorDto create(DoctorDto doctorDto) {
        return this.doctorService.create(doctorDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.doctorService.delete(id);
    }

}