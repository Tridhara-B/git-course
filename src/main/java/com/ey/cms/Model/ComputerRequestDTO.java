package com.ey.cms.Model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerRequestDTO {
    private String company;
    private double price;
    private int RAM;

}
