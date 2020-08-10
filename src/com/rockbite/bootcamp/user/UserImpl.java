package com.rockbite.bootcamp.user;

import com.rockbite.bootcamp.item.ItemType;
import com.rockbite.bootcamp.item.container.ItemContainerImpl;

public class UserImpl extends UserAbstract {

    private ItemContainerImpl items = new ItemContainerImpl();

    private String name;

    private int id;

    public UserImpl(String name, ItemContainerImpl items) {

        this.name = name;

        this.items = items;

        users.add(this);
    }

    public UserImpl(String name) {

        this.name = name;

        users.add(this);
    }

    public ItemContainerImpl getItems () { return items; }

    public void outputItems () {
        items.outputItems();
    }

    public void setItems (ItemContainerImpl items) { this.items = items; }

    public void addItems (ItemType item, int count) { items.addItem(item, count);}

    public void removeItems (ItemType item, int count) { items.removeItem(item, count);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id;}
}
