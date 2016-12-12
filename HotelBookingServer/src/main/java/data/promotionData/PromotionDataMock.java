//package data.promotionData;
//
//import java.util.*;
//
//import dataService.promotionDataService.*;
//import po.*;
//import po.promotionpo.hotelpromotionPO.EnterpriseHotelproPO;
//import po.promotionpo.webpromotionPO.VipLevelWebproPO;
//
//public class PromotionDataMock implements PromotionDataService {
//
//	public boolean add(PromotionPO promotion) {
//		return false;
//	}
//
//	public ArrayList<PromotionPO> find(String hotelnameOrWeb) {
//		//以下是酒店促销策略
//		ArrayList<String> enterprise=new ArrayList<String>();
//		enterprise.add("南京大学");
//		enterprise.add("企业2");
//		enterprise.add("企业3");
//		/*public EnterpriseHotelproPO(String promotionID, String promotionName, String promotionType,
//			String hotelnameOrWeb, ArrayList<String> enterprise, int discount)*/
//		PromotionPO hotelPro1=new EnterpriseHotelproPO(123, "hotelPro1", "EnterpriseHotelPromotion",
//				"酒店1", enterprise, 80);
//		PromotionPO hotelPro2=new EnterpriseHotelproPO(124, "hotelPro2", "EnterpriseHotelPromotion",
//				"酒店2", enterprise, 90);
//		
//		//以下是网站促销策略
//		ArrayList<Integer> vipLevel=new ArrayList<Integer>();
//		vipLevel.add(3);
//		vipLevel.add(4);
//		vipLevel.add(5);
//		ArrayList<Integer> discount=new ArrayList<Integer>();
//		discount.add(90);
//		discount.add(80);
//		discount.add(70);
//		/*	public VipLevelWebproPO(String promotionID, String promotionName, String promotionType,
//		String hotelnameOrWeb,ArrayList<Integer> vipLevel, ArrayList<Integer> discount)*/
//
//		PromotionPO webPro=new VipLevelWebproPO(456, "webPro", "VipLevelWebPromotion", 
//				"WebPromtion", vipLevel, discount);
//		
//		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
//		if(hotelnameOrWeb.equals("WebPromotion")){
//			list.add(webPro);
//		}else{
//			list.add(hotelPro1);
//			list.add(hotelPro2);
//		}
//		return list;
//	}
//
//	public boolean modify(PromotionPO promotion) {
//		return false;
//	}
//
//	public boolean delete(PromotionPO promotion) {
//		return false;
//	}
//
//}
