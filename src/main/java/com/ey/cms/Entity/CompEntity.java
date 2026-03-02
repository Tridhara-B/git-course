package com.ey.cms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Table(name ="Computer_info")

@AllArgsConstructor
@NoArgsConstructor
public class CompEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name ="Company", nullable = false)
    private String company;
    @Column (name ="Price", nullable = false)
    private double price;
    @Column (name ="RAM", nullable = false)
    private int RAM;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", RAM=" + RAM +
                '}';
    }
}
