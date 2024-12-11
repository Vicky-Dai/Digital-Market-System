/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;


import java.util.ArrayList;
import java.util.HashMap;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    String name;
    HashMap<Product, Float> products;
    // ArrayList<Product> products; // to make things easier, we will assume that the bundled product is a single product
    int targetPrice;// floor, ceiling, and target ideas
    MarketChannelAssignment marketChannelComb;
    ArrayList<OrderItem> orderItems;

    public SolutionOffer(String name, MarketChannelAssignment m, int price) {
        this.name = name;
        targetPrice = price; // later maybe used in orderitem
        marketChannelComb = m;
        m.addSolutionOffer(this);
        products = new HashMap<Product, Float>();
        orderItems = new ArrayList<OrderItem>();
    }


    public void addProduct(Product p, float priceFract) {
        products.put(p, priceFract);
        p.addBundle(this);  // link back to the product, let product know that it is part of this bundle
        normalize();
    }

    // to make sure that the sum of the shares is 1
    public void normalize() {
        float total = 0f;
        for (Product product : products.keySet()) { /* products.values() 会返回 Map 中所有的值（例如产品的销售额、份额等） */
            float productPrice = product.getTargetPrice();
            total += productPrice;
        }
        for (Product product : products.keySet()) {
            float productPrice = product.getTargetPrice(); // 获取当前值
            float newValue = productPrice / total; // 计算新的值
            products.replace(product, newValue); // 使用 replace() 方法替换值
        }
    }

    public int getSalesQuantity() {
        int total = 0;
        for (OrderItem oi : orderItems) {
            total += oi.getQuantity();
        }
        return total;
    }

    public int getSalesShare(Product p) { //calculate the sales share of a product in this bundle
        Float result = products.get(p) == null ? 0 : products.get(p) * getSalesVolume(); // getSalesVolume() 返回销售总量 作用在当前类的对象身上
        return result.intValue();
    }

    // calculate the advertising budget share of a product in this bundle
    public int getProductAdsBudgetShare(Product p) {
        Float result = products.get(p) == null ? 0
                : products.get(p) * marketChannelComb.getAdvertisingExpenseShare(this); // 1. product in the bundle share 2. bundle in the mca share 3. 1*2*totaladexpense
                /*  products.get(p) --fraction of product in bundle   marketChannelComb.getAdvertisingExpenseShare(this) -- adexpense share of a bundle in mca */
        return result.intValue();
    }

    public int getBundleAdsBudget() {
        return marketChannelComb.getAdvertisingExpenseShare(this) ;
    }

    public void setPrice(int p) {
        targetPrice = p;

    }

    public void addOrderItem(OrderItem oi) {
        orderItems.add(oi);
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public String getBundleName() {
        return name +  marketChannelComb.getName();
    }

    // get the total sales volume of this bundle
    public int getSalesVolume() {
        int total = 0;
        for (OrderItem oi : orderItems) {
            total += oi.getOrderItemTotalVolume();
            //好像有点问题 ，orderitem怎么知道solutionoffer的销售额
        }
        return total;
    }

    public Market getMarket() {
        return marketChannelComb.getMarket();
    }

    public Channel getChannel() {
        return marketChannelComb.getChannel();
    }

    public String getName() {
        return name;
    }

    public HashMap<Product, Float> getProducts() {
        return products;
    }

    public MarketChannelAssignment getMarketChannelComb() {
        return marketChannelComb;
    }


    public void printProductInfo() {
        for (Product p : products.keySet()) {
            System.out.println("Product: " + p.getName() + " Price Share: " + products.get(p));
        }
    }



}
