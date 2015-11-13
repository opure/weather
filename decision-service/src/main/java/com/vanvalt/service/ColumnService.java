package com.vanvalt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.Column;

/**
 * 
 * @author Xiaoyang
 *
 */
public interface ColumnService {

	public void add(Column column);

	public void delete(Class<Column> clz,Map<String, Object> params);

	public void deleteBatch(Class<Column> clz,Map<String, Object> params);
	
	public void update(Column column);
	
	public void updateBatch(Class<Column> clz,Map<String,Object> params);
	
	public Column load(Class<Column> clz,String id);
	
	public List<Column> list(Class<Column> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<Column> list(Class<Column> clz, Map<String, Object> params);

	public int findCount(Class<Column> clz, Map<String, Object> params);
	
}
