package com.vanvalt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.AlarmInfo;


/**
 * 
 * @author Xiaoyang
 *
 */
public interface AlarmInfoDao {

	public void add(AlarmInfo alarmInfo);

	public void delete(Class<AlarmInfo> clz,Map<String, Object> params);

	public void deleteBatch(Class<AlarmInfo> clz,Map<String, Object> params);
	
	public void update(AlarmInfo alarmInfo);
	
	public void updateBatch(Class<AlarmInfo> clz,Map<String,Object> params);
	
	public AlarmInfo load(Class<AlarmInfo> clz,String id);
	
	public List<AlarmInfo> list(Class<AlarmInfo> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<AlarmInfo> list(Class<AlarmInfo> clz, Map<String, Object> params);
	
	public List<AlarmInfo> listByPage(Class<AlarmInfo> clz, Map<String, Object> params);

	public int findCount(Class<AlarmInfo> clz, Map<String, Object> params);
}
