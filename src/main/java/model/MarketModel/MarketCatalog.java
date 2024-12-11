/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class MarketCatalog {
    Business business;
    ArrayList<Market> markets;

    public MarketCatalog(Business b){
        business = b;
        markets = new ArrayList<Market>();
    }

    public Market newMarket(String name) {
        Market market = new Market(name);
        markets.add(market);
        return market;
    }
    
    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public MarketChannelAssignment pickRandomMarketChannel(){
        //implement random market picker
        // Check if submarkets list is not empty
        if (markets.isEmpty()) {
        return null;  // Or you could throw an exception depending on your use case
        }

        // Create Random object
        Random random = new Random();

        // Generate a random index within the bounds of the submarkets list
        int randomIndex = random.nextInt(markets.size());

        MarketChannelAssignment marketchannel = markets.get(randomIndex).pickRandomMarketChannel();
        return marketchannel;
  
    }



    public void printShortInfo() {
        System.out.println(markets.size() + " Markets in the catalog");
        for (Market m : markets) {
            System.out.println(m.getName());
            for (MarketChannelAssignment mca: m.getMarketChannelCombs()) {
                System.out.println(mca.getName());
                mca.printBundleInfo();
            }
        }
    }

    public void printAdvertisingCosts() {
        for (Market m : markets) {
            System.out.println(m.getName());
            for (MarketChannelAssignment mca: m.getMarketChannelCombs()) {
                System.out.println(mca.getName());
                System.out.println("Advertising Cost: " + mca.getAdvertisingExpense());
                for (SolutionOffer so: mca.bundles) {
                    System.out.println(so.getName() + " SalesVolume is: " + so.getSalesVolume());
                    System.out.println("Advertising Expense Share: " + mca.getAdvertisingExpenseShare(so));
                }
            }
        }
    }


}
