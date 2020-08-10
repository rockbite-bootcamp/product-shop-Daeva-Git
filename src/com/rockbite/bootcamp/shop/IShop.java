package com.rockbite.bootcamp.shop;

import com.rockbite.bootcamp.product.ProductCategory;
import com.rockbite.bootcamp.product.ProductStack;
import com.rockbite.bootcamp.product.ProductType;

import java.util.HashMap;

/**
 * Simple interface to host shop API methods
 *  **/
public interface IShop {

    HashMap<ProductType, ProductStack> getProducts(ProductCategory productCategory);

    void addProduct(ProductType productCategory, int count);

    void removeProduct(ProductType productCategory, int count);

    void purchaseProduct(int userId, ProductType productType, int count);

    void returnProduct(int userId, ProductType productType, int count);

    void outputCategory(ProductCategory category);
}
