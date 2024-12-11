/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    String name;
    ArrayList<SolutionOffer> solutionOffers;
    ArrayList<MarketChannelAssignment> marketChannelCombs;


    public Channel(String n) {
        name = n;
        solutionOffers = new ArrayList<SolutionOffer>();

        marketChannelCombs = new ArrayList<MarketChannelAssignment>();
    }

    public float getSalesVolume() {
        float total = 0;
        for (SolutionOffer so : solutionOffers) {
          total += so.getSalesVolume();
        }
        return total;
    }

    public int getAdvertisingExpense() {
        int total = 0;
        for (SolutionOffer so : solutionOffers) {
          total += so.getBundleAdsBudget();
        }
        return total;
    }

    public float getEfficiency() {
        return getSalesVolume() / getAdvertisingExpense();
    }

    public void addSolutionOffer(SolutionOffer so) {
        solutionOffers.add(so);
    }



    public MarketChannelAssignment getMarketChannelComb(Market m) {
        for (MarketChannelAssignment mca : marketChannelCombs) {
          if (mca.getChannel().equals(m)) 
            return mca;
          
        }
        MarketChannelAssignment newMca = new MarketChannelAssignment(m, this);
        marketChannelCombs.add(newMca);
        return newMca;
      }

    public void setMarketChannelCombs(MarketCatalog mc) {
      for (Market m : mc.getMarkets()) {
        MarketChannelAssignment mca = new MarketChannelAssignment(m, this);
        marketChannelCombs.add(mca);
      }
    }

    public void addMarketChannelComb(MarketChannelAssignment mca) {
      marketChannelCombs.add(mca);
    }

    public String getName() {
      return name;
    }

    public ArrayList<SolutionOffer> getSolutionOffer() {
      return solutionOffers;
    }


    public ArrayList<MarketChannelAssignment> getMarketChannelCombs() {
      return marketChannelCombs;
    }


}
