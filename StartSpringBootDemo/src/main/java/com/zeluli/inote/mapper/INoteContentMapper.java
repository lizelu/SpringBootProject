package com.zeluli.inote.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zeluli.inote.model.Content;

@Mapper
public interface INoteContentMapper {
	//根据ContentId来查询内容信息
	@Select("select content from content where id = #{contentId}")
	ArrayList<Content> queryByContentId(@Param("contentId") String contentId);
	
	//根据外键UserId来查询内容
	@Select("select * from content where userID = #{userId}")
	@Results(value={
			@Result(column="create_time", property="time"),
			@Result(id=true, column="id", property="contentId")
			})
	ArrayList<Content> queryByUserId(@Param("userId") String userId);
	
	//插入用户，用户注册
	@Insert("insert into content (userID, title, content) values (#{userId}, #{title}, #{content})")
	void insert(@Param("userId") String userId, @Param("title") String title, @Param("content") String content);
	
	//根据ContentId来更新内容信息
	@Update("update content set title=#{title}, content=#{content}, create_time=now() where id=#{contentId}")
	void updateContent(@Param("contentId") String contentId, @Param("title") String title, @Param("content") String content);
	
	@Delete("delete from content where id=#{contentId}")
	void deleteContent(@Param("contentId") String contentId);
}
