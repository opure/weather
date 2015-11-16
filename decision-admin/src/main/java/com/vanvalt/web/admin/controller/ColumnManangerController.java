package com.vanvalt.web.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.google.common.collect.Lists;
import com.vanvalt.entity.AlarmInfo;
import com.vanvalt.entity.Column;
import com.vanvalt.service.AppService;
import com.vanvalt.service.ColumnService;

/**
 * 
* @ClassName: ColumnMananger
* @Description: 栏目管理
* @author haoc
* @date 2015年11月15日
*
 */
@Controller
@RequestMapping("/column")
public class ColumnManangerController extends BaseController {
	@Autowired
	private ColumnService columnService;
	@Autowired
	private AppService appService;
	
	@RequestMapping(value="allColumn")
	public String allColumn(Model model,
			@RequestParam(required=false) Integer pageNum,
			@RequestParam(required=false) Integer pageSize,
			HttpSession htppSession){
		String returnUrl = "page/columnmananger/columnmananger";
		List<Column> columnList =new ArrayList<Column>();
		
		Map<String,Object> params =new HashMap<String,Object>();
		
		List list=Lists.newArrayList();
		
		Integer totalCount = this.columnService.findCount(Column.class, params);
		
		this.initPage(params, pageNum, pageSize, totalCount);
		
		columnList =this.columnService.list(Column.class, params);
           for(Column ai:columnList){
			String id =ai.getName();
			String id3=ai.getApp().getTitle();
			int id1=ai.getApp().getId();
			int id2=ai.getAppId();
		
           }
			
		
		list=columnList;
		
		this.initResult(model, list, params);
		
		model.addAttribute("columnList",columnList);
		
	     return returnUrl ;
	}

}
