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
import com.vanvalt.service.AdminService;
import com.vanvalt.service.AlarmInfoService;
import com.vanvalt.util.comm.StringUtils;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 下午11:49:35 
 * 
 */
@Controller
@RequestMapping("/alarm")
public class AlarmInfoController extends BaseController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AlarmInfoService alarmInfoService;
	
	
	@RequestMapping(value="list")
	public String list(Model model,  
			@RequestParam(required=false) Integer pageNum,   
            @RequestParam(required=false) Integer pageSize, 
            HttpSession httpSession){
		
		String returnUrl = "page/alarm/alarmInfo";
		
		List<AlarmInfo> alarmInfoList = new ArrayList<AlarmInfo>();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		List list = Lists.newArrayList();
		
		Integer totalCount = this.alarmInfoService.findCount(AlarmInfo.class, params);
		this.initPage(params, pageNum, pageSize, totalCount);
		
		alarmInfoList = this.alarmInfoService.listByPage(AlarmInfo.class, params);
		
		for(AlarmInfo ai:alarmInfoList){
			
			String issueTime = ai.getIssueTime();
			String relieveTime = ai.getRelieveTime();
			
			ai.setIssueTime(StringUtils.formateDateStr(issueTime));
			ai.setRelieveTime(StringUtils.formateDateStr(relieveTime));
		}
		
		list = alarmInfoList;
		this.initResult(model, list, params);
		
		model.addAttribute("alarmInfoList", alarmInfoList);
		
		return returnUrl;
	}
	
	
}
