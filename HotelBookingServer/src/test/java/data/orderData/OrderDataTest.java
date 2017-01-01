package data.orderData;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import po.OrderPO;
import po.hotelPO.RoomPO;

public class OrderDataTest {
	OrderData od=OrderData.getInstance();
	@Test
	public void testAdd() {
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
		assertEquals(true,od.add(op));
	}

	@Test
	public void testPersonFind() {
		assertEquals("201602060302052000010000",od.personFind("夏沐天").get(0).getOrderID());
	}

	@Test
	public void testModify() {
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
		assertEquals(true,od.modify(op));
	}

	@Test
	public void testHotelFind() {
		assertEquals("201602060302052000010000",od.hotelFind("南京大酒店").get(0).getOrderID());

	}

	@Test
	public void testGetOrderInfo() {
		assertEquals("夏沐天",od.getOrderInfo("201602060302052000010000").getPersonname());
	}

	@Test
	public void testExceptionFind() {
		assertEquals("夏沐天",od.exceptionFind().get(0).getPersonname());

	}

}
