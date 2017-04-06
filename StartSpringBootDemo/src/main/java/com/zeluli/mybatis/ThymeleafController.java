package com.zeluli.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@MapperScan("com.zeluli.mybatis")
public class ThymeleafController {
	
	@Autowired
	private ContentMapper contentMapper;
	
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("contents", contentMapper.query());
		return "display";
	}
}
