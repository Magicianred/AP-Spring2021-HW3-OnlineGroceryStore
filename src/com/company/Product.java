package com.company;

import java.time.LocalDate;
import org.json.simple.JSONObject;

/**
 * This class represents a product. Each product has a name, category, weight, price and date.
 * LocalDate is used to store the manufacture and expiration date of products.
 * This class generates the product's information both in String format and json.
 * @author KIMIA
 * @version 1.0
 * @since 4/15/2021
 */
public class Product
{
    private String name;
    private String category;
    private double weight;
    private double price;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;

    /**
     * This is the constructor of Product. The constructor checks if the given numbers,
     * (price and weight) are positive numbers. It also checks whether the expiration date is
     * after manufacture date or not.
     * @param name the product's name
     * @param category the category in which the product belongs to
     * @param weight the product's weight
     * @param price the product's price
     * @param manufactureDate the date in which the product was made
     * @param expirationDate the date in which the product is going to expire
     */
    public Product(String name, String category, double weight, double price,
                   LocalDate manufactureDate, LocalDate expirationDate)
    {
        // making sure the parameters are valid
        if (manufactureDate.isAfter(expirationDate)) {
            System.out.println("Dates are not valid.");
            return;
        }
        if (price < 0 || weight < 0) {
            System.out.println("Product's price or weight are not positive.");
            return;
        }
        // assign each field to its corresponding parameter
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
    }

    /**
     * Getter for name attribute.
     * @return the name of the product
     */
    public String getName() { return name; }

    /**
     * Getter for category attribute.
     * @return the category of the product
     */
    public String getCategory() { return category; }

    /**
     * Getter for weight attribute.
     * @return the weight of the product
     */
    public double getWeight() { return weight; }

    /**
     * Getter for the price attribute.
     * @return the price of the product
     */
    public double getPrice() { return price; }

    /**
     * Getter for the manufactureDate attribute
     * @return the manufacture date in LocalDate format
     */
    public LocalDate getManufactureDate() { return manufactureDate; }

    /**
     * Getter for the expirationDate attribute.
     * @return the expiration date in LocalDate format
     */
    public LocalDate getExpirationDate() { return expirationDate; }

    /**
     * Overridden toString method from Object class.
     * @return all the fields into a String form, separated by a line (\n)
     */
    @Override
    public String toString()
    {
        return "name: " + name + "\ncategory: " + category + "\nweight: " + weight
                + "\nprice: " + price + "\nmanufacture date: " + manufactureDate.toString()
                + "\nexpiration date : " + expirationDate.toString();
    }

    /**
     * This method converts all the product's field into json object and returns the object.
     * json-simple-1.1 is used here to create json objects.
     * @return the json format of the product
     */
    public JSONObject toJsonObject()
    {
        JSONObject product = new JSONObject();
        product.put("NAME", name);
        product.put("CATEGORY", category);
        product.put("WEIGHT", weight);
        product.put("PRICE", price);
        product.put("MANUFACTURE_DATE", manufactureDate.toString());
        product.put("EXPIRATION_DATE", expirationDate.toString());
        return product;
        // json-simple rearranges the elements (the output is not in the above order)
    }
}
