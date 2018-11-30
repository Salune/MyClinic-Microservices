
package com.ensi.ilsi.myclinic.ConsultationService.web;

import com.ensi.ilsi.myclinic.ConsultationService.service.OrderService;
import com.ensi.ilsi.myclinic.commons.dto.OrderDto;
import static com.ensi.ilsi.myclinic.commons.utils.Web.API;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/orders")
public class OrderResource {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

    @GetMapping("/orders")
    public List<OrderDto> findAllByUser(@PathVariable Long id) {
        return this.orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}
