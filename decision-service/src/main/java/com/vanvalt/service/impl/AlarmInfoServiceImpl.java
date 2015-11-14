package com.vanvalt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.dao.AlarmInfoDao;
import com.vanvalt.entity.AlarmInfo;
import com.vanvalt.service.AlarmInfoService;

@Service
@Transactional
public class AlarmInfoServiceImpl extends BaseServiceImpl<AlarmInfo> implements AlarmInfoService{

	@Autowired
	private AlarmInfoDao alarmInfoDao;
	
	@Override
	public List<AlarmInfo> listByPage(Class<AlarmInfo> clz,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return alarmInfoDao.listByPage(clz, params);
	}

	
}
