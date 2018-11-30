package com.ensi.ilsi.myclinic.DoctorService.repository;

import com.ensi.ilsi.myclinic.DoctorService.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findAllBySpeciality(String specialiy);

}
