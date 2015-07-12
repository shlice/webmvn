package org.eu.slice.util.lang;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 国际化语言类。<br>
 * 通过静态方法getManager获取StringMgr对象；<br>
 * 调用getLocalString或getString方法获取国际化字符串。
 * 
 * @author shild 2014年4月30日
 */
public class StringMgr
{
	private final static int LOCALE_CACHE_SIZE = 5;
	
	private final String packageName;

	private StringMgr(String packageName)
	{
		this.packageName = packageName;
	}
	
	/**
	 * 根据key返回服务端语言的国际化字符串。
	 * 
	 * @param key
	 */
    public String getLocalString(final String key) {
        StringBnd bundle = getBundle();
        String str = bundle.getString(key);
        
        if(str == null)
        	str = key;
        
        return str;
    }

    /**
     * 根据key返回服务端语言的国际化字符串，并按照参数进行格式化。
     *
     * @param key
     * @param args 格式化参数
     */
    public String getLocalString(final String key, final Object... args) {
    	StringBnd bundle = getBundle();
        return bundle.getString(key, args);
    }
    
    /**
	 * 根据key返回国际化字符串。
	 * <p>
	 * 在Web应用中，国际化采用的语言如下判断：<br>
	 * 首先判断客户端request的lang参数；<br>
	 * 如果不存在则判断cookie中的lang参数；<br>
	 * 如果还不存在则判断session中的lang参数；<br>
	 * 如果上述均不存在，则取服务端的语言。
	 * 
	 * @param key
	 */
    public String getString(String key) {
    	Locale locale = threadLocale.get();
    	
    	StringBnd bundle = getBundle(locale);
        String str = bundle.getString(key);
        
        if(str == null)
        	str = key;
        
        return str;
    }
    
    /**
     * 根据key返回国际化字符串，并按照参数进行格式化。
     * <p>
	 * 在Web应用中，国际化采用的语言如下判断：<br>
	 * 首先判断客户端request的lang参数；<br>
	 * 如果不存在则判断cookie中的lang参数；<br>
	 * 如果还不存在则判断session中的lang参数；<br>
	 * 如果上述均不存在，则取服务端的语言。
     *
     * @param key
     * @param args 格式化参数
     */
    public String getString(final String key, final Object... args) {
    	Locale locale = threadLocale.get();
    	
    	StringBnd bundle = getBundle(locale);
        return bundle.getString(key, args);
    }

    // --------------------------------------------------------------
    // STATIC SUPPORT METHODS
    // --------------------------------------------------------------

    private static final Map<String, StringMgr> managers =
            new Hashtable<String, StringMgr>();
    
    private static final Map<String, Map<Locale,StringBnd>> bundles =
        new Hashtable<String, Map<Locale,StringBnd>>();

	static final ThreadLocal<Locale> threadLocale = new ThreadLocal<Locale>();
    
    /**
     * 根据指定的packageName返回StringMgr。<br>
     * 翻译文件放置在packageName对应的包目录下。<br>
     * 翻译文件命名格式如下：<br>
     * &nbsp;&nbsp;LocalString.properties  默认中文语言<br>
     * &nbsp;&nbsp;LocalString_en.properties  英文语言<br>
     * &nbsp;&nbsp;LocalString_xx.properties 其他区域语言
     * 
     */
    public final static synchronized StringMgr getManager(String packageName)
    {
    	StringMgr strmgr = managers.get(packageName);
    	
    	if(strmgr == null)
    	{
    		strmgr = new StringMgr(packageName);
    		managers.put(packageName, strmgr);
    	}
    	
    	return strmgr;
    }
    
    /**
     * 返回默认Locale对应的StringBnd。
     *
     */
    protected final synchronized StringBnd getBundle()
    {
        return getBundle(Locale.getDefault());
    }

    /**
     * 根据指定的locale返回StringBnd。
     *
     * @param locale      The Locale
     */
    protected final synchronized StringBnd getBundle(Locale locale)
    {
    	if(locale == null)
        	locale = Locale.getDefault();
    	
        Map<Locale,StringBnd> map = bundles.get(packageName);
        if (map == null) {
            map = new LinkedHashMap<Locale,StringBnd>(LOCALE_CACHE_SIZE, 1, true) {
                private static final long serialVersionUID = 1L;
                @Override
                protected boolean removeEldestEntry(
                        Map.Entry<Locale,StringBnd> eldest) {
                    if (size() > (LOCALE_CACHE_SIZE - 1)) {
                        return true;
                    }
                    return false;
                }
            };
            bundles.put(packageName, map);
        }

        StringBnd bnd = map.get(locale);
        if (bnd == null) {
        	bnd = new StringBnd(packageName, locale);
            map.put(locale, bnd);
        }
        return bnd;
    }

    /**
     * 返回locales列表中匹配的第一个StringBnd。
     *
     * @param requestedLocales locale列表
     *
     * @return 匹配到的StringBnd或者默认的StringBnd
     */
    protected StringBnd getBundle(Enumeration<Locale> requestedLocales) {
        while (requestedLocales.hasMoreElements()) {
            Locale locale = requestedLocales.nextElement();
            StringBnd result = getBundle(locale);
            if (result.getLocale().equals(locale)) {
                return result;
            }
        }
        // Return the default
        return getBundle();
    }
}