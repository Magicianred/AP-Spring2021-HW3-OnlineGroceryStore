package com.company;

import java.time.LocalDate;

public class Product
{
    private String name;
    private String category;
    private double weight;
    private double price;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;

    public Product(String name, String category, double weight, double price,
                   LocalDate manufactureDate, LocalDate expirationDate)
    {
        if (manufactureDate.isAfter(expirationDate))
            return;

        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
    }

    public String getName() { return name; }

    public String getCategory() { return category; }

    public double getWeight() { return weight; }

    public double getPrice() { return price; }

    public LocalDate getManufactureDate() { return manufactureDate; }

    public LocalDate getExpirationDate() { return expirationDate; }

    @Override
    public String toString()
    {
        return "";
    }
}
