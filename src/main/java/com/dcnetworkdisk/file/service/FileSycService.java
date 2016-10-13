package com.dcnetworkdisk.file.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.dcnetworkdisk.common.constant.Constants;
import com.dcnetworkdisk.common.enums.IsDir;
import com.dcnetworkdisk.file.dao.FileDao;
import com.dcnetworkdisk.file.model.DcFile;
import com.dcnetworkdisk.user.dao.UserDao;
import com.dcnetworkdisk.user.model.User;

public class FileSycService implements InitializingBean{

	private static final Logger logger = LoggerFactory.getLogger(FileSycService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FileDao fileDao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Lock lock = new ReentrantLock();
		lock.lock();
		try{
			refresh();
		} finally {
			lock.unlock();
		}
	}

	public void refresh() throws InterruptedException{
		logger.info("sychronizing the local file to database...");
		Iterable<User> users = userDao.findAll();
		for(User user : users){
			logger.info("sychronize " + user.getUsername());
			String userPath = Constants.DEFAULT_STORAGE_LOCATION + user.getUsername() + "/";
			sycRescursive(user.getUsername(), userPath);
		}
		logger.info("sychronized complete.");
	}

	/**
	 * 递归地同步文件到数据库，根据本地文件存储的实际情况来同步到数据库中
	 * file --> database
	 * @param username
	 * @param userPath
	 */
	private void sycRescursive(String username, String userPath){
		File userPathFile = new File(userPath);
		File[] files = userPathFile.listFiles();
		//对当前文件夹下的所有文件进行遍历
		for(File file : files){
			//通过本地文件名、用户名和目录查找数据库中的文件，
			String relativePath = getRelativePath(username, userPath);
			List<DcFile> list = fileDao.findByOwnerNameAndFilenameAndFilepath(username, file.getName(), relativePath);
			if(file.isDirectory()){
				//本地是目录，数据库是空，则更新数据库
				if(list == null || list.size() == 0){
					logger.debug("file " + file.getName() + " don't have record, need to be update to database.");
					DcFile dcFile = new DcFile();
					dcFile.setFilename(file.getName());
					dcFile.setFilepath(relativePath);
					dcFile.setIsdir(IsDir.dir.getCode());
					dcFile.setOwnerName(username);
					fileDao.save(dcFile);
				}
				//本地是目录，数据库不是目录，则报错误（或者修改数据库信息）
				else if(!list.get(0).getIsdir().equals(IsDir.dir.getCode())){
					logger.error("file {} exist but not a dir at database.", file.getName());
				}
				//本地是目录，数据库存在，并且也是目录，则递归同步里面的部分
				else
					sycRescursive(username, file.getAbsolutePath());
			}
			//如果本地是文件
			else{
				logger.debug("sychronize to database.");
				//如果返回null，则表示当前文件在数据库中并不存在，则将文件同步到数据库中
				if(list == null || list.size() == 0){
					logger.debug("file " + file.getName() + " don't have record, need to be update to database.");
					DcFile dcFile = new DcFile();
					dcFile.setFilename(file.getName());
					dcFile.setFilepath(relativePath);
					dcFile.setFilesize(BigDecimal.valueOf(file.length()));
					dcFile.setIsdir(IsDir.file.getCode());
					dcFile.setOwnerName(username);
					fileDao.save(dcFile);
				}
				//返回有值，但是不是文件，则报错（或修改数据库）
				else if(!list.get(0).getIsdir().equals(IsDir.file.getCode())){
					logger.error("file {} exist but not a file at database.", file.getName());
				}
			}
		}
	}
	
	private String getRelativePath(String username, String absolutePath){
		return absolutePath.substring((Constants.DEFAULT_STORAGE_LOCATION+username).length(), absolutePath.length());
	}
	
}
