package com.huzhiyi.housereadily.action;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;

import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ResponseUtils;
import com.tastysoft.swct.util.DateHelper;

/**
 * @ClassName: FileUploadServlet
 * @Description: 文件上传
 *               <p>
 * @author willter
 * @date 2012-11-1
 */
public class FileUploadServlet extends HttpServlet {

	/**
	 * @Fields serialVersionUID : 描述变量
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public FileUploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: doPost
	 * @Description: TODO(上传附件，返回格式：) { "status": 1, "msg":
	 *               "2_100620151445_5.jpg,/upload/user/img/1352170110972.jpg,7995"
	 *               }
	 *               <p>
	 * @author willter
	 * @date 2012-11-6
	 *       <p>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constants.UTF8);

		String type = request.getParameter("type"); // 图片类型
		String rootPath = Configuration.WEB_ROOT_PATH; // 图片存储绝对路径

		final long MAX_SIZE = 3 * 1024 * 1024;// 设置上传文件最大为 3M
		// 允许上传的文件格式的列表
		final String[] allowedExt = new String[] { "jpg", "jpeg", "gif", "png", "bmp" };
		// final String[] allowedExt = new String[] { "jpg", "jpeg", "gif",
		// "png", "bmp", "txt", "doc", "docx", "mp3", "wma", "m4a" };

		// 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(4096);// 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
		dfif.setRepository(new File(rootPath + "uploadTemp"));// 设置存放临时文件的目录,web根目录下的uploadTemp目录

		// 用以上工厂实例化上传组件
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		// 设置最大上传尺寸
		sfu.setSizeMax(MAX_SIZE);

		// 从request得到 所有 上传域的列表
		List fileList = null;
		try {
			fileList = sfu.parseRequest(request);
		} catch (FileUploadException e) {// 处理文件尺寸过大异常
			if (e instanceof SizeLimitExceededException) {
				render(response, type, 0, "文件超过规定大小:" + MAX_SIZE + "字节");
				return;
			}
			e.printStackTrace();
		}
		// 没有文件上传
		if (fileList == null || fileList.size() == 0) {
			render(response, type, 0, "请选择上传文件");
			return;
		}
		// 返回消息
		StringBuffer msg = new StringBuffer();
		// 得到所有上传的文件
		Iterator fileItr = fileList.iterator();
		// 循环处理所有文件
		while (fileItr.hasNext()) {
			FileItem fileItem = null;
			String path = null;
			long size = 0;
			// 得到当前文件
			fileItem = (FileItem) fileItr.next();
			// 忽略简单form字段而不是上传域的文件域(<input type="text" />等)
			if (fileItem == null || fileItem.isFormField()) {
				continue;
			}
			// 得到文件的完整路径
			path = fileItem.getName();
			// 得到文件的大小
			size = fileItem.getSize();
			if ("".equals(path) || size == 0) {
				continue;
			}

			// 得到去除路径的文件名
			String t_name = path.substring(path.lastIndexOf("\\") + 1);
			// 得到文件的扩展名(无扩展名时将得到全名)
			String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);
			// 拒绝接受规定文件格式之外的文件类型
			int allowFlag = 0;
			int allowedExtCount = allowedExt.length;
			for (; allowFlag < allowedExtCount; allowFlag++) {
				if (allowedExt[allowFlag].equals(t_ext))
					break;
			}
			if (allowFlag == allowedExtCount) {
				msg = new StringBuffer();
				msg.append("请上传以下类型的文件：");
				for (allowFlag = 0; allowFlag < allowedExtCount; allowFlag++)
					msg.append("*.").append(allowedExt[allowFlag]).append(",");
				msg.deleteCharAt(msg.lastIndexOf(","));
				render(response, type, 0, msg.toString());
				return;
			}

			long now = System.currentTimeMillis();
			// 根据系统时间生成上传后保存的文件名
			String prefix = DateHelper.dateToString(new Date(), "hhmmss") + String.valueOf(now);
			// 保存的最终文件完整路径,保存在web根目录下的upload目录下
			String u_dir = getDir(type);

			String u_file = prefix + "." + t_ext;
			String u_name = rootPath + u_dir + u_file;

			String u_s_file = prefix + "_s." + t_ext; // 固定大小的图片名称
			String u_s_name = rootPath + u_dir + u_s_file; // 固定大小的图片路径

			String u_m_file = prefix + "_m." + t_ext; // 按比例缩放大小的图片名称
			String u_m_name = rootPath + u_dir + u_m_file; // 按比例缩放大小的图片路径

			File dir = new File(rootPath + u_dir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			try {
				// 保存文件
				File fileName = new File(u_name);
				fileItem.write(fileName);
				
				if ("user".equals(type)) {
					msg.append(t_name).append(",");
					msg.append("/").append(u_dir).append(u_file).append(","); // 原图片路径
					msg.append(size);
					render(response, type, 1, msg.toString());
					return;
				}

				Image srcImg = ImageIO.read(fileName);
				Integer s_width = srcImg.getWidth(null);
				Integer s_height = srcImg.getHeight(null);

				/**************** 生成固定大小的图片 ************************/
//				BufferedImage buffImg = null;
//				buffImg = new BufferedImage(192, s_width / 192 * s_height, BufferedImage.TYPE_INT_RGB);
//				buffImg.getGraphics().drawImage(srcImg.getScaledInstance(192, 100, Image.SCALE_SMOOTH), 0, 0, null);
//				ImageIO.write(buffImg, t_ext, new File(u_s_name));
				renderPic(srcImg, s_width, s_height, 190, 190, t_ext, u_s_name);

				/**************** 生成按比例缩放大小的图片 ************************/
				renderPic(srcImg, s_width, s_height, 350, 350, t_ext, u_m_name);

				// 输入json格式返回值
				msg.append(t_name).append(",");
				msg.append("/").append(u_dir).append(u_file).append(","); // 原图片路径
				msg.append("/").append(u_dir).append(u_s_file).append(","); // 固定大小的图片路径
				msg.append("/").append(u_dir).append(u_m_file).append(","); // 按比例缩放大小的图片路径
				msg.append(size).append(";");
			} catch (Exception e) {
				render(response, type, 0, "图片上传失败");
				break;
			}
		}
		msg.deleteCharAt(msg.lastIndexOf(";"));
		render(response, type, 1, msg.toString());
	}

	/**
	 * @Title: getDir
	 * @Description: 根据请求类型获取上传路径
	 *               <p>
	 * @author willter
	 * @date 2012-11-5
	 *       <p>
	 * @param type
	 * @return
	 */
	private String getDir(String type) {
		Date now = new Date();
		String dir = DateHelper.dateToString(now, "yyyyMM") + "/" + DateHelper.dateToString(now, "dd") + "/";
		if ("user".equals(type)) {
			return "upload/user/img/";
		} else if ("bt".equals(type) || "sn".equals(type) || "fx".equals(type) || "xq".equals(type)) {
			return "upload/credit_pics/" + dir;
		} else {
			return null;
		}
//		if ("bt".equals(type)) {
//			return "upload/bt_pics/" + dir;
//		} else if ("sn".equals(type)) {
//			return "upload/sn_pics/" + dir;
//		} else if ("fx".equals(type)) {
//			return "upload/fx_pics/" + dir;
//		} else if ("xq".equals(type)) {
//			return "upload/xq_pics/" + dir;
//		} else if ("user".equals(type)) {
//			return "upload/user/img/";
//		} else {
//			return "upload/credit_pics/" + dir;
//		}
	}

	private void render(HttpServletResponse response, String type, Integer status, String msg) throws IOException {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("type", type);
			jsonObject.put("status", status);
			jsonObject.put("msg", new String(msg.getBytes("ISO-8859-1"), "utf-8"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		ResponseUtils.renderJson(response, jsonObject.toString());
	}

	private float getRatio(int width, int height, int maxWidth, int maxHeight) {
		float ratio = 1.0f;
		float widthRatio;
		float heightRatio;
		widthRatio = (float) maxWidth / width;
		heightRatio = (float) maxHeight / height;
		if (widthRatio < 1.0 || heightRatio < 1.0) {
			ratio = widthRatio <= heightRatio ? widthRatio : heightRatio;
		}
		return ratio;
	}
	
	private void renderPic(Image srcImg, Integer s_width, Integer s_height, Integer maxWidth, Integer maxHeight, String t_ext, String name) throws IOException {
		float scale = getRatio(s_width, s_height, maxWidth, maxHeight);
		Integer width = (int) (s_width * scale);
		Integer height = (int) (s_height * scale);
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		buffImg.getGraphics().drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		ImageIO.write(buffImg, t_ext, new File(name));
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
