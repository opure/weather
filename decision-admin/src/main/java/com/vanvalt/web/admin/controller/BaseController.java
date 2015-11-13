package com.vanvalt.web.admin.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vanvalt.util.comm.Pager;
import com.vanvalt.util.constant.Constant;


public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	//初始化分页相关信息  
    protected void initPage(Map<String,Object> map, Integer pageNum, Integer pageSize, Integer totalCount){  
        if(null==pageSize || pageSize.equals("")){  
            pageSize = Constant.PAGE_SIZE;  
        }  
        if(pageSize>50){  
            pageSize = 50;  
        }  
        Integer totalPage = (totalCount+pageSize-1)/pageSize;  
        if(null==pageNum){  
            pageNum = 1;  
        }else if(pageNum>totalPage){  
            pageNum = totalPage;  
        }  
        map.put("startIndex", Pager.getStartIndex(pageNum, pageSize));  
        map.put("pageNum", pageNum);  
        map.put("totalPage", totalPage);  
        map.put("pageSize", pageSize);  
        map.put("totalCount", totalCount);  
          
    }  
      
    //将相关数据放入model  
    protected void initResult(Model model, List<Object> list, Map<String,Object> map){  
        model.addAttribute("list", list);  
        Iterator it = map.entrySet().iterator();   
        while(it.hasNext()){   
            Map.Entry m = (Map.Entry)it.next();   
            model.addAttribute(m.getKey().toString(), m.getValue());  
       }   
    }  
      
	
	/**
	 * 添加Model消息
	 * @param messages 消息
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		model.addAttribute("message", sb.toString());
	}
	
	/**
	 * 添加Flash消息
     * @param messages 消息
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
	
	/**
	 * 初始化数据绑定
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	 * 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}
			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				try {
					setValue(DateUtils.parseDate(text));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
}
