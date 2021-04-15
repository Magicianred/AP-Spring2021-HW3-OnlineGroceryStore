package com.company;

import java.util.ArrayList;

public class Basket
{
    private ArrayList<Product> products;

    public Basket()
    {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() { return products; }

    public void setProducts(ArrayList<Product> products) { this.products = products; }

    public void addProduct(int i, Inventory inventory)
    {
        Product product = products.get(i);                // get the product using its index
        int stock = inventory.getStock(product);          // get the current stock of the product
        inventory.changeStock(product, stock - 1);  // decrement the product's stock by 1
        products.add(product);                            // add the product to the cart
    }

    public void removeProduct(int i, Inventory inventory)
    {
        Product product = products.get(i);                    // get the product using its index
        if (existsInBasket(product))                          // check if the product exists in the basket
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
