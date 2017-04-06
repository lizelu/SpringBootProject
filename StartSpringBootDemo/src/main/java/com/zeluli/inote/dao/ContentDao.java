package com.zeluli.inote.dao;

import java.util.ArrayList;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeluli.inote.mapper.INoteContentMapper;
import com.zeluli.inote.model.Content;

@Service
@MapperScan("com.zeluli.inote.mapper")
public class ContentDao extends SuperDao {
	@Autowired
	private INoteContentMapper contentMapper;
	
	public Map<String, Object> queryContent (String contentId) {
		this.responseBody.remove("list");
		ArrayList<Content> contents = contentMapper.queryByContentId(contentId);
		if(!contents.isEmpty()){
			this.responseBody.put("list", contents.get(0));
		}
		
		this.responseBody.put("result", "SUCCESS");
		this.responseBody.put("errorMessage", "");
		return this.responseBody;
	}
	
	public Map<String, Object> queryContentList (String userId) {
		this.responseBody.put("list", contentMapper.queryByUserId(userId));
		this.responseBody.put("result", "SUCCESS");
		this.responseBody.put("errorMessage", "");
		return this.responseBody;
	}
	
	public Map<String, Object> addContent (String userId, String title, String content) {
		contentMapper.insert(userId, title, content);
		this.responseBody.remove("list");
		this.responseBody.put("result", "SUCCESS");
		this.responseBody.put("errorMessage", "");
		return this.responseBody;
	}
}
