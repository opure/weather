package com.vanvalt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.dao.AppDao;
import com.vanvalt.entity.App;
import com.vanvalt.service.AppService;

@Service
@Transactional
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService{

	
	@Autowired
	private AppDao appDao;
	
	@Override
	public List<App> listByPage(Class<App> clz,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return appDao.listByPage(clz, params);
	}

	@Override
	public App load(Class<App> clz, Integer id) {
		// TODO Auto-generated method stub
		return appDao.load(clz, id);
	}
	
}
