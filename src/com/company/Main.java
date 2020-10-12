package com.company;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static ProductRepo productRepository;
    static Scanner scanner;
    static ShoppingCart shoppingCart;


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        productRepository = new ProductRepo ();
        shoppingCart = new ShoppingCart ();

        boolean continueShopping = false;

        do {
            showProducts ();
            chooseProduct ();
            checkOut ();
            deleteCartItem (  );
            continueShopping = continueShopping ();
        }while(continueShopping == true);
        NumberFormat numberFormat = new DecimalFormat ("#,###.00");

        System.out.printf ("Price before tax: $%f\n" , shoppingCart.getItemsPriceBeforeTax ());
        // System.out.printf ("Price before tax: $%f \n" , shoppingCart.getItemsPriceBeforeTax ());


        //System.out.printf ("Price before tax:$\"%10.2f\" " , shoppingCart.getItemsPriceBeforeTax ());

        System.out.printf ("Price after tax: $%f\n", shoppingCart.getItemsPriceAfterTax ());

    }

    // option to delete from the cart.
    public static void deleteCartItem() {
        System.out.println ("Do you want to delete an item in the cart? Enter 'y' or 'n'");
        String response = scanner.next ();

        if(response.equalsIgnoreCase ( "y" )) {
            showItemsInCart ();
            System.out.println ("Enter the Id of the product you want to remover.");
            int prodIdToDelete = scanner.nextInt ();
            shoppingCart.removeItem ( prodIdToDelete );
            showItemsInCart ();
        }
    }

    // this is called from lines 47 and 51
    public static void showItemsInCart() {
        System.out.println ("Items in your cart include: ");
        var products = shoppingCart.getItemsInCart ();

        for (int i = 0; i < products.size (); i++) {
            Product p = products.get ( i );
            System.out.println ( (p.ID) + "). " + p.productName + ":" + p.productDescription + " - $" + p.productPrice + " > Qty: " + p.productInventory );
        }
    }
    //this is being called from line
    public static void showProducts() {
        System.out.println ("Items in the inventory include: ");
        var products = productRepository.getProducts ();

        for (int i = 0; i < products.size (); i++) {
            Product p = products.get ( i );
            System.out.println ( (p.ID) + "). " + p.productName + ":" + p.productDescription + " - $" + p.productPrice + " > Qty: " + p.productInventory );
        }
    }

    // this called from line 24
    public static void chooseProduct() {
        System.out.println ("Please enter the id of the product you want.");
        int userSelectedProductID = scanner.nextInt ();
        System.out.println ("Please enter the quantity");
        int quantity = scanner.nextInt ();

        Product product = findProduct ( userSelectedProductID );
        shoppingCart.addItemToCart (product, quantity );
    }

    // this is called from line 82
    public static Product findProduct(int productId) {
        Product product = null;

        // this forloop searches the productRepository for a product that has same id with  the one passed in as a parameter.
        for (int i = 0; i < productRepository.getProducts ().size (); i++) {
            Product prod = productRepository.getProducts ().get ( i );
            if(prod.ID == productId) {
                product = prod;
                break;
            }
        }
        return product;
    }

    // this is called from line 25
    public static boolean checkOut() {
        System.out.println ("Do you want to checkout? Enter 'y' or 'n'");
        String checkoutResponse = scanner.next ();

        if(checkoutResponse.equalsIgnoreCase ( "y" )) {

            NumberFormat numberFormat = new DecimalFormat ("#,###.00");

            System.out.printf ("Price before tax: $%f/n" , shoppingCart.getItemsPriceBeforeTax ());
           // System.out.printf ("Price before tax: $%f \n" , shoppingCart.getItemsPriceBeforeTax ());


            //System.out.printf ("Price before tax:$\"%10.2f\" " , shoppingCart.getItemsPriceBeforeTax ());

            System.out.println ("Price after tax: $" + shoppingCart.getItemsPriceAfterTax ());
            return true;
        }
        return false;
    }

    public static boolean continueShopping() {
        System.out.println ("Do you want to continue shopping? Enter 'y' or 'n'");
        String response = scanner.next ();

        if(response.equalsIgnoreCase ( "y" )) {
            return true;
        }
        return false;
    }
}
