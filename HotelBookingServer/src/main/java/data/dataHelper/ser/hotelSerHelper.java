package data.dataHelper.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.hotelPO.CommentPO;
import po.hotelPO.RoomPO;

public class hotelSerHelper {
	String path = "src/main/resources/order/";

	/**
	 * 写入roomtype ser文件
	 * 
	 * @param hotelname
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public boolean writeRoomTypeSer(String orderID, ArrayList<String> object)
			throws IOException {
		String path = "src/main/resources/hotel/";
		path = path + orderID + "/" + "roomtype.txt";
		File RoomType = new File(path);
		boolean exists = RoomType.exists();
		if (exists == false) {
			RoomType.createNewFile();
		}
		try {
				FileOutputStream fos = new FileOutputStream(RoomType);// out和in不能同时被实例化
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(object);
				oos.flush();
				oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取roomtype ser文件
	 * 
	 * @param hotelname
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> readRoomtypeSer(String orderID)
			throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		String path = "src/main/resources/order/";
		path = path + orderID + "/" + "roomtype.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				result = (ArrayList<String>) ois.readObject();
				ois.close();
				return result;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;

		}
	}

	/**
	 * 写入roomnum ser文件
	 * 
	 * @param orderID
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public boolean writeRoomNumSer(String orderID, ArrayList<Integer> object)
			throws IOException {
		String path = "src/main/resources/hotel/";
		path = path + orderID + "/" + "roomnum.txt";
		File RoomNum = new File(path);
		boolean exists = RoomNum.exists();
		if (exists == false) {
			RoomNum.createNewFile();
		}
		try {
				FileOutputStream fos = new FileOutputStream(RoomNum);// out和in不能同时被实例化
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(object);
				oos.flush();
				oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取roomnum ser文件
	 * 
	 * @param orderID
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> readRoomNumSer(String orderID)
			throws IOException {
		ArrayList<Integer> result = new ArrayList<Integer>();
		String path = "src/main/resources/order/";
		path = path + orderID + "/" + "roomnum.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				result = (ArrayList<Integer>) ois.readObject();
				ois.close();
				return result;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;

		}
	}
	/**
	 * 写入theNumOfRoom ser文件
	 * 
	 * @param hotelname
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public boolean writetheNumOfRoomSer(String orderID, ArrayList<String> object)
			throws IOException {
		String path = "src/main/resources/hotel/";
		path = path + orderID + "/" + "NumOfRoom.txt";
		File theNumOfRoom = new File(path);
		boolean exists = theNumOfRoom.exists();
		if (exists == false) {
			theNumOfRoom.createNewFile();
		}
		try {
				FileOutputStream fos = new FileOutputStream(theNumOfRoom);// out和in不能同时被实例化
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(object);
				oos.flush();
				oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取roomtype ser文件
	 * 
	 * @param hotelname
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> readtheNumOfRoomSer(String orderID)
			throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		String path = "src/main/resources/order/";
		path = path + orderID + "/" + "theNumOfRoom.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				result = (ArrayList<String>) ois.readObject();
				ois.close();
				return result;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;

		}
	}
}
