/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

// import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class OrderItem {

    Order order;
    SolutionOffer selectedBundle;
    int actualPrice;
    int quantity;

    public OrderItem(SolutionOffer s, int paidprice, int q, Order o) {
        selectedBundle = s;
        s.addOrderItem(this); // make sure product links back to the item
        quantity = q;
        this.actualPrice = paidprice;
        order = o;
    }

    public int getOrderItemTotalVolume() {
        return actualPrice * quantity;
    }

    // The following calculates what the price gain would have been if products were
    // sold at target price
    public int getOrderItemTargetTotal() {
        return selectedBundle.getTargetPrice() * quantity;
    }

    // returns positive if seller is making higher margin than target
    // returns negative if seller is making lower margin than target
    // otherwise zero meaning neutral
    public int calculatePricePerformance() {
        return (actualPrice - selectedBundle.getTargetPrice()) * quantity;
    }

    public boolean isActualAboveTarget() {
        if (actualPrice > selectedBundle.getTargetPrice()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isActualBelowTarget() {
        if (actualPrice < selectedBundle.getTargetPrice()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isActualATTarget() {
        if (actualPrice == selectedBundle.getTargetPrice()) {
            return true;
        } else {
            return false;
        }

    }

    public SolutionOffer getSelectedProduct() {
        return selectedBundle;
    }

    public int getActualPrice() {
        return actualPrice;

    }

    public int getQuantity() {
        return quantity;
    }

    public void printOrderItem() {
        System.out.println("Bundle: " + selectedBundle.getName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Actual Price: " + actualPrice);
        // System.out.println("Total Price: " + getOrderItemTotal());
    }

}
