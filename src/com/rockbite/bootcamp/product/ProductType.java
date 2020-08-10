package com.rockbite.bootcamp.product;

import com.rockbite.bootcamp.item.container.ItemContainerImpl;

public class ProductType {

    private int id;

    private String name;

    private ItemContainerImpl payload;

    private ItemContainerImpl cost;


    public ProductType(int id, String name, ItemContainerImpl payload, ItemContainerImpl cost) {

        this.id = id;

        this.name = name;

        this.payload = payload;

        this.cost = cost;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemContainerImpl getPayload() {
        return payload;
    }

    public void setPayload(ItemContainerImpl payload) {
        this.payload = payload;
    }

    public ItemContainerImpl getCost() {
        return cost;
    }

    public void setCost(ItemContainerImpl cost) {
        this.cost = cost;
    }
}
