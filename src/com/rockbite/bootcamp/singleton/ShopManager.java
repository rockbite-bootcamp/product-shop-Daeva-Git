package com.rockbite.bootcamp.singleton;

import com.rockbite.bootcamp.product.ProductType;
import com.rockbite.bootcamp.shop.ShopImpl;

public class ShopManager {

    private static ShopManager instance;

    private ShopManager () {

    }

    public static ShopManager getInstance () {
        if (instance == null) instance = new ShopManager();
        return instance;
    }

    public void purchaseProduct  (int userId, ShopImpl shop, ProductType productType, int count) {
        shop.purchaseProduct(userId, productType,count);
    }

    public void returnProduct (int userId, ShopImpl shop, ProductType productType, int count) {
        shop.returnProduct(userId, productType, count);
    }
}
