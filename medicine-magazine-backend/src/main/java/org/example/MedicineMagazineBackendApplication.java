package org.example;

import com.github.javafaker.Faker;
import com.github.javafaker.Medical;
import lombok.extern.java.Log;
import org.example.medicine.Medicine;
import org.example.medicine.MedicineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@Log
public class MedicineMagazineBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicineMagazineBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(MedicineRepository medicineRepository) {
        return args -> {
            Medical medical = new Faker().medical();

            List<Medicine> medicines = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                int days = ThreadLocalRandom.current().nextInt(1, 1000);
                int packagesNumberInMagazine = ThreadLocalRandom.current().nextInt(1, 100);
                Medicine medicine = new Medicine(0L, medical.medicineName(), LocalDate.now().plusDays(days), packagesNumberInMagazine);
                medicines.add(medicine);
            }

            medicines = medicineRepository.saveAll(medicines);
            log.info("Finished initializing data...");
            for (Medicine medicine : medicines) {
                log.info(medicine.toString());
            }
        };
    }

}
