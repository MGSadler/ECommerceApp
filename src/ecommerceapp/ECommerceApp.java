/* main method follows the pseudocode below, and whose other methods are as specified below.

 *    Print the banner message
      Get the products catalog String
      Get the product order from the user and check it exists in the products catalog String
      If the product exists
          Get the product price
          Compute the product tax
          Compute the total sale
          Output the total sale
      Else
          Output "The product was not found."

 * Your program must include the following methods:

    1. A method called bannerPrinter that takes no parameter and has no return value. 
    bannerPrinter outputs a greeting to the command line as shown below.

******************************************
====== Welcome to my eCommerce app! ======
******************************************
(print a blank line after the banner)
	
    2. A method called productsBuilder that takes no parameters and returns a String.
    In the method body construct a String (name it productsCatalog) and populate it with items,
    each of which must be 10 characters long. For any product less than 10 characters, pad the
    remainder with spaces. You don't need to get the values from the user, just populate the 
    String with 3 product names. For example, product 1 might be "Desk ", product 2 might be 
    "Table ", and product 3 might be "Pen ". All 3 of these products are within the productsCatalog String.
 

    3. A method called getOrder that takes a String as a parameter (the productsCatalog String) 
    and returns a boolean. In the method body, prompt the user to enter a product name (a String), 
    then check whether the product name exists in productsCatalog. If it exists, return true, otherwise return false.
 

    4. A method called getPrice that returns a double. In the method body generate a random number 
    between 1 and 100 (Hint: See Horstmann Section 4.9.2.) and return this value as the price.
 

    5. A method called getTax that takes a double as a parameter (the price) and returns a double. 
    Compute the return value as 10% of the parameter value (i.e. 10% of the price). This is the tax.
 

    6. A method called getTotal that takes two doubles as parameters (the price and the tax) and returns
    a double. The return value is computed as the sum of the two parameters (the return value is the sale total).
 

    7. A method called printTotal that takes a double as a parameter (the sale total) and has no return value.
    This method outputs the following to the command line: "Your sale total is: $X" where X is the sale total parameter value.

 * All currency amounts that your program outputs should show a leading "$" followed by the whole number, a decimal, and two decimal positions.

 * Thoughts
   Refer to Horstmann chapter 2 for details on formatting output values.
 */
package ecommerceapp;

import java.util.Scanner;

public class ECommerceApp {
    
    public static void main(String args[]){
        bannerPrinter();
        String[]productName = productsBuilder();
        boolean productEntry = getOrder(productName);
        if (productEntry){
            double price = getPrice();
            double priceTax= getTax(price);
            double total = getTotal(price, priceTax);
            System.out.println("Your sale total is: " + String.format("$%.2f",total));
                    }
        else {
            System.out.println("The product was not found.");
        }
    }
    public static void bannerPrinter(){
        System.out.println("******************************************\r\n" +
                "====== Welcome to my eCommerce app! ======\r\n" +
                "******************************************\r\n");
    }
    public static String[] productsBuilder(){
        String[]productsCatalog = new String[5];
        productsCatalog[0]= "Desk";
        productsCatalog[1]= "Table";
        productsCatalog[2]= "Pen";
        return productsCatalog;
    }
    public static boolean getOrder(String[]productsCatalog){
        String productName = "";
        Scanner inputProduct = new Scanner(System.in);
        System.out.println("Please enter a product name: ");
        productName = inputProduct.nextLine();
        for (String productsCatalog1 : productsCatalog) {
            if (productName.equals(productsCatalog1)) {
                inputProduct.close();
                return true;
            }
        }
        inputProduct.close();
        return false;
    }
    public static double getPrice(){
        double price = Math.random()*100.0 + 1.0;
        return price;
    }
    public static double getTax(double price){
        return (price * 0.10);
    }
    public static double getTotal(double price, double priceTax){
        double total = price + priceTax;
        return total;
    }
    public static void printTotal(double total){
        System.out.println("Your sale Total is $" + total);
    }
}