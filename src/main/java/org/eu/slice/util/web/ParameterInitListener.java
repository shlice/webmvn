package org.eu.slice.util.web;

/**
 * Created by shild on 2015/8/18.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

@WebListener
/**
 * 初始化Web应用参数
 */
public class ParameterInitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		// 设置工程webapp目录
		String webAppPath = getWebAppPath(sce);

		if (!webAppPath.endsWith("/") && !webAppPath.endsWith("\\")) {
			webAppPath += File.separator;
		}
		ContextUtility.setWebAppPath(webAppPath);

		// 设置工程WEB-INF目录
		String webinfPath = webAppPath + "WEB-INF" + File.separator;
		ContextUtility.setWEBINFPath(webinfPath);
	}

	// ServletContext销毁时调用该方法
	public void contextDestroyed(ServletContextEvent sce) {
	}

	/**
	 * 通过上下文来取工程路径
	 * 
	 * @return
	 * @throws Exception
	 */
	private String getAbsolutePathByContext(ServletContextEvent sce)
			throws Exception {
        /*
		String webAppPath = sce.getServletContext().getRealPath("/");

		webAppPath = webAppPath.replaceAll(
				"[\\\\/]WEB-INF[\\\\/]classes[\\\\/]?", "/");

		if (webAppPath.matches("^[a-zA-Z]:.*")) {
		} else {
			webAppPath = "/" + webAppPath;
		}

		webAppPath += "/";
        webAppPath = webAppPath.replaceAll("[\\\\\\/]+", "/");
        webAppPath = webAppPath.replaceAll("%20", " ");
		return webAppPath;
		*/

        return null;
	}

	/**
	 * 通过类路径来取工程路径
	 * 
	 * @return
	 */
	private String getAbsolutePathByClass(){
		String webAppPath = this.getClass().getClassLoader().getResource("/").getPath();//this.getClass().getResource("/").getPath()
        webAppPath = webAppPath.replaceAll("^/", "");
		webAppPath = webAppPath.replaceAll(
				"[\\\\/]WEB-INF[\\\\/]classes[\\\\/]", "/");

		if (!webAppPath.matches("^[a-zA-Z]:.*")) {
			webAppPath = "/" + webAppPath;
		}

		webAppPath += "/";
		webAppPath = webAppPath.replaceAll("[\\\\/]+", "/");
        webAppPath = webAppPath.replaceAll("%20", " ");

		return webAppPath;
	}

	/**
	 * 获得web应用绝对路径
	 * @param sce
	 * @return web应用路径
	 */
	private String getWebAppPath(ServletContextEvent sce){
		String webAppPath = null;
		try {
			webAppPath = getAbsolutePathByContext(sce);
		} catch (Exception e) {
		}

		if (webAppPath == null) {
			try {
				webAppPath = getAbsolutePathByClass();
			} catch (Exception e) {
			}
		}

		return webAppPath;
	}
}
