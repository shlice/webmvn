package org.eu.slice.util.lang;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author shild 2014年4月30日
 */
public class StringBnd
{
	private static final Logger logger = LoggerFactory.getLogger(StringBnd.class);
	
	/**
	 * The ResourceBundle for this StringMgr.
	 */
	private final ResourceBundle bundle;
	private final Locale locale;

	/**
	 * 根据package和locale构造StringMgr。
	 *
	 * @param packageName Package name
	 */
	StringBnd(String packageName, Locale locale) {
		String bundleName = packageName + ".LocalStrings";
		ResourceBundle bnd = null;
		try{
			bnd = ResourceBundle.getBundle(bundleName, locale);
		}catch(MissingResourceException ex){
			// Try from the current loader (that's the case for trusted apps)
			// Should only be required if using a TC5 style classloader
			// structure
			// where common != shared != server
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			if(cl != null){
				try{
					bnd = ResourceBundle.getBundle(bundleName, locale, cl);
				}catch(MissingResourceException ex2){
					logger.warn("lang of " + locale + " missing!");
				}
			}
		}
		bundle = bnd;
		// Get the actual locale, which may be different from the requested one
		if(bundle != null){
			Locale bundleLocale = bundle.getLocale();
			if(bundleLocale.equals(Locale.ROOT)){
				this.locale = Locale.ENGLISH;
			}
			else{
				this.locale = bundleLocale;
			}
		}
		else{
			this.locale = null;
		}
	}

	/**
	 * 返回关联的locale
	 * @return Locale
	 */
	public Locale getLocale()
	{
		return locale;
	}

	/**
	Get a string from the underlying resource bundle or return
	null if the String is not found.

	@param key to desired resource String
	@return resource String matching <i>key</i> from underlying
	        bundle or null if not found.
	@throws IllegalArgumentException if <i>key</i> is null.
	*/
	public String getString(String key)
	{
		if(key == null){
			String msg = "key may not have a null value";

			throw new IllegalArgumentException(msg);
		}

		String str = null;
		try{
			if(bundle != null){
				str = bundle.getString(key);
			}
		}catch(MissingResourceException mre){
			str = null;
		}

		return str;
	}
	
	 /**
     * Get a string from the underlying resource bundle and format
     * it with the given set of arguments.
     *
     * @param key
     * @param args
     */
    public String getString(final String key, final Object... args) {
        String value = getString(key);
        if (value == null) {
            value = key;
        }

        MessageFormat mf = new MessageFormat(value);
        mf.setLocale(locale);
        return mf.format(args, new StringBuffer(), null).toString();
    }
}
