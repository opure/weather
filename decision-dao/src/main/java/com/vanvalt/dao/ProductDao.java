package com.vanvalt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.Product;


/**
 * 
 * @author Xiaoyang
 *
 */
public interface ProductDao {

	public void add(Product product);

	public void delete(Class<Product> clz,Map<String, Object> params);

	public void deleteBatch(Class<Product> clz,Map<String, Object> params);
	
	public void update(Product product);
	
	public void updateBatch(Class<Product> clz,Map<String,Object> params);
	
	public Product load(Class<Product> clz,String id);
	
	public List<Product> list(Class<Product> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<Product> list(Class<Product> clz, Map<String, Object> params);

	public int findCount(Class<Product> clz, Map<String, Object> params);
}
