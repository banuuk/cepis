/*
 * Copyright (C) 2005 Erik Swenson - erik@oreports.com
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 */

package org.efs.openreports.objects;

import java.io.Serializable;

/**
 * @author  keerthi
 */
public class ORProperty implements Serializable
{	
	public static final String DATE_FORMAT = "date.format";
	public static final String BASE_DIRECTORY = "base.directory";
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_AUTH_USER = "mail.auth.user";
	public static final String MAIL_AUTH_PASSWORD = "mail.auth.password";		
	public static final String TEMP_DIRECTORY = "temp.directory";
	public static final String QUERYREPORT_MAXROWS = "queryreport.maxrows";	
	public static final String REPORT_GENERATION_DIRECTORY = "report.generation.directory";
    public static final String XMLA_URL = "xmla.uri";
    public static final String XMLA_DATASOURCE = "xmla.datasource";
    public static final String XMLA_CATALOG = "xmla.catalog";
	
	private static final long serialVersionUID = 806285455871073093L;
	
	/**
	 * @uml.property  name="id"
	 */
	private Integer id;
	/**
	 * @uml.property  name="key"
	 */
	private String key;
	/**
	 * @uml.property  name="value"
	 */
	private String value;

	public ORProperty()
	{
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property  name="key"
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 * @uml.property  name="key"
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * @return
	 * @uml.property  name="value"
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 * @uml.property  name="value"
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

}