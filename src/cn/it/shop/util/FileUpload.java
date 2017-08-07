package cn.it.shop.util;

import cn.it.shop.model.FileImage;

public interface FileUpload {

	String uploadFile(FileImage fileImage);
	
	String[] getBankImage();

}