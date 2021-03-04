package System;

public interface SystemApi {

	
	public void addBuyer(String name);
	public void addSeller(String name);
	public void createAuction(String id,String lowestBid,String highestBid,String cost,String seller) throws Exception;
	public void createBid(String buyer,String auctionId,String amount) throws Exception;
	public void withDrawBid(String buyer,String auctionId);
	public void closeAuction(String auctionId);
	public void getProfitOrLoss(String seller,String auctionId);
	public void updateBid(String buyer,String auctionId,String amount);

}
