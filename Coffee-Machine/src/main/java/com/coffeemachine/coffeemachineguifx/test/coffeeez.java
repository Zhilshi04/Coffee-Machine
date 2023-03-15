package com.coffeemachine.coffeemachineguifx.test;
import java.util.Scanner;

public class coffeeez extends CoffeeMachine{
    private static final Scanner scanner = new Scanner(System.in);
    public coffeeez(int water, int milk, int beans, int cups, int cash) {
        super(water, milk, beans, cups, cash);
    }
    public void doBuyCoffee() {
        System.out.println("What do you want to buy? \n1 - espresso \n2 - latte \n3 - cappuccino \nback - to main menu: ");
        String option = scanner.next();
        if (option.equals("back")) {
            // go back to main
        } else {
            int coffeeType = Integer.parseInt(option);
            Coffee coffee = Coffee.values()[coffeeType - 1];

            switch (coffee) {
                case ESPRESSO, LATTE, CAPPUCCINO : {
                    String coffeeMessage = super.makeCoffee(coffee);
                    System.out.println(coffeeMessage);
                }
                default : {
                }
                // do nothing
            }
        }
    }
    
    public void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", getWater());
        System.out.printf("%d ml of milk\n", getMilk());
        System.out.printf("%d g of coffee beans%n", getBeans());
        System.out.printf("%d disposable cups%n", getCups());
        System.out.printf("$%d of money%n", getCash());

    }
    public static void doFilling() {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        setWater(getWater() + addedWater);

        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        setMilk(getMilk() + addedMilk);

        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedBeans = scanner.nextInt();
        setBeans(getBeans() + addedBeans);

        System.out.println("Write how many disposable cups you want to add:");
        int addedCups = scanner.nextInt();
        setCups(getCups() + addedCups);
    }

    public static void doTakeMoney() {
        System.out.println("I gave you $" + getCash());
        setCash(0);
    }

    public boolean execute(String action) {
        boolean done = false;
        switch (action) {
            case "buy" : doBuyCoffee();
            break;
            case "fill" : doFilling();
            break;
            case "take" : doTakeMoney();
            break;
            case "remaining" : printState();
            break;
            case "exit" : {
                done = true;
            }
            default : {
            }
            // do nothing
        }
        return done;
    }
    public static void main(String[] args) {
        coffeeez coffeeUI = new coffeeez(400, 540, 120, 9, 550);
        boolean done = false;
        do {
            System.out.printf("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            done = coffeeUI.execute(action);
        } while (!done);
    }
}