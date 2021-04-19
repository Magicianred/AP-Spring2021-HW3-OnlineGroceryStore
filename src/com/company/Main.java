package com.company;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * The program's execution is started form here.
 * @author KIMIA
 * @version 1.0
 * @since 4-15-2021
 */
public class Main
{
    /**
     * Adds 8 default products to the inventory.
     * @param inventory the current inventory
     */
    public static void initInventory(Inventory inventory)
    {
        LocalDate manufactureDate, expirationDate;

        // 1
        manufactureDate = LocalDate.of(2020, 3, 15);
        expirationDate = LocalDate.of(2021, 3,15);
        Product carrot = new Product("Carrot", "Vegetables", 5, 20,
                manufactureDate, expirationDate);
        inventory.add(carrot, 10);

        // 2
        manufactureDate = LocalDate.of(2020, 4, 1);
        expirationDate = LocalDate.of(2020, 8, 1);
        Product apple = new Product("Apple", "Fruits", 10, 50,
                manufactureDate, expirationDate);
        inventory.add(apple, 50);

        // 3
        manufactureDate = LocalDate.of(2020, 1, 1);
        expirationDate = LocalDate.of(2020, 6, 1);
        Product eggs = new Product("12xEggs", "Egg", 100, 40,
                manufactureDate, expirationDate);
        inventory.add(eggs, 20);

        // 4
        manufactureDate = LocalDate.of(2020, 6, 1);
        expirationDate = LocalDate.of(2021, 1, 1);
        Product oats = new Product("Oats", "Grains", 70, 100,
                manufactureDate, expirationDate);
        inventory.add(oats, 45);

        // 5
        manufactureDate = LocalDate.of(2020, 1, 1);
        expirationDate = LocalDate.of(2020, 2, 1);
        Product salmon = new Product("Salmon", "Seafood", 150, 250,
                manufactureDate, expirationDate);
        inventory.add(salmon, 5);

        // 6
        manufactureDate = LocalDate.of(2020, 3, 1);
        expirationDate = LocalDate.of(2020, 9, 1);
        Product steak = new Product("Steak", "Meat", 800, 1000,
                manufactureDate, expirationDate);
        inventory.add(steak, 5);

        // 7
        manufactureDate = LocalDate.of(2020, 1, 10);
        expirationDate = LocalDate.of(2020, 1, 25);
        Product milk = new Product("Milk", "Dairy", 100, 20,
                manufactureDate, expirationDate);
        inventory.add(milk, 20);

        // 8
        manufactureDate = LocalDate.of(2020, 2, 1);
        expirationDate = LocalDate.of(2020, 3, 15);
        Product cheese = new Product("Cheese", "Dairy", 150, 10,
                manufactureDate, expirationDate);
        inventory.add(cheese, 50);
    }

    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();
        initInventory(inventory);
        Basket basket = new Basket();

        // wait for the user's commands
        Scanner scanner =  new Scanner(System.in);
        String input;

        while (true)
        {
            input = scanner.nextLine();
            if (input.startsWith("add"))
            {
                // add a product using its index
                int index = Integer.parseInt(input.substring(4)) - 1;
                // the called method returns null if the given index is not valid
                Product productToAdd = inventory.getProductByIndex(index);
                // the adding process fails if the index is out of boundary and productToAdd is null
                if (productToAdd != null)
                    basket.addProduct(productToAdd, inventory);
            }
            else if (input.startsWith("remove"))
            {
                // remove a product using its index
                int index = Integer.parseInt(input.substring(7)) - 1;
                // the removing process fails if the index is out of boundary
                basket.removeProduct(index, inventory);
            }
            else if (input.equals("cart"))
            {
                // print all the products in the basket (JSON)
                System.out.println(basket);
                System.out.println("Total price: " + basket.totalPrice());
            }
            else if (input.equals("products"))
            {
                // print all the products in the inventory (JSON)
                System.out.println(inventory);
            }
            else if (input.equals("checkout"))
            {
                System.out.println("It was a pleasure doing business with you.");
                break; // break from the while loop and end the program
            }
        }
    }
}