package com.bocloud.work.mapper;

import java.util.List;

import com.bocloud.work.SuperMapper;
import com.bocloud.work.entity.User;

public interface UserMapper extends SuperMapper<User>{

	void save(User user);    
    boolean update(User user);    
    boolean delete(int id);    
    User findById(int id);    
    List<User> findAll();
	static boolean ajaxValidateusername(String username) {
		return false;
	}  
	
}
