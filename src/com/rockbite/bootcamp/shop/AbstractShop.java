package com.rockbite.bootcamp.shop;

import com.rockbite.bootcamp.product.ProductCategory;
import com.rockbite.bootcamp.product.ProductStack;
import com.rockbite.bootcamp.product.ProductType;

import java.util.HashMap;

public abstract class AbstractShop implements IShop {

    protected HashMap<ProductType, ProductStack> productMap = new HashMap<ProductType, ProductStack>();

    @Override
    public HashMap<ProductType, ProductStack> getProducts (ProductCategory productCategory) {

        HashMap<ProductType, ProductStack> categoryProducts = new HashMap<ProductType, ProductStack>();

        for (ProductType type:productCategory.getProducts()) {
            categoryProducts.put(type, productMap.get(type));
        }

       return categoryProducts;
    }
}
