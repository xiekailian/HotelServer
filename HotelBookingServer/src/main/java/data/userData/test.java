package data.userData;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;

public class test {
	public static void main (String args[]){
//		UserData ud=new UserData();
//		PersonPO pp=new PersonPO();
//		MarketPO mp=new MarketPO();
//		HotelWorkerPO hp=new HotelWorkerPO();
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, 1997);
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.DATE, 15);
//		pp.setuserName("xia");
//		pp.setpassword("111111");
//		pp.setVipType("企业");
//		pp.setEnterpriseName("苏州大学");
//		pp.setBirthday(cal);
//		mp.setUsername("xiamutian");
//		mp.setPassword("555666");
//		hp.setUsername("xiamutian");
//		hp.setPassword("123456");
//		hp.setHotelname("苏州大酒店");
//		System.out.println(ud.addHotelWorker(hp));
		java.util.Date date=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String birth=sdf.format(date);
		System.out.println(birth);
	}
}
