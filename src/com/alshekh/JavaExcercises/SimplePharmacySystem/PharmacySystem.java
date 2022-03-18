/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.alshekh.JavaExcercises.SimplePharmacySystem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class PharmacySystem {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Store store = new Store();
        Cashier cashier = new Cashier(15000);
        Orders orders = new Orders();

        System.out.println("\t<-- Welcome to our Pharmacy -->");
        printMenu();

        while (true) {
            System.out.print("Please chose an option or 12 to print the menu:");
            int userInput = scanner.nextInt();
            char confirm = '\u0000';

            if (userInput == 0) break;
            System.out.println("============== Results ===============");
            switch (userInput){
                case 1:
                    ArrayList<Medicine> orderMedicines = new ArrayList<>();
                    do {
                        System.out.print("Search a medicine:");
                        String searchText = scanner.next();
                        ArrayList<Medicine> searchResults =  store.searchMedicine(searchText);

                        if(! searchResults.isEmpty()){
                            System.out.println("The following medicine were found");
                            store.printMedicinesTable(searchResults);
                            System.out.print("Enter the medicine ID to add it to the order or 0 to repeat the search");
                            int medId = scanner.nextInt();

                            if(medId > 0){
                                System.out.print("\nCount: ");
                                int medCount = scanner.nextInt();

                                for (int i = 0; i < medCount; i++) {
                                    Medicine m = store.getMedicine(medId);
                                    orderMedicines.add(m);
                                    m.setQuantity(m.getQuantity() - 1);
                                    cashier.setTotalCache(cashier.getTotalCache()  + m.getPrice());
                                }

                                System.out.print("Add more medicines? (Y/N)");
                                confirm = scanner.next().toLowerCase(Locale.ROOT).charAt(0);
                            }
                        }else {
                            System.out.print("No results was found, search again? (Y/N)");
                            confirm = scanner.next().toLowerCase(Locale.ROOT).charAt(0);
                        }

                    } while (confirm != 'n');

                    if(! orderMedicines.isEmpty()){
                        orders.makeOrder(orderMedicines);
                        orders.printLastOdrder();
                    }

                break;
                case 2:
                    orders.printAllOrders();
                break;
                case 3:
                    System.out.print("Please enter the order id: ");
                    int orderId = scanner.nextInt();
                    orders.printOrderDetails(orderId);
                break;
                case 4:
                    System.out.printf("Total cache: %.2f \n" ,cashier.getTotalCache());
                break;
                case 5:
                    System.out.print("Enter the amount: ");
                    double newCache = scanner.nextDouble();

                    cashier.setTotalCache(cashier.getTotalCache() + newCache);

                    System.out.printf("New cache status: %.2f \n", cashier.getTotalCache());

                    scanner.reset();
                break;
                case 6:
                    System.out.print("Enter the medicine name:");
                    String searchText = scanner.next();

                    ArrayList<Medicine> searchResult = store.searchMedicine(searchText);

                    if(! searchResult.isEmpty()){
                        store.printMedicinesTable(searchResult);
                    }else {
                        System.out.println("No results was founded!");
                    }
                    scanner.reset();
                break;
                case 7:
                    store.showAllMedicines();
                break;
                case 8:
                    System.out.print("Please enter the medicine id: ");
                    int medId = scanner.nextInt();
                    store.printMedicineDetails(medId);
                    scanner.reset();
                break;
                case 9:
                    store.addMedicine();
                break;
                case 10:
                    store.addMultipleMedicine();
                break;
                case 11:
                    System.out.print("Please enter the medicine id to delete: ");
                    int medicineId = scanner.nextInt();
                    boolean searchResults = store.printAMedicine(medicineId);

                    if(searchResults){
                        System.out.println("This medicine will be removed form the system. are you sure? Y|N");
                        confirm = scanner.next().toLowerCase(Locale.ROOT).charAt(0);

                        if(confirm == 'y'){
                            store.removeMedicine(medicineId);
                            System.out.println("The medicine has been removed successfully");
                        }
                    }
                    scanner.reset();
                break;
                case 12:
                default:
                    printMenu();
            }
            System.out.println("======================================");
        }
    }

    public static void printMenu()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|              Menu                         |");
        System.out.println("| >>>>>>> Manage Orders <<<<<<              |");
        System.out.println("|    1: Make an Order                       |");
        System.out.println("|    2: Show all Orders                     |");
        System.out.println("|    3: Show Order details                  |");
        System.out.println("| >>>>>>> Manage Cache <<<<<<<              |");
        System.out.println("|    4: Show cache status                   |");
        System.out.println("|    5: Add money                           |");
        System.out.println("| >>>>>>> Manage Store <<<<<<<              |");
        System.out.println("|    6: Search a medicine                   |");
        System.out.println("|    7: Show All medicines                  |");
        System.out.println("|    8: Show medicine details               |");
        System.out.println("|    9: Add a new medicine                  |");
        System.out.println("|    10: Add Multiple medicines             |");
        System.out.println("|    11: Delete a medicine form the system  |");
        System.out.println("|    12: PrintMenu                          |");
        System.out.println("|    0: exit                                |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }
}