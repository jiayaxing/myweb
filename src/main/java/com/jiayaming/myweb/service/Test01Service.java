package com.jiayaming.myweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiayaming.myweb.dao.Test01Mapper;
import com.jiayaming.myweb.model.Test01;

@Service("test01Service")
public class Test01Service {
	@Resource
	Test01Mapper test01Mapper;
	
	public Test01 selectById(Integer id) throws Exception{
		Test01 test01 = test01Mapper.selectByPrimaryKey(id);
		return test01;
	}
}
