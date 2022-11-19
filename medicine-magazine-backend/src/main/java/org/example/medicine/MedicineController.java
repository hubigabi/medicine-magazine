package org.example.medicine;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
@Log
public class MedicineController {

    private final MedicineRepository medicineRepository;

    @GetMapping("/medicines")
    public List<Medicine> getMedicines() {
        log.info("Processing request...");
        return medicineRepository.findAll().stream()
                .filter(medicine -> Math.random() > 0.5) // Added some randomness
                .toList();
    }

}
