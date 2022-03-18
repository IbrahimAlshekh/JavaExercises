package com.alshekh.JavaExcercises.SimplePharmacySystem;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int id;
    private String date;
    private int medicineCount;
    private float totalPrice;
    private ArrayList<Medicine> medicines;

    public Order(int id, ArrayList<Medicine> medicines) {
        this.id = id;
        this.date = getFormattedDate();
        this.medicines = medicines;
        this.medicineCount = medicines.size();
        this.totalPrice = sumTotalPrice();
    }

    private float sumTotalPrice()
    {
        float price = 0.0f;

        for (Medicine m: this.medicines) {
            price += m.getPrice();
        }
        return price;
    }

    public void printOverView()
    {
        System.out.println("┌──────┬──────────────────────┬──────────────────┬──────────────────────┐");
        System.out.printf("| %4s | %20s | %16s | %20s | \n", "ID", "Medicine count", "Total price","Date");
        System.out.println("├──────┼──────────────────────┼──────────────────┼──────────────────────┤");
        System.out.printf("| %4d | %20d | %15.2f$ | %20s |\n", this.id, this.medicineCount, this.totalPrice, this.date);
        System.out.println("└──────┴──────────────────────┴──────────────────┴──────────────────────┘");
    }

    public void printDetails()
    {
        System.out.println("Order ID: " + this.id);
        System.out.println("Order date: " + this.date);
        System.out.println("Total price: " + this.totalPrice);
        System.out.println("Count of medicines: " + this.medicineCount);
        System.out.println("┌──────┬─────────────────────┬────────────────────────────────┬──────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┐");
        System.out.printf("| %4s | %25s | %30s | %16s | %15s | %15s | %15s | %15s | \n", "ID", "Name", "Category name", "Price", "Dosage form", "Contents", "Need recipe", "Quantity");
        System.out.println("├──────┼─────────────────────┼────────────────────────────────┼──────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤");
        for (Medicine m : this.medicines){
            System.out.printf("| %4s | %25s | %30s | %16.2f | %15s | %15s | %15s | %15d |\n", m.getId(), m.getName(), m.getCategory(), m.getPrice(), m.getDosageForm(), m.getContents(), m.isNeedRecipe(), m.getQuantity());
        }
        System.out.println("└──────┴─────────────────────┴────────────────────────────────┴──────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┘");
    }


    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getMedicineCount() {
        return medicineCount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    private String getFormattedDate()
    {
        LocalDateTime myDateObj = LocalDateTime.now();

        return myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
}
