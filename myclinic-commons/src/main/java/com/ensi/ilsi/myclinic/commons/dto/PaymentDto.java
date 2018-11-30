
package com.ensi.ilsi.myclinic.commons.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private String creditcardPaymentId;
    private String status;
    private BigDecimal totalPrice;
    private ConsultationDto consultation;

    
}
