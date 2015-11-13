package com.vanvalt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.Admin;


/**
 * 用户接口
 * @author Xiaoyang
 *
 */
public interface AdminDao {

	public void add(Admin admin);

	public void delete(Class<Admin> clz,Map<String, Object> params);

	public void deleteBatch(Class<Admin> clz,Map<String, Object> params);
	
	public void update(Admin admin);
	
	public void updateBatch(Class<Admin> clz,Map<String,Object> params);
	
	public Admin load(Class<Admin> clz,String id);
	
	public List<Admin> list(Class<Admin> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<Admin> list(Class<Admin> clz, Map<String, Object> params);

	public int findCount(Class<Admin> clz, Map<String, Object> params);
}
