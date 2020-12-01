package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void printState(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.printf("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n" + "\n", water, milk, coffeeBeans, disposableCups, money);
    }

    public static boolean hasEnoughResourcesCase1(int water, int coffeeBeans, int disposableCups) {
        boolean enough = true;
        if (water - 250 < 0) {
            System.out.println("Sorry, not enough water!\n");
            enough = false;
        } else if (coffeeBeans - 16 < 0) {
            System.out.println("Sorry, not enough coffee beans!\n");
            enough = false;
        } else if (disposableCups - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!\n");
            enough = false;
        }
        return enough;
    }

    public static boolean hasEnoughResourcesCase2(int water, int milk, int coffeeBeans, int disposableCups) {
        boolean enough = true;
        if (water - 350 < 0) {
            System.out.println("Sorry, not enough water!\n");
            enough = false;
        } else if (milk - 75 < 0) {
            System.out.println("Sorry, not enough milk!\n");
            enough = false;
        } else if (coffeeBeans - 20 < 0) {
            System.out.println("Sorry, not enough coffee beans!\n");
            enough = false;
        } else if (disposableCups - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!\n");
            enough = false;
        }
        return enough;
    }

    public static boolean hasEnoughResourcesCase3(int water, int milk, int coffeeBeans, int disposableCups) {
        boolean enough = true;
        if (water - 200 < 0) {
            System.out.println("Sorry, not enough water!\n");
            enough = false;
        } else if (milk - 100 < 0) {
            System.out.println("Sorry, not enough milk!\n");
            enough = false;
        } else if (coffeeBeans - 12 < 0) {
            System.out.println("Sorry, not enough coffee beans!\n");
            enough = false;
        } else if (disposableCups - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!\n");
            enough = false;
        }
        return enough;
    }

    public static void main(String[] args) {

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;
        boolean exit = false;

        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):\n");
            Scanner sc = new Scanner(System.in);
            String ans = sc.nextLine();

            switch (ans) {
                case "buy": {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n");
                    String sort = sc.nextLine();
                    switch (sort) {
                        case "1": {
                            boolean enough = hasEnoughResourcesCase1(water, coffeeBeans, disposableCups);
                            if (enough) {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                water -= 250;
                                coffeeBeans -= 16;
                                disposableCups -= 1;
                                money += 4;
                            }
                        } break;
                        case "2": {
                            boolean enough = hasEnoughResourcesCase2(water, milk, coffeeBeans, disposableCups);
                            if (enough) {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                water -= 350;
                                milk -= 75;
                                coffeeBeans -= 20;
                                disposableCups -= 1;
                                money += 7;
                            }
                        } break;
                        case "3": {
                            boolean enough = hasEnoughResourcesCase3(water, milk, coffeeBeans, disposableCups);
                            if (enough) {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                water -= 200;
                                milk -= 100;
                                coffeeBeans -= 12;
                                disposableCups -= 1;
                                money += 6;
                            }
                        } break;
                        case "back": break;
                    }
                } break;
                case "fill": {
                    System.out.println("Write how many ml of water do you want to add:\n");
                    water += sc.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:\n");
                    milk += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:\n");
                    coffeeBeans += sc.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:\n");
                    disposableCups += sc.nextInt();
                } break;
                case "take": {
                    System.out.printf("I gave you $%d\n", money);
                    money = 0;
                } break;
                case "remaining": printState(water, milk, coffeeBeans, disposableCups, money); break;
                case "exit": exit = true; break;
            }
        }
    }
}
