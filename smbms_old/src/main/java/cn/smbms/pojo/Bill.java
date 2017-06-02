package cn.smbms.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Bill {

	private int id; // 主键ID
	private String billCode;// 账单编码
	private String productName; // 商品名称
	private String productDesc; // 商品描述
	private String productUnit;// 单位
	private BigDecimal productCount;// 商品数据
	private BigDecimal totalPrice;// 账单总金额
	private int isPayment;// 是否付款（1 未支付 2 已支付）
	private int providerId;// 供应商ID
	private Timestamp createDate;// 创建时间
	private int createBy;// 创建者
	private Timestamp modifyDate;// 更新时间
	private int modifyBy;// 更新者

	private String providerName; // 供应商名称

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Bill() {
		super();
	}

	public Bill(int id, String billCode, String productName,
			String productDesc, String productUnit, BigDecimal productCount,
			BigDecimal totalPrice, int isPayment, int providerId,
			Timestamp createDate, int createBy, Timestamp modifyDate,
			int modifyBy) {
		super();
		this.id = id;
		this.billCode = billCode;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productUnit = productUnit;
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.isPayment = isPayment;
		this.providerId = providerId;
		this.createDate = createDate;
		this.createBy = createBy;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public BigDecimal getProductCount() {
		return productCount;
	}

	public void setProductCount(BigDecimal productCount) {
		this.productCount = productCount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", billCode=" + billCode + ", productName="
				+ productName + ", productDesc=" + productDesc
				+ ", productUnit=" + productUnit + ", productCount="
				+ productCount + ", totalPrice=" + totalPrice + ", isPayment="
				+ isPayment + ", providerId=" + providerId + ", createDate="
				+ createDate + ", createBy=" + createBy + ", modifyDate="
				+ modifyDate + ", modifyBy=" + modifyBy + "]";
	}

}
