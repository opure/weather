package com.vanvalt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.ProductCategory;

/**
 * 
 * @author Xiaoyang
 *
 */
public interface ProductCategoryService {

	public void add(ProductCategory productCategory);

	public void delete(Class<ProductCategory> clz,Map<String, Object> params);

	public void deleteBatch(Class<ProductCategory> clz,Map<String, Object> params);
	
	public void update(ProductCategory productCategory);
	
	public void updateBatch(Class<ProductCategory> clz,Map<String,Object> params);
	
	public ProductCategory load(Class<ProductCategory> clz,String id);
	
	public List<ProductCategory> list(Class<ProductCategory> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<ProductCategory> list(Class<ProductCategory> clz, Map<String, Object> params);

	public int findCount(Class<ProductCategory> clz, Map<String, Object> params);
	
}
