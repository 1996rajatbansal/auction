package CacheController;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import Pojo.Auction;
import Pojo.Bid;
import Pojo.Buyer;
import Pojo.Seller;

public class AuctionCache {
	
	public static ConcurrentHashMap<String,Buyer>buyerMap=new ConcurrentHashMap<String, Buyer>();
	
	public static ConcurrentHashMap<String,Seller>sellerMap=new ConcurrentHashMap<String, Seller>();
	public static ConcurrentHashMap<Integer, Auction>auctionMap=new ConcurrentHashMap<Integer, Auction>();
	public static ConcurrentHashMap<Integer, HashMap<String,Bid>>bidMap=new ConcurrentHashMap<>();
	
	public static ConcurrentHashMap<Integer,Integer>winningMap=new ConcurrentHashMap<>();

	public static ConcurrentHashMap<Integer, Integer> getWinningMap() {
		return winningMap;
	}
	public static void setWinningMap(ConcurrentHashMap<Integer, Integer> winningMap) {
		AuctionCache.winningMap = winningMap;
	}
	public static ConcurrentHashMap<String, Buyer> getBuyerMap() {
		return buyerMap;
	}
	public static void setBuyerMap(ConcurrentHashMap<String, Buyer> buyerMap) {
		AuctionCache.buyerMap = buyerMap;
	}
	public static ConcurrentHashMap<String, Seller> getSellerMap() {
		return sellerMap;
	}
	public static void setSellerMap(ConcurrentHashMap<String, Seller> sellerMap) {
		AuctionCache.sellerMap = sellerMap;
	}
	public static ConcurrentHashMap<Integer, Auction> getAuctionMap() {
		return auctionMap;
	}
	public static void setAuctionMap(ConcurrentHashMap<Integer, Auction> auctionMap) {
		AuctionCache.auctionMap = auctionMap;
	}
	public static ConcurrentHashMap<Integer, HashMap<String, Bid>> getBidMap() {
		return bidMap;
	}
	public static void setBidMap(ConcurrentHashMap<Integer, HashMap<String, Bid>> bidMap) {
		AuctionCache.bidMap = bidMap;
	}
	

}
