package com.company;

import java.util.ArrayList;

public class Basket
{
    ArrayList<Product> products;

    public Basket()
    {
        products = new ArrayList<>();
    }

    public void addProduct(Product product, Inventory inventory)
    {
        int stock = inventory.getStock(product);          // get the current stock of the product
        inventory.changeStock(product, stock - 1);  // decrement the product's stock by 1
        products.add(product);                            // add the product to the cart
    }

    public void removeProduct(Product product, Inventory inventory)
    {
        if (existsInBasket(product))
        {
            int stock = inventory.getStock(product);          // get the current stock of the product
            inventory.changeStock(product, stock + 1);  // decrement the product's stock by 1
            products.remove(product);                         // remove the product from the cart
            return;
        }
        System.out.println("This product doesn't exist in your basket.");
    }

    public double totalPrice()
    {
        double total = 0;
        // iterate the products in the basket and add each product's price to total variable
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

    @Override
    public String toString()
    {
        return "";
    }
}
