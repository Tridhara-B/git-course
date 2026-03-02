package com.ey.cms.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerResponseDTO {
    private Long id;
    private String company;
    private double price;
    private int RAM;
}
