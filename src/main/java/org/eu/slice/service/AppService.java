package org.eu.slice.service;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
@Service
public class AppService
{
	@Resource
	JdbcTemplate jdbcTemplate;

	/*
	 * 通过appServiceProxy获取的事务代理对象调用本方法，实现函数的事务管理。
	 */
	public void insertUser()
	{
		jdbcTemplate
				.update("insert into user (username,password,fullname,invalidyear) values ('xiaxin', '1234','full','2020');");
		jdbcTemplate.update("insert into user (username) values ('xiaxin');");
	}
}
