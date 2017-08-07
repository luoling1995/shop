package cn.it.shop.model;

import java.io.File;

public class FileImage {
	private File file;
	private String contentType;
	private String filename;

	public File getFile() {
		return file;
	}

	public void setUpload(File file) {
		this.file = file;
	}

	public String getContentType() {
		return contentType;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

}
