package com.ensi.ilsi.myclinic.ConsultationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensi.ilsi.myclinic.ConsultationService.domain.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
