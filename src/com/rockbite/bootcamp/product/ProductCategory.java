package com.rockbite.bootcamp.product;

import java.util.ArrayList;

public class ProductCategory {

    String name;

    ArrayList<ProductType> products = new ArrayList<ProductType>();

    public ProductCategory (String name) {
        this.name = name;
    }

    public void addProduct(ProductType productType) {
        products.add(productType);
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public ArrayList<ProductType> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductType> products) {
        this.products = products;
    }
}
