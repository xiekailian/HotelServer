package data.promotionData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.dataHelper.jdbc.Builder;
import data.dataHelper.jdbc.ChangerHelper;
import data.dataHelper.ser.hotelSerHelper;
import dataService.promotionDataService.PromotionDataService;
import po.PromotionPO;
import po.promotionpo.hotelpromotionPO.BirthdayHotelproPO;
import po.promotionpo.hotelpromotionPO.EnterpriseHotelproPO;
import po.promotionpo.hotelpromotionPO.LargeAmountHotelproPO;
import po.promotionpo.hotelpromotionPO.PeriodHotelproPO;
import po.promotionpo.webpromotionPO.CircleWebproPO;
import po.promotionpo.webpromotionPO.PeriodWebproPO;
import po.promotionpo.webpromotionPO.VipLevelWebproPO;

public class PromotionData implements PromotionDataService {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private Builder builder = new Builder();
	private ResultSet rs = null;
	private hotelSerHelper hsh = new hotelSerHelper();
	private static PromotionData promotiondata = null;
	/**
	 * 
	 * @return 唯一的PromotionData对象
	 */


	public static PromotionData getInstance() {
		if (promotiondata == null)
			promotiondata = new PromotionData();
		return promotiondata;
	}
	/*
	 * (non-Javadoc)
	 * @see dataService.promotionDataService.PromotionDataService#add(po.PromotionPO)
	 */
	public boolean add(PromotionPO promotion) {
		try {
			int lastID = 0;
			String Cricleselect = "select * from `CircleWebpromotion`;";
			String Periodselect = "select * from `PeriodWebpromotion`;";
			String VipLevelselect = "select * from `VipLevelWebpromotion`;";
			String Cricleinsert = "insert into circlewebpromotion (策略名,策略ID,折扣,策略类型,酒店名或网站,商圈,vip等级) values(?,?,?,?,?,?,?);";
			String Periodinsert = "insert into periodwebpromotion (策略名,策略ID,折扣,策略类型,酒店名或网站,开始时间,结束时间) values(?,?,?,?,?,?,?);";
			String VipLevelinsert = "insert into vipLevelwebpromotion (策略名,策略ID,策略类型,酒店名或网站,等级1折扣,等级2折扣,等级3折扣,等级4折扣,等级5折扣) values(?,?,?,?,?,?,?,?,?);";
			if(promotion.getPromotionType().equals("生日优惠策略")){
				promotion.setPromotionID(1);
					hsh.writeBirthdayPromotionSer(promotion.getHotelnameOrWeb(), (BirthdayHotelproPO)promotion);
					return true;}
			if(promotion.getPromotionType().equals("企业优惠策略")){
				promotion.setPromotionID(1);
					hsh.writeEnterprisePromotionSer(promotion.getHotelnameOrWeb(), (EnterpriseHotelproPO)promotion);
					return true;}
			if(promotion.getPromotionType().equals("多购优惠策略")){
				promotion.setPromotionID(1);
					hsh.writeLargeAmountPromotionSer(promotion.getHotelnameOrWeb(), (LargeAmountHotelproPO)promotion);
					return true;}
			if(promotion.getPromotionType().equals("特定时间优惠策略")){
				if(hsh.readPeriodPromotionSer(promotion.getHotelnameOrWeb())!=null){
					ArrayList<PeriodHotelproPO> list=hsh.readPeriodPromotionSer(promotion.getHotelnameOrWeb());
					promotion.setPromotionID(list.get(list.size()-1).getPromotionID()+1);
					}
					else{
					promotion.setPromotionID(1);
				}
					hsh.writePeriodHotelSer(promotion.getHotelnameOrWeb(), (PeriodHotelproPO)promotion);
					return true;}
			if(promotion.getPromotionType().equals("网站商圈优惠策略")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(Cricleselect);
				rs = ps.executeQuery();
				while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
					if (rs.getInt(2) > lastID) {
						lastID = rs.getInt(2);
					}
				}
				rs.close();
				ps = conn.prepareStatement(Cricleinsert);
				ps.setString(1, ((CircleWebproPO)promotion).getPromotionName());
				ps.setInt(2, lastID+1);
				ps.setInt(3, ((CircleWebproPO)promotion).getDiscount());
				ps.setString(4, ((CircleWebproPO)promotion).getPromotionType());
				ps.setString(5, ((CircleWebproPO)promotion).getHotelnameOrWeb());
				ps.setString(6, ((CircleWebproPO)promotion).getCircle());
				ps.setInt(7, ((CircleWebproPO)promotion).getVipLevel());
				ps.execute();
				ps.close();
				conn.close();
				return true;}
			if(promotion.getPromotionType().equals("网站特定时间优惠策略")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(Periodselect);
				rs = ps.executeQuery();
				while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
					if (rs.getInt(2) > lastID) {
						lastID = rs.getInt(2);
					}
				}
				rs.close();
				ps = conn.prepareStatement(Periodinsert);
				ps.setString(1, ((PeriodWebproPO)promotion).getPromotionName());
				ps.setInt(2, lastID+1);
				ps.setInt(3, ((PeriodWebproPO)promotion).getDiscount());
				ps.setString(4, ((PeriodWebproPO)promotion).getPromotionType());
				ps.setString(5, ((PeriodWebproPO)promotion).getHotelnameOrWeb());
				ps.setTimestamp(6, ChangerHelper.changeToTimestamp(((PeriodWebproPO)promotion).getStartTime()));
				ps.setTimestamp(7, ChangerHelper.changeToTimestamp(((PeriodWebproPO)promotion).getEndTime()));
				ps.execute();
				ps.close();
				conn.close();	
				return true;}
			if(promotion.getPromotionType().equals("VipLevelWebPromotion")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(VipLevelselect);
				rs = ps.executeQuery();
				while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
					if (rs.getInt(2) > lastID) {
						lastID = rs.getInt(2);
					}
				}
				rs.close();
				ps = conn.prepareStatement(VipLevelinsert);
				ps.setString(1, ((VipLevelWebproPO)promotion).getPromotionName());
				ps.setInt(2, lastID+1);
				ps.setString(3, ((VipLevelWebproPO)promotion).getPromotionType());
				ps.setString(4, ((VipLevelWebproPO)promotion).getHotelnameOrWeb());
				ps.setInt(5, ((VipLevelWebproPO)promotion).getDiscount().get(0));
				ps.setInt(6, ((VipLevelWebproPO)promotion).getDiscount().get(1));
				ps.setInt(7, ((VipLevelWebproPO)promotion).getDiscount().get(2));
				ps.setInt(8, ((VipLevelWebproPO)promotion).getDiscount().get(3));
				ps.setInt(9, ((VipLevelWebproPO)promotion).getDiscount().get(4));
				ps.execute();
				ps.close();
				conn.close();	
				return true;
		}
			}  catch (SQLException e) {
				e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
				
			}
		return false;
		

	}
	/*
	 * (non-Javadoc)
	 * @see dataService.promotionDataService.PromotionDataService#find(java.lang.String)
	 */
	public ArrayList<PromotionPO> find(String hotelnames)  {
		ArrayList<PromotionPO> result=new ArrayList<PromotionPO>();
		String Cricleselect = "select * from `CircleWebpromotion`;";
		String Periodselect = "select * from `PeriodWebpromotion`;";
		String VipLevelselect = "select * from `VipLevelWebpromotion`;";
		try {
		if(hotelnames!="WebPromotion"){
			if(hsh.readBirthdayPromotionSer(hotelnames)!=null){
				result.add(hsh.readBirthdayPromotionSer(hotelnames));
			}
			if(hsh.readEnterprisePromotionSer(hotelnames)!=null){
				result.add(hsh.readEnterprisePromotionSer(hotelnames));
			}
			if(hsh.readLargeAmountPromotionSer(hotelnames)!=null){
				result.add(hsh.readLargeAmountPromotionSer(hotelnames));
			}
			if(hsh.readPeriodPromotionSer(hotelnames)!=null){
				for(int i=0;i<hsh.readPeriodPromotionSer(hotelnames).size();i++){
					result.add(hsh.readPeriodPromotionSer(hotelnames).get(i));
				}
			}
			return result;
		}
		else{
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(Cricleselect);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				CircleWebproPO cp=new CircleWebproPO();
				cp.setPromotionName(rs.getString(1));
				cp.setPromotionID(rs.getInt(2));
				cp.setDiscount(rs.getInt(3));
				cp.setPromotionType(rs.getString(4));
				cp.setHotelnameOrWeb(rs.getString(5));
				cp.setCircle(rs.getString(6));
				cp.setVipLevel(rs.getInt(7));
				result.add(cp);
			}
			rs.close();
			ps.close();
			conn.close();
			
			
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(Periodselect);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				PeriodWebproPO pp=new PeriodWebproPO();
				pp.setPromotionName(rs.getString(1));
				pp.setPromotionID(rs.getInt(2));
				pp.setDiscount(rs.getInt(3));
				pp.setPromotionType(rs.getString(4));
				pp.setHotelnameOrWeb(rs.getString(5));
				pp.setStartTime(ChangerHelper.changeToCalendar(rs.getTimestamp(6)));
				pp.setEndTime(ChangerHelper.changeToCalendar(rs.getTimestamp(6)));
				result.add(pp);
			}
			rs.close();
			ps.close();
			conn.close();
			
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(VipLevelselect);
			rs = ps.executeQuery();
			ArrayList<Integer> list=new ArrayList<Integer>();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				VipLevelWebproPO vp=new VipLevelWebproPO();
				vp.setPromotionName(rs.getString(1));
				vp.setPromotionID(rs.getInt(2));
				vp.setPromotionType(rs.getString(3));
				vp.setHotelnameOrWeb(rs.getString(4));
				list.add(rs.getInt(5));
				list.add(rs.getInt(6));
				list.add(rs.getInt(7));
				list.add(rs.getInt(8));
				list.add(rs.getInt(9));
				vp.setDiscount(list);
				result.add(vp);
			}
			rs.close();
			ps.close();
			conn.close();
			return result;
		}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	 * (non-Javadoc)
	 * @see dataService.promotionDataService.PromotionDataService#modify(po.PromotionPO)
	 */
	public boolean modify(PromotionPO promotion) {
		try {
			int lastID = 0;
			
			String Circleupdate="update circlewebpromotion set `策略名`=?,`折扣`=?,`策略类型`=?,`酒店名或网站`=?,`商圈`=?,`vip等级`=? where 策略ID=?;";
			String Periodupdate="update periodwebpromotion set `策略名`=?,`折扣`=?,`策略类型`=?,`酒店名或网站`=?,`开始时间`=?,`结束时间`=? where 策略ID=?;";
			String VipLevelupdate = "update vipLevelwebpromotion set `策略名`=?,`策略类型`=?,`酒店名或网站`=?,`等级1折扣`=?,`等级2折扣`=?,`等级4折扣`=?,`等级5折扣`=?,`等级3折扣`=? where 策略ID=?;";
			if(promotion.getPromotionType().equals("生日优惠策略")){
				promotion.setPromotionID(1);
					hsh.writeBirthdayPromotionSer(promotion.getHotelnameOrWeb(), (BirthdayHotelproPO)promotion);
					return true;}
			if(promotion.getPromotionType().equals("企业优惠策略")){
				promotion.setPromotionID(1);
					hsh.writeEnterprisePromotionSer(promotion.getHotelnameOrWeb(), (EnterpriseHotelproPO)promotion);
					return true;}
			if(promotion.getPromotionType().equals("多购优惠策略")){
				promotion.setPromotionID(1);
					hsh.writeLargeAmountPromotionSer(promotion.getHotelnameOrWeb(), (LargeAmountHotelproPO)promotion);
					return true;}
			if(promotion.getPromotionType().equals("特定时间优惠策略")){
				hsh.modifyPeriodHotelSer(promotion.getHotelnameOrWeb(), (PeriodHotelproPO)promotion);
				return true;}
			
			
			if(promotion.getPromotionType().equals("网站商圈优惠策略")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(Circleupdate);
				ps.setString(1, ((CircleWebproPO)promotion).getPromotionName());
				ps.setInt(2, ((CircleWebproPO)promotion).getDiscount());
				ps.setString(3, ((CircleWebproPO)promotion).getPromotionType());
				ps.setString(4, ((CircleWebproPO)promotion).getHotelnameOrWeb());
				ps.setString(5, ((CircleWebproPO)promotion).getCircle());
				ps.setInt(6, ((CircleWebproPO)promotion).getVipLevel());
				ps.setInt(7, ((CircleWebproPO)promotion).getPromotionID());
				ps.execute();
				ps.close();
				conn.close();
				return true;
			}
			if(promotion.getPromotionType().equals("网站特定时间优惠策略")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(Periodupdate);
				ps.setString(1, ((PeriodWebproPO)promotion).getPromotionName());
				ps.setInt(2, ((PeriodWebproPO)promotion).getDiscount());
				ps.setString(3, ((PeriodWebproPO)promotion).getPromotionType());
				ps.setString(4, ((PeriodWebproPO)promotion).getHotelnameOrWeb());
				ps.setTimestamp(5, ChangerHelper.changeToTimestamp(((PeriodWebproPO)promotion).getStartTime()));
				ps.setTimestamp(6, ChangerHelper.changeToTimestamp(((PeriodWebproPO)promotion).getEndTime()));
				ps.setInt(7, lastID+1);
				ps.execute();
				ps.close();
				conn.close();	
				return true;
				}
	
			
			if(promotion.getPromotionType().equals("VipLevelWebPromotion")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(VipLevelupdate);
				ps.setString(1, ((VipLevelWebproPO)promotion).getPromotionName());
				ps.setString(2, ((VipLevelWebproPO)promotion).getPromotionType());
				ps.setString(3, ((VipLevelWebproPO)promotion).getHotelnameOrWeb());
				ps.setInt(4, ((VipLevelWebproPO)promotion).getDiscount().get(0));
				ps.setInt(5, ((VipLevelWebproPO)promotion).getDiscount().get(1));
				ps.setInt(6, ((VipLevelWebproPO)promotion).getDiscount().get(2));
				ps.setInt(7, ((VipLevelWebproPO)promotion).getDiscount().get(3));
				ps.setInt(8, ((VipLevelWebproPO)promotion).getDiscount().get(4));
				ps.setInt(9, lastID+1);
				ps.execute();
				ps.close();
				conn.close();	
				return true;
		}
			}  catch (SQLException e) {
				e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
				
			}
		return false;
	}
	/*
	 * (non-Javadoc)
	 * @see dataService.promotionDataService.PromotionDataService#delete(po.PromotionPO)
	 */
	public boolean delete(PromotionPO promotion) {
		try {
			String Circledelete="delete from circlewebpromotion  where 策略ID=?;";
			String Perioddelete="delete from periodwebpromotion  where 策略ID=?;";
			String VipLeveldelete = "delete from vipLevelwebpromotion  where 策略ID=?;";
			
			if(promotion.getPromotionType().equals("生日优惠策略")){
				hsh.deleteBirthdayPromotionSer(promotion.getHotelnameOrWeb());
					return true;}
			if(promotion.getPromotionType().equals("企业优惠策略")){
				hsh.deleteEnterprisePromotionSer(promotion.getHotelnameOrWeb());
					return true;}
			if(promotion.getPromotionType().equals("多购优惠策略")){
				hsh.deleteLargeAmountPromotionSer(promotion.getHotelnameOrWeb());
					return true;}
			if(promotion.getPromotionType().equals("PeriodHotelPromotion")){
				hsh.deletePeriodHotelSer(promotion.getHotelnameOrWeb(), (PeriodHotelproPO)promotion);
				return true;}
			
			
			if(promotion.getPromotionType().equals("CircleWebPromotion")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(Circledelete);
				ps.setInt(1, ((CircleWebproPO)promotion).getPromotionID());
				ps.execute();
				ps.close();
				conn.close();
				return true;
			}
			if(promotion.getPromotionType().equals("PeriodWebPromotion")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(Perioddelete);
				ps.setInt(1, ((PeriodWebproPO)promotion).getPromotionID());
				ps.execute();
				ps.close();
				conn.close();	
				return true;
				}
			
			
			if(promotion.getPromotionType().equals("VipLevelWebPromotion")){
				conn = builder.BuildConnection();
				ps = conn.prepareStatement(VipLeveldelete);
				ps.setInt(1, ((VipLevelWebproPO)promotion).getPromotionID());
				ps.execute();
				ps.close();
				conn.close();	
				return true;
		}
			}  catch (SQLException e) {
				e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
				
			}
		return false;
	}
}
