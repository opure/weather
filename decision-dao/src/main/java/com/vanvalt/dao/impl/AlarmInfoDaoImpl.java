package com.vanvalt.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vanvalt.dao.AlarmInfoDao;
import com.vanvalt.entity.AlarmInfo;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 下午11:08:11 
 * 
 */
@Repository
public class AlarmInfoDaoImpl extends BaseDaoImpl<AlarmInfo> implements AlarmInfoDao {

	private static final String LIST_BY_PAGE			= "listByPage";
	
	@Override
	public List<AlarmInfo> listByPage(Class<AlarmInfo> clz,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(clz.getName() + DOT + LIST_BY_PAGE, params);
	}

}
