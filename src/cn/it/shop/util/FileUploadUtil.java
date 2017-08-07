package cn.it.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.it.shop.model.FileImage;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	@Value("#{prop.basePath + prop.filePath}")
	private String filePath;
	@Value("#{prop.basePath + prop.bankPath}")
	private String bankPath;
	
	
	public void setFilePath(String filePath) {
		System.out.println(filePath);
		this.filePath = filePath;
	}
	
	//1.取得文件的后缀名
	private String getFileExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	
	//2.根据UUID重新生成文件名
	private String newFileName(String fileName){
		return UUID.randomUUID() + "." + getFileExt(fileName);
	}
	
	/* (non-Javadoc)
	 * @see cn.it.shop.util.FileUpload#uploadFile(cn.it.shop.model.FileImage)
	 */
	//3.上传文件
	@Override
	public String uploadFile(FileImage fileImage){
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			fileImage.getFile().delete();
		}
	}

	@Override
	public String[] getBankImage() {
		return new File(bankPath).list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".gif");
			}
		});
	}
}
