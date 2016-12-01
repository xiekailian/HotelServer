package data.promotionData;
import java.util.*;

import dataService.promotionDataService.*;
import po.*;

public class PromotionDataMock implements PromotionDataService {

	public boolean add(PromotionPO promotion) {
		return false;
	}

	public ArrayList<PromotionPO> find(String hotelnames) {
		ArrayList<PromotionPO> list=new ArrayList<PromotionPO>();
		PromotionPO po1=new PromotionPO();
		PromotionPO po2=new PromotionPO();

		list.add(po2);
		list.add(po1);
		return list;
	}

	public boolean modify(PromotionPO promotion) {
		return false;
	}

	public boolean delete(PromotionPO promotion) {
		return false;
	}


}
