import java.util.ArrayList;
import java.util.Scanner;
//Created by Robert Fretter 2/10/2017
//This is a dealership app. Allows user to view and select a car from inventory

public class Main {

    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        int count1 = 1;
        int count2 = 7;
        ArrayList<Car> carList = getCars(); // generates arrayList of cars


        for (Car c : carList) {

            System.out.println(count1++ + "." + c.toString());

        }
        System.out.println(count2-- + "." + "Quit"); //Quit option added to list

        boolean carPurchase = true;

        int count3 = 8;


        while (carPurchase) {                                   //loops while customer purchases cars


            count3--;

            System.out.println();
            System.out.println("Which car would you like?");
            int carChoice = Validation.getValidInteger(0, count3 + 1);                     //reads user input for car choice


            selectQuit1(carList, count3, carChoice);                                     //user can select quit from menu
            System.out.println("Would you like to buy this car?(Y/N");
            char purchCar = scan1.next().charAt(0);


            count2 = purchaseOrQuit(count2, carList, carChoice, purchCar);               //purchase car or quit

        }
    }

    private static int purchaseOrQuit(int count2, ArrayList<Car> carList, int carChoice, char purchCar) {
        if (purchCar == 'Y' || purchCar == 'y') {
            System.out.println("Excellent! Our finance department will be in touch shortly.");
            System.out.println();

            carList.remove(carChoice - 1);                  //removes selected car from arrayList

            int count4 = 1;
            for (Car c : carList) {
                System.out.println((count4++ + "." + c.toString()));    //resarts the count over for the arrayList
            }

            System.out.println(count2-- + "." + "Quit");


        } else {
            System.out.println("Have a great day!");
            System.exit(0);
        }
        return count2;
    }

    private static void selectQuit1(ArrayList<Car> carList, int count3, int carChoice) {
        if (carChoice > 0 && carChoice < count3) {
            System.out.println(carList.get(carChoice - 1));

        } else {

            System.out.println("Goodbye!");
            System.exit(0);


        }
    }

    private static ArrayList<Car> getCars() {
        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(new Car("Nikolai", "Model S", 2017, 54999.90));
        carList.add(new Car("Fourd", "Escapade", 2017, 31999.90));
        carList.add(new Car("Chewie", "Vette", 2017, 44989.95));
        carList.add(new UsedCar("Hyonda", "Prior", 2015, 14795.50, 35987.6));
        carList.add(new UsedCar("GC", "Chirpus", 2013, 8500.00, 12345.0));
        carList.add(new UsedCar("GC", "Witherell", 2016, 14450.00, 3500.3));
        return carList;
    }
}