package data.hotelData;

import java.util.ArrayList;
import java.util.Calendar;

import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;

public class test {
	public static void main(String args[]){
		HotelPO hp=new HotelPO();
		RoomPO rp=new RoomPO();
		ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
		rp.setRoomnum("513");
		rp.setRoomPrice(1000);
		rp.setRoomType("大床房");
		rpList.add(rp);
		
		CommentPO cp=new CommentPO();
		ArrayList<CommentPO> cpList=new ArrayList<CommentPO>();
		cp.setContent("很好");
		cp.setHotelname("南京大酒店2");
		cp.setPersonname("夏沐天");
		cp.setScore(5);
		cpList.add(cp);
		Calendar cal=Calendar.getInstance();
		cp.setTime(cal);
		
		ArrayList<Boolean> ServiceList=new ArrayList<Boolean>();
		
		ServiceList.add(true);
		ServiceList.add(true);
		ServiceList.add(true);
		ServiceList.add(true);

		hp.setHotelname("南京大酒店2");
		hp.setAddress("南京");
		hp.setCircle("新街口");
		hp.setFeature("特色");
		hp.setHotelworker("xiamutian");
		hp.setScore(5.0);
		hp.setStar(5);
		hp.setService(ServiceList);
		hp.setComment(cpList);
		hp.setRoom(rpList);
		
		HotelData hd=new HotelData();
//		hd.addHotel(hp);
		hd.addComment(cp);
		System.out.println(hd.showHotelinfo("南京大酒店2").getAddress());
		System.out.println(hd.showHotelinfo("南京大酒店2").getRoom().get(0).getRoomType());
		System.out.println(hd.showHotelinfo("南京大酒店2").getComment().get(0).getContent());

		
	}
}
