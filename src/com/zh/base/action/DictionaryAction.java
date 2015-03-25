package com.zh.base.action;

import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.DictionaryModel;
import com.zh.base.model.bean.BasiType;
import com.zh.base.model.bean.Dictionary;
import com.zh.base.service.BasiTypeService;
import com.zh.base.service.DictionaryService;
import com.zh.core.base.action.BaseAction;
import com.zh.core.exception.ProjectException;

/**
 * 
* @Title: DictionaryAction.java 
* @Package com.zh.base.action 
* @Description: 数据库字典
* @date 2015年3月25日 下午3:52:56 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class DictionaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(DictionaryAction.class); 
	
	private DictionaryModel dictionaryModel = new DictionaryModel();
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private BasiTypeService BasiTypeService;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dictionaryModel;
	}
	
	@Override
	public String execute() throws Exception {
		
		return "usersjson";

	}
	
	/**
	* @Title: queryDictionary 
	* @Description: 数据库字典
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 * @throws ParameterException 
	 */
	public String queryDictionary() throws ProjectException {
		String formId = dictionaryModel.getFormId();
		if (null == formId || "".equals(formId))
		{
			throw new ProjectException("字典key不允许为null!");
		}
		Dictionary dictionary = new Dictionary();
		dictionary.setBasiTypeID(Integer.valueOf(formId));
		List<Dictionary> list = dictionaryService.queryList(dictionary);
		this.dictionaryModel.setDictionaryList(list);
		return "dictionaryjson";
	}

	/**
	 * 
	* @Title: queryBasiType 
	* @Description: 基础类别资料
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 * @throws ParameterException 
	 */
	public String queryBasiType() throws ProjectException {
		String formId = dictionaryModel.getFormId();
		BasiType basiType = new BasiType();
		if (null != formId && !"".equals(formId))
		{
			basiType.setId(Integer.valueOf(formId));
		}
		
		List<BasiType> list = BasiTypeService.queryList(basiType);
		this.dictionaryModel.setBasiTypeList(list);
		return "basiTypejson";
	}

	public DictionaryModel getDictionaryModel() {
		return dictionaryModel;
	}

	public void setDictionaryModel(DictionaryModel dictionaryModel) {
		this.dictionaryModel = dictionaryModel;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public BasiTypeService getBasiTypeService() {
		return BasiTypeService;
	}

	public void setBasiTypeService(BasiTypeService basiTypeService) {
		BasiTypeService = basiTypeService;
	}
	
}
