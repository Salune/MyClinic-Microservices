package com.ensi.ilsi.myclinic.ConsultationService.service;

import com.ensi.ilsi.myclinic.ConsultationService.domain.Consultation;
import com.ensi.ilsi.myclinic.ConsultationService.domain.Order;
import com.ensi.ilsi.myclinic.ConsultationService.repository.OrderRepository;
import com.ensi.ilsi.myclinic.commons.dto.OrderDto;
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
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
   

    public List<OrderDto> findAll() {
        log.debug("Request to get all Orders");
        return this.orderRepository.findAll()
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        log.debug("Request to get Order : {}", id);
        return this.orderRepository.findById(id).map(OrderService::mapToDto).orElse(null);
    }


    public OrderDto create(OrderDto orderDto) {
        log.debug("Request to create Order : {}", orderDto);
        return mapToDto(
                this.orderRepository.save(
                        new Order(
                                null,
                                null,
                                null,
                                null,
                                null,null
                        )
                )
        );
    }

    public Order create(Consultation cart) {
        log.debug("Request to create Order with a Cart : {}", cart);
        return this.orderRepository.save(
                new Order(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                            )
        );
    }

    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        this.orderRepository.deleteById(id);
    }


    public static OrderDto mapToDto(Order order) {
        if (order != null) {
            return new OrderDto(
                    order.getId(),
                    order.getObservation(),
                    order.getTitle(),
                    order.getTreatment(),
                    order.getDate(),
                    ConsultationService.mapToDto(order.getConsultation())
                     );
        }
        return null;
    }
}
