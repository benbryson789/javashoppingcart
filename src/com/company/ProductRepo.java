package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    private List<Product> productList = new ArrayList<> ();

    public ProductRepo () {
        Product product1 = new Product ( 111 , "Coffee" , "Mocha" , "Beverage" , 6.00 , 10 );
        Product product2 = new Product ( 222 , "Coffee" , "Colombia" , "Beverage" , 5.00 , 9 );
        Product product3 = new Product ( 333 , "Coffee" , "French Roast" , "Beverage" , 5.00 , 8 );
        Product product4 = new Product ( 444 , "Coffee" , "Cocoa" , "Beverage" , 5.00 , 7 );
        Product product5 = new Product ( 555 , "Coffee" , "Hazlenut" , "Beverage" , 5.00 , 0 );

        productList.add ( product1 );
        productList.add ( product2 );
        productList.add ( product3 );
        productList.add ( product4 );
        productList.add ( product5 );
    }


    public List<Product> getProducts() {
        return productList;
    }
}
