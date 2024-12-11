/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.Business.Business;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    Business business;
    ArrayList<SolutionOffer> solutionoffers;
    
    public ArrayList<SolutionOffer> getSolutionoffers() {
        return solutionoffers;
    }

    public SolutionOfferCatalog(Business b){
        business = b;
        solutionoffers = new ArrayList<SolutionOffer>();
    }

    public SolutionOffer newBundle(String name, MarketChannelAssignment mca, int tp) {
        SolutionOffer bundle = new SolutionOffer(name, mca, tp);
        solutionoffers.add(bundle);
        Market m = mca.getMarket();
        m.addSolutionOffer(bundle);
        Channel c = mca.getChannel();
        c.addSolutionOffer(bundle);
        return bundle;
    }

    // public HashMap<Channel, Float> getSalesVolumebyChannel() {
    //     HashMap<Channel, Float> salesVolumebyChannel = new HashMap<Channel, Float>();
    //     // for (SolutionOffer so : solutionoffers) {
    //     //     for (Map.Entry<Channel, Float> entry : so.getChannels().entrySet()) {
    //     //         Channel channel = entry.getKey();
    //     //         Float fraction = entry.getValue();
    //     //         Float salesVolume = so.getSalesVolume() * fraction;
    //     //         if (salesVolumebyChannel.containsKey(channel)) {
    //     //             salesVolumebyChannel.put(channel, salesVolumebyChannel.get(channel) + salesVolume);
    //     //         } else {
    //     //             salesVolumebyChannel.put(channel, salesVolume);
    //     //         }
    //     //     }
    //     // }
    // }

    public SolutionOffer pickRandomBundle() {
        // TODO implement picking random bundle
       
        Random r = new Random();
        if (solutionoffers.size() == 0)
            return null;
        return solutionoffers.get(r.nextInt(solutionoffers.size()));

    }

    public AdvertisingCostReport generateAdvertisingCostReport () {
        AdvertisingCostReport acr = new AdvertisingCostReport();
        for (SolutionOffer so : solutionoffers) {
            AdvertisingCostSummaryList acsl = new AdvertisingCostSummaryList(so);
            acr.addAdvertisingCostSummaryList(acsl);
        }
        return acr;
    }

    public void printShortInfo() {
        System.out.println(solutionoffers.size() + " Bundles in the catalog");
        int i = 1;
        for (SolutionOffer so : solutionoffers) {
            System.out.println(i++ + ". " + so.getName() + " Price: " + so.getTargetPrice());
            for (Map.Entry<Product, Float> entry : so.getProducts().entrySet()) { 
                Product product = entry.getKey();
                int targetPrice = product.getTargetPrice();
                int bundletargetPrice = so.getTargetPrice();
                Float fraction = entry.getValue();
                Float priceInBundle = bundletargetPrice * fraction;
                System.out.println("Product: " + product.getName() + ", Price: " + targetPrice + ", Fraction: " + fraction + ", Price in Bundle: " + priceInBundle);
}
        }
    }



}
