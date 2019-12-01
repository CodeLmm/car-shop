package cn.jzdy.util;





import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author Lujingdong
 *
 */
public class FileUploadUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtils.class);
	public static String upload(MultipartFile file) {
		if(file!=null) {
			try {
				if (file.isEmpty()) {
					return null;
				}
				// 获取文件名
				String fileName = file.getOriginalFilename();
				LOGGER.info("上传的文件名为：" + fileName);
				// 获取文件的后缀名
				String suffixName = fileName.substring(fileName.lastIndexOf("."));
				LOGGER.info("文件的后缀名为：" + suffixName);
				// 设置文件存储路径
				String filePath = ResourceUtils.getURL("classpath:").getPath()+"static/image/";
				String path = filePath + fileName;
				
				File dest = new File(path);
				// 检测是否存在目录
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();// 新建文件夹
				}
				file.transferTo(dest);// 文件写入
				return path;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}else {
			return null;
		}
		
	}
}
