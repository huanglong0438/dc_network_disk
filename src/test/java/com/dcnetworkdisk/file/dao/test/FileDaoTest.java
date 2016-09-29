package com.dcnetworkdisk.file.dao.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dcnetworkdisk.common.test.BaseTest;
import com.dcnetworkdisk.file.dao.FileDao;
import com.dcnetworkdisk.file.model.DcFile;
import com.dcnetworkdisk.user.dao.UserDao;

public class FileDaoTest extends BaseTest{
	
	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void findByOwnerNameAndPathTest(){
		String ownerName = "dlc";
		String path = "/";
		List<DcFile> list = fileDao.findByOwnerNameAndFilepath("dlc", "/");
		userDao.ensureUser("dlc", "123");
		System.out.println("Test test");
	}
	
	@Test
	public void saveTest(){
		DcFile dcFile = new DcFile();
		dcFile.setFilename("test");
		fileDao.save(dcFile);
		System.out.println(dcFile);
	}
}
