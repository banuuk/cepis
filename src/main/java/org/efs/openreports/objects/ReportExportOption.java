/*
 * Copyright (C) 2006 Erik Swenson - erik@oreports.com
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
public class ReportExportOption implements Serializable
{	
	private static final long serialVersionUID = -8911923598920065987L;
	
	/**
	 * @uml.property  name="id"
	 */
	private Integer id;
	
	/**
	 * @uml.property  name="xlsRemoveEmptySpaceBetweenRows"
	 */
	private boolean xlsRemoveEmptySpaceBetweenRows;
	/**
	 * @uml.property  name="xlsOnePagePerSheet"
	 */
	private boolean xlsOnePagePerSheet;	
	/**
	 * @uml.property  name="xlsAutoDetectCellType"
	 */
	private boolean xlsAutoDetectCellType;
	/**
	 * @uml.property  name="xlsWhitePageBackground"
	 */
	private boolean xlsWhitePageBackground;	
	 
	/**
	 * @uml.property  name="htmlRemoveEmptySpaceBetweenRows"
	 */
	private boolean htmlRemoveEmptySpaceBetweenRows;	
	/**
	 * @uml.property  name="htmlWhitePageBackground"
	 */
	private boolean htmlWhitePageBackground;
	/**
	 * @uml.property  name="htmlUsingImagesToAlign"
	 */
	private boolean htmlUsingImagesToAlign;
	/**
	 * @uml.property  name="htmlWrapBreakWord"
	 */
	private boolean htmlWrapBreakWord; 
 	
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
	 * @uml.property  name="htmlRemoveEmptySpaceBetweenRows"
	 */
	public boolean isHtmlRemoveEmptySpaceBetweenRows()
	{
		return htmlRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @param htmlRemoveEmptySpaceBetweenRows
	 * @uml.property  name="htmlRemoveEmptySpaceBetweenRows"
	 */
	public void setHtmlRemoveEmptySpaceBetweenRows(boolean htmlRemoveEmptySpaceBetweenRows)
	{
		this.htmlRemoveEmptySpaceBetweenRows = htmlRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @return
	 * @uml.property  name="xlsRemoveEmptySpaceBetweenRows"
	 */
	public boolean isXlsRemoveEmptySpaceBetweenRows()
	{
		return xlsRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @param xlsRemoveEmptySpaceBetweenRows
	 * @uml.property  name="xlsRemoveEmptySpaceBetweenRows"
	 */
	public void setXlsRemoveEmptySpaceBetweenRows(boolean xlsRemoveEmptySpaceBetweenRows)
	{
		this.xlsRemoveEmptySpaceBetweenRows = xlsRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @return
	 * @uml.property  name="xlsOnePagePerSheet"
	 */
	public boolean isXlsOnePagePerSheet()
	{
		return xlsOnePagePerSheet;
	}

	/**
	 * @param xlsOnePagePerSheet
	 * @uml.property  name="xlsOnePagePerSheet"
	 */
	public void setXlsOnePagePerSheet(boolean xlsOnePagePerSheet)
	{
		this.xlsOnePagePerSheet = xlsOnePagePerSheet;
	}

	/**
	 * @return
	 * @uml.property  name="htmlUsingImagesToAlign"
	 */
	public boolean isHtmlUsingImagesToAlign()
	{
		return htmlUsingImagesToAlign;
	}

	/**
	 * @param htmlUsingImagesToAlign
	 * @uml.property  name="htmlUsingImagesToAlign"
	 */
	public void setHtmlUsingImagesToAlign(boolean htmlUsingImagesToAlign)
	{
		this.htmlUsingImagesToAlign = htmlUsingImagesToAlign;
	}

	/**
	 * @return
	 * @uml.property  name="htmlWhitePageBackground"
	 */
	public boolean isHtmlWhitePageBackground()
	{
		return htmlWhitePageBackground;
	}

	/**
	 * @param htmlWhitePageBackground
	 * @uml.property  name="htmlWhitePageBackground"
	 */
	public void setHtmlWhitePageBackground(boolean htmlWhitePageBackground)
	{
		this.htmlWhitePageBackground = htmlWhitePageBackground;
	}

	/**
	 * @return
	 * @uml.property  name="htmlWrapBreakWord"
	 */
	public boolean isHtmlWrapBreakWord()
	{
		return htmlWrapBreakWord;
	}

	/**
	 * @param htmlWrapBreakWord
	 * @uml.property  name="htmlWrapBreakWord"
	 */
	public void setHtmlWrapBreakWord(boolean htmlWrapBreakWord)
	{
		this.htmlWrapBreakWord = htmlWrapBreakWord;
	}

	/**
	 * @return
	 * @uml.property  name="xlsAutoDetectCellType"
	 */
	public boolean isXlsAutoDetectCellType()
	{
		return xlsAutoDetectCellType;
	}

	/**
	 * @param xlsAutoDetectCellType
	 * @uml.property  name="xlsAutoDetectCellType"
	 */
	public void setXlsAutoDetectCellType(boolean xlsAutoDetectCellType)
	{
		this.xlsAutoDetectCellType = xlsAutoDetectCellType;
	}

	/**
	 * @return
	 * @uml.property  name="xlsWhitePageBackground"
	 */
	public boolean isXlsWhitePageBackground()
	{
		return xlsWhitePageBackground;
	}

	/**
	 * @param xlsWhitePageBackground
	 * @uml.property  name="xlsWhitePageBackground"
	 */
	public void setXlsWhitePageBackground(boolean xlsWhitePageBackground)
	{
		this.xlsWhitePageBackground = xlsWhitePageBackground;
	}
}