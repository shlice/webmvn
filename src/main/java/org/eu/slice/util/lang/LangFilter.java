package org.eu.slice.util.lang;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 处理国际化语言的过滤器
 * 
 * @author shild 2014年4月30日
 */
@WebFilter(urlPatterns = {"/*"})
public class LangFilter implements Filter
{
	private static final String LangName = "lang";
	
	@Override
	public void destroy()
	{}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest)request;

		String lang = req.getParameter(LangName);
		
		if(lang == null || lang.isEmpty())
		{
			Cookie[] cookies = req.getCookies();
			if(cookies != null)
			{
				for (Cookie c:cookies)
				{
					if(c.getName().equals(LangName))
					{
						lang = c.getValue();
						break;
					}
				}
			}
		}
		
		if(lang == null || lang.isEmpty())
		{
			HttpSession session = req.getSession(false);
			if(session != null) lang = (String)session.getAttribute(LangName);
		}

		if(lang == null || lang.isEmpty())
		{
			filterChain.doFilter(request, response);
			return;
		}

		try{
			lang = lang.split("_")[0];
			Locale locale = new Locale(lang);
			StringMgr.threadLocale.set(locale);

			filterChain.doFilter(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			StringMgr.threadLocale.set(null);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{}
}
