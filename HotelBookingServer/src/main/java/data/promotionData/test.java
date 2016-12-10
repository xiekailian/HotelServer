package data.promotionData;

import po.promotionpo.hotelpromotionPO.BirthdayHotelproPO;

public class test {
	public static void main(String args[]){
		BirthdayHotelproPO bp=new BirthdayHotelproPO();
		bp.setDiscount(5);
		bp.setHotelnameOrWeb("南京大酒店2");
		bp.setPromotionID(-1);
		bp.setPromotionName("打折");
		bp.setPromotionType("BirthdayHotelPromtion");
		PromotionData pd=PromotionData.getInstance();
		System.out.println(pd.find("南京大酒店2").get(0).getPromotionName());
		
	}
}
