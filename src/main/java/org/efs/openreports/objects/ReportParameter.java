/*
 * Copyright (C) 2002 Erik Swenson - erik@oreports.com
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
public class ReportParameter implements Serializable
{
	private static final long serialVersionUID = 667082979233371385l;

	public static String[] TYPES =
		new String[] { "Date", "List", "Query", "Text", "SubReport","Boolean" };

	private static final String STRING = "java.lang.String";
	private static final String DOUBLE = "java.lang.Double";
	private static final String INTEGER = "java.lang.Integer";
	private static final String LONG = "java.lang.Long";
	private static final String BIGDECIMAL = "java.math.BigDecimal";
	private static final String DATE = "java.util.Date";
	private static final String SQL_DATE = "java.sql.Date";
	private static final String TIMESTAMP = "java.sql.Timestamp";	
	private static final String BOOLEAN = "java.lang.Boolean";
	
	public static String[] CLASS_NAMES =
		new String[] {
			STRING,
			DOUBLE,
			INTEGER,
			LONG,
			BIGDECIMAL,
			DATE,
			SQL_DATE,
			TIMESTAMP,
			BOOLEAN};

	public static final String QUERY_PARAM = "Query";
	public static final String LIST_PARAM = "List";
	public static final String TEXT_PARAM = "Text";
	public static final String DATE_PARAM = "Date";
	public static final String SUBREPORT_PARAM = "SubReport";
	public static final String BOOLEAN_PARAM = "Boolean";
	
	/**
	 * @uml.property  name="id"
	 */
	private Integer id;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="type"
	 */
	private String type;
	/**
	 * @uml.property  name="className"
	 */
	private String className;
	/**
	 * @uml.property  name="dataSource"
	 * @uml.associationEnd  
	 */
	private ReportDataSource dataSource;
	/**
	 * @uml.property  name="data"
	 */
	private String data;
	/**
	 * @uml.property  name="values"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private ReportParameterValue[] values;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	/**
	 * @uml.property  name="required"
	 */
	private boolean required;
	/**
	 * @uml.property  name="multipleSelect"
	 */
	private boolean multipleSelect;
	/**
	 * @uml.property  name="defaultValue"
	 */
	private String defaultValue;

	/**
	 * @return
	 * @uml.property  name="dataSource"
	 */
	public ReportDataSource getDataSource()
	{
		return dataSource;
	}

	/**
	 * @param dataSource
	 * @uml.property  name="dataSource"
	 */
	public void setDataSource(ReportDataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public ReportParameter()
	{
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return
	 * @uml.property  name="type"
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @return
	 * @uml.property  name="className"
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * @return
	 * @uml.property  name="data"
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * @return
	 * @uml.property  name="values"
	 */
	public ReportParameterValue[] getValues()
	{
		return values;
	}

	/**
	 * @param values
	 * @uml.property  name="values"
	 */
	public void setValues(ReportParameterValue[] values)
	{
		this.values = values;
	}

	/**
	 * @param className
	 * @uml.property  name="className"
	 */
	public void setClassName(String className)
	{
		this.className = className;
	}

	/**
	 * @param data
	 * @uml.property  name="data"
	 */
	public void setData(String data)
	{
		this.data = data;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param type
	 * @uml.property  name="type"
	 */
	public void setType(String type)
	{
		this.type = type;
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
	 * @uml.property  name="description"
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 * @uml.property  name="description"
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return
	 * @uml.property  name="required"
	 */
	public boolean isRequired()
	{
		return required;
	}

	/**
	 * @param required
	 * @uml.property  name="required"
	 */
	public void setRequired(boolean required)
	{
		this.required = required;
	}	
	
	/**
	 * @return
	 * @uml.property  name="multipleSelect"
	 */
	public boolean isMultipleSelect()
	{
		return multipleSelect;
	}

	/**
	 * @param multiple
	 * @uml.property  name="multipleSelect"
	 */
	public void setMultipleSelect(boolean multiple)
	{
		this.multipleSelect = multiple;
	}

	/**
	 * @return
	 * @uml.property  name="defaultValue"
	 */
	public String getDefaultValue() 
	{
		return defaultValue;
	}

	/**
	 * @param defaultValue
	 * @uml.property  name="defaultValue"
	 */
	public void setDefaultValue(String defaultValue) 
	{
		this.defaultValue = defaultValue;
	}

}