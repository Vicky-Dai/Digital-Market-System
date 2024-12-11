/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.HashMap;

import model.MarketModel.Market;
import model.MarketModel.MarketReport;
import model.MarketModel.MarketSummaryList;
import model.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class Product {
    private String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    ArrayList<SolutionOffer> bundles; // all bundles that contain this product

    public Product(int fp, int cp, int tp) {

        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        bundles = new ArrayList<SolutionOffer>();
    }

    public Product(String n, int fp, int cp, int tp) {
        name = n;
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        bundles = new ArrayList<SolutionOffer>();
    }

    public Product updateProduct(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; // returns itself
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void addBundle(SolutionOffer so) {
        bundles.add(so);
    }

    // get the sales quantity for a specific market (market perspective)
    public int getSalesQuantity(Market m) {
        int total = 0;
        for (SolutionOffer so : bundles) {
            if (so.getMarket() == m) {
                total += so.getSalesQuantity();
            }
        }
        return total;
    }

    // get the sales volume for a specific market
    public int getSalesVolumeForMarket(Market m) {
        int total = 0;
        for (SolutionOffer so : bundles) {
            if (so.getMarket() == m) {
                total += so.getSalesShare(this);
            }
        }
        return total;
    }

    // get the advertising budget for each market
    public HashMap<Market, Integer> getAdBudgetList() {
        HashMap<Market, Integer> resultsByMarket = new HashMap<Market, Integer>();
        for (SolutionOffer so : bundles) {
            Market m = so.getMarket();
            if (resultsByMarket.get(m) != null) {
                resultsByMarket.replace(m, resultsByMarket.get(m) + so.getProductAdsBudgetShare(this));
            } else {
                resultsByMarket.put(m, so.getProductAdsBudgetShare(this));
            }
        }
        return resultsByMarket;
    }
    // get total sales volume of this product in all bundle
    public int getSalesVolume() {
        int total = 0;
        for (SolutionOffer so : bundles) {
            total += so.getSalesShare(this); // get the sales volume for this product in the bundle
        }
        return total;
    }

    //get the total advertising budget for the product
    public int getAdBudget() {
        int total = 0;
        for (SolutionOffer so : bundles) {
            total += so.getProductAdsBudgetShare(this); // get the advertising budget for this product in the bundle
        }
        return total;
    }

    public int getProfit() {
        return getSalesVolume() - getAdBudget();
    }

     // get the product quantities for each market
    public HashMap<Market, Integer> getSalesQuantityList() {
        HashMap<Market, Integer> resultsByMarket = new HashMap<Market, Integer>();
        for (SolutionOffer so : bundles) {
            Market m = so.getMarket();
            //这里似乎有点问题
            if (resultsByMarket.get(m) != null) {
                resultsByMarket.replace(m, resultsByMarket.get(m) + so.getSalesQuantity());
            } else {
                resultsByMarket.put(m, so.getSalesQuantity());
            }
        }
        return resultsByMarket;
    }
     // get the product sales volume for each market
    public HashMap<Market, Integer> getSalesVolumeList() {
        HashMap<Market, Integer> resultsByMarket = new HashMap<Market, Integer>();
        for (SolutionOffer so : bundles) {
            Market m = so.getMarket();
            if (resultsByMarket.get(m) != null) {
                resultsByMarket.replace(m, resultsByMarket.get(m) + so.getSalesShare(this));
            } else {
                resultsByMarket.put(m, so.getSalesShare(this)); //if the market is not in the list, add it
            }
        }
        return resultsByMarket;
    };

    
    // Number of item sales above target
    public int getNumberOfProductSalesAboveTarget() {
        int sum = 0;
        for (SolutionOffer so : bundles) {
            // if (so.isActualAboveTarget() == true)
            //     sum = sum + 1;
        }
        return sum;
    }

    public int getNumberOfProductSalesBelowTarget() {
        int sum = 0;
        // for (SolutionOffer so : bundles) {

        //     if (oi.isActualBelowTarget() == true)
        //         sum = sum + 1;
        // }
        return sum;
    }

    public boolean isProductAlwaysAboveTarget() {

        // for (OrderItem oi : orderItems) {
        //     if (oi.isActualAboveTarget() == false)
        //         return false; //
        // }
        return true;
    }
    // calculates the revenues gained or lost (in relation to the target)
    // For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will
    // be $200
    // Add all these difference to get the total including wins and loses

    public int getOrderPricePerformance() {
        int sum = 0;
        // for (OrderItem oi : orderItems) {
        //     sum = sum + oi.calculatePricePerformance(); // positive and negative values
        // }
        return sum;
    }

    // public int getSalesVolume() {
    //     int sum = 0;
    //     // for (OrderItem oi : orderItems) {
    //     //     sum = sum + oi.getOrderItemTotal(); // positive and negative values
    //     // }
    //     return sum;
    // }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        // for (OrderItem oi : orderItems) {
        //     totalQuantity = totalQuantity + oi.getQuantity();
        // }
        return totalQuantity;
    }

    // public float getAveragePrice() {
    //     // if (getTotalQuantity() == 0)
    //     //     return 0;
    //     // return (float) getSalesVolume() / getTotalQuantity();
    // }

    public void setName(String n) {
        name = n;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public int getCeilingPrice() {
        return ceilingPrice;
    }

    // get bundles that contain this product
    public ArrayList<SolutionOffer> getBundles() {
        return bundles;
    }




}
