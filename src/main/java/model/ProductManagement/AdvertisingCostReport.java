package model.ProductManagement;

import java.util.ArrayList;

public class AdvertisingCostReport {
    ArrayList<AdvertisingCostSummaryList> advertisingCostSummaryList;

    public AdvertisingCostReport() {
        advertisingCostSummaryList = new ArrayList<AdvertisingCostSummaryList>();
    }

    public void addAdvertisingCostSummaryList(AdvertisingCostSummaryList acsl) {
        advertisingCostSummaryList.add(acsl);
    }

    public void printReport() {
        int total = 0;
        System.out.println("Advertising Cost Summary");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.format("%-10s%-30s%-15s%-15s%-15s%n", 
            "Index",
            "Solution Offer", 
            "Channel", 
            "Market", 
            "Advertising Cost"
        );
        System.out.println("---------------------------------------------------------------------------------------");
        for (int i = 0; i < advertisingCostSummaryList.size(); i++) {
            advertisingCostSummaryList.get(i).printSummaryRow(i);
            total += advertisingCostSummaryList.get(i).advertisingCost;
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Total Advertising Cost: " + total);
    }

}
