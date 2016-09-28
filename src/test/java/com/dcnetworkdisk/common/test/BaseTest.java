package com.dcnetworkdisk.common.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests{
//本类作为基类，所有要用到的东西都在annotation里配置了。所以什么内容都不用写了。
	
}
