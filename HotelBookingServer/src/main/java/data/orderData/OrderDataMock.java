package data.orderData;

import java.util.ArrayList;

import po.OrderPO;

public class OrderDataMock extends OrderData {
	OrderPO order1 = new OrderPO();
	OrderPO order2 = new OrderPO();
	OrderPO order3 = new OrderPO();
	private ArrayList<OrderPO> list = new ArrayList<OrderPO>();

	public OrderDataMock() {
	}

	@Override
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

	@Override
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

	@Override
	public ArrayList<OrderPO> exceptionFind() {
		// TODO Auto-generated method stub
		return list;
	}

}
