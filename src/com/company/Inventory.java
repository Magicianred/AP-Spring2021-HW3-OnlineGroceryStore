package com.company;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.JSONObject;

public class Inventory
{
    private HashMap<Product, Integer> totalProducts;

    public Inventory()
    {
        totalProducts = new HashMap<>();
    }

    public void setTotalProducts(HashMap<Product, Integer> totalProducts) {
        this.totalProducts = totalProducts;
    }

    public HashMap<Product, Integer> getTotalProducts() {
        return totalProducts;
    }

    public int getStock(Product product) {
        return totalProducts.get(product);
    }

    public void add(Product product, int stock) {
        totalProducts.put(product, stock);
    }

    public void remove(Product product) {
        totalProducts.remove(product);
    }

    public void changeStock(Product product, int stock) {
        totalProducts.replace(product, stock);
    }

    public ArrayList<Product> getArrayListOfProducts() {
        return new ArrayList<>(totalProducts.keySet());
    }

    @Override
    public String toString()
    {
        // print a message if the list is empty
        if (totalProducts.isEmpty())
            return "List is empty";

        StringBuilder result = new StringBuilder();
        JSONObject inventory = new JSONObject();
        int i = 1;
        for (Map.Entry<Product, Integer> entry : totalProducts.entrySet())
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
