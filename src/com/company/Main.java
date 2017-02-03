package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scnr = new Scanner(System.in);

    public static int getDieSize(String prompt) {
        int num;

        do {
            System.out.println(prompt);
            while (!scnr.hasNextInt()) {
                System.out.println("Input error");
                System.out.println(prompt);
                scnr.nextLine();
            }
            num = scnr.nextInt();
            if (num <=0){
                System.out.println("Input error");
                scnr.nextLine();
            }

        } while (num <=0);

        return num;
    }

    public static void isSpecialRoll (int die1, int die2){

        if (die1 == 1 && die2 == 1) {
            System.out.println("Snake Eyes");
        } else if (die1 == 6 && die2 == 6) {
            System.out.println("Box Cars");
        } else if (die1 + die2 == 7) {
            System.out.println("Crap Out");
        }
    }

    public static int rollDieMethodOne (int numDieSides){
        int die = (int) (Math.random()*numDieSides+1);
        return die;
    }

    public static int rollDieMethodTwo (int numDieSides){
        Random random = new Random();
        int die = random.nextInt(numDieSides)+1;
        return die;
    }


    public static void displayRoll (int die1, int die2, int rollCounter){

        System.out.println("Roll " + rollCounter + ":");
        System.out.println(die1);
        System.out.println(die2);
        isSpecialRoll(die1, die2);

    }


    public static void main(String[] args) {
        String input = null;
        int rollCounter = 1;

        do {
            int numSides = getDieSize("Enter number of die sides");
            int die1 = rollDieMethodOne(numSides);
            int die2 = rollDieMethodOne(numSides);
            displayRoll(die1, die2, rollCounter);
            rollCounter++;
            System.out.println("Continue (Y/N)");
            scnr.nextLine();
            input = scnr.nextLine();
            while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                System.out.println("Input error");
                System.out.println("Continue? (Y/N)");
                input = scnr.nextLine();
            }
        } while (input.equalsIgnoreCase("y"));

        }
    }

