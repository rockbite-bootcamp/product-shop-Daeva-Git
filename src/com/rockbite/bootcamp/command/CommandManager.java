package com.rockbite.bootcamp.command;

import com.rockbite.bootcamp.pool.Pool;
import com.rockbite.bootcamp.product.ProductType;
import com.rockbite.bootcamp.shop.ShopImpl;

import java.util.ArrayList;

public class CommandManager {

    private static CommandManager instance;

    public CommandManager() {

    }

    public static CommandManager getInstance () {
        if (instance == null) instance = new CommandManager();
        return instance;
    }

    private ArrayList<Command> history = new ArrayList<Command>();

    private int cursor = 0;

    private ArrayList<Pool> poolCommands = new ArrayList<>();

    public Pool<PurchaseCommand> purchaseCommandPool = new Pool<PurchaseCommand> () {
        @Override
        protected PurchaseCommand newObject() {
            return new PurchaseCommand();
        }
    };

    public void executeCommand(Command command, int userId, ShopImpl shop, ProductType productType, int count) {

        command.execute(userId, shop, productType, count);

        if (cursor < history.size()) history.clear();

        history.add(command);

        cursor++;
    }

    public void undo () {
        if (cursor == 0) return;

        Command command = history.get(cursor - 1);
        command.undo();

        cursor--;
    }

    public void redo () {
        if (cursor >= history.size()) return;

        Command command = history.get(cursor);
        command.execute();

        cursor++;
    }
}
