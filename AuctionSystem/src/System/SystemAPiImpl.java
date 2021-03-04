package System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import CacheController.AuctionCache;
import Pojo.Auction;
import Pojo.Bid;
import Pojo.Buyer;
import Pojo.Seller;

public class SystemAPiImpl implements SystemApi {

	@Override
	public void addBuyer(String name) {
		// TODO Auto-generated method stub
		AuctionCache.getBuyerMap().put(name,new Buyer(name));
		
		
	}

	@Override
	public void addSeller(String name) {
		// TODO Auto-generated method stub
		AuctionCache.getSellerMap().put(name,new Seller(name));
		
	}

	@Override
	public void createAuction(String id, String lowestBid, String highestBid, String cost, String seller) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			AuctionCache.getAuctionMap().put(Integer.parseInt(id),new Auction(Integer.parseInt(id), Integer.parseInt(highestBid), Integer.parseInt(lowestBid), Integer.parseInt(cost), seller));
			
		} catch (Exception e) {
	
			e.printStackTrace();
			throw new Exception("Unable to create Auction");
		}
		
	}

	@Override
	public void createBid(String buyer, String auctionId, String amount) throws Exception {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(auctionId);
		int bidAmount=Integer.parseInt(amount);
		HashMap<String,Bid>hashMap;
		Auction auction=null;
		try {
			
			if(!AuctionCache.auctionMap.containsKey(id))
			{
				throw new Exception("Given Auction is not exixts..");
			}
			
			auction=AuctionCache.auctionMap.get(id);
			if(bidAmount>auction.getHighestBid()||bidAmount<auction.getLowestBid())
			{
				//auction.incrementUser();
				throw new Exception("Bid amount is not possible");
			}
			
			if(!AuctionCache.getBidMap().containsKey(id))
			{
			hashMap=new HashMap<String, Bid>();
			AuctionCache.getBidMap().put(id, hashMap);
			}

			AuctionCache.getBidMap().get(id).put(buyer,new Bid(id, buyer, bidAmount));
			auction.incrementUser();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//throw e;
		}
		
	}

	@Override
	public void withDrawBid(String buyer, String auctionId) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(auctionId.trim());
		try {
			
			//System.out.println(	AuctionCache.getBidMap().get(id));
			AuctionCache.getBidMap().get(id).remove(buyer);
	
	//		AuctionCache.getAuctionMap().get(id).decrementUser();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void closeAuction(String auctionId) {
		int id=Integer.parseInt(auctionId);
		try {
			
			Bid bid=getMinUniquePrice(id);
			AuctionCache.getBidMap().remove(id);
			if(bid==null)
			{
				AuctionCache.getWinningMap().put(id,-1);
				System.out.println("No User found");
			}
			else {
				System.out.println("Bid amount:"+bid.getAmount()+" "+bid.getBuyer());
				AuctionCache.getWinningMap().put(id, bid.getAmount());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getProfitOrLoss(String seller, String auctionId) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(auctionId);
		int bidAmount=AuctionCache.winningMap.get(id);
		int highestBid=AuctionCache.getAuctionMap().get(id).getHighestBid();
		int lowest=AuctionCache.getAuctionMap().get(id).getLowestBid();
		int cost=AuctionCache.getAuctionMap().get(id).getParticipationCost();
		int user=AuctionCache.getAuctionMap().get(id).getUser();
		if(bidAmount==-1)
		{
			System.out.println("Profit/loss="+((user*0.2*cost)));	
		}
		else {
			System.out.println("Profit/loss="+(bidAmount-((highestBid+lowest)/2)+(user*0.2*cost)));
		}
		
		
	}
	
	public  static Bid  getMinUniquePrice(int auctionId)
	{
		HashMap<Integer,Bid>treeMap=new HashMap<Integer, Bid>();
		ArrayList<Integer>list=new ArrayList<Integer>();
		
		try {
			String userName;
			Bid bid;
			//System.out.println("List:"+AuctionCache.getBidMap().get(auctionId));
			Iterator<String>itr=AuctionCache.getBidMap().get(auctionId).keySet().iterator();
			while(itr.hasNext())
			{
			userName=itr.next();
				bid=AuctionCache.getBidMap().get(auctionId).get(userName);
			treeMap.put(bid.getAmount(),bid);
			list.add(bid.getAmount());
			}
			Collections.sort(list,Collections.reverseOrder());
			//System.out.println("List:"+list.toString());
			if(list.size()==0)
			{
				return null;
			}
			if(list.size()==1)
			{
				return treeMap.get(list.get(0));
			}
			for(int i=1;i<list.size()-1;i++)
			{
				if(list.get(i)!=list.get(i-1)&&list.get(i)!=list.get(i+1))
				{
					return treeMap.get(list.get(i));
				}
			}
			if(list.get(list.size()-1)!=list.get(list.size()-2))
			{
				return treeMap.get(list.get(list.size()-1));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void updateBid(String buyer, String auctionId, String amount) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(auctionId);
		AuctionCache.bidMap.get(id).get(buyer).setAmount(Integer.parseInt(amount));
	}

}
