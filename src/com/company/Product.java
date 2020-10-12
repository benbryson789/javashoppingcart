package com.company;

public class Product {
    int ID;
    String productName;
    String productDescription;
    String productCategory;
    Double productPrice;
    int productInventory;

    public Product(int ID, String productName, String productDescription, String productCategory, Double productPrice, int productInventory) {
        this.ID = ID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productInventory = productInventory;
    }

    // simulates a purchase, removes requested quantity from inventory.
    public boolean purchase(int requestedQuantity) {
        if(productInventory == 0) {
            System.err.println ("Product inventory for " + productName + " is 0");
            return false;
        } else {
            int newInventory = productInventory - requestedQuantity;
            productInventory = newInventory;
            return true;
        }
    }
}





