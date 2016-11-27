package data.userData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import dataService.userDataService.UserDataService;
import po.HotelWorkerPO;
import po.ManagerPO;
import po.MarketPO;
import po.PersonPO;

public class UserDataMock implements UserDataService{

	public boolean addPerson(PersonPO personInfo) {
		if(personInfo.getUsername().equals("xiamutian"))
			return true;
		return false;
	}

	public PersonPO findPerson(String personname) {
		Calendar c=Calendar.getInstance();
		PersonPO pp=new PersonPO("xiamutian", "123", 123456789, 5000,c , "企业会员",5, "南京大学","13128830102");
		if(personname.equals(pp.getUsername()))
			return pp;
		return null;
	}

	public boolean modifyPerson(PersonPO personInfo) {
		Calendar c=Calendar.getInstance();
		PersonPO pp=new PersonPO("xiamutian", "123", 123456789, 5000,c , "企业会员",5, "南京大学","13128830102");
		if(personInfo.getUsername().equals(pp.getUsername())){
			pp=personInfo;
			return true;
			}
		return false;
	}

	public boolean personLogin(String personname, String password) {
		Calendar c=Calendar.getInstance();
		PersonPO pp=new PersonPO("xiamutian", "123", 123456789, 5000,c , "企业会员",5, "南京大学","13128830102");
		if(personname.equals(pp.getUsername())){
			if(password.equals(pp.getPassword()))
			return true;
			}
		return false;
		}

	public MarketPO findMarket(String marketname) {
		MarketPO pp=new MarketPO("xiamutian", "123");
		if(marketname.equals(pp.getUsername()))
			return pp;
		return null;
	}

	public boolean modifyMarket(MarketPO marketInfo) {
		MarketPO pp=new MarketPO("xiamutian", "123");
		if(marketInfo.getUsername().equals(pp.getUsername())){
			pp=marketInfo;
			return true;
			}
		return false;
		}

	public boolean marketLogin(String marketname, String password) {
		MarketPO pp=new MarketPO("xiamutian", "123");
		if(marketname.equals(pp.getUsername())){
			if(password.equals(pp.getPassword()))
			return true;
			}
		return false;
		}		

	public boolean changeCredit(String username, int credit) {
		PersonPO pp1=new PersonPO();
		pp1.setUsername("xiamutian");
		PersonPO pp2=new PersonPO();
		pp2.setUsername("xiekailian");
		ArrayList<PersonPO> List = new ArrayList<PersonPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(username)){
				return true;
			}
		}
		return false;		
	}

	public HotelWorkerPO findHotelWorker(String hotelWorkername) {
		HotelWorkerPO pp=new HotelWorkerPO("xiamutian", "123", "南京大酒店");
		if(hotelWorkername.equals(pp.getUsername()))
			return pp;
		return null;		
	}

	public boolean modifyHotelWorker(HotelWorkerPO hotelWorkerInfo) {
		HotelWorkerPO pp=new HotelWorkerPO("xiamutian", "123", "南京大酒店");
		if(hotelWorkerInfo.getUsername().equals(pp.getUsername())){
			pp=hotelWorkerInfo;
			return true;
		}
			
		return false;
		}	

	public boolean hotelWorkerLogin(String hotelWorkername, String password) {
		HotelWorkerPO pp=new HotelWorkerPO("xiamutian", "123", "南京大酒店");
		if(hotelWorkername.equals(pp.getUsername())){
			if(password.equals(pp.getPassword()))
			return true;
		}
			
		return false;
	}

	public boolean addMarket(MarketPO marketInfo) {
		if(marketInfo.getUsername().equals("xiamutian"))
			return true;
		return false;
	}

	public boolean managerLogin(String managername, String password) {
		ManagerPO pp=new ManagerPO("xiamutian", "123");
		if(managername.equals(pp.getUsername())){
			if(password.equals(pp.getPassword()))
			return true;
		}
			
		return false;
		}

	public boolean addHotelWorker(HotelWorkerPO hotelworker) {
		if(hotelworker.getUsername().equals("xiamutian"))
			return true;
		return false;
	}

}
