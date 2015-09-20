package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: Customer.java 
* @Package com.zh.web.model.bean 
* @Description: 客户资料
* @date 2015年3月30日 下午3:08:45 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class Customer extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7952984219744829098L;

	private Long id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 法人
	 */
	private String legalPerson;
	
	/**
	 * 类型  （客户，原材料商）
	 */
	private Integer type;
	
	/**
	 * 状态 0:有效，，1:无效
	 */
	private Integer enabled;
	
	/**
	 * 邮件
	 */
	private String mail;
	
	/**
	 * 传真
	 */
	private String faxNumber;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 客户级别
	 */
	private Integer lev;
	
	/**
	 * 开户银行
	 */
	private String openingBank;
	
	/**
	 * 银行账号
	 */
	private String bankAccount;
	
	/**
	 * 电话号码
	 */
	private String iphone;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getLev() {
		return lev;
	}

	public void setLev(Integer lev) {
		this.lev = lev;
	}

	public String getOpeningBank() {
		return openingBank;
	}

	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getIphone() {
		return iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	
}
