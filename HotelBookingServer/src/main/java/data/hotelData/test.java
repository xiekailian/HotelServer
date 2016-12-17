//package data.hotelData;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//
//import po.hotelPO.CommentPO;
//import po.hotelPO.HotelPO;
//import po.hotelPO.RoomPO;
//
//public class test {
//	public static void main(String args[]){
//		HotelData hd=new HotelData();
//		HotelPO hpw=new HotelPO();
//		HotelPO hpb=new HotelPO();
//		RoomPO rpw=new RoomPO();
//		RoomPO rpb=new RoomPO();
//
////		HotelPO hp=new HotelPO();
////		ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
////		rp.setRoomnum("513");
////		rp.setRoomPrice(500);
////		rp.setRoomType("大床房");
////		rpList.add(rp);
////		
////		CommentPO cp=new CommentPO();
////		ArrayList<CommentPO> cpList=new ArrayList<CommentPO>();
////		cp.setContent("很好");
////		cp.setHotelname("南京大酒店1");
////		cp.setPersonname("夏沐天");
////		cp.setScore(5);
////		cpList.add(cp);
////		Calendar cal=Calendar.getInstance();
////		cp.setTime(cal);
////		
////		ArrayList<Boolean> ServiceList=new ArrayList<Boolean>();
////		
////		ServiceList.add(true);
////		ServiceList.add(true);
////		ServiceList.add(true);
////		ServiceList.add(true);
////
////		hp.setHotelname("南京大酒店1");
////		hp.setAddress("南京");
////		hp.setCircle("新街口");
////		hp.setFeature("特色");
////		hp.setHotelworker("xiamutian");
////		hp.setScore(5.0);
////		hp.setStar(5);
////		hp.setService(ServiceList);
////		hp.setComment(cpList);
////		hp.setRoom(rpList);
////		
////
////		hd.addHotel(hp);
////		hd.addComment(cp);
////		System.out.println(hd.showHotelinfo("南京大酒店1").getAddress());
////		System.out.println(hd.showHotelinfo("南京大酒店1").getRoom().get(0).getRoomType());
////		System.out.println(hd.showHotelinfo("南京大酒店1").getComment().get(0).getContent());
//		ArrayList<RoomPO> best=new ArrayList<RoomPO>();
//		rpb.setRoomPrice(-1);
//		best.add(rpb);
//		
//		ArrayList<RoomPO> worst=new ArrayList<RoomPO>();
//		rpw.setRoomPrice(2000);
//		worst.add(rpw);
//
//		hpw.setCircle("新街口");
//		hpw.setHotelname("大酒店");
//		hpw.setScore(0);
//		hpw.setStar(0);
//		hpw.setRoom(worst);
//		hpb.setCircle("新街口");
//		hpb.setHotelname("大酒店");
//		hpb.setScore(5);
//		hpb.setStar(5);
//		hpb.setRoom(best);	
//		System.out.println(best.get(0).getRoomPrice());
//		System.out.println(hpb.getRoom().get(0).getRoomPrice());
//
//
//		ArrayList<HotelPO> hpList=new ArrayList<HotelPO>();
//		hpList=hd.findWithReq(hpw, hpb);
//		System.out.println(hpList.get(0).getHotelname());		
//	}
//}
