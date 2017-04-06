package com.zeluli.inote;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeluli.inote.dao.ContentDao;


@RestController
public class ContentRestController {
	@Autowired
	private ContentDao contentDao;
	
	@RequestMapping(value="/contentList")
	public Map<String, Object> queryContentList(String userId) {
		return contentDao.queryContentList(userId);
	}
	
	@RequestMapping(value="/contentDetail")
	public Map<String, Object> queryContent(String contentId) {
		return contentDao.queryContent(contentId);
	}
	
	@RequestMapping(value="/contentAdd")
	public Map<String, Object> addContent(String userId, String title, String content) {
		return contentDao.addContent(userId, title, content);
	}
}
