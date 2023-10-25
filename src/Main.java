import java.util.Scanner;
import java.lang.System;
import java.util.InputMismatchException;

public class Main {
    public static Scanner scan = new Scanner(System.in);//Initializing  input
//    list of all the items
    public static String[] types = {"Veggie Burger", "Deluxe Veggie Burger", "Chicken Burger", "Cheese Chicken Burger", "Cheese Bacon Burger", "Deluxe Bacon Burger", "Healthy Bacon Burger"};
//    List prices of the items is sequence as that of the items
    public static double[] price = {5.95, 7.95, 6.45, 8.50, 9.25, 10.95, 12.45};
//    Variable to store the total available options
    static int count = types.length + 1;
//    intialize the sum as 0
    static double sum = 0;
//  Method to start the process .This method assists in making multiple orders by creating loops
    public static void start(){
        Menu( types, price,count);
                int order = INPUT(scan);
                if (order<0||order==0||order>count){
                    System.out.println("please input a valid number");
                    order = VALIDATION(order);
                }
                if(order>=0 && order<=count) {
                    if (order == count) {
                        double discount = discount(sum);
                        double tax = sum * 0.13;
                        double total = sum + tax - discount;
                        System.out.println("your total cost is: " + total);
                    }
                    else {
                        sum = sum + ORDDET(price, order, scan);
                        start();
                    }
                }
    }
    public static double discount(double sum){
        double discount;
        if (sum>100){
            discount = sum*0.1;
        } else if (sum>50) {
            discount = sum*0.5;
        }
        else{
            discount = 0;
        }
        return discount;
    }
//    method to hand misc tasks
public static String misc( int numb){
        String spaces="";
        for( int i = 0 ; i< numb;i++){
            spaces = spaces+" ";
        }
        return spaces;
    }
//    method to handle out of bound error(requests input a valid value when and integer value beyond input range is entered)
    public static int VALIDATION(int order) {
        for (int i = 0; i < 3; i++) {
            Menu(types, price, count);
            int retry = INPUT(scan);
            if (retry > 0 && retry < count) {
                order = retry;
                return order;
            }
        }
        return 0;
    }
//   Method to display menu
public static double Menu(String[] types, double[] price,int count){

        for (int i = 0; i < types.length; i++) {
            System.out.println(i + 1 + " ." + types[i] + misc(30 - types[i].length()) + "$" + price[i]);
        }
        System.out.println(types.length + 1 + " .Quit");
        System.out.println("Please select an option from 1 to " + count);
        return 0;
}
//Method to take input from user
public static int INPUT(Scanner scan){
    System.out.print("Which item do you want:  ");
    int orderno = scan.nextInt();
    return orderno;
}
//Method to get more details reguarding the ordred item from user
public static double ORDDET(double[] price,int itemno,Scanner scan ){
        System.out.print("How many of the item doy you want:  ");
    int quantity = scan.nextInt();
    double cost = quantity* price[itemno-1];
    return cost;
}
//    THis is the main looping function
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//THis is not uderstood by me
        try {
            System.out.println("Bipul's BurgerStop\n");
            start();
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input. Please try again and enter an integer.");
        }
    }
}