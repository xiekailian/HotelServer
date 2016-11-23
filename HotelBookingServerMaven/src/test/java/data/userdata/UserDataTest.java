package data.userdata;

import static org.junit.Assert.*;

import data.userData.UserData;
import data.userdata.*;

import org.junit.Test;

import po.PersonPO;

public class UserDataTest {
	UserData ud=new UserData();
	PersonPO pp=new PersonPO();
	PersonPO ppFalse=new PersonPO();//用于得出false的对象
	@Test
	public void testAddPerson() {
		//每次测试需修改用户名 不然同样用户名必然返回false
		pp.setuserName("xie");
		pp.setpassword("123456");
		pp.setVIPinfo("");
		assertEquals(false,ud.addPerson(pp));
	}

	@Test
	public void testFindPerson() {
		ppFalse=ud.findPerson("不存在");
		pp=ud.findPerson("xia");
		assertEquals("xia",pp.getuserName());
		assertEquals("",pp.getpassword());
		assertEquals("南京大学",pp.getVIPinfo());
		assertEquals(24,pp.getVIPlevel());
		assertEquals(2,pp.getPersonID());
		assertEquals(1000,pp.getCredit());
		assertEquals(null,ppFalse);

	}

	@Test
	public void testModifyPerson() {
		//每次修改 不然看不出效果
		pp.setuserName("xie");
		pp.setpassword("123456789");
		pp.setVIPinfo("北京大学");
		pp.setVIPlevel(23);
		pp.setCredit(-900);
		ppFalse.setuserName("不存在");
		assertEquals(true,ud.modifyPerson(pp));
		assertEquals(false,ud.modifyPerson(ppFalse));
	}

	@Test
	public void testPersonLogin() {
		assertEquals(true,ud.personLogin("xia", "123465"));
		assertEquals(false,ud.personLogin("xia", "123"));

		
	}

	@Test
	public void testFindMarket() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyMarket() {
		fail("Not yet implemented");
	}

	@Test
	public void testMarketLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeCredit() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindHotelWorker() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyHotelWorker() {
		fail("Not yet implemented");
	}

	@Test
	public void testHotelWorkerLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddMarket() {
		fail("Not yet implemented");
	}

	@Test
	public void testManagerLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testHotelWorkerAdd() {
		fail("Not yet implemented");
	}

}
