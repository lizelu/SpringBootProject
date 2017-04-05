package com.zeluli.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBatisTestController {
	
	@Autowired
	private ContentMapper contentMapper;
	
	//http://127.0.0.1:8080/queryContentById?contentId=6
	@RequestMapping(value="/queryContentById")
	public Content queryContentById(String contentId) {

		Content content = contentMapper.queryById(contentId);
		return content;
	}
	
	@RequestMapping(value="/queryAll")
	public List<Content> queryAll() {

		List<Content> content = contentMapper.query();
		return content;
	}
}
