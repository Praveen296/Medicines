package com.assignment.saveo.medicines;

import com.assignment.saveo.medicines.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

}
