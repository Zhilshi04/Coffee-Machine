package com.coffeemachine.coffeemachineguifx.test;

public class CoffeeMachine {
    enum Coffee {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        private int waterNeeded;
        private int milkNeeded;
        private int beansNeeded;
        private int price;
        Coffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
            this.waterNeeded = waterNeeded;
            this.milkNeeded = milkNeeded;
            this.beansNeeded = beansNeeded;
            this.price = price;
        }
        public int getWaterNeeded() {
            return waterNeeded;
        }
        public int milkNeeded() {
            return milkNeeded;
        }
        public int beansNeeded() {
            return beansNeeded;
        }
        public int price() {
            return price;
        }
    }
    private static int water;
    private static int milk;
    private static int beans;
    private static int cups;
    private static int cash;
    
    CoffeeMachine(int water, int milk, int beans, int cups, int cash) {
        CoffeeMachine.water = water;
        CoffeeMachine.milk = milk;
        CoffeeMachine.beans = beans;
        CoffeeMachine.cups = cups;
        CoffeeMachine.cash = cash;
    }

    static boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        return water >= waterNeeded &&
                milk >= milkNeeded &&
                beans >= beansNeeded &&
                cups >= 1;
    }
    public String makeCoffee(Coffee coffee) {
        if (canMakeCoffee(coffee.getWaterNeeded(), coffee.milkNeeded(), coffee.beansNeeded())) {
            water -= coffee.getWaterNeeded();
            milk -= coffee.milkNeeded();
            beans -= coffee.beansNeeded();
            cups--;
            cash += coffee.price();
            return "I have enough resources, making you a coffee!";
        } else {
            StringBuilder sb = new StringBuilder();
            if (water < coffee.getWaterNeeded()) {
                sb.append("water");
            } else if (milk < coffee.milkNeeded()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("milk");
            } else if (beans < coffee.beansNeeded()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("coffee beans");
            } else if (cups == 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("disposable cups");
            }
            return "Sorry, not enough %s!\n" + sb;
        }
    }

    public static int getWater() {
        return water;
    }

    public static void setWater(int water) {
        CoffeeMachine.water = water;
    }

    public static int getBeans() {
        return beans;
    }

    public static void setBeans(int beans) {
        CoffeeMachine.beans = beans;
    }

    public static int getMilk() {
        return milk;
    }

    public static void setMilk(int milk) {
        CoffeeMachine.milk = milk;
    }

    public static int getCash() {
        return cash;
    }

    public static void setCash(int cash) {
        CoffeeMachine.cash = cash;
    }

    public static int getCups() {
        return cups;
    }

    public static void setCups(int cups) {
        CoffeeMachine.cups = cups;
    }
}