package com.vanvalt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.entity.App;
import com.vanvalt.service.AppService;

@Service
@Transactional
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService{

	
}
