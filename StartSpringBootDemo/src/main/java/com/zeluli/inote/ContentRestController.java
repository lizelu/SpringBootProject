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
	
	//获取内容列表
	@RequestMapping(value="/contentList")
	public Map<String, Object> queryContentList(String userId) {
		return contentDao.queryContentList(userId);
	}
	//获取内容详情
	@RequestMapping(value="/contentDetail")
	public Map<String, Object> queryContent(String contentId) {
		return contentDao.queryContent(contentId);
	}
	//添加内容
	@RequestMapping(value="/contentAdd")
	public Map<String, Object> addContent(String userId, String title, String content) {
		return contentDao.addContent(userId, title, content);
	}
	//更新内容
	@RequestMapping(value="/contentUpdate")
	public Map<String, Object> updateContent(String contentId, String title, String content) {
		return contentDao.updateContent(contentId, title, content);
	}
	//删除内容
	@RequestMapping(value="/contentDelete")
	public Map<String, Object> deleteContent(String contentId) {
		return contentDao.deleteContent(contentId);
	}
}
