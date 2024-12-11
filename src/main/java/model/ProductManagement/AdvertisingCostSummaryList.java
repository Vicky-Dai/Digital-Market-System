package model.ProductManagement;



public class AdvertisingCostSummaryList {
    String solutionOfferName;
    String channelName;
    String marketName;
    int advertisingCost;

    public AdvertisingCostSummaryList (SolutionOffer so) {
        solutionOfferName = so.getName();
        channelName = so.getChannel().getName();
        marketName = so.getMarket().getName();
        advertisingCost = so.getBundleAdsBudget();
    }

    public void printSummaryRow(int index) {
        System.out.format("%-10d%-30s%-15s%-15s%-15d%n", 
            index,
            solutionOfferName, 
            channelName, 
            marketName, 
            advertisingCost
        );
    }


}
