package com.siteview.springboot.service;

import com.siteview.springboot.bean.UserMessage;
import com.siteview.springboot.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * <p>
 * 服务层
 */
@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public List<UserMessage> selectAll() {
    return userMapper.selectAll();
  }

  public int delete(String id) {
    return userMapper.delete(id);
  }

  public int insert(UserMessage user) {
    return userMapper.insert(user);
  }

  public int update(UserMessage user) {
    return userMapper.update(user);
  }

  public UserMessage getUserById(String id) {
    return userMapper.getUserById(id);
  }

}
