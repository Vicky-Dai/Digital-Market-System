package model.System;

import java.util.Scanner;

public class CustomerShoppingSystem {
    public static void displayMainMenu() {
        System.out.println("Welcome! Please choose a system:");
        System.out.println("1. Admin Report System");
        System.out.println("2. Customer Shopping System");
        System.out.println("3. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMainMenu();  // Show the main menu

            System.out.print("Please enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Entering Admin Report System...");
                        AdminReportSystem.start();  // Start the Admin Report System
                        break;
                    case 2:
                        System.out.println("Entering Customer Shopping System...");
                        CustomerShoppingSystem.start();  // Start the Customer Shopping System
                        break;
                    case 3:
                        System.out.println("Exiting the system.");
                        scanner.close();
                        return;  // Exit the program
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }

}
