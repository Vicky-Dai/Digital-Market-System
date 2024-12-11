/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;

import model.CustomerManagement.CustomerDirectory;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.ChannelReport;
// import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketReport;
import model.MarketingManagement.MarketingPersonDirectory;
import model.OrderManagement.MasterOrderList;
import model.Personnel.EmployeeDirectory;
import model.Personnel.PersonDirectory;
import model.ProductManagement.AdvertisingCostReport;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOfferCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory;
    MasterOrderList masterorderlist;
    SupplierDirectory suppliers;
    ProductCatalog productcatalog;
    MarketCatalog marketcatalog;
    ChannelCatalog channelcatalog;
    SolutionOfferCatalog solutionoffercatalog;
    CustomerDirectory customerdirectory;
    EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;

    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory(this);
        productcatalog = new ProductCatalog();
        marketcatalog = new MarketCatalog(this);
        channelcatalog = new ChannelCatalog(this);
        solutionoffercatalog = new SolutionOfferCatalog(this);
        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        employeedirectory = new EmployeeDirectory(this);

    }

    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }

    public ProductCatalog getProductcatalog() {
        return productcatalog;
    }

    public MarketCatalog getMarketcatalog() {
        return marketcatalog;
    }

    public ChannelCatalog getChannelcatalog() {
        return channelcatalog;
    }


    public SolutionOfferCatalog getSolutionoffercatalog() {
        return solutionoffercatalog;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        // if (supplier == null) {
        //     return null;
        // }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); // return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public MarketReport prepareMarketReport(MarketCatalog marketcatalog) {
        MarketReport marketreport = productcatalog.generateMarketReport(marketcatalog);
        return marketreport;
    }

    public ChannelReport prepareChannelReport() {
        ChannelReport channelreport = channelcatalog.generateChannelReport();
        return channelreport;
    }

    public AdvertisingCostReport prepareAdvertisingCostReport() {
        AdvertisingCostReport acr = solutionoffercatalog.generateAdvertisingCostReport();
        return acr;
    }

    public void printShortInfo() {
        System.out.println("Checking what's inside the business hierarchy.");
        suppliers.printShortInfo();
        customerdirectory.printShortInfo();
        masterorderlist.printShortInfo();
    }

    public void printBusinessDemo() {
        System.out.println("Printing business demo");
        System.out.println("Business name: " + name);
        // System.out.println("Printing product catalog");
        // productcatalog.printShortInfo();

        // System.out.println("Printing market catalog");
        // marketcatalog.printShortInfo();

        // System.out.println("===================================================");

        // System.out.println("Printing channel catalog");
        // channelcatalog.printShortInfo();
        
        
        // System.out.println("Printing solution offer catalog");
        // solutionoffercatalog.printShortInfo();

        // System.out.println("Printing customer catalog");
        // customerdirectory.printShortInfo();

        // System.out.println("Printing customer directory");
        // customerdirectory.printShortInfo();

        // System.out.println("Printing master order list");
        // masterorderlist.printShortInfo();

        // System.out.println("Printing customers' orders");
        // customerdirectory.printCustomerOrders();

        // System.out.println("Printing advertising costs");
        // marketcatalog.printAdvertisingCosts();

        // System.out.println("Printing Channel SolutionOffer List");
        // channelcatalog.printChannelSolutionOfferList();

    }

}
