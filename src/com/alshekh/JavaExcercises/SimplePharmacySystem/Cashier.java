package com.alshekh.JavaExcercises.SimplePharmacySystem;


class Cashier {
    
    private double totalCache;
    public Cashier(double totalCache) {
        this.totalCache = totalCache;
    }

    public double getTotalCache() {
        return totalCache;
    }

    public void setTotalCache(double totalCache) {
        this.totalCache = totalCache;
    }
}

