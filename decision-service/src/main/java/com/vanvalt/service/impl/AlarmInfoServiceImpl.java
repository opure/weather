package com.vanvalt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.entity.AlarmInfo;
import com.vanvalt.service.AlarmInfoService;

@Service
@Transactional
public class AlarmInfoServiceImpl extends BaseServiceImpl<AlarmInfo> implements AlarmInfoService{

	
}
