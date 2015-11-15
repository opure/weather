package com.vanvalt.web.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
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
import com.vanvalt.util.date.DateUtil;

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
	 * 生效中预警信息
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
		
		String returnUrl = "page/alarm/effectAlarmInfo";
		
		List<AlarmInfo> allAlarmInfoList = new ArrayList<AlarmInfo>();
		List<AlarmInfo> alarmInfoList = new ArrayList<AlarmInfo>();
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("alartId", "201511141508598560");
		
		List list = Lists.newArrayList();
		
		allAlarmInfoList = this.alarmInfoService.list(AlarmInfo.class, params);
		
		for(AlarmInfo ai:allAlarmInfoList){
			
			String issueTime = ai.getIssueTime();
			String relieveTime = ai.getRelieveTime();
			
			if(issueTime != null && !"".equals(issueTime)){
				if(relieveTime != null && !"".equals(relieveTime)){
					
					String issueDateStr = StringUtils.formateStr2Date(issueTime);
					String relieveDateStr = StringUtils.formateStr2Date(relieveTime);
					
					Date issueDate = DateUtil.dateFormat(issueDateStr);
					Date relieveDate = DateUtil.dateFormat(relieveDateStr);
					//logger.info(issueTime+", "+relieveTime);
					// 判断当前时间是否在发布时间和解除时间之间
					if(DateUtil.nowDateBetweenStartDateAndEndDate(issueDate, relieveDate)){
						
						ai.setIssueTime(issueDateStr);
						ai.setRelieveTime(relieveDateStr);
						
						alarmInfoList.add(ai);
					}
				}
			}
		}
		
		Integer totalCount = alarmInfoList.size();
		this.initPage(params, pageNum, pageSize, totalCount);
		
		list = alarmInfoList;
		this.initResult(model, list, params);
		
		model.addAttribute("alarmInfoList", alarmInfoList);
		
		return returnUrl;
	}
	
	/**
	 * 全部预警信息
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="all")
	public String all(Model model,  
			@RequestParam(required=false) Integer pageNum,   
            @RequestParam(required=false) Integer pageSize, 
            HttpSession httpSession){
		
		String returnUrl = "page/alarm/allAlarmInfo";
		
		List<AlarmInfo> alarmInfoList = new ArrayList<AlarmInfo>();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		List list = Lists.newArrayList();
		
		Integer totalCount = this.alarmInfoService.findCount(AlarmInfo.class, params);
		this.initPage(params, pageNum, pageSize, totalCount);
		
		alarmInfoList = this.alarmInfoService.listByPage(AlarmInfo.class, params);
		
		for(AlarmInfo ai:alarmInfoList){
			
			String issueTime = ai.getIssueTime();
			String relieveTime = ai.getRelieveTime();
			
			ai.setIssueTime(StringUtils.formateStr2Date(issueTime));
			ai.setRelieveTime(StringUtils.formateStr2Date(relieveTime));
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
			alarmInfo.setIssueTime(StringUtils.formateStr2Date(issueTime));
			alarmInfo.setRelieveTime(StringUtils.formateStr2Date(relieveTime));
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
				alarmInfo.setIssueTime(StringUtils.formatDate2Str(issueTime));
				alarmInfo.setRelieveTime(StringUtils.formatDate2Str(relieveTime));
				alarmInfo.setIssueContent(issueContent);
				
				this.alarmInfoService.update(alarmInfo);
				
				json.put("success", true);
			}
		}
		
		return json.toString();
	}
	
	/**
	 * 解除预警
	 * @param model
	 * @param alertId
	 * @param httpSession
	 * @return
	 * @throws JSONException
	 */
	@ResponseBody
	@RequestMapping(value="relieve")
	public String relieve(Model model,  
			@RequestParam String alertId,
            HttpSession httpSession) throws JSONException{
		
		JSONObject json = new JSONObject();
		
		if(alertId != null && !"".equals(alertId)){
			
			AlarmInfo alarm = this.alarmInfoService.load(AlarmInfo.class, alertId);
			
			if(alarm != null){
				
				String nowDate = DateUtil.getStringNowTime();
				String relieveTime = StringUtils.formatDate2Str(nowDate);
				
				alarm.setRelieveTime(relieveTime);
				
				this.alarmInfoService.update(alarm);
				json.put("success", true);
			}
		}
		
		return json.toString();
	}
	
}
