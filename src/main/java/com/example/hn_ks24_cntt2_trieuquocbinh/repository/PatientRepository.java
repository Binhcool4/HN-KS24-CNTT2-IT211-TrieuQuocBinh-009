package com.example.hn_ks24_cntt2_trieuquocbinh.repository;

import com.example.hn_ks24_cntt2_trieuquocbinh.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByIdAndDeletedFalse(Long id);

    Page<Patient> findAllByDeletedFalse(Pageable pageable);

    @Query("select p from Patient p where p.deleted = false and (lower(p.fullName) like lower(concat('%', :keyword, '%')) or lower(p.disease) like lower(concat('%', :keyword, '%')))")
    Page<Patient> searchActive(@Param("keyword") String keyword, Pageable pageable);
}

