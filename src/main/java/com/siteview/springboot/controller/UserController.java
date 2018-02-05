package com.siteview.springboot.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siteview.springboot.bean.UserMessage;
import com.siteview.springboot.service.UserService;

/**
 * 
 * @author Administrator
 *
 *         控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserService userService;

	@RequestMapping("/getUsers")
	public List<Map<String, Object>> getUsers() {
		String sql = "select * from user";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : list) {
			Set<Entry<String, Object>> entries = map.entrySet();
			if (entries != null) {
				Iterator<Entry<String, Object>> iterator = entries.iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
					Object key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + ":" + value);
				}
			}
		}
		return list;
	}

	@RequestMapping("/getUser/{id}")
	public Map<String, Object> getUser(@PathVariable String id) {
		Map<String, Object> map = null;
		List<Map<String, Object>> list = getUsers();
		for (Map<String, Object> dbmap : list) {
			Set<String> set = dbmap.keySet();
			for (String key : set) {
				if (key.equals("id")) {
					if (dbmap.get(key).equals(id)) {
						map = dbmap;
					}
				}
			}
		}
		if (map == null)
			map = list.get(0);
		return map;
	}

	@RequestMapping("/allUsers")
	public List<UserMessage> selectAll() {
		return userService.selectAll();
	}

	@RequestMapping("/delete/{id}")
	public int delete(@PathVariable String id) {
		return userService.delete(id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int insert(@RequestBody UserMessage user) {
		return userService.insert(user);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(UserMessage user) {
		return userService.update(user);
	}

	@RequestMapping("/user/{id}")
	public UserMessage getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}
}
