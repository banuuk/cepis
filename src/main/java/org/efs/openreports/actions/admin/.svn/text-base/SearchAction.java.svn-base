/*
 * Copyright (C) 2007 Erik Swenson - erik@oreports.com
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

import java.util.List;

import org.apache.log4j.Logger;

import org.efs.openreports.actions.DisplayTagAction;
import org.efs.openreports.objects.ORTag;
import org.efs.openreports.providers.ProviderException;
import org.efs.openreports.providers.TagProvider;

/**
 * @author  keerthi
 */
public class SearchAction extends DisplayTagAction  
{	
	private static final long serialVersionUID = 7643660200420455493L;

	protected static Logger log = Logger.getLogger(SearchAction.class);

    /**
	 * @uml.property  name="tags"
	 */
    private String tags;
    /**
	 * @uml.property  name="search"
	 */
    private String search;
	/**
	 * @uml.property  name="results"
	 */
	private List results;

	/**
	 * @uml.property  name="tagProvider"
	 * @uml.associationEnd  
	 */
	private TagProvider tagProvider;

	public String execute()
	{
		try
		{            
            tags = tagProvider.getTagList(null, ORTag.TAG_TYPE_UI);
			results = tagProvider.getTaggedObjects(new String[]{search}, null, ORTag.TAG_TYPE_UI);
        }
		catch (ProviderException pe)
		{
			addActionError(pe.getMessage());
			return ERROR;
		}

		return SUCCESS;
	}
    
    /**
	 * @return
	 * @uml.property  name="search"
	 */
    public String getSearch() 
    {
        return search;
    }
    
    /**
	 * @param search
	 * @uml.property  name="search"
	 */
    public void setSearch(String search) 
    {
        this.search = search;
    }    
    
    /**
	 * @return
	 * @uml.property  name="tags"
	 */
    public String getTags() 
    {
        return tags;
    }

    /**
	 * @return
	 * @uml.property  name="results"
	 */
    public List getResults() 
    {
        return results;
    }
    
    /**
	 * @param tagProvider
	 * @uml.property  name="tagProvider"
	 */
    public void setTagProvider(TagProvider tagProvider) 
    {
        this.tagProvider = tagProvider;
    }

}