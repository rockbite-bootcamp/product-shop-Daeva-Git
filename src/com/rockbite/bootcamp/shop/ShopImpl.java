package com.rockbite.bootcamp.shop;

import com.rockbite.bootcamp.item.ItemType;
import com.rockbite.bootcamp.item.container.ItemContainerImpl;
import com.rockbite.bootcamp.product.ProductCategory;
import com.rockbite.bootcamp.product.ProductStack;
import com.rockbite.bootcamp.product.ProductType;
import com.rockbite.bootcamp.user.UserAbstract;
import com.rockbite.bootcamp.user.UserImpl;

public class ShopImpl extends AbstractShop{

    @Override
    public void addProduct (ProductType productType, int count) {

        ProductStack stack = productMap.get(productType);

        if (stack == null) productMap.put(productType, new ProductStack(productType));

        int initialCount = productMap.get(productType).getCount();

        int newCount = initialCount + count;

        productMap.get(productType).setCount(newCount);
    }

    @Override
    public void removeProduct (ProductType productType, int count) {

        ProductStack stack = productMap.get(productType);

        if (stack != null){

            int currentCount = productMap.get(productType).getCount();

            int newCount = currentCount - count;

            productMap.get(productType).setCount(newCount);
        }
    }

    @Override
    public void purchaseProduct (int userId, ProductType productType, int count) {

        if (productMap.get(productType).getCount() - count < 0) return;

        if (canPurchase(UserAbstract.users.get(userId), productType.getCost(), count)){

            for (ItemType itemType : productType.getCost().itemsMap.keySet()) {

                int userItemCount = UserAbstract.users.get(userId).getItems().getItem(itemType).getCount();

                int costItemCount = productType.getCost().getItems().get(itemType).getCount();

                UserAbstract.users.get(userId).removeItems(itemType,costItemCount * count);

            }

            for(ItemType itemType : productType.getPayload().itemsMap.keySet()) {

                UserAbstract.users.get(userId).addItems(itemType, productType.getPayload().itemsMap.get(itemType).getCount() * count);

            }

            productMap.get(productType).setCount(productMap.get(productType).getCount() - count);
        }
    }

    @Override
    public void returnProduct (int userId, ProductType productType, int count) {

        if (UserAbstract.users.get(userId).getItems().contains(productType.getPayload(), count)) {

            for (ItemType itemType : productType.getCost().itemsMap.keySet()) {

                int userItemCount = UserAbstract.users.get(userId).getItems().getItem(itemType).getCount();

                int costItemCount = productType.getCost().getItems().get(itemType).getCount();

                UserAbstract.users.get(userId).addItems(itemType,costItemCount * count);

            }

            for(ItemType itemType : productType.getPayload().itemsMap.keySet()) {

                UserAbstract.users.get(userId).removeItems(itemType, productType.getPayload().itemsMap.get(itemType).getCount() * count);

            }

            productMap.get(productType).setCount(productMap.get(productType).getCount() + count);
        }
    }

    private boolean canPurchase (UserImpl userImpl, ItemContainerImpl items, int count) {

        for (ItemType itemType : items.itemsMap.keySet()) {

            int userItemCount = userImpl.getItems().getItem(itemType).getCount();

            int costItemCount = items.getItems().get(itemType).getCount();

            if(userItemCount < costItemCount * count) return false;
        }

        return true;
    }

    @Override
    public void outputCategory (ProductCategory category) {

        for (ProductType type : getProducts(category).keySet()) {

            System.out.println(type.getName() + ": " + productMap.get(type).getCount());

        }
    }
}
