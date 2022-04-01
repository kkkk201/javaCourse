package by.gsu.asoilab;

import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseDiscountNumber extends Purchase {


    public double discount;

    public final int num = 3;

    public PurchaseDiscountNumber(){
        super();
    }

    public PurchaseDiscountNumber(String name, int price, int count, double discount){
        super(name, price, count);
        this.className = "PurchaseDiscountNumber";
        this.discount = discount;
    }

    public int getCost(){
        if(count >= num) return (int)(price * count * (1 - (discount / 100)));
        else return (price * count);

    }

    public String toString() {
        if(count >= num) return name + ";" + price + ";" + count + ";" + discount + "%;" + getCost();
        else return name + ";" + price + ";" + count + ";discount didn't work;" + getCost();
    }

    public static PurchaseDiscountNumber createNewObj(){
        Scanner in = new Scanner(System.in);
        System.out.println("enter name, price, count, discount");
        String name = in.next();
        int price = in.nextInt();
        int count = in.nextInt();
        int discount = in.nextInt();
        return new PurchaseDiscountNumber( name, price, count, discount);
    }

    public static void inputArrayObjPurchaseDiscountNumber(ArrayList<Purchase> list){
        System.out.println("PurchaseDiscountNumber...");
        for (Purchase purchase : list) {
            if (purchase.className.equals("PurchaseDiscountNumber")) {
                System.out.println(purchase);
            }
        }
        System.out.println("--------------------------");
    }

}

