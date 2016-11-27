package data.promotionData;
import java.util.*;

import dataService.promotionDataService.*;
import po.*;

public class PromotionDataMock implements PromotionDataService {

	public boolean add(PromotionPO promotion) {
		if(promotion.getName().equals("双十一打折"))
			return true;
		return false;
	}

	public ArrayList<PromotionPO> find(String hotelnames) {
		ArrayList<PromotionPO> list=new ArrayList<PromotionPO>();
		PromotionPO po1=new PromotionPO();
		po1.setName("双十一折扣");
		po1.get
		po1.setType("111");
		PromotionPO po2=new PromotionPO();
		po2.setName("双十二折扣");
		list.add(po2);
		list.add(po1);
		return list;
	}

	public boolean modify(PromotionPO promotion) {
		if(promotion.getName().equals("一二"))
			return true;
		return false;
	}

	public boolean delete(PromotionPO promotion) {
		if(promotion.getName().equals("一二"))
			return true;
		return false;
	}


}
