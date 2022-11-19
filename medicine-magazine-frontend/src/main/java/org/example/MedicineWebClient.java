package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log
public class MedicineWebClient {

    private static final String MEDICINES_ENDPOINT = "http://localhost:8080/api/medicines";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Medicine> getMedicines() throws Exception {
        ResponseEntity<String> entity = restTemplate.getForEntity(MEDICINES_ENDPOINT, String.class);
        List<Medicine> medicines = objectMapper.readValue(entity.getBody(), new TypeReference<>() {
        });

        if (medicines == null) {
            throw new Exception("No medicines...");
        }
        log.info(medicines.toString());
        return medicines;
    }

}
