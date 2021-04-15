package com.company;

import java.util.ArrayList;

public class Basket
{
    ArrayList<Product> products;

    public Basket()
    {
        products = new ArrayList<>();
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }

    public void removeProduct(Product product)
    {
        products.remove(product);
    }

    public double totalPrice()
    {
        double total = 0;
        for (Product p : products)
            total += p.getPrice();

        return total;
    }

    private boolean existsInBasket(Product product)
    {
        for (Product p : products)
        {
            if (p.equals(product))
                return true;
        }
        return false;
    }
}
