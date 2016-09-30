package com.dcnetworkdisk.file.dao.test;

import java.util.List;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
		List<DcFile> list = fileDao.findByOwnerNameAndFilepath("dlc", "/");
		System.out.println(list);
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
