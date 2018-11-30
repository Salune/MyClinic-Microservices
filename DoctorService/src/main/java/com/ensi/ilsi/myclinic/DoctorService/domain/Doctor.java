package com.ensi.ilsi.myclinic.DoctorService.domain;

import com.ensi.ilsi.myclinic.commons.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "doctor")
public class Doctor extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

      
    @Column(name = "speciality", nullable = false)
    private String speciality;

   private Long patientId;

     
}
