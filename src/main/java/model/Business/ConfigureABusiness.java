/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.Random;

import org.yaml.snakeyaml.error.Mark;

import com.github.javafaker.Faker;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
// import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  static int upperPriceLimit = 1500;
  static int lowerPriceLimit = 1000;
  static int range = 5;
  static int productMaxQuantity = 30;
  static int marketCount = 3;
  static int channelCount = 4;
  static String[] productNames = {
    "Mario Kart Standard Kart",
    "Luigi's Green Machine",
    "Peach's Royal Racer",
    "Bowser's Monster Truck",
    "Yoshi's Egg Mobile",
    "Toad's Turbo Toadster",
    "DK Jungle Buggy",
    "Wario's Wicked Wagon",
    "Waluigi's Twisted Kart",
    "Koopa Cruiser",
    "Baby Mario Stroller",
    "Shy Guy Speedster",
    "King Boo Ghost Rider",
    "Dry Bones Dune Buggy",
    "Rosalina's Cosmic Cruiser",
    "Daisy's Flower Kart",
    "Metal Mario Steel Chariot",
    "Lakitu's Cloud Runner",
    "Toadette's Toadette Kart",
    "Inkling Squid Mobile",
    "Tanooki Mario Off-Roader",
    "Cat Peach Pink Panther",
    "Bowser Jr. Mini Kart",
    "Gold Mario Gleaming Kart",
    "Dry Bowser Skeleton Kart",
    "Link's Master Cycle",
    "Villager's Retro Wagon",
    "Isabelle's Puppy Cruiser",
    "Mii Racer Custom Kart",
    "Bullet Bill Blaster"
};

// static String[] bundleNames = {
//   "Speedster Bundle",
//   "Ultimate Kart Collection",
//   "Royal Racers Set",
//   "Monster Vehicle Bundle",
//   "Egg Cart Bundle",
//   "Turbo Kart Pack",
//   "Jungle Adventure Bundle",
//   "Wicked Racing Collection",
//   "Twisted Track Bundle",
//   "Cruiser Combo",
//   "Stroller and Kart Set",
//   "Speedster Bundle"
// };

static String[] bundleNames = {
  "Speedster Bundle",
  "Ultimate Kart Collection",
  "Royal Racers Set",
  "Monster Vehicle Bundle",
  "Egg Cart Bundle",

};

static int[][] advertisingExpenses = {
  {1414001, 1663397, 1167187},  // Channel 1
  {1072266, 1040847, 626880},  // Channel 2
  {509258, 1805058, 821457},  // Channel 3
  {688083, 587244, 707078}    // Channel 4
};

static String[] marketNames = {"US", "Mexico", "Canada"};
static String[] channelNames = {"Tiktok", "ins", "X", "facebook"};

  public static Business createABusinessAndLoadALotOfData(String name, int supplierCount, int productCount,
      int customerCount, int orderCount, int orderitemCount, int bundleCount) {
    Business business = new Business(name);

    // Add Suppliers +
    loadSuppliers(business, supplierCount);

    // Add Products +
    loadProducts(business, productCount);

    // Add Customers
    loadCustomers(business, customerCount);

    // Add Markets
    loadMarkets(business, marketCount);

    // Add Channels
    loadChannels(business, channelCount);

    // Add MarketChannelAssignment
    loadMarketChannelAssignment(business);

    // Add Bundles
    loadBundles(business, bundleCount);

    // Add Order
    loadOrders(business, orderCount, orderitemCount);

    return business;
  }

  public static void loadSuppliers(Business b, int supplierCount) {
    Faker faker = new Faker();

    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    for (int index = 1; index <= supplierCount; index++) {
      supplierDirectory.newSupplier(faker.company().name());
    }
  }

  static void loadProducts(Business b, int productCount) {
    // SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    ProductCatalog productCatalog = b.getProductcatalog();


    // for (Product product : productCatalog.getProductList()) {

    //   int randomProductNumber = getRandom(1, productCount);
    //   ProductCatalog productCatalog = supplier.getProductCatalog();

    for (int index = 0; index < productCount; index++) {

      String productName = productNames[index] ;
      int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
      int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
      int randomTarget = getRandom(randomFloor, randomCeiling);

      productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
    } /* actully the price of product is not used in this model 因为都是bundle定价 */
    // }
  }

  static int getRandom(int lower, int upper) {
    Random r = new Random();

    // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
    // numbers from 10 to 15
    // I will have result = 10 + nextInt(5)
    int randomInt = lower + r.nextInt(upper - lower);
    return randomInt;
  }

  static void loadCustomers(Business b, int customerCount) {
    CustomerDirectory customerDirectory = b.getCustomerDirectory();
    PersonDirectory personDirectory = b.getPersonDirectory();

    Faker faker = new Faker();

    for (int index = 1; index <= customerCount; index++) {
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      customerDirectory.newCustomerProfile(newPerson);
    }
  }

  

  // load markets and channels
  static void loadMarkets(Business b, int marketCount){
    MarketCatalog marketCatalog = b.getMarketcatalog();
    for (int index = 1; index <= marketCount; index++) {
      marketCatalog.newMarket(marketNames[index - 1]);
    }

  }

  static void loadChannels(Business b, int channelCount){
    ChannelCatalog channelCatalog = b.getChannelcatalog();
    for (int index = 1; index <= channelCount; index++) {
      channelCatalog.newChannel(channelNames[index - 1]);
    }
  }

  static void loadMarketChannelAssignment(Business b){
    //market channel advertising Expense name bundles
    MarketCatalog marketCatalog = b.getMarketcatalog();
    ChannelCatalog channelCatalog = b.getChannelcatalog();
    for (Market market : marketCatalog.getMarkets()) {
      for (Channel channel : channelCatalog.getChannels()) {
        MarketChannelAssignment mca = market.setMarketChannelCombs(channel);
        channel.addMarketChannelComb(mca);  // ensure that mca is not created twice
      }
      
    }

    

    // set advertising expense
    for (int i = 0; i < marketCount; i++) {
      for (int j = 0; j < channelCount; j++) {
        Market market = marketCatalog.getMarkets().get(i);
        Channel channel = channelCatalog.getChannels().get(j);
        market.getMarketChannelComb(channel).setAdvertisingExpense(advertisingExpenses[j][i]);
        
      }
    }
  }


  // load bundles
  static void loadBundles(Business b, int bundleCount) {
    // 这里是Bundle对products的生成 
    SolutionOfferCatalog solutionOfferCatalog = b.getSolutionoffercatalog();
  
    MarketCatalog marketCatalog = b.getMarketcatalog();
    // SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    ProductCatalog productCatalog = b.getProductcatalog();
    int randonmbundlecount = getRandom(1, bundleCount);

    for ( Market m: marketCatalog.getMarkets()) {
      for (MarketChannelAssignment mca: m.getMarketChannelCombs()) {
        for (int index = 0; index < randonmbundlecount; index++) {
          // initialize bundle name maketchannelassignment targetprice product
          // int randomBundleNumber = getRandom(1, bundleCount);
          int randomProductNumber = getRandom(2, 5);
          int randomBundleNameIndex = getRandom(0, bundleNames.length);
          String bundleName = bundleNames[randomBundleNameIndex];
          int targetPrice = getRandom(3000, 4000);
          // Market market = marketchannel.getMarket();
          // Channel channel = marketchannel.getChannel();  load到channel和market 放在newBundle里面
          SolutionOffer solutionOffer = solutionOfferCatalog.newBundle(bundleName, mca, targetPrice);
          // pick random products
          for (int i = 0; i < randomProductNumber; i++) {
            Product p = productCatalog.pickRandomProduct();
            while(p == null) {
              System.out.println("Cannot generate bundles. No products in the product catalog.");
              p = productCatalog.pickRandomProduct();
              return;
            }
            solutionOffer.addProduct(p, 0.1f);  // 0.1f is the price fraction only for initialize, the normalize will change it
            //addProduct will add the product to the bundle and add bundle to product
          }
    
  
        }
  
      }
      
      
    }
    
  }

  /* loadorder loadbundle实现了 bundle对product和orderitem的连接 */

  static void loadOrders(Business b, int orderCount, int itemCount) {
    // TODO 这里要改成对bundle 的order

    // reach out to masterOrderList
    MasterOrderList mol = b.getMasterOrderList();

    // pick a random customer (reach to customer directory)
    CustomerDirectory cd = b.getCustomerDirectory();

    for (int index = 0; index < orderCount; index++) {

      CustomerProfile randomCustomer = cd.pickRandomCustomer();
      if (randomCustomer == null) {
        System.out.println("Cannot generate orders. No customers in the customer directory.");
        return;
      }

      // create an order for that customer
      Order randomOrder = mol.newOrder(randomCustomer);
      SolutionOfferCatalog soc = b.getSolutionoffercatalog();
      // add order items
      // -- pick a solutionoffer first (randomly)
      // -- get customer mca
      // -- provide customized bundle in specific mca

 
      // Supplier randomSupplier = sd.pickRandomSupplier();
      SolutionOffer randomBundle = soc.pickRandomBundle();
      while (randomBundle == null) {
        // System.out.println("Cannot generate orders. No supplier in the supplier directory.");
        System.out.println("the solutionoffer number is " + soc.getSolutionoffers().size());
        randomBundle = soc.pickRandomBundle();
      }

      randomOrder.newOrderItem(randomBundle, randomBundle.getTargetPrice(), itemCount);
      
     }
    }
    // Make sure order items are connected to the order

}
