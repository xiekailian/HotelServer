package data.hotelData;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;

public class HotelDataTest {
	HotelData hd=HotelData.getInstance();
	@Test
	public void testShowHotelinfo() {
		assertEquals("商圈1",hd.showHotelinfo("南京大酒店"));
	}

	@Test
	public void testAddComment() {
		CommentPO cp=new CommentPO();
		cp.setContent("很好");
		cp.setHotelname("南京大酒店");
		cp.setPersonname("夏沐天");
		cp.setScore(5);
		assertEquals(true,hd.addComment(cp));
	}

	@Test
	public void testModify() {
		HotelPO hp=new HotelPO();
		ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
		RoomPO rp=new RoomPO();
		RoomPO rp1=new RoomPO();
		rp.setRoomnum("513");
		rp.setRoomPrice(1000);
		rp.setRoomType("大床房");
		rp1.setRoomnum("514");
		rp1.setRoomPrice(800);
		rp1.setRoomType("标准间");
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp1);
		rpList.add(rp1);
		
		CommentPO cp=new CommentPO();
		ArrayList<CommentPO> cpList=new ArrayList<CommentPO>();
		cp.setContent("很好");
		cp.setHotelname("南京大酒店1");
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
		hd.roomModify("njuHotel4", rpList);
		hp.setHotelname("南京大酒店1");
		hp.setAddress("南京");
		hp.setCircle("新街口");
		hp.setFeature("特色");
		hp.setHotelworker("xiamutian");
		hp.setScore(5.0);
		hp.setStar(5);
		hp.setService(ServiceList);
		hp.setComment(cpList);
		hp.setRoom(rpList);
		hp.setHotelPhone("123456798");
		hd.addComment(cp);
		assertEquals(true,hd.modify(hp));
	}

	@Test
	public void testRoomModify() {
		ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
		RoomPO rp=new RoomPO();
		RoomPO rp1=new RoomPO();
		rp.setRoomnum("513");
		rp.setRoomPrice(1000);
		rp.setRoomType("大床房");
		rp1.setRoomnum("514");
		rp1.setRoomPrice(800);
		rp1.setRoomType("标准间");
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp1);
		rpList.add(rp1);
		assertEquals(true,hd.roomModify("南京大酒店", rpList));
	}

	@Test
	public void testAddHotel() {
		HotelPO hp=new HotelPO();
		ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
		RoomPO rp=new RoomPO();
		RoomPO rp1=new RoomPO();
		rp.setRoomnum("513");
		rp.setRoomPrice(1000);
		rp.setRoomType("大床房");
		rp1.setRoomnum("514");
		rp1.setRoomPrice(800);
		rp1.setRoomType("标准间");
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp1);
		rpList.add(rp1);
		
		CommentPO cp=new CommentPO();
		ArrayList<CommentPO> cpList=new ArrayList<CommentPO>();
		cp.setContent("很好");
		cp.setHotelname("南京大酒店1");
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
		hd.roomModify("njuHotel4", rpList);
		hp.setHotelname("南京大酒店1");
		hp.setAddress("南京");
		hp.setCircle("新街口");
		hp.setFeature("特色");
		hp.setHotelworker("xiamutian");
		hp.setScore(5.0);
		hp.setStar(5);
		hp.setService(ServiceList);
		hp.setComment(cpList);
		hp.setRoom(rpList);
		hp.setHotelPhone("123456798");
		hd.addComment(cp);
		assertEquals(true,hd.addHotel(hp));
	}

	@Test
	public void testFindWithReq() {
		HotelPO hpw=new HotelPO();
		HotelPO hpb=new HotelPO();
		RoomPO rpw=new RoomPO();
		RoomPO rpb=new RoomPO();
		ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
		RoomPO rp=new RoomPO();
		RoomPO rp1=new RoomPO();
		rp.setRoomnum("513");
		rp.setRoomPrice(1000);
		rp.setRoomType("大床房");
		rp1.setRoomnum("514");
		rp1.setRoomPrice(800);
		rp1.setRoomType("标准间");
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp);
		rpList.add(rp1);
		rpList.add(rp1);
		hpw.setRoom(rpList);
		hpb.setRoom(rpList);
		hpw.setScore(0);
		hpb.setScore(5);
		hpw.setStar(0);
		hpb.setStar(5);
		hpw.setCircle("商圈1");
		hpb.setCircle("商圈1");
		assertEquals("南京大酒店",hd.findWithReq(hpw, hpb).get(0).getHotelname());
	}

}
