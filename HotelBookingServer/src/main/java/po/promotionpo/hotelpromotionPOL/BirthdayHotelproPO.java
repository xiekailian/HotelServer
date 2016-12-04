package po.promotionpo.hotelpromotionPOL;

import java.util.ArrayList;

import po.PromotionPO;

/**
 *  @author 武秀峰
 *  酒店促销策略：生日特惠折扣*/
public class BirthdayHotelproPO extends PromotionPO{
//	private String promotionType="BirthdayHotelPromtion";
	private int discount;//如打九五折时，discount=95
	
	public BirthdayHotelproPO() {
		// TODO Auto-generated constructor stub
	}
	
	public BirthdayHotelproPO(String promotionID, String promotionName, String promotionType,
			String hotelnameOrWeb, int discount) {
		super.setPromotionID(promotionID);
		super.setPromotionName(promotionName);
		super.setPromotionType(promotionType);
		super.setHotelnameOrWeb(hotelnameOrWeb);
		this.discount=discount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	

}
