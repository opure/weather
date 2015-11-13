package com.vanvalt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

/**
 * 通用服务接口.
 * @author chenbowang
 *
 * @param <T>
 */
public interface BaseService<T> {
	/** 
	 * 新增. 
	 * 
	 * @param obj
	 */
	public void add(T obj);
	/** 
	 * 删除. 
	 * 
	 * @param clz
	 * @param params
	 */
	public void delete(Class<T> clz,Map<String, Object> params);
	/** 
	 * 批量删除. 
	 * @param clz
	 * @param params
	 */
	public void deleteBatch(Class<T> clz,Map<String, Object> params);
	/** 
	 * 更新. 
	 * 
	 * @param obj
	 */
	public void update(T obj);
	/** 
	 * 批量更新. 
	 * 
	 * @param clz
	 * @param params
	 */
	public void updateBatch(Class<T> clz,Map<String,Object> params);
	/** 
	 * 查询.
	 * 
	 * @param clz
	 * @param id
	 * @return
	 */
	public T load(Class<T> clz,String id);
	/** 
	 * 查询. 
	 * 
	 * @param clz
	 * @param id
	 * @return
	 */
	public T load(Class<T> clz,long id);
	/**
	 * 查询.
	 * 
	 * @param sqlId
	 * @param params
	 * @return
	 */
	public T loadBySqlId(String sqlId, Map<String, Object> params);
	/**
	 * 查询.
	 * @param sqlId
	 * @param obj
	 * @return
	 */
	public T loadBySqlId(String sqlId, Object obj);
	/**
	 * 列表查询.
	 * 
	 * @param clz
	 * @param params
	 * @param rowBounds
	 * @return
	 */
	public List<T> list(Class<T> clz,Map<String, Object> params,RowBounds rowBounds);
	/**
	 * 列表查询.
	 * 
	 * @param clz
	 * @param params
	 * @return
	 */
	public List<T> list(Class<T> clz,Map<String, Object> params);
	/**
	 * 列表查询.
	 * 
	 * @param sqlId
	 * @param params
	 * @param rowBounds
	 * @return
	 */
	public List<T> list(String sqlId, Map<String, Object> params,RowBounds rowBounds);
	/**
	 * 统计总数.
	 * 
	 * @param clz
	 * @param map
	 * @return
	 */
	public int findCount(Class<T> clz,Map<String, Object> map) ;
	
}
