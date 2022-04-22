// This code written by timka123
// You can use this code in commercial projects without pay
// This code is emulating a Bank devise.
// You can support me. Donate to QIWI link: https://qiwi.com/n/VAKZN
// timka123, 2022. All righes reserver(no)
// Last update: 22.04.22


package ru.timka123.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int limit = 500;

    public static void main(String[] args) {
        System.out.println("Starting...");
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Bank. You must to enter your pin for login to Private Account.");
        Integer[] pins = new Integer[]{1110, 9999, 9876, 5555};
        List<Integer> pincodes = new ArrayList<>(Arrays.asList(pins));
        int pincode = sc.nextInt();
        if (pincode == 1111) {
            staff_enter();
        } else if (pincodes.contains(pincode)) {
            // todo: create a sql database to keep names and pins
            user_authed_menu("Timka", pincode);
        }
    }

    public static void staff_enter() {
        // start message in admin panel
        System.out.println("Welcome to the bank`s admin panel");
        System.out.println("Enter 0 for exit");
        System.out.println("Enter 1 for set limit to remove money");
        System.out.println("Enter 2 for turn off");
        System.out.println("Enter 3 for call to Bank");
        // state boolean
        boolean state = true;
        // session
        while (state == true) {
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 0) {
                System.out.println("Exit from admin panel");
                state = false;
                menu();
            // edit the output limit
            } else if (command == 1) {
                System.out.println("Enter a new limit: ");
                limit = scanner.nextInt();
                System.out.println("Changed limit to " + limit);
                state = true;
            // turn off...
            } else if (command == 2) {
                System.out.println("Turning off...");
                System.exit(0);
            // meme command :D
            } else if (command == 3) {
                System.out.println("This method to call to bank is deprecated. Please, call to this number: +7 (800)-555-35-35");
                state = true;
            } else {
                // incorrect numbers handling
                System.out.println("Unknown command.");
                state = true;
            }
        }
    }


    // menu for authed user
    public static void user_authed_menu(String name, int pincode) {
        // boolean status
        boolean status = true;
        // session
        while (status) {
            // start message
            System.out.println("Bank account\nEnter 0 for exit\nEnter 1 to remove money\nEnter 2 for add money\nEnter 3 for call to Bank\nEnter 4 for credit\nEnter 5 for contribution");
            // commands scanner
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();

            if (command == 0) {
                // unlogin
                System.out.println("Return to the main menu");
                status = false;
            } else if (command == 1) {
                // withdraw money from bank account
                System.out.println("Please, enter the amount: ");
                Scanner sc = new Scanner(System.in);
                int anount = sc.nextInt();
                // check for system limit
                if (anount > limit) {
                    System.out.println("Amount is bigger than system limit. Redirect back.");
                    user_authed_menu(name, pincode);
                } else {
                    System.out.println("OK, give you " + anount);
                    user_authed_menu(name, pincode);
                }
            } else if (command == 2) {
                // add money to the bank account
                System.out.println("Enter the amount");
                Scanner sc = new Scanner(System.in);
                int anount = sc.nextInt();
                System.out.println("OK, add money to your bank account");
            } else if (command == 3) {
                // prank command :D
                System.out.println("This method to call to bank is deprecated. Please, call to this number: +7 (800)-555-xx-xx");
            } else if (command == 4) {
                // credit command
                System.out.println("What amount you want?");
                Scanner sc = new Scanner(System.in);
                int amount = sc.nextInt();
                // check for prankers
                if (amount > 1000000) {
                    System.out.println("You want very big money. You can credit maximum to 500$");
                } else {
                    System.out.println("OK, we will see your resume. Enter the phone number.");
                    Scanner s1 = new Scanner(System.in);
                    int phone = s1.nextInt();
                    System.out.println("OK, we will call you, what your resume have seen.");
                    user_authed_menu(name, pincode);
                }
            } else if (command == 5) {
                // contribution to the bank account
                System.out.println("What amount you want?");
                Scanner sc = new Scanner(System.in);
                int amount = sc.nextInt();
                System.out.println("OK, give me this amount");
                user_authed_menu(name, pincode);
            }
        }
        // check the status.
        if (status == false) {
            System.out.println("Return to main menu");
            menu();
        }
    }

}

// Made with fun by timka123 :D