package com.rockbite.bootcamp.item.container;

import com.rockbite.bootcamp.item.ItemStack;
import com.rockbite.bootcamp.item.ItemType;

import java.util.HashMap;

public abstract class AbstractItemContainer implements IItemContainer {

    public HashMap<ItemType, ItemStack> itemsMap = new HashMap<ItemType, ItemStack>();

    @Override
    public HashMap<ItemType, ItemStack> getItems () {

        return itemsMap;

    }
}
