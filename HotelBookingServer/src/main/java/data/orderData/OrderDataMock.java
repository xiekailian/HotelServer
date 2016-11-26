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
		ArrayList<OrderPO> result = new ArrayList<OrderPO>();
		order1.setPersonname("小夏");
		order2.setPersonname("大夏");
		order3.setPersonname("小夏");
		list.add(order1);
		list.add(order2);
		list.add(order3);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getPersonname().equals(personname))
				result.add(list.get(i));
		}
		return result;
		
	}

	public ArrayList<OrderPO> hotelFind(String hotelname) {
		ArrayList<OrderPO> hotelList=new ArrayList<OrderPO>();
		OrderPO temp=new OrderPO();
		temp.setOrderprice(1234);
		temp.setPeoplenum(5);
		temp.setHotelname("南京大酒店");
		hotelList.add(temp);
		for (int i = 0; i < list.size(); i++) {
			temp=list.get(i);
			if (temp.getHotelname().equals(hotelname)) {
				hotelList.add(temp);
			}
		}
		return hotelList;
	}

	public ArrayList<OrderPO> exceptionFind() {
		ArrayList<OrderPO> hotelList=new ArrayList<OrderPO>();
		order1.setOrderstate("未执行");
		order1.setOrderprice(3600);
		order2.setOrderstate("异常");
		order2.setOrderprice(7200);
		order3.setOrderstate("异常");
		order3.setOrderprice(9800);
		hotelList.add(order1);
		hotelList.add(order2);
		hotelList.add(order3);
		return hotelList;
	}

	public void add(OrderPO order) {
		if(order.getHotelname().equals("南京大酒店"));
		
	}

	public void modify(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
