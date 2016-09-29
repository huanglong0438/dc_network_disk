package com.dcnetworkdisk.file.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dcnetworkdisk.common.constant.Constants;
import com.dcnetworkdisk.common.enums.Order;
import com.dcnetworkdisk.common.enums.OrderBy;
import com.dcnetworkdisk.common.vo.OutputWrapper;
import com.dcnetworkdisk.file.dao.FileDao;
import com.dcnetworkdisk.file.model.DcFile;
import com.dcnetworkdisk.web.utils.WebCache;

@Service
public class FileService {
	
	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	@Autowired
	private WebCache webCache;
	
	@Autowired
	private FileDao fileDao;
	
	/**
	 * 显示用户的文件列表，这里最好的实现方法还是用 [内存-数据库-文件] 互相刷 模式
	 * @param secureToken
	 * @return
	 */
	public OutputWrapper<ShowFileListOutput> getFileList(String secureToken, String path, String orderBy, String order, String limit){
		OutputWrapper<ShowFileListOutput> wrapper = new OutputWrapper<ShowFileListOutput>();
		String username = webCache.getUsername(secureToken);
		ShowFileListOutput showFileListOutput = new ShowFileListOutput();
		//path此处应该校验合法性 ，'/'开头，并且要urlcode转码
		try {
			path = URLDecoder.decode(path, "utf-8");
			File userFile = new File(Constants.DEFAULT_STORAGE_LOCATION + username + path);
			//路径不存在，或者路径指向的不是文件夹目录而是文件
			if(!userFile.exists()){
				wrapper.setErrorCode("300");
				wrapper.setErrorMsg("request error: directory doesn't exists");
				return wrapper;
			}
			if(!userFile.isDirectory()){
				wrapper.setErrorCode("301");
				wrapper.setErrorMsg("request error: not a directory");
				return wrapper;
			}
			//可选参数是否存在，如果不存在，设置为默认值
			orderBy = (orderBy == null ? OrderBy.NAME.getCode() : orderBy);
			order = (order == null ? Order.asc.getCode() : order);
			limit = (limit == null ? "all" : limit);
			//还要根据上面的条件，对查找的结果进行控制，或者应该直接根据上面的条件来进行数据库查找！！！
			List<DcFile> list = null;
			if(limit.equals("all")){
				list = fileDao.getAllFilelist(username, path, orderBy, order);
			}
			else{
				int ends[] = getLimit(limit);
				list = fileDao.getSubFilelist(username, path, orderBy, order, ends[0], ends[1]-ends[0]+1);
			}
			showFileListOutput.setFilelist(list);
			wrapper.setResult(showFileListOutput);
			return wrapper;
		} catch (UnsupportedEncodingException e) {
			logger.error("request param filepath format error.", e);
			wrapper.setErrorCode("300");
			wrapper.setErrorMsg("request param filepath format error.");
			return wrapper;
		}
	}
	
	/**
	 * 根据token和路径path上传文件的到服务器，并且记录到数据库中
	 * @param secureToken
	 * @param path
	 * @param remoteFile
	 * @return
	 */
	public OutputWrapper<UploadFileOutput> uploadFile(String secureToken, String path, MultipartFile remoteFile){
		OutputWrapper<UploadFileOutput> wrapper = new OutputWrapper<UploadFileOutput>();
		try {
			path = URLDecoder.decode(path, "utf-8");
			String username = webCache.getUsername(secureToken);
			File localFile = new File(Constants.DEFAULT_STORAGE_LOCATION + username + path + remoteFile.getOriginalFilename());
			if(remoteToLocal(remoteFile, localFile)){
				//修改数据库
				DcFile dcFile = new DcFile();
				dcFile.setFilename(localFile.getName());
				dcFile.setFilepath(path);
				dcFile.setFilesize(BigDecimal.valueOf(localFile.length()));
				dcFile.setIsdir("0");
				dcFile.setOwnerName(username);
				dcFile = fileDao.save(dcFile);
				logger.info("数据库修改成功:" + dcFile);
				//返回结果
				UploadFileOutput output = new UploadFileOutput();
				output.setFid(dcFile.getFid());
				output.setFilename(dcFile.getFilename());
				output.setPath(dcFile.getFilepath());
				output.setSize(dcFile.getFilesize());
				output.setCreate_time(dcFile.getCreate_date());
				output.setModified_time(dcFile.getModified_date());
				wrapper.setResult(output);
				return wrapper;
			}
			else{
				wrapper.setErrorCode("400");
				wrapper.setErrorMsg("upload failed.");
				return wrapper;
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("request param filepath format error.", e);
			wrapper.setErrorCode("300");
			wrapper.setErrorMsg("request param filepath format error.");
			return wrapper;
		}
	}
	
	public OutputWrapper<DownloadFileOutput> downloadFile(){
		return null;
	}
	
	private boolean remoteToLocal(MultipartFile remoteFile, File localFile){
		byte buffer[] = new byte[1024];
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(localFile);
			InputStream is = remoteFile.getInputStream();
			int size;
			while((size = is.read(buffer)) > 0){
				fos.write(buffer, 0, size);
			}
		} catch (FileNotFoundException e){
			logger.error("file not found of FileOutputStream.", e);
			return false;
		} catch (IOException e) {
			logger.error("IOException while uploading.", e);
			return false;
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				logger.error("FileOutputStream close error.", e);
			}
		}
		return true;
	}
	
	private int[] getLimit(String limit){
		String[] strs = limit.split("-");
		int[] res = new int[strs.length];
		for(int i = 0; i < strs.length; i++){
			res[i] = Integer.parseInt(strs[i]);
		}
		return res;
	}
	
	
}
