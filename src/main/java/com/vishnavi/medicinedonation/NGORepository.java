package com.vishnavi.medicinedonation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NGORepository extends JpaRepository<NGO, Long> {

    NGO findByEmailAndPassword(String email, String password);

}