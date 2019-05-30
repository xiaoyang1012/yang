package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yang.service.PictureService;
import com.yang.util.JsonUtils;
import com.yang.util.PictureResult;

@Controller
public class PicUploadController {
	@Autowired
	private PictureService picService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String picUpload(MultipartFile uploadFile){
		PictureResult result=picService.uploadPic(uploadFile);
		//将结果序列化为json
		String result1=JsonUtils.objectToJson(result);
		return result1;
	}
}
