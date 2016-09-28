package com.dcnetworkdisk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dcnetworkdisk.common.vo.OutputWrapper;
import com.dcnetworkdisk.file.service.DownloadFileOutput;
import com.dcnetworkdisk.file.service.FileService;
import com.dcnetworkdisk.file.service.ShowFileListOutput;
import com.dcnetworkdisk.file.service.UploadFileOutput;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/sfl/{secureToken}/{path}",method=RequestMethod.GET)
	public OutputWrapper<ShowFileListOutput> showFileList(@PathVariable String secureToken, @PathVariable String path, @RequestParam(required=false) String orderBy, @RequestParam(required=false) String order, @RequestParam(required=false) String limit){
		return fileService.getFileList(secureToken, path, orderBy, order, limit);
	}
	
	@RequestMapping(value="/upload/{secureToken}", method=RequestMethod.POST)
	public OutputWrapper<UploadFileOutput> uploadFile(@PathVariable String secureToken, @RequestParam MultipartFile file){
		return fileService.uploadFile(secureToken, file);
	}
	
	@RequestMapping(value="/download/{secureToken}")
	public OutputWrapper<DownloadFileOutput> downloadFile(@PathVariable String secureToken){
		return null;
	}
	
}
