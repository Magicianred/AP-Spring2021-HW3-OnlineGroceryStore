package com.company;

import java.time.LocalDate;
import org.json.simple.JSONObject;

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
        if (price < 0 || weight < 0)
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
        String result = "";
        return result;
    }

    public JSONObject toJson()
    {
        JSONObject product = new JSONObject();
        product.put("NAME", name);
        product.put("CATEGORY", category);
        product.put("WEIGHT", weight);
        product.put("PRICE", price);
        product.put("MANUFACTURE_DATE", manufactureDate.toString());
        product.put("EXPIRATION_DATE", expirationDate.toString());
        return product;
    }
}
