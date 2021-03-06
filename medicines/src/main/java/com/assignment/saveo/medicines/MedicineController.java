package com.assignment.saveo.medicines;

import com.assignment.saveo.medicines.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/")
    public String home() {
        return "Home Page";
    }

    @PostMapping("/uploadCSV")
    public void sendData() {
        medicineService.addMedicines();
    }
}
