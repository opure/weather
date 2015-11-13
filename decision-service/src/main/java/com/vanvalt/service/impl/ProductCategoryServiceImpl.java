package com.vanvalt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanvalt.entity.ProductCategory;
import com.vanvalt.service.ProductCategoryService;

@Service
@Transactional
public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory> implements ProductCategoryService{

	
}
