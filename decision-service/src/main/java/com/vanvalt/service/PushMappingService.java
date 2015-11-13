package com.vanvalt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.PushMapping;

/**
 * 信息推送映射接口
 * @author Xiaoyang
 *
 */
public interface PushMappingService {

	public void add(PushMapping pushMapping);

	public void delete(Class<PushMapping> clz,Map<String, Object> params);

	public void deleteBatch(Class<PushMapping> clz,Map<String, Object> params);
	
	public void update(PushMapping pushMapping);
	
	public void updateBatch(Class<PushMapping> clz,Map<String,Object> params);
	
	public PushMapping load(Class<PushMapping> clz,String id);
	
	public List<PushMapping> list(Class<PushMapping> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<PushMapping> list(Class<PushMapping> clz, Map<String, Object> params);

	public int findCount(Class<PushMapping> clz, Map<String, Object> params);
	
}
