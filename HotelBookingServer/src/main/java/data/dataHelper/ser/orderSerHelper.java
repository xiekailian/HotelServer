
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

public class orderSerHelper {
	String path = "src/main/resources/order/";

	/**
	 * 写入commentpo ser文件
	 * 
	 * @param hotelname
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public boolean writeCommentSer(String orderID, CommentPO object)
			throws IOException {
		String path = "src/main/resources/order/";
		path = path + orderID + "/" + "comment.txt";
		ArrayList<CommentPO> origin = new ArrayList<CommentPO>();
		File comment = new File(path);
		boolean exists = comment.exists();
		if (exists == false) {
			comment.createNewFile();
		}
		try {
			if (exists) {
				origin = this.readCommentSer(orderID);
				origin.add(object);
				FileOutputStream fos = new FileOutputStream(comment);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(origin);
			} else {
				FileOutputStream fos = new FileOutputStream(comment);// out和in不能同时被实例化
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				origin.add(object);
				oos.writeObject(origin);
				oos.flush();
				oos.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取comment ser文件
	 * 
	 * @param hotelname
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<CommentPO> readCommentSer(String orderID)
			throws IOException {
		ArrayList<CommentPO> result = new ArrayList<CommentPO>();
		String path = "src/main/resources/order/";
		path = path + orderID + "/" + "comment.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				result = (ArrayList<CommentPO>) ois.readObject();
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
