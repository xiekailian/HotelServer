package po.promotionpo.webpromotionpo;

import java.util.ArrayList;

import po.PromotionPO;

/**
 *  @author 武秀峰
 *  网站促销策略：制定会员等级及其折扣*/
public class VipLevelWebproPO extends PromotionPO {
	private String promotionID;
	private String promotionType="WebPromtion";
	/*会员等级、折扣为一组，即vipLevel[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private ArrayList<Integer> vipLevel;
	private ArrayList<Integer> discount;//如打九五折时，discount=95
	
	public VipLevelWebproPO(String promotionID, ArrayList<Integer> vipLevel, ArrayList<Integer> discount){
		this.promotionID=promotionID;
		this.vipLevel=vipLevel;
		this.discount=discount;
	}
	
	public VipLevelWebproPO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Integer> getVipLevel(){
		return vipLevel;
	}
	public void setVipLevel(ArrayList<Integer> vipLevel){
		this.vipLevel=vipLevel;
	}

	public ArrayList<Integer> getDiscount(){
		return discount;
	}
	public void setDiscount(ArrayList<Integer> discount){
		this.discount=discount;
	}
	public String getPromotionID() {
		return promotionID;
	}
	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}
	public String getPromotionType() {
		return promotionType;
	}
}
