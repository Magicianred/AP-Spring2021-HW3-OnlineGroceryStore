package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 * This class represents an inventory. It contains a HashMap of products and
 * it maps each product to its stock in the inventory.
 * This class provides methods to add or remove products from the list or
 * change the number of remaining items.
 * @author KIMIA
 * @version 1.0
 * @since 4-15-2021
 */
public class Inventory
{
    private HashMap<Product, Integer> products;

    /**
     * Inventory's constructor creates a new HashMap for the products
     * and allocates memory.
     */
    public Inventory() {
        products = new HashMap<>();
    }

    /**
     * Sets the HashMap of products to the given parameter.
     * @param products a HashMap of products and the number of each product
     */
    public void setTotalProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    /**
     * Getter for the HashMap of products.
     * @return the HashMap of products and the stock of each product
     */
    public HashMap<Product, Integer> getTotalProducts() {
        return products;
    }

    /**
     * This method finds the stock of the given product
     * @param product the product to find it's number
     * @return the stock of the given product in the inventory, or null if the product didn't exist
     */
    public Integer getStock(Product product)
    {
        if (products.containsKey(product))
            return products.get(product);

        return null;
    }

    /**
     * Adds a product to the hashMap and maps the product to the given integer.
     * @param product the product to add to the HashMap
     * @param stock the number of the products to add
     */
    public void add(Product product, int stock) {
        products.put(product, stock);
    }

    /**
     * Removes a product from the HashMap.
     * @param product the product to remove from the HashMap
     */
    public void remove(Product product) {
        products.remove(product);
    }

    /**
     * This method changes the number of the remaining items of the given product.
     * @param product the product to change its remaining items
     * @param stock the new number of items for the product
     */
    public void changeStock(Product product, int stock) {
        products.replace(product, stock);
    }

    /**
     * This method finds a product by a given index.
     * @param index the index of the wanted product
     * @return the wanted product found in the HashMap, or null if the index is out of boundary
     */
    public Product getProductByIndex(int index)
    {
        // check the validity of the index
        if (index < 0 || index >= products.size()) {
            System.out.println("Invalid index.");
            return null;
        }

        Product product = null;
        // an iterator object to iterate a set of Products
        Iterator<Product> itr = products.keySet().iterator();
        // iterate the HashMap's keySet for "index" times to find the product
        for (int i = 0; i <= index; i++) {
            product = itr.next(); // move on to the next product
        }
        return product;
    }

    /**
     * This method converts all the information of inventory into a String in json format.
     * @return a String containing the information of each product inside the inventory
     */
    @Override
    public String toString()
    {
        // print a message if the list is empty
        if (products.isEmpty())
            return "List is empty";

        StringBuilder result = new StringBuilder();
        // the json object that the inventory is converted to
        JSONObject inventory = new JSONObject();
        int i = 1;
        for (Map.Entry<Product, Integer> entry : products.entrySet())
        {
            // There are 2 JSONObjects here -> inventory & product.toJson
            result.append(i).append("){");
            inventory.put("Product", entry.getKey().toJsonObject());
            inventory.put("instock", entry.getValue());
            result.append(inventory.toJSONString()).append("}\n");
            i++;
        }

        return result.toString();
    }
}
