package com.zh.web.dao;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.Products;

@Component("productsDao")
public class ProductsDao extends BaseDao<Products> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Products");
	}
}
