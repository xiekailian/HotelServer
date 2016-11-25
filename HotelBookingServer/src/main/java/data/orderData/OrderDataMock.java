package data.orderData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.orderDataService.OrderDataService;
import po.OrderPO;

public class OrderDataMock implements OrderDataService {
	OrderPO order1 = new OrderPO();
	OrderPO order2 = new OrderPO();
	OrderPO order3 = new OrderPO();
	private ArrayList<OrderPO> list = new ArrayList<OrderPO>();

	public OrderDataMock() {
	}

	public ArrayList<OrderPO> personFind(String personname) {
		ArrayList<OrderPO> personList=new ArrayList<OrderPO>();
		OrderPO temp=null;
		for (int i = 0; i < list.size(); i++) {
			temp=list.get(i);
			if (temp.getPersonname().equals(personname)) {
				personList.add(temp);
			}
		}
		return personList;
	}

	public ArrayList<OrderPO> hotelFind(String hotelname) {
		ArrayList<OrderPO> hotelList=new ArrayList<OrderPO>();
		OrderPO temp=null;
		for (int i = 0; i < list.size(); i++) {
			temp=list.get(i);
			if (temp.getHotelname().equals(hotelname)) {
				hotelList.add(temp);
			}
		}
		return hotelList;
	}

	public ArrayList<OrderPO> exceptionFind() {
		// TODO Auto-generated method stub
		return list;
	}

	public void add(OrderPO order) {
		// TODO Auto-generated method stub
		
	}

	public void modify(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
