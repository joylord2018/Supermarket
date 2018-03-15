package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Bill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -23940321576038477L;
	private Integer bid;
	@NotEmpty(message="订单编号不能为空")
	private String billCode;
	@NotEmpty(message="商品名不能为空")
	private String productName;					
	private String productDesc;	
	private String productUnit;
	private Integer productCount;
	private double totalPrice;
	private Integer isPayment;
	private Integer providerId;
	private Integer createBy;
	private Date createtionDate;
	private String modifyBy;
	private Date modifyDate;
	private String proName;
	
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(Integer bid, String billCode, String productName,
			String productDesc, String productUnit, Integer productCount,
			double totalPrice, Integer isPayment, Integer providerId,
			Integer createBy, Date createtionDate, String modifyBy, Date modifyDate) {
		super();
		this.bid = bid;
		this.billCode = billCode;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productUnit = productUnit;
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.isPayment = isPayment;
		this.providerId = providerId;
		this.createBy = createBy;
		this.createtionDate = createtionDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public String getCreatetionDate() {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=format.format(createtionDate);
		return dateString;
	}
	public void setCreatetion(Date createtionDate) {
		this.createtionDate = createtionDate;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
