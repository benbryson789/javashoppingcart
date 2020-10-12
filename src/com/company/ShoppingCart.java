package com.company;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> itemsInCart;
    private List<Integer> quantities;

    // constructor.  used to initialize variables.
    public ShoppingCart() {
        itemsInCart = new ArrayList<> (  );
        quantities = new ArrayList<> (  );
    }

    // adds item/product and quantity to the shopping cart.
    public void addItemToCart(Product product, int quantity) {
        if(product.purchase ( quantity ) == true) {
            //Product product = new Product (prod.ID,prod.productName, prod.productDescription, prod.productCategory, prod.productPrice, prod.productInventory );
            itemsInCart.add ( product ); // items in Cart holds the product selected
            quantities.add ( quantity ); // quantities hold the number/quantity of the product that was selected
        }
    }

    /**
     * Returns the total price og the items in the cart before tax is added.
     * @return
     */
    public double getItemsPriceBeforeTax() {
        double totalPrice = 0;

        for (int i = 0; i < itemsInCart.size (); i++) { // iterate over all items in the cart
            double price = itemsInCart.get ( i ).productPrice; // get the price of the selected product
            int quantity = quantities.get(i); // get the quantity of the product selected by the user

            totalPrice =  totalPrice + ( price * quantity); // add the calculated cost for an item, add it to the totalPrice variable.
        }

        return totalPrice;
    }

    /**
     * Returns the total price fo the items in the cart after tax has been added.
     * @return
     */
    public double getItemsPriceAfterTax() {
        double totalPrice = getItemsPriceBeforeTax(); // get the price of item before tax
        double afterTax = totalPrice * 0.04; // calculate tax on the total amount gotten from line above.
        return afterTax + totalPrice;
    }

    /**
     * Removes selected product from the shopping cart based on its productId.
     * @param productId
     */
    public void removeItem(int productId) {
        Product prodToRemove = null;

        // this forloop performs a search for the product that matches the productId that was sent in.
        for (int i = 0; i < itemsInCart.size (); i++) { // iterate over all items in cart
            Product prod = itemsInCart.get ( i ); // get indexed product
            if(prod.ID == productId){
                prodToRemove = prod; // this line sets the product to be removed.
                quantities.remove ( i ); // remove the quantity entry of the deleted product.
                break;
            }
        }

        // this code actual carries out the removal of the item after the item finds a match
        // this is done outside the forloop because you can't edit a forloop while  it is being iterated over
        if(prodToRemove != null) {
            itemsInCart.remove ( prodToRemove );
        }
    }

    /**
     * This returns all the itmes in the cart
     * @return
     */
    public List<Product> getItemsInCart() {
        return itemsInCart;
    }
}
