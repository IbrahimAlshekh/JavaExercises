package com.alshekh.JavaExcercises.SimplePharmacySystem;


class Medicine {

    private final int id;
    private String name;
    private String category;
    private int quantity;
    private boolean needRecipe;
    private String dosageForm;
    private String contents;
    private String description;
    private float price;

    public Medicine(int id, String name, String category, int quantity, boolean needRecipe, String dosageForm, String contents, String description, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.needRecipe = needRecipe;
        this.dosageForm = dosageForm;
        this.contents = contents;
        this.description = description;
        this.price = price;
    }

    public void printOverView()
    {
        System.out.println("┌──────┬─────────────────────┬────────────────────────────────┬──────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┐");
        System.out.printf("| %4s | %25s | %30s | %16s | %15s | %15s | %15s | %15s | \n", "ID", "Name", "Category name", "Price", "Dosage form", "Contents", "Need recipe", "Quantity");
        System.out.println("├──────┼─────────────────────┼────────────────────────────────┼──────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤");
        System.out.printf(
                "| %4s | %25s | %30s | %16.2f | %15s | %15s | %15s | %15d |\n",
                this.id,
                this.name,
                this.category,
                this.price,
                this.dosageForm,
                this.contents,
                (this.needRecipe ? "needed": "No need"),
                this.quantity
        );
        System.out.println("└──────┴─────────────────────┴────────────────────────────────┴──────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┘");
    }

    public void printDetails()
    {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Category: " + this.category);
        System.out.println("Dosage form: " + this.dosageForm);
        System.out.println("Contents: " + this.contents);
        System.out.println("Recipe: " + (this.needRecipe ? "needed": "No need"));
        System.out.println("Price: " + this.price);
        System.out.println("Quantity in the store: " + this.quantity);
        System.out.println("Description: " + this.description);
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public String getContents() {
        return contents;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isNeedRecipe() {
        return needRecipe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }
}
