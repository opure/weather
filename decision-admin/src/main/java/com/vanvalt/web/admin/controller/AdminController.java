package com.vanvalt.web.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanvalt.service.AdminService;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 下午11:49:35 
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	private AdminService adminServvice;
	
	
	@RequestMapping(value="myContacts")
	public String myContacts(Model model,  
			@RequestParam(required=false) Integer pageNum,   
            @RequestParam(required=false) Integer pageSize, 
            HttpSession httpSession){
		
		String returnUrl = "page/person/myContacts";
		
		
		
		return returnUrl;
	}
	
	
}
