package com.yang.service;

import org.springframework.web.multipart.MultipartFile;

import com.yang.util.PictureResult;
 
public interface PictureService { 
	PictureResult uploadPic(MultipartFile picFile) ;

}
