
package com.ensi.ilsi.myclinic.ConsultationService.web;

import com.ensi.ilsi.myclinic.ConsultationService.service.HospitalizationService;
import com.ensi.ilsi.myclinic.commons.dto.HospitalizationDto;
import static com.ensi.ilsi.myclinic.commons.utils.Web.API;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/hospitalizations")
public class HospitalizationResource {

    private final HospitalizationService hospitalizationService;

    @GetMapping
    public List<HospitalizationDto> findAll() {
        return this.hospitalizationService.findAll();
    }

    @GetMapping("/{id}")
    public HospitalizationDto findById(@PathVariable Long id) {
        return this.hospitalizationService.findById(id);
    }

    @PostMapping
    public HospitalizationDto create(HospitalizationDto hospitalizationDto, Long id) {
        return this.hospitalizationService.create(hospitalizationDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.hospitalizationService.delete(id);
    }
}
