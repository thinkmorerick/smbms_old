package cn.smbms.pojo;

import java.sql.Timestamp;

public class Provider {

	private int id; // 主键ID
	private String proCode; // 供应商编码
	private String proName; // 供应商名称
	private String proDesc; // 供应商描述信息
	private String proContact; // 供应商联系人
	private String proPhone; // 联系电话
	private String proAddress; // 地址
	private String proFax; // 传真
	private int createBy; // 创建者（userID）
	private Timestamp creationDate; // 创建时间
	private int modifyBy; // 更新者
	private Timestamp modifyDate; // 更新时间

	public Provider() {
		super();
	}

	public Provider(int id, String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, int createBy, Timestamp creationDate, int modifyBy,
			Timestamp modifyDate) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public String getProContact() {
		return proContact;
	}

	public void setProContact(String proContact) {
		this.proContact = proContact;
	}

	public String getProPhone() {
		return proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}

	public String getProAddress() {
		return proAddress;
	}

	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}

	public String getProFax() {
		return proFax;
	}

	public void setProFax(String proFax) {
		this.proFax = proFax;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", proCode=" + proCode + ", proName="
				+ proName + ", proDesc=" + proDesc + ", proContact="
				+ proContact + ", proPhone=" + proPhone + ", proAddress="
				+ proAddress + ", proFax=" + proFax + ", createBy=" + createBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}

}
