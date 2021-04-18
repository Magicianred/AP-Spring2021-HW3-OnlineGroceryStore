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

    public HashMap<Product, Integer> getTotalProducts() { return totalProducts; }

    public int getStock(Product product)
    {
        return totalProducts.get(product);
    }

    public void add(Product product, int stock)
    {
        totalProducts.put(product, stock);
    }

    public void remove(Product product)
    {
        totalProducts.remove(product);
    }

    public void changeStock(Product product, int stock)
    {
        totalProducts.replace(product, stock);
    }

    @Override
    public String toString()
    {
        String result = "";
        return result;
    }

    public ArrayList<Product> displayInJsonFormat()
    {
        if (totalProducts.isEmpty())
        {
            System.out.println("List is empty");
            return null;
        }
        JSONObject inventory = new JSONObject();
        ArrayList<Product> productArrayList = new ArrayList<>();
        int i = 1;
        for (Map.Entry<Product, Integer> entry : totalProducts.entrySet())
        {
            System.out.print(i + "){");
            inventory.put("Product", entry.getKey().toJson());
            inventory.put("instock", entry.getValue());
            productArrayList.add(entry.getKey());
            System.out.println(inventory.toJSONString() + "}");
            i++;
        }
        return productArrayList;
    }
}
