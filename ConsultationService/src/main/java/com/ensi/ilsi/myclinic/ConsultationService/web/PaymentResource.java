
package com.ensi.ilsi.myclinic.ConsultationService.web;

import com.ensi.ilsi.myclinic.ConsultationService.service.PaymentService;
import com.ensi.ilsi.myclinic.commons.dto.PaymentDto;
import static com.ensi.ilsi.myclinic.commons.utils.Web.API;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/payments")
public class PaymentResource {

    private final PaymentService paymentService;
    
    @GetMapping()
    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }

    @PostMapping()
    public PaymentDto create(@RequestBody PaymentDto consultationDto, Long id) {
        return this.paymentService.create(consultationDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }
}
