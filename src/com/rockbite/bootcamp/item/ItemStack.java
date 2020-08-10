package com.rockbite.bootcamp.item;

public class ItemStack {
    /**
     * The type of this stack
     */
    private ItemType itemType;
    /**
     * The count of things in this stack
     */
    private int count = 0;

    private int maxCount = 0;

    public ItemStack(ItemType itemType){
        this.itemType = itemType;
    }

    public void setCount (int count){

        this.count = count;

        if (this.count < 0) {
            this.count = 0;
        }
    }

    public int getCount (){
        return this.count;
    }
}
