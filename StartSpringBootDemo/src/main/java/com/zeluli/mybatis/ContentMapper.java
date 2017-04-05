package com.zeluli.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ContentMapper {
	@Select("select * from content")
	@Results(value={@Result(id=true, column="id", property="contentId"),
			@Result(column="create_time", property="createTime")
			})
	List<Content> query();
	
	@Select("select * from content where id = #{id}")
	@Results(value={@Result(column="create_time", property="createTime"),
			@Result(id=true, column="id", property="contentId")})
	Content queryById(@Param("id") String contentId);
}
