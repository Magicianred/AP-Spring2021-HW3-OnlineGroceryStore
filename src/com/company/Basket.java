package com.company;

import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 * This class represents a costumer's basket.
 * A costumer chooses a product and the product is added to an ArrayList.
 * Costumers can also remove products from their basket.
 * This class contains a method to calculate the total amount of money
 * that the costumer should pay for the chosen products.
 * @author KIMIA
 * @version 1.0
 * @since 15/4/2021
 */
public class Basket
{
    private ArrayList<Product> products;

    /**
     * This is the constructor of the class. It creates a new ArrayList
     * to store the costumers chosen products and allocates memory.
     */
    public Basket() {
        products = new ArrayList<>();
    }

    /**
     * A getter for the ArrayList of products.
     * @return the ArrayList of products
     */
    public ArrayList<Product> getProducts() { return products; }

    /**
     * A setter that sets the ArrayList of products to the given parameter.
     * @param products a new ArrayList of products
     */
    public void setProducts(ArrayList<Product> products) { this.products = products; }

    /**
     * This method adds a product to the basket.
     * It prints an error message if the inventory is out of the given product.
     * @param product the product to add to the basket
     * @param inventory the current inventory
     */
    public void addProduct(Product product, Inventory inventory)
    {
        int stock = inventory.getStock(product);          // get the current stock of the product
        if (stock == 0)                                   // check if the inventory has the product
        {
            System.out.println("We're out of " + product.getName() + "!");
            return;
        }
        inventory.changeStock(product, stock - 1);  // decrement the product's stock by 1
        products.add(product);                            // add the product to the cart
        System.out.println(product.getName() + " added to your basket.");
    }

    /**
     * Removes the ith product from the list and moves it back to the inventory by incrementing its stock.
     * @param i the index of the product inside the basket
     * @param inventory the current inventory
     */
    public void removeProduct(int i, Inventory inventory)
    {
        // check if the index is out of boundary or not
        if (i < 0 || i >= products.size())
        {
            System.out.println("Invalid index!");
            return;
        }
        Product product = products.get(i);                   // get the product using its index
        int stock = inventory.getStock(product);             // get the current stock of the product
        inventory.changeStock(product, stock + 1);     // increment the product's stock by 1
        System.out.println(product.getName() + " removed.");
        products.remove(product);                            // remove the product from the cart
    }

    /**
     * This method calculates the whole fee.
     * @return the total price of the chosen products
     */
    public double totalPrice()
    {
        double total = 0;
        // iterate the products in the basket and add each product's price to total variable
        for (Product p : products)
            total += p.getPrice();

        return total;
    }

    /**
     * This method iterates the products, converts them into json object
     * and creates a String in json format.
     * @return the basket's information in String
     */
    @Override
    public String toString()
    {
        // print a message if the list is empty
        if (products.isEmpty())
            return "List is empty";

        StringBuilder result = new StringBuilder();
        result.append("Itemsincart:\n");
        JSONObject basket = new JSONObject();
        int i = 1;
        // iterate the products ArrayList and convert each product into json string format
        for (Product p : products)
        {
            result.append(i).append("){");
            basket.put("Product", p.toJsonObject());
            result.append(basket.toJSONString()).append("}\n");
            i++;
        }

        return result.toString();
    }
}
