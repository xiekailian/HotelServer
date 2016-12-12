package data.promotionData;

import java.util.ArrayList;
import java.util.Calendar;

import po.promotionpo.hotelpromotionPO.BirthdayHotelproPO;
import po.promotionpo.hotelpromotionPO.EnterpriseHotelproPO;
import po.promotionpo.hotelpromotionPO.PeriodHotelproPO;
import po.promotionpo.webpromotionPO.CircleWebproPO;
import po.promotionpo.webpromotionPO.PeriodWebproPO;
import po.promotionpo.webpromotionPO.VipLevelWebproPO;

public class test {
	public static void main(String args[]){
		
		PromotionData pd=PromotionData.getInstance();
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 11);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		
		
//		BirthdayHotelproPO bp=new BirthdayHotelproPO();
//		bp.setDiscount(5);
//		bp.setHotelnameOrWeb("南京大酒店2");
//		bp.setPromotionID(-1);
//		bp.setPromotionName("打折");
//		bp.setPromotionType("BirthdayHotelPromtion");
//		System.out.println(pd.find("南京大酒店2").get(0).getPromotionName());
		
		
//		EnterpriseHotelproPO ep=new EnterpriseHotelproPO();
//		ep.setHotelnameOrWeb("南京大酒店2");
//		ep.setDiscount(56);
//		ep.setPromotionID(9);
//		ep.setPromotionName("打折2");
//		ep.setPromotionType("EnterpriseHotelPromtion");
//		ArrayList<String> StringList=new ArrayList<String>();
//		StringList.add("南京大学");
//		pd.add(ep);
//		ep=(EnterpriseHotelproPO) pd.find("南京大酒店2").get(1);
//		System.out.println(ep.getPromotionName());
		
//		PeriodHotelproPO pp=new PeriodHotelproPO();
//		pp.setDiscount(5656);
//		pp.setPromotionType("PeriodHotelPromtion");
//		pp.setHotelnameOrWeb("南京大酒店2");
//		pp.setPromotionID(-1);
//		PeriodHotelproPO pp2=new PeriodHotelproPO();
//		pp2.setDiscount(56567878);
//		pp2.setPromotionType("PeriodHotelPromtion");
//		pp2.setHotelnameOrWeb("南京大酒店2");
//		pp2.setPromotionID(-1);
//		pd.add(pp);
//		pd.add(pp2);
//		PeriodHotelproPO pp3=new PeriodHotelproPO();
//		PeriodHotelproPO pp4=new PeriodHotelproPO();
//		pp3=(PeriodHotelproPO) pd.find("南京大酒店2").get(2);
//		pp4=(PeriodHotelproPO) pd.find("南京大酒店2").get(3);
//		System.out.println(pp3.getDiscount());
//		System.out.println(pp4.getPromotionID());

//		CircleWebproPO cp=new CircleWebproPO();
//		cp.setCircle("新街口");
//		cp.setDiscount(5656);
//		cp.setHotelnameOrWeb("WebPromotion");
//		cp.setPromotionType("CircleWebPromotion");
//		cp.setPromotionName("策略");
//		System.out.println(pd.add(cp));
		
//		PeriodWebproPO pwp=new PeriodWebproPO();
//		pwp.setDiscount(5656);
//		pwp.setPromotionName("periodweb");
//		pwp.setStartTime(cal);
//		pwp.setEndTime(cal);
//		pwp.setPromotionType("PeriodWebPromtion");
//		System.out.println(pd.add(pwp));
//		pwp=(PeriodWebproPO)pd.find("南京大酒店2").get(0);
//		System.out.println(pwp.getEndTime().get(Calendar.DATE));
		
//		VipLevelWebproPO vwp=new VipLevelWebproPO();
//		ArrayList<Integer> IntList=new ArrayList<Integer>();
//		IntList.add(1);
//		IntList.add(1);
//		IntList.add(1);
//		IntList.add(1);
//		IntList.add(1);
//		vwp.setDiscount(IntList);
//		vwp.setPromotionName("vip");
//		vwp.setPromotionType("VipLevelWebPromtion");
//		vwp=(VipLevelWebproPO) pd.find("").get(1);
//		System.out.println(vwp.getPromotionName());
		
		
	}
}
