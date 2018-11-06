package com.company.model;

import java.util.ArrayList;

public class Market {
    //Singleton to avoid multiple markets
    private static final Market market = new Market();
    private Market(){}
    public static Market getInstance() {return market;}

    private ArrayList<Purchase> allPurchases = new ArrayList<Purchase>();

    public void addPurchase(Person customer,
                            int customerId,
                            Person seller,
                            int sellerId,
                            String goodieName,
                            long goodiePrice,
                            long goodieAmount){

        try {
            Purchase purchase = new Purchase(customer, customerId, seller, sellerId, goodieName, goodiePrice, goodieAmount);
            allPurchases.add(purchase);
        } catch (Exception exc){
            System.out.println(exc.getMessage());
        }
    }

    public String getPurchase(int purchaseId) {
        String result = "THIS PURCHASE DOESN'T EXIST!!!";
        try {
            for (Purchase purchase : allPurchases) {
                if (purchase.getPurhcaseId() == purchaseId) result = purchase.toString();
            }
        } catch (NullPointerException npe) {
            System.out.println(result + " catched exception!");
        }
        return result;
    }

    public String getAllPurchases() {
        StringBuilder sb = new StringBuilder("");
        try {
            for (Purchase purchase : allPurchases) {
                sb.append(purchase.toString());
                sb.append("\n\t---------------------\n");
            }
        } catch (NullPointerException npe) {
            System.out.println(" catched exception!");
        }
        return sb.toString();
    }

    public String getTotalPriceOfAllPurchases() {
        long result = 0L;

        for(Purchase purchase : allPurchases) {
            result += purchase.getPurchaseTotalPrice();
        }
        return Long.toString(result);
    }

    public String getTotalPriceOfAllCommission() {
        long result = 0L;

        for(Purchase purchase : allPurchases) {
            result += purchase.getPurchaseCommission();
        }
        return Long.toString(result);
    }
}
