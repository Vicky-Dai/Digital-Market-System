/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
// import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class Order {

    ArrayList<OrderItem> orderItems;
    CustomerProfile customer;
    SalesPersonProfile salesperson;
    MarketChannelAssignment mca;
    String status;
    SolutionOffer so;

    public Order() {
    }

    public Order(CustomerProfile cp) {
        orderItems = new ArrayList<OrderItem>();
        customer = cp;
        customer.addCustomerOrder(this); // we link the order to the customer
        salesperson = null;
        status = "in process";
    }

    public Order(CustomerProfile cp, SalesPersonProfile ep) {
        orderItems = new ArrayList<OrderItem>();
        customer = cp;
        salesperson = ep;
        customer.addCustomerOrder(this); // we link the order to the customer
        salesperson.addSalesOrder(this);
    }

    public OrderItem newOrderItem(SolutionOffer so, int actualPrice, int q) {
        OrderItem oi = new OrderItem(so, actualPrice, q, this);
        orderItems.add(oi);
        so.addOrderItem(oi); //important!! link order to solution offer
        // MarketChannelAssignment mca = so.getMarketChannelComb();
        // Market m = mca.getMarket();
        return oi;
    }

    // order total is the sumer of the order item totals
    public int getOrderTotal() {
        int sum = 0;
        // for (OrderItem oi : orderItems) {
        //     sum = sum + oi.getOrderItemTotal();
        // }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.calculatePricePerformance(); // positive and negative values
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    // sum all the item targets and compare to the total of the order
    public boolean isOrderAboveTotalTarget() {
        // int sum = 0;
        // for (OrderItem oi : orderItems) {
        //     sum = sum + oi.getOrderItemTargetTotal(); // product targets are added
        // }
        // if (getOrderTotal() > sum) {
        //     return true;
        // } else {
        //     return false;
        // }
        return false;

    }

    public void CancelOrder() {
        status = "Cancelled";
    }

    public void Submit() {
        status = "Submitted";
    }

    public int getNumberOfItems() {
        return orderItems.size();
    }

    public String getCustomerId() {
        return customer.getCustomerId();
    }

    public void printOrderInfo() {
        System.out.println("Order for customer: " + customer.getCustomerId());
        for (OrderItem oi : orderItems) {
            oi.printOrderItem();
        }
    }
}
