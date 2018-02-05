package com.siteview.springboot.mapper;

import java.util.List;

import com.siteview.springboot.bean.UserMessage;

public interface UserMapper {

	int delete(String id);

	int insert(UserMessage user);

	int update(UserMessage user);

	List<UserMessage> selectAll();

	UserMessage getUserById(String id);
}
