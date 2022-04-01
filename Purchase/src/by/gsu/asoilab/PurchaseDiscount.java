package by.gsu.asoilab;

import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseDiscount extends Purchase {


    public double discount;

    public PurchaseDiscount(){
        super();
    }

    public PurchaseDiscount(String name, int price, int count, double discount){
        super(name, price, count);
        this.className = "PurchaseDiscount";
        this.discount = discount;
    }

    public int getCost(){
        return (int)(price * count * (1 - (discount / 100)));
    }

    public String toString() {
        return name + ";" + price + ";" + count + ";" + discount + "%;" + getCost();
    }


    public static PurchaseDiscount createNewObj(){
        Scanner in = new Scanner(System.in);
        System.out.println("enter name, price, count, discount");
        String name = in.next();
        int price = in.nextInt();
        int count = in.nextInt();
        int discount = in.nextInt();
        return new PurchaseDiscount( name, price, count, discount);
    }

    public static void inputArrayObjPurchaseDiscount(ArrayList<Purchase> list){
        System.out.println("PurchaseDiscount...");
        for (Purchase purchase : list) {
            if (purchase.className.equals("PurchaseDiscount")) {
                System.out.println(purchase);
            }
        }
        System.out.println("---------------------------");
    }
}


