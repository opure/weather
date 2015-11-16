package com.vanvalt.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vanvalt.dao.AppDao;
import com.vanvalt.entity.App;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 下午11:08:11 
 * 
 */
@Repository
public class AppDaoImpl extends BaseDaoImpl<App> implements AppDao {

	private static final String LIST_BY_PAGE			= "listByPage";
	private static final String LOAD					= "load";
	
	@Override
	public List<App> listByPage(Class<App> clz, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(clz.getName() + DOT + LIST_BY_PAGE, params);
	}

	@Override
	public App load(Class<App> clz, Integer id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(clz.getName() + DOT + LOAD, id);
	}

}
