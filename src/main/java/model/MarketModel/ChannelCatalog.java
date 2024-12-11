/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.Business.Business;
import model.ProductManagement.SolutionOffer;


/**
 *
 * @author kal bugrara
 */
public class ChannelCatalog {
    Business business;
    ArrayList<Channel> channels;

    public ChannelCatalog(Business b){
        business = b;
        channels = new ArrayList<Channel>();
    }

    public Channel newChannel(String s) {
        Channel c = new Channel(s);
        channels.add(c);
        return c;
    }
        
    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public ChannelReport generateChannelReport() {
        ChannelReport cr = new ChannelReport();
        for (Channel c : channels) {
            cr.addChannel(c);
        }
        return cr;
    }

    public void printShortInfo() {
        System.out.println(channels.size() + " Channels in the catalog");
        for (Channel c : channels) {
            System.out.println(c.getName());
            for (MarketChannelAssignment mca: c.getMarketChannelCombs()) {
                System.out.println(mca.getName());
                mca.printBundleInfo();
            }
        }
    }

    public void printChannelSolutionOfferList() {
        for (Channel c : channels) {
            System.out.println(c.getName());
            for (SolutionOffer so: c.getSolutionOffer()) {
                System.out.println(so.getName());

            }
        }
    }

}
