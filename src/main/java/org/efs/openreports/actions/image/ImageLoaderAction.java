/*
 * Copyright (C) 2003 Erik Swenson - erik@oreports.com
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

package org.efs.openreports.actions.image;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;

/**
 * This action is used to return images for HTML pages generated by the JasperReports HTML export process.  Each image generated by the export process is placed in the  session scoped IMAGES_MAP. The generated HTML page calls this  action to retreive the image from the map. Another possible solution is to output images generated by the export to a directory and have the HTML page refer to the directory. This could cause a problem with multiple users because the image names generated are not unique. Both solutions are not ideal and are the result of the JasperReports HTML export process. Rewriting the export to only generate dynamic images and not images already available as files would probably speed  up the process but is not possible with the current api.
 */

public class ImageLoaderAction extends ActionSupport
{	
	private static final long serialVersionUID = -3666965473175085098L;

	protected static Logger log = Logger.getLogger(ImageLoaderAction.class);

	/**
	 * @uml.property  name="imageName"
	 */
	private String imageName;

	public String execute()
	{
		Map imagesMap = (Map) ActionContext.getContext().getSession().get("IMAGES_MAP");

		if (imagesMap != null)
		{
			if (imageName != null)
			{
				byte[] imageData = (byte[]) imagesMap.get(imageName);

				HttpServletResponse response =
					ServletActionContext.getResponse();

				try
				{
					response.setContentLength(imageData.length);
					ServletOutputStream ouputStream = response.getOutputStream();
					ouputStream.write(imageData, 0, imageData.length);
					ouputStream.flush();
					ouputStream.close();
				}
				catch(IOException ioe)
				{
					log.warn(ioe.toString());
				}
			}
		}

		return NONE;
	}

	/**
	 * @return
	 * @uml.property  name="imageName"
	 */
	public String getImageName()
	{
		return imageName;
	}

	/**
	 * @param imageName
	 * @uml.property  name="imageName"
	 */
	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}

}