package org.eu.slice.util.web;

import org.springframework.context.ApplicationContext;

public class ContextUtility 
{
	public static ApplicationContext ctx;

    public static String contextPath = "pcs9000";

    public static String webAppPath = "";

    public static String webINFPath = "";

    public static Object getBean(Class<?> clazz)
	{
		return ctx.getBean(clazz);
	}
	
	public static Object getBean(String beanName)
	{
		return ctx.getBean(beanName);
	}

    public static void setWebAppPath(String webAppPath) {
        ContextUtility.webAppPath = webAppPath;
    }

    public static void setWEBINFPath(String webINFPath) {
        ContextUtility.webINFPath = webINFPath;
    }
}
