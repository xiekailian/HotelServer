package data.orderData;
import java.util.ArrayList;
import java.util.Calendar;

import po.hotelPO.*;
import po.OrderPO;
public class test {
	public static void main(String args[]){
		RoomPO rp=new RoomPO();
		ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
		rp.setRoomnum("513");
		rp.setRoomPrice(1000);
		rp.setRoomType("大床房");
		rpList.add(rp);
		OrderPO op=new OrderPO();
		op.setOrderID("2016120610410000011111");
		op.setOrderprice(1000);
		op.setOrderstate("异常");
		op.setHotelname("南京大酒店");
		op.setPersonname("xiamutian");
		op.setRealname("夏沐天");
		op.setPeoplenum(5);
		op.setChildnum(0);
		Calendar cal=Calendar.getInstance();
		op.setProducttime(cal);
		op.setExecutetime(cal);
		op.setCanceltime(cal);
		op.setPredictExecutetime(cal);
		op.setPredictLeaveTime(cal);
		op.setActualLeaveTime(cal);
		op.setRoom(rpList);
		op.setPersonPhone("56556456");
		op.setRoomNum(5);
		OrderData od=new OrderData();
		System.out.println(od.exceptionFind().get(0).getPersonPhone());

	}
}
