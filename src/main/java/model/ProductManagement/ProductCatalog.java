/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Random;

import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketReport;
import model.MarketModel.MarketSummaryList;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    String type;
    ArrayList<Product> products; // list of products initially empty

    public ProductCatalog(String n) {
        type = n;
        products = new ArrayList<Product>(); /// create the list of elements otherwise it is null
    }

    // new ProductCatalog(); or new ProductCatalog("Printers");
    public ProductCatalog() {
        type = "unknown";
        products = new ArrayList<Product>();
    }

    public Product newProduct(int fp, int cp, int tp) {
        Product p = new Product(fp, cp, tp);
        products.add(p);
        return p;
    }

    public Product newProduct(String n, int fp, int cp, int tp) {
        Product p = new Product(n, fp, cp, tp);
        products.add(p);
        return p;
    }

    public ProductsReport generateProductPerformanceReport(String sortingRule) {
        ProductsReport productsReport = new ProductsReport(sortingRule);

        for (Product p : products) {
            ProductSummary ps = new ProductSummary(p);
            productsReport.addProductSummary(ps);
        }
        return productsReport;
    }

    public ArrayList<Product> getProductList() {
        return products;
    }

    public MarketReport generateMarketReport(MarketCatalog mc) {
        MarketReport marketReport = new MarketReport(mc);

        for (Product p: products) {
            MarketSummaryList ms = new MarketSummaryList(p, mc);
            marketReport.addMarketSummaryList(ms);
        }
        return marketReport;
    }

    public Product pickRandomProduct() {
        if (products.size() == 0)
            return null;
        Random r = new Random();
        int randomIndex = r.nextInt(products.size());
        return products.get(randomIndex);
    }

    public void printShortInfo() {
        int i = 1;
        System.out.println("There are " + products.size() + " products in this catalog");
        for (Product p : products) {
            System.out.println(i++  + ". " + p.getName() + " " + p.getTargetPrice());
            for (SolutionOffer so : p.getBundles()) {
                System.out.println("from: " + so.getName() + " " + so.getMarketChannelComb().getName());
            }
        }
    }
    

}
