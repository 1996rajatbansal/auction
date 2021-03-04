package Pojo;

public class Auction {
	
	int id;
	int highestBid;
	int lowestBid;
	int participationCost;
	String seller;
	int user;
	public Auction(int id, int highestBid, int lowestBid, int participationCost, String seller) {
		super();
		this.id = id;
		this.highestBid = highestBid;
		this.lowestBid = lowestBid;
		this.participationCost = participationCost;
		this.seller = seller;
	}
	public int getId() {
		return id;
	}
	public Auction(int id, int highestBid, int lowestBid, int participationCost, String seller, int user) {
		super();
		this.id = id;
		this.highestBid = highestBid;
		this.lowestBid = lowestBid;
		this.participationCost = participationCost;
		this.seller = seller;
		this.user = user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHighestBid() {
		return highestBid;
	}
	public void setHighestBid(int highestBid) {
		this.highestBid = highestBid;
	}
	public int getLowestBid() {
		return lowestBid;
	}
	public void setLowestBid(int lowestBid) {
		this.lowestBid = lowestBid;
	}
	public int getParticipationCost() {
		return participationCost;
	}
	public void setParticipationCost(int participationCost) {
		this.participationCost = participationCost;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public int getUser() {
		return user;
	}
	public void incrementUser() {
		this.user++;
	}
	public void decrementUser() {
		this.user--;
	}

}
