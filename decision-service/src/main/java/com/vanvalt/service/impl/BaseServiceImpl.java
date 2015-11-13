package com.vanvalt.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.dao.BaseDao;
import com.vanvalt.service.BaseService;

@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

	protected Logger logger = Logger.getLogger(this.getClass());

	/*
	 * @Autowired是根据类型进行自动装配的。例如，如果当Spring上下文中存在不止一个UserDao类型的bean时，
	 * 就会抛出BeanCreationException异常
	 * ;如果Spring上下文中不存在UserDao类型的bean，也会抛出BeanCreationException异常
	 * 。我们可以使用@Qualifier配合@Autowired来解决这些问题。
	 */
	@Autowired
	@Qualifier("baseDaoImpl")
	private BaseDao<T> baseDao;

	@Override
	public void add(T obj) {
		baseDao.add(obj);

	}

	@Override
	public void delete(Class<T> clz, Map<String, Object> params) {
		baseDao.delete(clz, params);
	}

	@Override
	public void deleteBatch(Class<T> clz, Map<String, Object> params) {
		baseDao.deleteBatch(clz, params);
	}

	@Override
	public void update(T obj) {
		baseDao.update(obj);

	}

	@Override
	public void updateBatch(Class<T> clz, Map<String, Object> params) {
		baseDao.updateBatch(clz, params);
	}

	@Override
	public T load(Class<T> clz, String id) {
		return baseDao.load(clz, id);
	}

	@Override
	public T load(Class<T> clz, long id) {
		return baseDao.load(clz, id);
	}

	@Override
	public T loadBySqlId(String sqlId, Map<String, Object> params) {
		return baseDao.loadBySqlId(sqlId, params);
	}

	@Override
	public T loadBySqlId(String sqlId, Object obj) {
		return baseDao.loadBySqlId(sqlId, obj);
	}

	@Override
	public List<T> list(Class<T> clz, Map<String, Object> params,
			RowBounds rowBounds) {
		return baseDao.list(clz, params, rowBounds);
	}

	@Override
	public List<T> list(Class<T> clz, Map<String, Object> params) {
		return baseDao.list(clz, params);
	}

	@Override
	public List<T> list(String sqlId, Map<String, Object> params,
			RowBounds rowBounds) {
		return baseDao.list(sqlId, params, rowBounds);
	}

	@Override
	public int findCount(Class<T> clz, Map<String, Object> map) {
		return baseDao.findCount(clz, map);
	}
	

}
