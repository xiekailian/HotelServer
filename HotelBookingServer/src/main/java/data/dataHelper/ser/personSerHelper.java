package data.dataHelper.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.personpo.RecordPO;

public class personSerHelper {
	String path = "src/main/resources/person/";

	/**
	 * 写入ser文件
	 * 
	 * @param personname
	 * @param object
	 * @throws IOException
	 */
	public boolean writeRecordSer(String personname, RecordPO object)
			throws IOException {
		String path = "src/main/resources/person/";
		path = path + personname + "/" + "record.txt";
		ArrayList<RecordPO> origin = new ArrayList<RecordPO>();
		File record = new File(path);
		boolean exists = record.exists();
		if (exists == false) {
			record.createNewFile();
		}
		try {
			if (exists) {
				origin = this.readRecordSer(personname);
				origin.add(object);
				FileOutputStream fos = new FileOutputStream(record);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(origin);
			} else {
				FileOutputStream fos = new FileOutputStream(record);// out和in不能同时被实例化
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
	 * 读取ser文件
	 * 
	 * @param personname
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RecordPO> readRecordSer(String personname)
			throws IOException {
		ArrayList<RecordPO> result = new ArrayList<RecordPO>();
		String path = "src/main/resources/person/";
		path = path + personname + "/" + "record.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				result = (ArrayList<RecordPO>) ois.readObject();
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
