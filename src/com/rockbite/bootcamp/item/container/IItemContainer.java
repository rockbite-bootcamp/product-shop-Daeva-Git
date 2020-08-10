package com.rockbite.bootcamp.item.container;

import com.rockbite.bootcamp.item.ItemStack;
import com.rockbite.bootcamp.item.ItemType;

import java.util.HashMap;

public interface IItemContainer {

    HashMap<ItemType, ItemStack> getItems();

    void addItem(ItemType itemType, int count);

    void removeItem(ItemType itemType, int count);

    void outputItems();

    boolean contains (ItemContainerImpl items, int count);

    ItemStack getItem (ItemType item);
}
