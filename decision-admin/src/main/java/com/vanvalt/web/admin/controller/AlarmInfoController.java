package com.vanvalt.web.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	/**
	 * 预警信息列表
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @param httpSession
	 * @return
	 */
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
	
	/**
	 * 编辑预警信息
	 * @param model
	 * @param alertId
	 * @param httpSession
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="edit")
	public String edit(Model model,  
			@RequestParam(required=false) String alertId,   
            HttpSession httpSession) throws UnsupportedEncodingException{
		
		String returnUrl = "page/alarm/editAlarmInfo";
		
		AlarmInfo alarmInfo = new AlarmInfo();
		
		if(alertId != null && !"".equals(alertId)){
			String alertIdStr = URLDecoder.decode(alertId, "UTF-8");
			alarmInfo = this.alarmInfoService.load(AlarmInfo.class, alertIdStr);
			
			String issueTime = alarmInfo.getIssueTime();
			String relieveTime = alarmInfo.getRelieveTime();
			
			// 格式化发布时间和解除时间
			alarmInfo.setIssueTime(StringUtils.formateDateStr(issueTime));
			alarmInfo.setRelieveTime(StringUtils.formateDateStr(relieveTime));
		}
		
		model.addAttribute("alarmInfo", alarmInfo);
		
		return returnUrl;
	}
	
	/**
	 * 保存预警信息更新
	 * @param model
	 * @param alertId
	 * @param province
	 * @param city
	 * @param signalType
	 * @param signalLevel
	 * @param issueTime
	 * @param relieveTime
	 * @param issueContent
	 * @param httpSession
	 * @return
	 * @throws JSONException
	 */
	@ResponseBody
	@RequestMapping(value="save")
	public String save(Model model,  
			@RequestParam String alertId,
			@RequestParam(required=false) String province,
			@RequestParam(required=false) String city,
			@RequestParam(required=false) String signalType,
			@RequestParam(required=false) String signalLevel,
			@RequestParam(required=false) String issueTime,
			@RequestParam(required=false) String relieveTime,
			@RequestParam(required=false) String issueContent,
            HttpSession httpSession) throws JSONException{
		
		JSONObject json = new JSONObject();
		
		if(alertId != null && !"".equals(alertId)){
			
			AlarmInfo alarmInfo = this.alarmInfoService.load(AlarmInfo.class, alertId);
			
			if(alarmInfo != null){
				alarmInfo.setProvince(province);
				alarmInfo.setCity(city);
				alarmInfo.setSignalType(signalType);
				alarmInfo.setSignalLevel(signalLevel);
				alarmInfo.setIssueTime(issueTime);
				alarmInfo.setRelieveTime(relieveTime);
				alarmInfo.setIssueContent(issueContent);
				
				this.alarmInfoService.update(alarmInfo);
				
				json.put("success", true);
			}
		}
		
		return json.toString();
	}
	
}
