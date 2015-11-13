package com.vanvalt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.App;

/**
 * 
 * @author Xiaoyang
 *
 */
public interface AppService {

	public void add(App app);

	public void delete(Class<App> clz,Map<String, Object> params);

	public void deleteBatch(Class<App> clz,Map<String, Object> params);
	
	public void update(App app);
	
	public void updateBatch(Class<App> clz,Map<String,Object> params);
	
	public App load(Class<App> clz,String id);
	
	public List<App> list(Class<App> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<App> list(Class<App> clz, Map<String, Object> params);

	public int findCount(Class<App> clz, Map<String, Object> params);
	
}
