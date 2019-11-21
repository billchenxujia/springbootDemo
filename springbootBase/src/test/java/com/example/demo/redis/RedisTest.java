package com.example.demo.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.bean.dto.UserDO;
import com.example.demo.util.RedisUtil;

/**
 * 
 * 类 @code(RedisTest)
 *
 * <p>
 *  功能简介：
 * <p>
* Redis工具类使用测试类
 * <p>
 *  创建时间：2019年9月23日
 *
 * @author chenxj
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {
	@Autowired
	private RedisUtil redisUtil;
	
	@Before
	public void testPre() {
		UserDO userDo =new UserDO();
		userDo.setAccount("111");
		userDo.setId(1l);
		userDo.setName("test");
		userDo.setPwd("000000");
		redisUtil.set("userDo", userDo);		
	}
	
	@Test
	public void testMain() {
		@SuppressWarnings("unused")
		UserDO userDo = (UserDO) redisUtil.get("userDo");
		System.out.println(userDo.getId());
	}
}
