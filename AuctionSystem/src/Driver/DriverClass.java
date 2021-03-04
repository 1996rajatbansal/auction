package Driver;

import System.SystemAPiImpl;
import System.SystemApi;

public class DriverClass {
	
	public static void main(String[] args) {
	
		SystemAPiImpl obj=new SystemAPiImpl(); 
		try {
		
			obj.addBuyer("buyer1");
			obj.addBuyer("buyer2");
			obj.addBuyer("buyer3");
			obj.addSeller("seller1");
			obj.createAuction("1", "10", "50", "1", "seller1");
			obj.createBid("buyer1", "1","17");
			obj.createBid("buyer2", "1","15");
			obj.updateBid("buyer2","1" ,"19");
			obj.createBid("buyer3", "1","19");
			obj.closeAuction("1");
			obj.getProfitOrLoss("seller1", "1");
			
			obj.addSeller("seller2");
			obj.createAuction("2", "5", "20", "2", "seller2");
			obj.createBid("buyer3", "2","25");
			obj.createBid("buyer2", "2", "5");
			obj.withDrawBid("buyer2", "2");
			obj.closeAuction("2");
			obj.getProfitOrLoss("seller2", "2");
		
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
