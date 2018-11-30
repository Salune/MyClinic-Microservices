package com.ensi.ilsi.myclinic.ConsultationService.service;
import com.ensi.ilsi.myclinic.ConsultationService.domain.Consultation;
import com.ensi.ilsi.myclinic.ConsultationService.domain.Payment;
import com.ensi.ilsi.myclinic.ConsultationService.enumeration.PaymentStatus;
import com.ensi.ilsi.myclinic.ConsultationService.repository.ConsultationRepository;
import com.ensi.ilsi.myclinic.ConsultationService.repository.PaymentRepository;
import com.ensi.ilsi.myclinic.commons.dto.PaymentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class PaymentService {
    private final Logger log = LoggerFactory.getLogger(PaymentService.class);
    private final PaymentRepository paymentRepository;
    private final ConsultationRepository consultationRepository;

    public List<PaymentDto> findAll() {
        log.debug("Request to get all Payments");
        return this.paymentRepository.findAll()
                .stream()
                .map(PaymentService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PaymentDto findById(Long id) {
        log.debug("Request to get Payment : {}", id);
        return this.paymentRepository.findById(id).map(PaymentService::mapToDto).orElse(null);
    }

    public PaymentDto create(PaymentDto paymentDto, Long ConsultationId) {
        log.debug("Request to create Payment : {}", paymentDto);
Consultation consultation = this.consultationRepository.findById(ConsultationId).orElseThrow(() -> new IllegalStateException("The Consultation does not exist!"));
        return mapToDto(this.paymentRepository.save(
                new Payment(
                        paymentDto.getCreditcardPaymentId(),
                        PaymentStatus.valueOf(paymentDto.getStatus()),
                        paymentDto.getTotalPrice(),
                        consultation
                )
        ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Payment : {}", id);
        this.paymentRepository.deleteById(id);
    }

    public static PaymentDto mapToDto(Payment payment) {
        if (payment != null) {
            return new PaymentDto(
                    payment.getId(),
                    payment.getCreditcardPaymentId(),
                    payment.getStatus().name(),
                    payment.getTotalPrice(),
                    ConsultationService.mapToDto(payment.getConsultation())
            );
        }
        return null;
    }
}