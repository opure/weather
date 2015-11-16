package com.vanvalt.web.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;
import com.vanvalt.entity.AlarmInfo;
import com.vanvalt.entity.App;
import com.vanvalt.service.AdminService;
import com.vanvalt.service.AppService;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 下午11:49:35 
 * 
 */
@Controller
@RequestMapping("/app")
public class AppController extends BaseController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AppService appService;
	
	/**
	 * 应用管理
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="index")
	public String index(Model model,  
			@RequestParam(required=false) Integer pageNum,   
            @RequestParam(required=false) Integer pageSize, 
            HttpSession httpSession){
		
		String returnUrl = "page/app/allAppInfo";
		
		List<App> appList = new ArrayList<App>();
		Map<String, Object> params = new HashMap<String,Object>();
		
		List list = Lists.newArrayList();
		
		Integer totalCount = this.appService.findCount(App.class, params);
		this.initPage(params, pageNum, pageSize, totalCount);
		appList = this.appService.listByPage(App.class, params);
		
		list = appList;
		this.initResult(model, list, params);
		
		model.addAttribute("appList", appList);
		
		return returnUrl;
	}
	
	/**
	 * 编辑应用信息
	 * @param model
	 * @param id
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="edit")
	public String edit(Model model,  
			@RequestParam Integer id,   
            HttpSession httpSession){
		
		String returnUrl = "page/app/editAppInfo";
		
		App app = new App();
		
		if(id != null){
			
			app = this.appService.load(App.class, id);
		}
		
		model.addAttribute("appInfo", app);
		
		return returnUrl;
	}
	
	/**
	 * 查看应用信息
	 * @param model
	 * @param id
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="view")
	public String view(Model model,  
			@RequestParam Integer id,   
            HttpSession httpSession){
		
		String returnUrl = "page/app/viewAppInfo";
		
		App app = new App();
		
		if(id != null){
			
			app = this.appService.load(App.class, id);
		}
		
		model.addAttribute("appInfo", app);
		
		return returnUrl;
	}
	
}
