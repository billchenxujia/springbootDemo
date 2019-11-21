package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.dto.UserDO;


/**
 * 
 * 类 @code(UserDao)
 *
 * <p>
 *  功能简介：
 * <p>
* 用户数据服务类
 * <p>
 *  创建时间：2019年9月16日
 *
 * @author chenxj
 */
@Repository
public interface UserDao extends JpaRepository<UserDO, Long> {
	
	UserDO findByAccount(String account);
}
