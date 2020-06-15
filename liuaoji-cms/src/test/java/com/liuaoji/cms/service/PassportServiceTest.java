package com.liuaoji.cms.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.liuaoji.cms.BaseTestCase;
import com.liuaoji.cms.domain.User;
import com.liuaoji.cms.metas.Gender;
import com.liuaoji.cms.service.PassportService;

public class PassportServiceTest extends BaseTestCase {

	@Resource
	PassportService passportService;
	
	//@Test
	public void testReg() {
		User user = passportService.reg("howsun", "123456", "howsun", Gender.MALE);
		System.out.println(user.getId());
		System.out.println(user.getCreated());
	}

	@Test
	public void testLogin() {
		User user = passportService.login("howsun", "123456");
		System.out.println(user.getId());
		System.out.println(user.getNickname());
		System.out.println(user.getCreated());
	}

	@Test
	public void testGetString() {
		User user = passportService.get("howsun");
		if(user != null){
			System.out.println(user.getId());
			System.out.println(user.getNickname());
			System.out.println(user.getCreated());
		}
	}

	@Test
	public void testCount() {
		int count = passportService.count(new User("howsun"));
		System.out.println(count);
	}

}