/**
* Licensed under the Artistic License; you may not use this file
* except in compliance with the License.
* You may obtain a copy of the License at
*
* http://displaytag.sourceforge.net/license.html
*
* THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR
* IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED
* WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
*/
package edu.uky.cepis.util.global;

import java.util.Iterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.views.jsp.TagUtils;
import org.displaytag.Messages;
import org.displaytag.localization.I18nResourceProvider;
import org.displaytag.localization.LocaleResolver;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.LocaleProvider;
import com.opensymphony.xwork2.TextProvider;
import com.opensymphony.xwork2.util.ValueStack;

/**
* Struts2 implementation of a resource provider and locale resolver.
* @author Richard HALLIER
* @author Fabrizio Giustina
* @author Nicolas Richeton - Fix for Struts 2.1.6
* @version $Revision: 1081 $ ($Author: fgiust $)
* @link http://blog.richeton.com/2009/08/12/displaytag-struts-2-localization/
*/
public class I18nStruts2Adapter implements LocaleResolver, I18nResourceProvider
{

/**
* prefix/suffix for missing entries.
*/
public static final String UNDEFINED_KEY = "???"; //$NON-NLS-1$

/**
* logger.
*/
private static Log log = LogFactory.getLog(I18nStruts2Adapter.class);

/**
* @see LocaleResolver#resolveLocale(HttpServletRequest)
*/
public Locale resolveLocale(HttpServletRequest request)
{

Locale result = null;
ValueStack stack = ActionContext.getContext().getValueStack();

Iterator iterator = stack.getRoot().iterator();
while (iterator.hasNext())
{
Object o = iterator.next();

if (o instanceof LocaleProvider)
{
LocaleProvider lp = (LocaleProvider) o;
result = lp.getLocale();

break;
}
}

if (result == null)
{
log.debug("Missing LocalProvider actions, init locale to default");
result = Locale.getDefault();
}

return result;
}

/**
* @see I18nResourceProvider#getResource(String, String, Tag, PageContext)
*/
public String getResource(String resourceKey, String defaultValue, Tag tag, PageContext pageContext)
{

// if resourceKey isn't defined either, use defaultValue
String key = (resourceKey != null) ? resourceKey : defaultValue;

String message = null;
ValueStack stack = TagUtils.getStack(pageContext);
Iterator iterator = stack.getRoot().iterator();

while (iterator.hasNext())
{
Object o = iterator.next();

if (o instanceof TextProvider)
{
TextProvider tp = (TextProvider) o;
message = tp.getText(key);

break;
}
}

// if user explicitely added a titleKey we guess this is an error
if (message == null && resourceKey != null)
{
log.debug(Messages.getString("Localization.missingkey", resourceKey)); //$NON-NLS-1$
message = UNDEFINED_KEY + resourceKey + UNDEFINED_KEY;
}

return message;
}

}