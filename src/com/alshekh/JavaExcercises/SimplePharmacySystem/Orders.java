package com.alshekh.JavaExcercises.SimplePharmacySystem;

import java.util.ArrayList;

class Orders {

    private ArrayList<Order> orders;

    public Orders() {
        this.orders = new ArrayList<Order>();
    }

    public void printOrder(int orderId)
    {
        if(this.orders == null || this.orders.isEmpty()){
            System.out.println("There are not orders yet!");
            return;
        }
        for (Order o: this.orders) {
            if(orderId == o.getId()){
                o.printOverView();
                break;
            }
        }
    }

    public void printOrderDetails(int orderId)
    {
        if(this.orders == null || this.orders.isEmpty()){
            System.out.println("There are not orders yet!");
            return;
        }
        for (Order o: this.orders) {
            if(orderId == o.getId()){
                o.printDetails();
                break;
            }
        }
    }

    public void printAllOrders()
    {
        if(this.orders == null || this.orders.isEmpty()){
            System.out.println("There are not orders yet!");
            return;
        }

        System.out.println("┌──────┬──────────────────────┬──────────────────┬──────────────────────┐");
        System.out.printf("| %4s | %20s | %16s | %20s | \n", "ID", "Medicine count", "Total price","Date");
        System.out.println("├──────┼──────────────────────┼──────────────────┼──────────────────────┤");
        for (Order o: orders) {
            System.out.printf("| %4d | %20d | %15.2f$ | %20s |\n", o.getId(), o.getMedicineCount(), o.getTotalPrice(), o.getDate());
        }
        System.out.println("└──────┴──────────────────────┴──────────────────┴──────────────────────┘");
    }

    public void makeOrder(ArrayList<Medicine> medicines)
    {
        int id = this.orders.size() == 0 ? 1 : this.orders.get(this.orders.size()  - 1).getId() + 1;

        this.orders.add(new Order(id, medicines));
    }

    public Order getLastOrder()
    {
        return this.orders.get(this.orders.size() -1);
    }

    public void printLastOdrder()
    {
        printOrder(getLastOrder().getId());
    }
}
