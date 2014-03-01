/*
 * Copyright (C) 2007 Erik Swenson - erik@oreports.com
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 */

package org.efs.openreports.services.input;

/**
 * @author  keerthi
 */
public class UserInput 
{
    /**
	 * @uml.property  name="userName"
	 */
    private String userName;
    /**
	 * @uml.property  name="password"
	 */
    private String password;
    /**
	 * @uml.property  name="userToken"
	 */
    private String userToken;
    /**
	 * @uml.property  name="userGroup"
	 */
    private String userGroup;
    
    /**
	 * @return
	 * @uml.property  name="password"
	 */
    public String getPassword() 
    {
        return password;
    }
    
    /**
	 * @param password
	 * @uml.property  name="password"
	 */
    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    /**
	 * @return
	 * @uml.property  name="userGroup"
	 */
    public String getUserGroup() 
    {
        return userGroup;
    }
    
    /**
	 * @param userGroup
	 * @uml.property  name="userGroup"
	 */
    public void setUserGroup(String userGroup) 
    {
        this.userGroup = userGroup;
    }
    
    /**
	 * @return
	 * @uml.property  name="userName"
	 */
    public String getUserName()
    {
        return userName;
    }
    
    /**
	 * @param userName
	 * @uml.property  name="userName"
	 */
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }
    
    /**
	 * @return
	 * @uml.property  name="userToken"
	 */
    public String getUserToken() 
    {
        return userToken;
    }
    
    /**
	 * @param userToken
	 * @uml.property  name="userToken"
	 */
    public void setUserToken(String userToken) 
    {
        this.userToken = userToken;
    }
    
    
}
