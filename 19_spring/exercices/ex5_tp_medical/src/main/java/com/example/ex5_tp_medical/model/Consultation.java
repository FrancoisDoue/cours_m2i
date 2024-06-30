package com.example.ex5_tp_medical.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Consultation {
    private int id;
    private LocalDate consultationDate;
    private String reason;
//
//    private void setConsultationDate(String date) {
//        this.consultationDate = LocalDate.parse(date);
//    }
}
