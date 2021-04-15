package com.company;

import java.util.HashMap;

public class Inventory
{
    private HashMap<Product, Integer> totalProducts;

    public Inventory()
    {
        totalProducts = new HashMap<>();
    }

    public void setTotalProducts(HashMap<Product, Integer> totalProducts) { this.totalProducts = totalProducts; }

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
        return "";
    }
}
