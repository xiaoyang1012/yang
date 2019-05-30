package com.yang.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.yang.fastdfs.FastDFSClient;

import com.yang.service.PictureService;
import com.yang.util.ExceptionUtil;
import com.yang.util.PictureResult;
/**
 * 
 * @author 小仰
 *
 */
@Service
public class PictureServiceImpl implements PictureService {
	Logger logger = Logger.getLogger(PictureServiceImpl. class );
	
	@Value("${IMAGE_SERVER_BASEURL}")
	String baseurl;
	
	public PictureResult uploadPic(MultipartFile picFile) {
		PictureResult result=new PictureResult();
		// 判断图片是否为空
		if(picFile.isEmpty()){
			result.setError(1);
			result.setMessage("您好像没有选择图片欸~");  
			return result;
		}
		
		try {
			//获得初始图片名
			String originalFilename =picFile.getOriginalFilename();
			String subName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			FastDFSClient client = new FastDFSClient("classpath:/resource/client.conf");
			String url=client.uploadFile(picFile.getBytes(),subName);
			
			result.setError(0);
			result.setUrl(baseurl+url);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setError(1);
			result.setMessage("error accured while uploadPic!");  
			logger.error("error accured while uploadPic detail:"+ExceptionUtil.getStackTrace(e));
		}
		
		return result;
	}

}
