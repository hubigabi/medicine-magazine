package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    private Long id;
    private String name;
    private LocalDate expirationDate;
    private int packagesNumberInMagazine;
}