package com.rockbite.bootcamp;

import com.rockbite.bootcamp.command.CommandManager;
import com.rockbite.bootcamp.item.ItemType;
import com.rockbite.bootcamp.item.container.ItemContainerImpl;
import com.rockbite.bootcamp.product.ProductCategory;
import com.rockbite.bootcamp.product.ProductType;
import com.rockbite.bootcamp.shop.ShopImpl;
import com.rockbite.bootcamp.user.UserImpl;

public class Main {

    public static void main(String[] args) {

        CommandManager commandManager = new CommandManager();

        // Creating some items
        ItemType iron = new ItemType("Iron", 400);
        ItemType bronze = new ItemType("Bronze", 200);
        ItemType bread = new ItemType("Bread", 300);

        // Creating payload for metals
        ItemContainerImpl metalsPayload_1 = new ItemContainerImpl();
        ItemContainerImpl metalsPayload_2 = new ItemContainerImpl();

        // Adding items
        metalsPayload_1.addItem(bronze,10);
        metalsPayload_1.addItem(iron,20);

        metalsPayload_2.addItem(bronze,25);
        metalsPayload_2.addItem(iron,15);

        // Creating cost for metals
        ItemContainerImpl metalsCost_1 = new ItemContainerImpl();
        ItemContainerImpl metalsCost_2 = new ItemContainerImpl();

        // Adding items
        metalsCost_1.addItem(bread,15);
        metalsCost_2.addItem(bread,25);

        // Creating new products
        ProductType metals_1 = new ProductType(0, "Metals Set 1", metalsPayload_1, metalsCost_1);
        ProductType metals_2 = new ProductType(0, "Metals Set 2", metalsPayload_2, metalsCost_2);

        // Declaring new shop
        ShopImpl newStore = new ShopImpl();

        // Adding a products to shop
        newStore.addProduct(metals_1, 10);
        newStore.addProduct(metals_2, 5);


        // Creating category
        ProductCategory sale = new ProductCategory("For Sale");

        // Adding category to shop
        newStore.getProducts(sale);

        // Adding products to category
        sale.addProduct(metals_1);
        sale.addProduct(metals_2);


        // Creating user
        UserImpl user = new UserImpl("David");
        user.addItems(bread, 150);

        System.out.println("\n===== For Sale items =====");
        newStore.outputCategory(sale);

        System.out.println("\n===== Payload of metals set 1 =====");
        metals_1.getPayload().outputItems();

        System.out.println("\n===== Cost of metals set 2 =====");
        metals_2.getCost().outputItems();

        System.out.println("\n===== User items =====");
        user.outputItems();

        System.out.println("\n===== New For Sale items =====");

        commandManager.executeCommand(commandManager.purchaseCommandPool.obtain(), user.getId(), newStore, metals_1, 2);
        commandManager.executeCommand(commandManager.purchaseCommandPool.obtain(), user.getId(), newStore, metals_2, 1);

        commandManager.undo();
        commandManager.undo();
        commandManager.executeCommand(commandManager.purchaseCommandPool.obtain(), user.getId(), newStore, metals_2, 3);
        commandManager.undo();
        commandManager.redo();

        newStore.outputCategory(sale);

        System.out.println("\n===== User items =====");
        user.outputItems();

    }
}
