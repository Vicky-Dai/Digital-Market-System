/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.Random;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {
  String name;
  ArrayList<SolutionOffer> so; 
  ArrayList<MarketChannelAssignment> marketChannelCombs; // though this mca, we can get the bundles and products sold in this mca  also the sales volume
  ArrayList<String> characteristics;
  ArrayList<Market> submarkets;
  ArrayList<SolutionOffer> solutionOffers;

  public Market(String name) {
    this.name = name;
    so = new ArrayList<SolutionOffer>();
    marketChannelCombs = new ArrayList<MarketChannelAssignment>();
    characteristics = new ArrayList<String>();
    submarkets = new ArrayList<Market>();

  }

  public void addSolutionOffer(SolutionOffer so) {
    this.so.add(so);
  }

  public MarketChannelAssignment setMarketChannelCombs(Channel c) {
      MarketChannelAssignment mca = new MarketChannelAssignment(this, c);
      marketChannelCombs.add(mca);
      return mca;
  }


  public MarketChannelAssignment getMarketChannelComb(Channel c) {
    for (MarketChannelAssignment mca : marketChannelCombs) {
      if (mca.getChannel().equals(c)) 
        return mca;
      
    }
    MarketChannelAssignment newMca = new MarketChannelAssignment(this, c);
    marketChannelCombs.add(newMca);
    return newMca;
  }

  public MarketChannelAssignment pickRandomMarketChannel(){
    //implement random market picker
    // Check if submarkets list is not empty
    
    // Create Random object
    Random random = new Random();

    // Generate a random index within the bounds of the submarkets list
    int randomIndex = random.nextInt(marketChannelCombs.size());

    // Return the randomly selected submarket
    return marketChannelCombs.get(randomIndex);
  
  }

  public ArrayList<SolutionOffer> getSolutionOffer() {
    return so;
  }

  public String getName() {
    return name;
  }


  public ArrayList<MarketChannelAssignment> getMarketChannelCombs() {
    return marketChannelCombs;
  }


}
