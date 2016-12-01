package data.userdata;

import static org.junit.Assert.*;

import java.util.Calendar;

import data.userData.*;

import org.junit.Test;

import po.*;
import po.personpo.PersonPO;

public class UserDataTest {
	UserData ud=UserData.getInstance();
	PersonPO pp=new PersonPO();
	PersonPO ppFalse=new PersonPO();//用于得出false的对象
	MarketPO mkp=new MarketPO();
	MarketPO mkpFalse=new MarketPO();
	ManagerPO magp=new ManagerPO();
	ManagerPO magpFalse=new ManagerPO();
	HotelWorkerPO hwp=new HotelWorkerPO();
	HotelWorkerPO hwpFalse=new HotelWorkerPO();

	@Test
	public void testAddPerson() {
		//每次测试需修改用户名 不然同样用户名必然返回false
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1997);
		calendar.set(Calendar.MONTH, 2);
		calendar.set(Calendar.DATE, 6);
		pp.setUsername("xmt");
		pp.setPassword("123456");
		pp.setBirthday(calendar);
		assertEquals(false,ud.addPerson(pp));
	}

	@Test
	public void testFindPerson() {
		ppFalse=ud.findPerson("不存在");
		pp=ud.findPerson("xia");
		assertEquals("111111",pp.getPassword());
		assertEquals("苏州大学",pp.getEnterpriseName());
		assertEquals(0,pp.getVipLevel());
		assertEquals(2,pp.getPersonID());
		assertEquals(null,ppFalse);
		assertEquals(6,pp.getBirthday().get(Calendar.MONTH));

	}

	@Test
	public void testModifyPerson() {
		//每次修改 不然看不出效果
		pp.setUsername("xie");
		pp.setPassword("123456789");
		pp.setEnterpriseName("苏州大学");
		pp.setVipLevel(25);
		pp.setCredit(-900);
		ppFalse.setUsername("不存在");
		assertEquals(true,ud.modifyPerson(pp));
		assertEquals(false,ud.modifyPerson(ppFalse));
	}

	@Test
	public void testPersonLogin() {
		assertEquals(true,ud.personLogin("xia", "111111"));
		assertEquals(false,ud.personLogin("xia", "123"));

		
	}

	@Test
	public void testFindMarket() {
		mkp=ud.findMarket("wuxiufeng");
		mkpFalse=ud.findMarket("不存在");
		assertEquals("555666",mkp.getPassword());
		assertEquals(null,mkpFalse);
	}

	@Test
	public void testModifyMarket() {
		mkp.setUsername("xiamutian");
		mkp.setPassword("123456");
		mkpFalse.setUsername("不存在");
		assertEquals(true,ud.modifyMarket(mkp));
		assertEquals(false,ud.modifyMarket(mkpFalse));
	}

	@Test
	public void testMarketLogin() {
		assertEquals(true,ud.marketLogin("wuxiufeng", "555666"));
		assertEquals(false,ud.marketLogin("wuxiufeng", "456465"));
	}

	@Test
	public void testChangeCredit() {
		assertEquals(true,ud.changeCredit("xia", -8000));
		assertEquals(false,ud.changeCredit("4545", 5500));
	}

	@Test
	public void testFindHotelWorker() {
		hwp=ud.findHotelWorker("xiamutian");
		hwpFalse=ud.findHotelWorker("不存在");
		assertEquals("123456",hwp.getPassword());
		assertEquals("北京大酒店",hwp.getHotelname());
		assertEquals(null,hwpFalse);
	}

	@Test
	public void testModifyHotelWorker() {
		hwp.setHotelname("北京大酒店");
		hwp.setUsername("xiamutian");
		hwp.setPassword("123456");
		hwpFalse.setUsername("不存在");
		assertEquals(true,ud.modifyHotelWorker(hwp));
		assertEquals(false,ud.modifyHotelWorker(hwpFalse));
	}

	@Test
	public void testHotelWorkerLogin() {
		assertEquals(true,ud.hotelWorkerLogin("xiamutian", "123456"));
		assertEquals(false,ud.hotelWorkerLogin("不存在", "123456"));
		assertEquals(false,ud.hotelWorkerLogin("xiamutian", "错误密码"));
	}

	@Test
	public void testAddMarket() {
		mkp.setUsername("新增");
		mkp.setPassword("123456");
		mkpFalse.setUsername("wuxiufeng");
		assertEquals(false,ud.addMarket(mkp));
		assertEquals(false,ud.addMarket(mkpFalse));
	}

	@Test
	public void testManagerLogin() {
		assertEquals(true,ud.hotelWorkerLogin("xiamutian", "123456"));
		assertEquals(false,ud.hotelWorkerLogin("不存在", "123456"));
		assertEquals(false,ud.hotelWorkerLogin("xiamutian", "错误密码"));
	}

	@Test
	public void testAddHotelWorker() {
		hwp.setHotelname("南大招待所");
		hwp.setPassword("123456");
		hwp.setUsername("新增");
		hwpFalse.setUsername("xiamutian");
		assertEquals(false,ud.addHotelWorker(hwp));
		assertEquals(false,ud.addHotelWorker(hwpFalse));
	}

}
