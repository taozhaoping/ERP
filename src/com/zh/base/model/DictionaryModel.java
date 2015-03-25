package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.BasiType;
import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.model.BaseModel;

public class DictionaryModel extends BaseModel {

	private Dictionary dictionary = new Dictionary();
	
	private List<Dictionary> dictionaryList = new ArrayList<Dictionary>();
	
	private BasiType basiType = new BasiType();
	
	private List<BasiType> basiTypeList = new ArrayList<BasiType>();

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public BasiType getBasiType() {
		return basiType;
	}

	public void setBasiType(BasiType basiType) {
		this.basiType = basiType;
	}

	public List<Dictionary> getDictionaryList() {
		return dictionaryList;
	}

	public void setDictionaryList(List<Dictionary> dictionaryList) {
		this.dictionaryList = dictionaryList;
	}

	public List<BasiType> getBasiTypeList() {
		return basiTypeList;
	}

	public void setBasiTypeList(List<BasiType> basiTypeList) {
		this.basiTypeList = basiTypeList;
	}
	
}
