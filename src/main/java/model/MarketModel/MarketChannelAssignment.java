/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.HashMap;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

  Market market;
  Channel channel;
  int advertisingExpense;
  String name;
  ArrayList<SolutionOffer> bundles;
  HashMap<SolutionOffer, Float> advertisingExpenseShare;


  public MarketChannelAssignment(Market m, Channel c) {
    bundles = new ArrayList<SolutionOffer>();
    market = m;
    channel = c;
    name = m.getName() + " - " + c.getName();
    advertisingExpenseShare = new HashMap<SolutionOffer, Float>();
  }

  public void addSolutionOffer(SolutionOffer so) {
    bundles.add(so);
  }

  public int getSalesVolume(){
    int total = 0;
    for (SolutionOffer so : bundles) {
      total += so.getSalesVolume();
    }
    return total;
  }

  // 整除导致计算出来share全都是1
  // public void setAdvertisingExpenseShare() {
  //   int totalSalesVolume = 0;
  //   for (SolutionOffer so : bundles) {
  //     totalSalesVolume += so.getSalesVolume();
  //   }
  //   for (SolutionOffer so : bundles) {
  //     float ShareofSoinBundle = so.getSalesVolume()  / totalSalesVolume;
  //     advertisingExpenseShare.put(so, ShareofSoinBundle);
  //   }
  //   // System.out.println("totalSalesVolume: " + totalSalesVolume);
  // }

  // public int getAdvertisingExpenseShare(SolutionOffer so) {
  //   // for each solution offer, its share in budget would be = sales * budget /
  //   // total sales
  //   // if (!bundles.contains(so))
  //   //   return 0;
  //   // return so.getSalesVolume() * advertisingExpense / this.getSalesVolume();
  //   setAdvertisingExpenseShare();
  //   Float share = advertisingExpenseShare.get(so);
  //   if (share == null) {
  //       return 0;
  //   }
  //   System.out.println("share: " + share);
  //   return (int) (share * advertisingExpense);
  // }
    
  public void setAdvertisingExpenseShare() {
    int totalSalesVolume = 0;
    
    // 计算总销售量
    for (SolutionOffer so : bundles) {
        totalSalesVolume += so.getSalesVolume();
    }
    
    // 确保总销售量不为零，避免除零错误
    if (totalSalesVolume == 0) {
        System.out.println("Total sales volume is zero. Cannot calculate advertising expense share.");
        return;
    }
    
    // 计算每个SolutionOffer在总销售量中的份额
    for (SolutionOffer so : bundles) {
        // 确保进行浮动数值除法
        float ShareofSoinBundle = (float) so.getSalesVolume() / totalSalesVolume;
        advertisingExpenseShare.put(so, ShareofSoinBundle);
    }
  }

  public int getAdvertisingExpenseShare(SolutionOffer so) {
      // 在调用之前确保广告费用份额已设置
      setAdvertisingExpenseShare();
      
      // 从广告费用份额中获取对应SolutionOffer的份额
      Float share = advertisingExpenseShare.get(so);
      
      // 如果没有找到对应的份额，返回 0
      if (share == null) {
          return 0;
      }
      
      // System.out.println("share: " + share);
      
      // 返回广告费用份额乘以广告总费用，转换为整数
      return (int) (share * advertisingExpense);
  }

    

  public void addBundle(SolutionOffer so) {
    bundles.add(so);
  }
  
  public String getName() {
    //implement name of market-channel comb
    return name;
  }

  public Market getMarket() {
    return market;
  }

  public Channel getChannel() {
    return channel;
  }

  public int getAdvertisingExpense() {
    return advertisingExpense;
  }

  public void setAdvertisingExpense(int advertisingExpense) {
    this.advertisingExpense = advertisingExpense;
  }

  public void printBundleInfo() {
    for (SolutionOffer so : bundles) {
      System.out.println(so.getName());
      so.printProductInfo();
    }
  }

}
