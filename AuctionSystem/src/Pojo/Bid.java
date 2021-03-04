package Pojo;

public class Bid {

	int  auction;
	String buyer;
	int amount;
	public int getAuction() {
		return auction;
	}
	public void setAuction(int auction) {
		this.auction = auction;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Bid(int auction, String buyer, int amount) {
		super();
		this.auction = auction;
		this.buyer = buyer;
		this.amount = amount;
	}

}
