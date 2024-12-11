package model.MarketModel;

public class ChannelSummaryList {
    String channelName;
    float salesVolume;
    int advertisingExpense;
    float efficiency;
    int rank;


    public ChannelSummaryList(Channel channel) {
        channelName = channel.getName();
        salesVolume = channel.getSalesVolume();
        advertisingExpense = channel.getAdvertisingExpense();
        efficiency = channel.getEfficiency();
    }

    public float getEfficiency() {
        return efficiency;
    }

    public void setIndexValue(int i) {
        rank = i;
    }


    public void printChannelSummary(int index) {
        // System.out.println("Channel Name: " + channelName);
        // System.out.println("Sales Volume: " + salesVolume);
        // System.out.println("Advertising Expense: " + advertisingExpense);
        // System.out.println("Efficiency: " + efficiency);
        rank = index;
        System.out.format("%-10d%-10s%-15.2f%-15d%-15.2f%n", 
            index,
            channelName, 
            salesVolume, 
            advertisingExpense, 
            efficiency
        );
    }




}
