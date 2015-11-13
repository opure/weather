package com.vanvalt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.entity.Product;
import com.vanvalt.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	
}
