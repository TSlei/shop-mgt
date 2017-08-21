package com.shop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.shop.web.service.OrderService;

@Controller
@RequestMapping(value="/echarts")
public class EchartsController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/page")
	public ModelAndView gotoEchartsPage(){
		ModelAndView model = new ModelAndView("/basic/echarts/echarts-page");
		return model;
	}
	@RequestMapping("/getAllDate")
	@ResponseBody
	public JSONObject getAllDate(){
		JSONObject selectMonthTheSales = orderService.selectMonthTheSales();
		return selectMonthTheSales;
	}
	
}
