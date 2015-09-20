package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: CuttingScheme.java 
* @Package com.zh.web.model.bean 
* @Description: 切割方案
* @date 2015年4月28日 下午3:26:27 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class CuttingScheme extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1288177167525441866L;

	private Long id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 原材料
	 */
	private Long rawMaterials;
	
	private String rawName;
	
	/**
	 * 主产品物料数量
	 */
	private Long mainProducts;
	
	private String mainName;
	
	/**
	 * 主产品物料数量
	 */
	private Integer manNumber;
	
	/**
	 * 副产品物料
	 */
	private Long byProducts;
	
	private String byName;
	
	/**
	 * 副产品物料数量
	 */
	private Integer byNumber;
	
	/**
	 * 状态
	 */
	private Integer enabled;

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

	public Long getRawMaterials() {
		return rawMaterials;
	}

	public void setRawMaterials(Long rawMaterials) {
		this.rawMaterials = rawMaterials;
	}

	public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public Long getMainProducts() {
		return mainProducts;
	}

	public void setMainProducts(Long mainProducts) {
		this.mainProducts = mainProducts;
	}

	public String getMainName() {
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public Integer getManNumber() {
		return manNumber;
	}

	public void setManNumber(Integer manNumber) {
		this.manNumber = manNumber;
	}

	public Long getByProducts() {
		return byProducts;
	}

	public void setByProducts(Long byProducts) {
		this.byProducts = byProducts;
	}

	public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public Integer getByNumber() {
		return byNumber;
	}

	public void setByNumber(Integer byNumber) {
		this.byNumber = byNumber;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}
