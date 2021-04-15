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

    public void add(Product product)
    {
        totalProducts.put(product, 1);
    }

    public void remove(Product product)
    {
        totalProducts.remove(product);
    }

    public void changeStock(Product product, int stock)
    {
        totalProducts.replace(product, stock);
    }
}
