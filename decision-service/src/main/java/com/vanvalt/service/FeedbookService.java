package com.vanvalt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.Feedbook;

/**
 * 
 * @author Xiaoyang
 *
 */
public interface FeedbookService {

	public void add(Feedbook feedbook);

	public void delete(Class<Feedbook> clz,Map<String, Object> params);

	public void deleteBatch(Class<Feedbook> clz,Map<String, Object> params);
	
	public void update(Feedbook feedbook);
	
	public void updateBatch(Class<Feedbook> clz,Map<String,Object> params);
	
	public Feedbook load(Class<Feedbook> clz,String id);
	
	public List<Feedbook> list(Class<Feedbook> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<Feedbook> list(Class<Feedbook> clz, Map<String, Object> params);

	public int findCount(Class<Feedbook> clz, Map<String, Object> params);
	
}
