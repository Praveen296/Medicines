package com.assignment.saveo.medicines;

import com.assignment.saveo.medicines.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    String line = "";

    public void addMedicines() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/Product list - Sheet1.csv"));
            int lineNumber = 0;
            while((line = bufferedReader.readLine()) != null) {
                if(lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                String[] data = line.split(",");
                Medicine medicine = new Medicine();
                medicine.setC_name(data[0]);
                medicine.setC_batch_no(data[1]);
                medicine.setD_expiry_date(data[2]);
                medicine.setN_balance_qty(Integer.parseInt(data[3]));
                medicine.setC_packaging(data[4]);
                medicine.setC_unique_code(data[5]);
                medicine.setC_schemes(data[6]);
                medicine.setN_mrp(Double.parseDouble(data[7]));
                medicine.setC_manufacturer(data[8]);
                medicine.setHsn_code(data[9]);
                medicineRepository.save(medicine);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
