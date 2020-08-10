package com.rockbite.bootcamp.command;

import com.rockbite.bootcamp.product.ProductType;
import com.rockbite.bootcamp.shop.ShopImpl;
import com.rockbite.bootcamp.singleton.ShopManager;

public class PurchaseCommand implements Command {

    private int userId;

    private ShopImpl shop;

    private ProductType productType;

    private int count;

    @Override
    public void execute (int userId, ShopImpl shop, ProductType productType, int count) {

        this.userId = userId;

        this.shop = shop;

        this.productType = productType;

        this.count = count;

        ShopManager.getInstance().purchaseProduct(userId, shop, productType, count);
    }

    @Override
    public void execute () {

        ShopManager.getInstance().purchaseProduct(userId, shop, productType, count);
    }

    @Override
    public void undo () {

        ShopManager.getInstance().returnProduct(userId, shop, productType, count);

    }

    @Override
    public void redo () {

        ShopManager.getInstance().purchaseProduct(userId, shop, productType, count);

    }

    @Override
    public void reset () {

    }
}
