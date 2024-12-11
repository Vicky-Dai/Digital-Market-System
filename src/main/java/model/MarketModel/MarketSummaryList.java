package model.MarketModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import model.ProductManagement.Product;

public class MarketSummaryList {
    
    Product subjectProduct;
    // ArrayList<Market> markets; // with the pointer of markets, get sales quantity list ....
    HashMap<Market, Integer> salesQuantityList; // sales quantity list for each market
    HashMap<Market, Integer> salesVolumeList; // sales value list for each market
    int salesVolume;
    HashMap<Market, Integer> advertisingExpenseList; // advertising expense list for each market
    float totalAdvertisingExpense;
    float Profit;
    MarketCatalog marketCatalog ;
    ArrayList<Market> markets;

    public MarketSummaryList(Product p) {
        
        subjectProduct = p;
        // markets = new ArrayList<Market>();
        salesQuantityList = p.getSalesQuantityList();
        salesVolumeList = p.getSalesVolumeList();
        salesVolume = p.getSalesVolume();
        advertisingExpenseList = p.getAdBudgetList();
        totalAdvertisingExpense = p.getAdBudget();
        Profit = p.getProfit();

      

    }

    public MarketSummaryList(Product p, MarketCatalog mc) {
        subjectProduct = p;
        // markets = new ArrayList<Market>();
        salesQuantityList = p.getSalesQuantityList();
        salesVolumeList = p.getSalesVolumeList();
        salesVolume = p.getSalesVolume();
        advertisingExpenseList = p.getAdBudgetList();
        totalAdvertisingExpense = p.getAdBudget();
        Profit = p.getProfit();
        markets = mc.getMarkets();

    }

    // product.getMarket()

    public void printMarketSummaryList(int index) {
        // System.out.println("marketlength" + markets.size());
        System.out.println(" ");
        System.out.format("%-6d%-30s%-10d%-10d%-10d%-10d%-10d%-10d%-15d%-10d%-10d%-10d%-15.1f%-15.1f", 
        index, 
        subjectProduct.getName(), 
        salesQuantityList.get(markets.get(0))==null?0:salesQuantityList.get(markets.get(0)), 
        salesQuantityList.get(markets.get(1))==null?0:salesQuantityList.get(markets.get(1)), 
        salesQuantityList.get(markets.get(2))==null?0:salesQuantityList.get(markets.get(2)),
        salesVolumeList.get(markets.get(0))==null?0:salesVolumeList.get(markets.get(0)), 
        salesVolumeList.get(markets.get(1))==null?0:salesVolumeList.get(markets.get(1)), 
        salesVolumeList.get(markets.get(2))==null?0:salesVolumeList.get(markets.get(2)), 
        salesVolume, 
        advertisingExpenseList.get(markets.get(0))==null?0:advertisingExpenseList.get(markets.get(0)),
        advertisingExpenseList.get(markets.get(1))==null?0:advertisingExpenseList.get(markets.get(1)),
        advertisingExpenseList.get(markets.get(2))==null?0:advertisingExpenseList.get(markets.get(2)),  
        totalAdvertisingExpense, 
        Profit
        );

    }
    



    

    
}
