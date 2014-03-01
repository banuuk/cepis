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

package org.efs.openreports.actions.admin;


import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.*;
import org.efs.openreports.providers.*;
import org.efs.openreports.util.ORUtil;

/**
 * @author  keerthi
 */
public class EditReportParameterAction extends ActionSupport 
{	
	private static final long serialVersionUID = 5156762771044903756L;

	protected static Logger log = Logger.getLogger(EditReportParameterAction.class);

	/**
	 * @uml.property  name="command"
	 */
	private String command;

	private boolean submitOk;
	private boolean submitValidate;
	private boolean submitDuplicate;

	/**
	 * @uml.property  name="id"
	 */
	private int id;
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
	 * @uml.property  name="data"
	 */
	private String data;
	/**
	 * @uml.property  name="dataSourceId"
	 */
	private int dataSourceId = Integer.MIN_VALUE;
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
	 * @uml.property  name="reportParameter"
	 * @uml.associationEnd  
	 */
	private ReportParameter reportParameter;
	/**
	 * @uml.property  name="queryParameter"
	 * @uml.associationEnd  
	 */
	private ReportParameter queryParameter;

	/**
	 * @uml.property  name="parameterValues"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private ReportParameterValue[] parameterValues;

	/**
	 * @uml.property  name="dataSourceProvider"
	 * @uml.associationEnd  
	 */
	private DataSourceProvider dataSourceProvider;
	/**
	 * @uml.property  name="parameterProvider"
	 * @uml.associationEnd  
	 */
	private ParameterProvider parameterProvider;

	@Override
	public String execute()
	{
		try
		{
			if (command.equals("edit"))
			{
				reportParameter =
					parameterProvider.getReportParameter(new Integer(id));
			}
			else
			{
				reportParameter = new ReportParameter();
			}

			if (command.equals("edit") && !submitOk && !submitValidate && !submitDuplicate)
			{
				name = reportParameter.getName();
				type = reportParameter.getType();
				className = reportParameter.getClassName();
				data = reportParameter.getData();
				id = reportParameter.getId().intValue();
				if (reportParameter.getDataSource() != null)
				{
					dataSourceId =
						reportParameter.getDataSource().getId().intValue();
				}
				description = reportParameter.getDescription();
				required = reportParameter.isRequired();
				multipleSelect = reportParameter.isMultipleSelect();
				defaultValue = reportParameter.getDefaultValue();
			}

			if (!submitOk && !submitValidate && !submitDuplicate)
				return INPUT;
			
			if (submitDuplicate)
            {
            	command = "add";
            	reportParameter.setId(null);
            	
            	if (reportParameter.getName().equals(name))
            	{
            		name = "Copy of ".concat(name);
            	}
            }

			reportParameter.setName(name);
			reportParameter.setType(type);
			reportParameter.setClassName(className);
			reportParameter.setData(data);			
			reportParameter.setDescription(description);
			reportParameter.setRequired(required);
			reportParameter.setMultipleSelect(multipleSelect);
			reportParameter.setDefaultValue(defaultValue);
			
			if (dataSourceId > -1)
			{
				reportParameter.setDataSource(dataSourceProvider.getDataSource(new Integer(dataSourceId)));
			}
			else
			{
				reportParameter.setDataSource(null);
			}

			if (submitValidate)
			{
				if (type.equals(ReportParameter.LIST_PARAM)
						|| type.equals(ReportParameter.QUERY_PARAM))
				{
					Map<String,Object> map = null;

					if (type.equals(ReportParameter.QUERY_PARAM)
							&& data.toUpperCase().indexOf("$P") > -1)
					{	
						ReportUser reportUser = (ReportUser) ActionContext.getContext().getSession().get(ORStatics.REPORT_USER);						
						map = ORUtil.buildQueryParameterMap(reportUser, data, parameterProvider);						
					}

					parameterValues = parameterProvider.getParamValues(reportParameter, map);
				}

				return INPUT;
			}

			if (command.equals("edit"))
			{
				parameterProvider.updateReportParameter(reportParameter);
			}

			if (command.equals("add"))
			{
				reportParameter = parameterProvider.insertReportParameter(reportParameter);
                id = reportParameter.getId().intValue();
			}

			return SUCCESS;
		}
		catch (Exception e)
		{
			addActionError(getText(e.getMessage()));
			return INPUT;
		}
	}

	/**
	 * @return
	 * @uml.property  name="command"
	 */
	public String getCommand()
	{
		return command;
	}

	/**
	 * @param command
	 * @uml.property  name="command"
	 */
	public void setCommand(String command)
	{
		this.command = command;
	}

	public void setSubmitOk(String submitOk)
	{
		if (submitOk != null) this.submitOk = true;
	}
	
	public void setSubmitValidate(String submitValidate)
	{
		if (submitValidate != null) this.submitValidate = true;
	}
	
	public void setSubmitDuplicate(String submitDuplicate)
	{
		if (submitDuplicate != null) this.submitDuplicate = true;
	}

	/**
	 * @return
	 * @uml.property  name="dataSourceId"
	 */
	public int getDataSourceId()
	{
		return dataSourceId;
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
	 * @param dataSourceId
	 * @uml.property  name="dataSourceId"
	 */
	public void setDataSourceId(int dataSourceId)
	{
		this.dataSourceId = dataSourceId;
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
	 * @return
	 * @uml.property  name="queryParameter"
	 */
	public ReportParameter getQueryParameter()
	{
		return queryParameter;
	}
	
	public List<ReportDataSource> getDataSources()
	{
		try
		{
			return dataSourceProvider.getDataSources();
		}
		catch (Exception e)
		{
			addActionError(e.getMessage());
			return null;
		}
	}

	public String[] getTypes()
	{
		return ReportParameter.TYPES;
	}

	public String[] getClassNames()
	{
		return ReportParameter.CLASS_NAMES;
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(int id)
	{
		this.id = id;
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
	 * @uml.property  name="type"
	 */
	public String getType()
	{
		return type;
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
	 * @param type
	 * @uml.property  name="type"
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return
	 * @uml.property  name="parameterValues"
	 */
	public ReportParameterValue[] getParameterValues()
	{
		return parameterValues;
	}

	/**
	 * @param parameterValues
	 * @uml.property  name="parameterValues"
	 */
	public void setParameterValues(ReportParameterValue[] parameterValues)
	{
		this.parameterValues = parameterValues;
	}

	/**
	 * @param dataSourceProvider
	 * @uml.property  name="dataSourceProvider"
	 */
	public void setDataSourceProvider(DataSourceProvider dataSourceProvider)
	{
		this.dataSourceProvider = dataSourceProvider;
	}

	/**
	 * @param parameterProvider
	 * @uml.property  name="parameterProvider"
	 */
	public void setParameterProvider(ParameterProvider parameterProvider)
	{
		this.parameterProvider = parameterProvider;
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
	 * @param multipleSelect
	 * @uml.property  name="multipleSelect"
	 */
	public void setMultipleSelect(boolean multipleSelect)
	{
		this.multipleSelect = multipleSelect;
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