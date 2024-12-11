package model.MarketModel;

import java.util.ArrayList;

public class MarketReport {
    ArrayList<MarketSummaryList> marketSummaryList;
    MarketCatalog marketCatalog;

    public MarketReport() {
        marketSummaryList = new ArrayList<MarketSummaryList>();
    }

    public MarketReport(MarketCatalog mc) {
        marketSummaryList = new ArrayList<MarketSummaryList>();
        marketCatalog = mc;
    }
    

    public void addMarketSummaryList(MarketSummaryList ms) {
        marketSummaryList.add(ms);
    }

    public void printMarketReport() {
        System.out.println();
        System.out.println("Market profitability Report");
        System.out.format("%-6s%-30s%-30s%-30s%-15s%-30s%-16s%-16s", "Index", "Product", "Quantities in Market", "Sales Revenues in Market", "Sales Volume", "AdBudget in Market", "Total AdBudget","Profit");
        System.out.println();
        System.out.format("%-6s%-30s%-10s%-10s%-10s%-10s%-10s%-10s%-15s%-10s%-10s%-10s%-16s%-16s", " ", " ", "US", "Mexico", "Canada", "US", "Mexico", "Canada", " ", "US", "Mexico", "Canada", " ", " ");
        System.out.println();
        int index = 1;
        for (MarketSummaryList ms : marketSummaryList) {
            ms.printMarketSummaryList(index++);
        }
        System.out.println();

        // "%-6d%-30s%-10d%-10d%-10d%-10d%-10d%-10d%-15d%-10d%-10d%-10d%-15.1f%-15.1f"
        // "%-6d%  -30s%  -10d%-10d%-10d%  -10d%-10d%-10d%  -15d%  -10d%-10d%-10d%  -15.1f%  -15.1f"
        // "%-6d%  -30s%  -10d%  -10d%  -10d%  -10d%  -10d%  -10d%  -15d%  -10d%  -10d%-10d%-15.1f%-15.1f"

    }
    


}
