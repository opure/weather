package com.vanvalt.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vanvalt.dao.BaseDao;


@Repository
public class BaseDaoImpl<T> implements BaseDao<T>{
	public  static final String DOT 			= ".";
	private static final String ADD				= "add";
	private static final String UPDATE			= "update";
	private static final String UPDATE_BATCH    = "updateBatch";
	private static final String DELETE			= "delete";
	private static final String DELETE_BATCH	= "deleteBatch";
	private static final String LOAD			= "load";
	private static final String LIST			= "list";
	private static final String FIND_COUNT		= "findCount";
	
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void add(T obj) {
		sqlSessionTemplate.insert(obj.getClass().getName() + DOT + ADD,obj);		
	}

	@Override
	public void update(T obj) {
		sqlSessionTemplate.update(obj.getClass().getName() + DOT + UPDATE, obj);
	}
	
	@Override
	public void updateBatch(Class<T> clz, Map<String, Object> params) {
		sqlSessionTemplate.update(clz.getName() + DOT + UPDATE_BATCH, params);
	}

	@Override
	public void delete(Class<T> clz,Map<String, Object> params) {
		sqlSessionTemplate.delete(clz.getName() + DOT + DELETE, params);		
	}

	@Override
	public void deleteBatch(Class<T> clz, Map<String, Object> params) {
		sqlSessionTemplate.delete(clz.getName() + DOT + DELETE_BATCH, params);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(Class<T> clz, String id) {
		return (T)sqlSessionTemplate.selectOne(clz.getName() + DOT + LOAD,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(Class<T> clz, long id) {
		return (T)sqlSessionTemplate.selectOne(clz.getName() + DOT + LOAD,id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T loadBySqlId(String sqlId, Map<String, Object> params) {
		return (T)sqlSessionTemplate.selectOne(sqlId,params);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T loadBySqlId(String sqlId, Object obj) {
		return (T)sqlSessionTemplate.selectOne(sqlId,obj);
	}

	@Override
	public List<T> list(Class<T> clz,Map<String, Object> params,RowBounds rowBounds) {
		
		return this.list(clz.getName()+ DOT +LIST, params,rowBounds);
	}

	@Override
	public List<T> list(Class<T> clz, Map<String, Object> params) {
		return sqlSessionTemplate.selectList(clz.getName() + DOT + LIST, params);
	}
	
	@Override
	public List<T> list(String sqlId, Map<String, Object> params,RowBounds rowBounds) {
		return sqlSessionTemplate.selectList(sqlId,params,rowBounds);
	}

	@Override
	public int findCount(Class<T> clz,Map<String, Object> map) {
		return sqlSessionTemplate.selectOne(clz.getName() + DOT + FIND_COUNT, map);
	}

}