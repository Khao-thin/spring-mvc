package com.yc.springmvc.web;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadAction {
	@PostMapping("/upload")
	public String upload(@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {
		String diskpath="D:\\项目作业\\新建文件夹/";
		String filename=file.getOriginalFilename();//文件名
		file.transferTo(new File(diskpath+filename));
		return "success:"+"photo/"+filename;
	}
}
