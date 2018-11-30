
package com.ensi.ilsi.myclinic.ConsultationService.web;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.ensi.ilsi.myclinic.ConsultationService.service.ConsultationService;
import com.ensi.ilsi.myclinic.commons.dto.ConsultationDto;
import static com.ensi.ilsi.myclinic.commons.utils.Web.API;


@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/consultations")
public class ConsultationResource {

    private final ConsultationService consultationService;

    @GetMapping
    public List<ConsultationDto> findAll() {
        return this.consultationService.findAll();
    }

    @GetMapping("/{id}")
    public ConsultationDto findById(@PathVariable Long id) {
        return this.consultationService.findById(id);
    }

    @PostMapping
    public ConsultationDto create(ConsultationDto consultationDto) {
        return this.consultationService.create(consultationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.consultationService.delete(id);
    }
}
