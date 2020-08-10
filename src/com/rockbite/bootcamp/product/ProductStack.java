package com.rockbite.bootcamp.product;

public class ProductStack {

    private ProductType productType;

    private int count = 0;

    public ProductStack (ProductType productType) {
        this.productType = productType;
    }

    public void setCount (int count) {
        this.count = count;

        if (this.count < 0){
            this.count = 0;
        }
    }

    public ProductType getProductType () { return productType; }

    public void setProductType (ProductType productType) {
        this.productType = productType;
    }

    public int getCount () {
        return count;
    }
}
