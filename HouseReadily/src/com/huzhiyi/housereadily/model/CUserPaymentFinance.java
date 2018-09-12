package com.huzhiyi.housereadily.model;



import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.util.DateHelper;
import com.huzhiyi.utils.ContextHelper;
import com.huzhiyi.utils.StringUtil;

public class CUserPaymentFinance extends TastyEntity{
	
	private int id;
	private int userId;
	private String userName;
	private Double balance;
	private Double money;
	private int mtype;
	private Date operateTime;
	private String remark;
	private int ctype;
	private Integer cityCode;
	private String orderId; 

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getBalanceStr(){
		return StringUtil.getDoubleValue(balance);
	}
	
	public String getMoneyStr(){
		return StringUtil.getDoubleValue(money);
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public int getMtype() {
		return mtype;
	}
	public void setMtype(int mtype) {
		this.mtype = mtype;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getOperateTimeStr(){
		return DateHelper.dateToString(operateTime);
	}
	
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	
	public String getCtypeName(){
		return ContextHelper.getCtypeName(ctype);
	}
	
	public String getRemarkStr(){
		return getRemarkStr_(1);
	}
	public String getRemarkWebStr(){
		return getRemarkStr_(2);
	}
	
	public String getRemarkStr_(int from ){
		if(this.remark!=null&&remark.length()>0){
			String[] remarkSplit = remark.split(",");
			
			if(remarkSplit.length==2){
				StringBuilder sb = new StringBuilder();
				if(this.ctype==1||this.ctype==3 || this.ctype==4){//版本套餐
					if(from==1){
						sb.append("订单号(<a href=\"user.do?moudle=UserPaymentOrderView&orderId="+remarkSplit[0]+"\">"+remarkSplit[0]+"</a>) ");
					}else if(from==2){
						sb.append("订单号("+remarkSplit[0]+") ");
					}
					
					if(this.mtype==1){
						if(remarkSplit[1].equals("1")){
							sb.append("支付宝支付");
						}
					}else{
						sb.append(""+remarkSplit[1]+"");
					}
				}else if(this.ctype==2){
					if(this.mtype==1){
						if(from==1){
							sb.append("订单号(<a href=\"user.do?moudle=UserPaymentOrderView&orderId="+remarkSplit[0]+"&ctype="+ctype+"\">"+remarkSplit[0]+"</a>) ");
						}else if(from==2){
							sb.append("订单号("+remarkSplit[0]+") ");
						}
						
						if(remarkSplit[1].equals("1")){
							sb.append("支付宝支付");
						}else{
							//sb.append(""+remarkSplit[1]+"");
						}
					}else{
						sb.append("发送"+remarkSplit[1]+"条短信");
					}
					
				}

				return sb.toString();
			}
			
			
		}
		return remark;
	}
}
