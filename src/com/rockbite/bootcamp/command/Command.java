package com.rockbite.bootcamp.command;

import com.rockbite.bootcamp.pool.Poolable;
import com.rockbite.bootcamp.product.ProductType;
import com.rockbite.bootcamp.shop.ShopImpl;

public interface Command extends Poolable {

    void execute(int userId, ShopImpl shop, ProductType productType, int count);

    void execute();

    void undo();

    void redo();
}

