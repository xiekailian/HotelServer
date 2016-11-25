package data.promotionData;
import java.util.*;

import dataService.promotionDataService.*;
import po.*;

public class PromotionDataMock  implements PromotionDataService {

	public boolean add(PromotionPO promotion) {
		if(promotion.getDiscount()!=0)
			return true;
		return false;
	}

	public ArrayList<PromotionPO> find(String hotelnames) {
		ArrayList<PromotionPO> test=new ArrayList<PromotionPO>();
		PromotionPO pro=new PromotionPO();
		pro.setName("南京大酒店");
		if(pro.getName().equals(hotelnames))
			pro.setDiscount(0.6);
			test.add(pro);
		
		return test;
	}

	public boolean modify(PromotionPO promotion) {
		if(promotion.getDiscount()==0)
			return false;
		return true;
	}

	public boolean delete(PromotionPO promotion) {
		if(promotion.getName().equals("打"))
			return true;
		return false;
	}

}
