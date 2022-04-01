package by.gsu.asoilab;

import java.util.ArrayList;
import java.util.Scanner;

public class Purchase {

    public String className;

    public String name;

    public int price;

    public int count;

    public Purchase() {

    }

    public Purchase(String name, int price, int count) {
        this.className = "Purchase";
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getCost() {
        return price * count;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count + ";" + getCost();
    }

    public static Purchase createNewObj() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter name, price, count");
        String name = in.next();
        int price = in.nextInt();
        int count = in.nextInt();
        return new Purchase(name, price, count);
    }

    public static void inputArrayObjPurchase(ArrayList<Purchase> list) {
        System.out.println("Purchase...");
        for (Purchase purchase : list) {
            if (purchase.className.equals("Purchase")) {
                System.out.println(purchase);
            }
        }
        System.out.println("---------------------");
    }

    public static void inputFullArrayObj(ArrayList<Purchase> list) {
        inputArrayObjPurchase(list);
        PurchaseDiscount.inputArrayObjPurchaseDiscount(list);
        PurchaseDiscountNumber.inputArrayObjPurchaseDiscountNumber(list);
    }

    public static void inputMaxPurchase(ArrayList<Purchase> list) {
        double max = 0;
        for (Purchase purchase : list) {
            if (purchase.getCost() > max) max = purchase.getCost();
        }
        System.out.println("Max cost purchase: " + max);
    }

    public static void equalsObjects(ArrayList<Purchase> list) {
        ArrayList<Purchase> myList = new ArrayList<>(list);
        Scanner in = new Scanner(System.in);
        String names;
        int price;
        int count;
        double cost;
        System.out.println("Enter by which attribute to compare(name, price, count, cost)...");
        String string = in.nextLine();
        String[] variables = {"name", "price", "count", "cost"};
        String[] str = string.split(" ");
        Boolean[] booleanStr = {false, false, false, false};
        for (String s : str) {
            if (s.equals(variables[0])) {
                booleanStr[0] = true;
                System.out.println("enter " + variables[0] + "...");
                names = in.next();
                String finalNames = names;
                myList.removeIf(obj -> (!obj.name.equals(finalNames)));
            }
            if (s.equals(variables[1])) {
                booleanStr[1] = true;
                System.out.println("enter " + variables[1] + "...");
                price = in.nextInt();
                int finalPrice = price;
                myList.removeIf(obj -> (obj.price != finalPrice));
            }
            if (s.equals(variables[2])) {
                booleanStr[2] = true;
                System.out.println("enter " + variables[2] + "...");
                count = in.nextInt();
                int finalCount = count;
                myList.removeIf(obj -> (obj.count != finalCount));
            }
            if (s.equals(variables[3])) {
                booleanStr[3] = true;
                System.out.println("enter " + variables[3] + "...");
                cost = in.nextDouble();
                double finalCost = cost;
                myList.removeIf(obj -> (obj.getCost() != finalCost));
            }
        }
        System.out.print("\nCompare by : " );
        for (int i = 0; i < booleanStr.length; i++) {
            if (booleanStr[i]){
                System.out.print(variables[i] + " ");
            }
        }
        System.out.println("\n");
        for (Purchase obj : myList){
            System.out.println(obj);
        }
    }
    public static void Program() {
        Scanner in = new Scanner(System.in);
        ArrayList<Purchase> arrayOfPurchase = new ArrayList<>();
        int ch;
        while (true) {
            System.out.println("1. Create ordinary purchase..." +
                    "\n2. Create discount purchase..." +
                    "\n3. Create discount number purchase..." +
                    "\n4. Go to methods.." +
                    "\n5. Exit...");
            ch = in.nextInt();
            switch (ch) {

                case 1:
                    arrayOfPurchase.add(Purchase.createNewObj());
                    break;
                case 2:
                    arrayOfPurchase.add(PurchaseDiscount.createNewObj());
                    break;
                case 3:
                    arrayOfPurchase.add(PurchaseDiscountNumber.createNewObj());
                    break;
                case 4:
                    if (arrayOfPurchase.size() > 0) {
                        arrayOfPurchase = Methods(arrayOfPurchase);
                    } else {
                        System.out.println("Error... Add new objects in array!");
                    }
                    break;
                case 5:
                    System.exit(0);
            }

        }
    }

    public static ArrayList<Purchase> Methods(ArrayList<Purchase> list) {
        Scanner in = new Scanner(System.in);
        int exMethods = 0;
        int ch;
        while (exMethods != 1) {
            System.out.println("1. Input ArrayObjPurchase..." +
                    "\n2. Input ArrayObjPurchaseDiscount..." +
                    "\n3. Input ArrayObjPurchaseDiscountNumber..." +
                    "\n4. Input Full Array..." +
                    "\n5. Max cost..." +
                    "\n6. Comparison..." +
                    "\n7. Go to add objects in array.." +
                    "\n8. Go to full rework array..." +
                    "\n9. Exit...");
            ch = in.nextInt();
            switch (ch) {

                case 1:
                    Purchase.inputArrayObjPurchase(list);
                    break;
                case 2:
                    PurchaseDiscount.inputArrayObjPurchaseDiscount(list);
                    break;
                case 3:
                    PurchaseDiscountNumber.inputArrayObjPurchaseDiscountNumber(list);
                    break;
                case 4:
                    Purchase.inputFullArrayObj(list);
                    break;
                case 5:
                    Purchase.inputMaxPurchase(list);
                    break;
                case 6:
                    equalsObjects(list);
                    break;
                case 7:
                    exMethods = 1;
                    break;
                case 8:
                    exMethods = 1;
                    list.clear();
                    break;
                case 9:
                    System.exit(0);
            }

        }
        return list;
    }


}




