package com.alshekh.JavaExcercises.SimplePharmacySystem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Store {
    private ArrayList<Medicine> medicines;

    public Store()
    {
        this.medicines = new ArrayList<>();

        this.medicines.add(new Medicine(1,"Paracetamol","painkillers",50 , false,"tablet", "30 tablets", "no descriptions", 2.49f));
        this.medicines.add(new Medicine(2,"Ibubrofine","painkillers",30 , false,"tablet", "20 tablets", "no descriptions", 4.49f));
        this.medicines.add(new Medicine(3,"HYLO-COMOD","eyedrop",84 , false,"drop", "2x10 ml", "no descriptions", 17.29f));
        this.medicines.add(new Medicine(4,"EUPHRASIA COMP.","Eye ointment",26 , false,"ointment", "5 Gramm", "no descriptions", 13.99f));
        this.medicines.add(new Medicine(5,"Tromcardin complex","heart",76 , true,"tablet", "120 tablets", "no descriptions", 10.49f));
        this.medicines.add(new Medicine(6,"Milgamma protekt","diabetes",76 , true,"tablet", "90 tablets", "no descriptions", 10.49f));
    }

    public void addMedicine() {
        String name, category, description, contents, dosageForm;
        float price;
        int id, quantity;
        boolean needRecipe = false;

        id= this.medicines.size() == 0 ? 1 : this.medicines.get(this.medicines.size()  - 1).getId() + 1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name:");
        name = scanner.nextLine();

        System.out.print("Category Name:");
        category = scanner.nextLine();

        System.out.print("Description:");
        description = scanner.nextLine();

        System.out.print("Contents (mg/ml):");
        contents = scanner.nextLine();

        System.out.print("Dosage form (syrup/tablet/drop):");
        dosageForm = scanner.nextLine();

        System.out.print("Quantity:");
        quantity = scanner.nextInt();

        System.out.print("Needs Recipe (Y/N):");
        needRecipe = scanner.next().toLowerCase(Locale.ROOT).charAt(0) == 'y';

        System.out.print("Price in form(00,00):");
        price = scanner.nextFloat();

        Medicine medicine = new Medicine(id, name, category, quantity, needRecipe, dosageForm, contents, description, price);

        this.medicines.add(medicine);
    }

    public void addMultipleMedicine()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many medicines want you add? please enter the count: ");
        int medCount = scanner.nextInt();

        for (int i = 0; i < medCount; i++) {
            System.out.println("Please enter the " + (i + 1) + ". medicine infos:");
            addMedicine();
        }
    }

    public void removeMedicine(int medicineId)
    {
        this.medicines.removeIf(m -> medicineId == m.getId());
    }

    public void showAllMedicines()
    {
        this.printMedicinesTable(this.medicines);
    }

    public void printMedicinesTable(ArrayList<Medicine> medicines)
    {
        if(medicines == null || medicines.isEmpty()){
            System.out.println("There are not medicines in the store");
            return;
        }

        System.out.println("┌──────┬───────────────────────────┬────────────────────────────────┬──────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┐");
        System.out.printf("| %4s | %25s | %30s | %16s | %15s | %15s | %15s | %15s | \n", "ID", "Name", "Category name", "Price", "Dosage form", "Contents", "Need recipe", "Quantity");
        System.out.println("├──────┼───────────────────────────┼────────────────────────────────┼──────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤");
        for (Medicine m: medicines) {
            System.out.printf("| %4s | %25s | %30s | %16.2f | %15s | %15s | %15s | %15d |\n", m.getId(), m.getName(), m.getCategory(), m.getPrice(), m.getDosageForm(), m.getContents(), m.isNeedRecipe(), m.getQuantity());
        }
        System.out.println("└──────┴───────────────────────────┴────────────────────────────────┴──────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┘");
    }

    public boolean printAMedicine(int id)
    {
        for (Medicine m: medicines) {
            if(id == m.getId()){
                m.printOverView();
                return true;
            }
        }
        System.out.println("No results was found!");
        return false;
    }

    public boolean printMedicineDetails(int id)
    {
        for (Medicine m: medicines) {
            if(id == m.getId()){
                m.printDetails();
                return true;
            }
        }
        System.out.println("No results was found!");
        return false;
    }

    public Medicine getMedicine(int medId)
    {
        for (Medicine m: this.medicines) {
            if(m.getId() == medId){
                return m;
            }
        }

        return null;
    }

    public ArrayList<Medicine> searchMedicine(String searchString)
    {
        ArrayList<Medicine> medicines = new ArrayList<>();

        for (Medicine m: this.medicines) {
            if(
                Pattern.matches("(.*)(" +  searchString.toLowerCase(Locale.ROOT) + ")(.*)", m.getName().toLowerCase(Locale.ROOT)) ||
                Pattern.matches("(.*)(" +  searchString.toLowerCase(Locale.ROOT) + ")(.*)", m.getCategory().toLowerCase(Locale.ROOT))
            ){
                medicines.add(m);
            }
        }

        return medicines;
    }
}