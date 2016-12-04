package data.orderData;

import java.util.ArrayList;

import dataService.orderDataService.OrderDataService;
import po.OrderPO;

public class OrderData /* implements OrderDataService */{

	private ArrayList<OrderPO> list = null;

	private static OrderData orderData = null;

	public static OrderData getInstance() {
		if (orderData == null) {
			orderData = new OrderData();
			return orderData;
		}
		return orderData;
	}

	public OrderData() {
	}

	public void add(OrderPO order) {
		// TODO Auto-generated method stub

	}

	public ArrayList<OrderPO> personFind(String personname) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modify(OrderPO order) {
		// TODO Auto-generated method stub

	}

	public ArrayList<OrderPO> hotelFind(String hotelname) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> exceptionFind() {
		// TODO Auto-generated method stub
		return null;
	}

}
