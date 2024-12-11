package model.MarketModel;

import java.util.ArrayList;

public class ChannelReport {
    ArrayList<ChannelSummaryList> channelSummaryList;

    public ChannelReport() {
        channelSummaryList = new ArrayList<ChannelSummaryList>();
    }

    public void addChannel(Channel c) {
        ChannelSummaryList csl = new ChannelSummaryList(c);
        channelSummaryList.add(csl);
    }

    public void printChannelReport() {
        int index = 1;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Channel Profitability Report");
        System.out.println("--------------------------------------------------------------");
        System.out.format("%-10s%-10s%-15s%-15s%-15s%n", 
            "Index",
            "Channel", 
            "Sales Volume", 
            "Ad Expense", 
            "Efficiency"
        );
        for (ChannelSummaryList csl : channelSummaryList) {
           csl.printChannelSummary(index++);
        }
        System.out.println("--------------------------------------------------------------");
    }

    // public void sortByEfficiency() {
    //     channelSummaryList.sort((ChannelSummaryList cs1, ChannelSummaryList cs2) -> cs2.getEfficiency() - cs1.getEfficiency());
    //     for (ChannelSummaryList csl : channelSummaryList) {
    //         csl.setIndexValue(channelSummaryList.indexOf(csl) + 1);
    //     }
    // }
    public void sortByEfficiency() {
        // 使用 Float.compare() 来比较 float 类型的值
        channelSummaryList.sort((cs1, cs2) -> Float.compare(cs2.getEfficiency(), cs1.getEfficiency()));
        //let summarylist sort by efficiency (float) without changing the index
        for (int i = 0; i < channelSummaryList.size(); i++) {
            ChannelSummaryList csl = channelSummaryList.get(i); 
            csl.setIndexValue(i + 1);  // 索引值从 1 开始  set index
        }
    }
    
    
}
