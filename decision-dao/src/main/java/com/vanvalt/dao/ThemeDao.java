package com.vanvalt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.Theme;


/**
 * 
 * @author Xiaoyang
 *
 */
public interface ThemeDao {

	public void add(Theme theme);

	public void delete(Class<Theme> clz,Map<String, Object> params);

	public void deleteBatch(Class<Theme> clz,Map<String, Object> params);
	
	public void update(Theme theme);
	
	public void updateBatch(Class<Theme> clz,Map<String,Object> params);
	
	public Theme load(Class<Theme> clz,String id);
	
	public List<Theme> list(Class<Theme> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<Theme> list(Class<Theme> clz, Map<String, Object> params);

	public int findCount(Class<Theme> clz, Map<String, Object> params);
}
