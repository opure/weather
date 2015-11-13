package com.vanvalt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.entity.Admin;
import com.vanvalt.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{

	
}
