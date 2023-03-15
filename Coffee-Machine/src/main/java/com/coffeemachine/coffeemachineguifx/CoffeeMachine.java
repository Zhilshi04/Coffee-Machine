package com.coffeemachine.coffeemachineguifx;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int cash;
    private int cashOut;

    CoffeeMachine(){

    }
    CoffeeMachine(int water, int milk, int beans, int cups, int cash) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cash = cash;
    }

    boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        return water >= waterNeeded &&
                milk >= milkNeeded &&
                beans >= beansNeeded &&
                cups >= 1;
    }
    public String makeCoffee(CoffeeTypes coffee) {
        if (canMakeCoffee(coffee.getWaterMilliLitrePerCup(), coffee.getMilkMilliLitrePerCup(), coffee.getBeansGramPerCup())) {
            water -= coffee.getWaterMilliLitrePerCup();
            milk -= coffee.getMilkMilliLitrePerCup();
            beans -= coffee.getBeansGramPerCup();
            cups--;
            cash += coffee.getPricePerCup();
            return "I have enough resources, making you a coffee!";
        } else {
            StringBuilder sb = new StringBuilder();
            if (water < coffee.getWaterMilliLitrePerCup()) {
                sb.append("water");
            } else if (milk < coffee.getMilkMilliLitrePerCup()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("milk");
            } else if (beans < coffee.getBeansGramPerCup()) {
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
            return "Sorry, not enough" + sb;
        }
    }
    public String makeCoffee(CoffeeTypes coffee, int quantity) {
        if (canMakeCoffee(coffee.getWaterMilliLitrePerCup() * quantity, coffee.getMilkMilliLitrePerCup() * quantity, coffee.getBeansGramPerCup() * quantity)) {
            water -= coffee.getWaterMilliLitrePerCup() * quantity;
            milk -= coffee.getMilkMilliLitrePerCup() * quantity;
            beans -= coffee.getBeansGramPerCup() * quantity;
            cups -= quantity;
            cash += coffee.getPricePerCup() * quantity;
            return "I have enough resources, making you a coffee!";
        } else {
            StringBuilder sb = new StringBuilder();
            if (water < coffee.getWaterMilliLitrePerCup() * quantity) {
                sb.append("water");
            } else if (milk < coffee.getMilkMilliLitrePerCup() * quantity) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("milk");
            } else if (beans < coffee.getBeansGramPerCup() * quantity) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("coffee beans");
            } else if (cups < quantity) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("disposable cups");
            }
            return "Sorry, not enough" + sb;
        }
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setCashOut(int cashOut) {
        this.cashOut += cashOut;
    }

    public int getCashOut() {
        return cashOut;
    }
}
