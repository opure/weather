package com.vanvalt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.vanvalt.entity.Template;


/**
 * 
 * @author Xiaoyang
 *
 */
public interface TemplateDao {

	public void add(Template template);

	public void delete(Class<Template> clz,Map<String, Object> params);

	public void deleteBatch(Class<Template> clz,Map<String, Object> params);
	
	public void update(Template template);
	
	public void updateBatch(Class<Template> clz,Map<String,Object> params);
	
	public Template load(Class<Template> clz,String id);
	
	public List<Template> list(Class<Template> clz, Map<String, Object> params, RowBounds rowBounds);
	
	public List<Template> list(Class<Template> clz, Map<String, Object> params);

	public int findCount(Class<Template> clz, Map<String, Object> params);
}
