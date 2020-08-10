package com.rockbite.bootcamp.item.container;

import com.rockbite.bootcamp.item.ItemStack;
import com.rockbite.bootcamp.item.ItemType;

import java.util.HashMap;

public class ItemContainerImpl extends AbstractItemContainer {

    @Override
    public void addItem(ItemType itemType, int count) {
        ItemStack stack = itemsMap.get(itemType);

        if(stack == null){
            itemsMap.put(itemType, new ItemStack(itemType));
        }

        int initialCount = itemsMap.get(itemType).getCount();

        int maxCount = itemType.getMaxCount();

        int newCount = initialCount + count;

        if (newCount > maxCount) {
            newCount = maxCount;
        }

        itemsMap.get(itemType).setCount(newCount);
    }

    @Override
    public void removeItem(ItemType itemType, int count) {
        ItemStack stack = itemsMap.get(itemType);

        if(stack != null){
            int currentCount = itemsMap.get(itemType).getCount();

            int newCount = currentCount - count;

            itemsMap.get(itemType).setCount(newCount);
        }
    }

    @Override
    public boolean contains (ItemContainerImpl items, int count) {
        for (ItemType itemType : items.itemsMap.keySet()) {

            int userItemCount = getItems().get(itemType).getCount();

            int costItemCount = items.getItems().get(itemType).getCount();

            if(userItemCount < costItemCount * count) return false;
        }

        return true;
    }

    @Override
    public HashMap<ItemType, ItemStack> getItems() {
        return itemsMap;
    }

    @Override
    public ItemStack getItem (ItemType item) {
        return itemsMap.get(item);
    }

    @Override
    public void outputItems() {
        for (ItemType type : itemsMap.keySet()){
            System.out.println(type.getName() + ": " + itemsMap.get(type).getCount());
        }
    }
}
