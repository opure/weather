package com.vanvalt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.entity.Feedbook;
import com.vanvalt.service.FeedbookService;

@Service
@Transactional
public class FeedbookServiceImpl extends BaseServiceImpl<Feedbook> implements FeedbookService{

	
}
