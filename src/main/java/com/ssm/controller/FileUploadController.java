package com.ssm.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.FileDomain;

@Controller
public class FileUploadController {
	 //得到一个用来记录日志的对象，这样在打印信息时能够标记打印的是哪个类的信息
	private static final Log logger=LogFactory.getLog(FileUploadController.class);
	/**
	 * 动态实现文件上传
	 */
	@RequestMapping("/upload")
	public String uploadFile(@ModelAttribute FileDomain fileDomain, HttpServletRequest request) {
		/*文件上传到服务器的位置“/upload”，该位置是指worksapce\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps,发布后使用*/
		String realpath=request.getServletContext().getRealPath("upload");
		String fileName=fileDomain.getMyfile().getOriginalFilename();
		File targetFile=new File(realpath,fileName);
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
		//上传
		try {
			fileDomain.getMyfile().transferTo(targetFile);
			logger.info("成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
