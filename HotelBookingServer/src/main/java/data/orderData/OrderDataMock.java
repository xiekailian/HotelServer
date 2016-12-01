package data.orderData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.orderDataService.OrderDataService;
import po.OrderPO;

public class OrderDataMock implements OrderDataService {
	public OrderDataMock() {
	}

	public ArrayList<OrderPO> personFind(String personname) {
		OrderPO order1 = new OrderPO();
		OrderPO order2 = new OrderPO();
		OrderPO order3 = new OrderPO();
		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
		ArrayList<OrderPO> result = new ArrayList<OrderPO>();
		order1.setPersonname("小夏");
		order2.setPersonname("大夏");
		order3.setPersonname("小夏");
		order1.setHotelname("南京大酒店");
		list.add(order1);
		list.add(order2);
		list.add(order3);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPersonname().equals(personname))
				result.add(list.get(i));
		}
		return result;

	}

	public ArrayList<OrderPO> hotelFind(String hotelname) {
		OrderPO order1 = new OrderPO();
		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
		order1.setHotelname("nju");
		if (order1.getHotelname().equals(hotelname))
			;
		list.add(order1);
		return list;
	}

	public ArrayList<OrderPO> exceptionFind() {
		OrderPO order1 = new OrderPO();
		OrderPO order2 = new OrderPO();
		OrderPO order3 = new OrderPO();
		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
		ArrayList<OrderPO> hotelList = new ArrayList<OrderPO>();
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

	public boolean add(OrderPO order) {
		if (order.getPersonname().equals("xiamutain"))
			return true;
		return false;

	}

	public boolean modify(OrderPO order) throws RemoteException {
		if (order.getPersonname().equals("xiamutain"))
			return true;
		return false;

	}

}
