/*
 * Copyright (C) 2003 Erik Swenson - erik@oreports.com
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *  
 */

package org.efs.openreports.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.efs.openreports.util.ByteArrayDataSource;

/**
 * @author  keerthi
 */
public class MailMessage implements Serializable
{
	private static final long serialVersionUID = -5816798771288286268L;

	/**
	 * @uml.property  name="sender"
	 */
	private String sender;
	/**
	 * @uml.property  name="subject"
	 */
	private String subject;
	/**
	 * @uml.property  name="text"
	 */
	private String text;
    /**
	 * @uml.property  name="bounceAddress"
	 */
    private String bounceAddress;

	/**
	 * @uml.property  name="recipients"
	 */
	private ArrayList<String> recipients = new ArrayList<String>();
	/**
	 * @uml.property  name="attachments"
	 */
	private ArrayList<String> attachments = new ArrayList<String>();
	/**
	 * @uml.property  name="htmlImageDataSources"
	 */
	private ArrayList<ByteArrayDataSource> htmlImageDataSources = new ArrayList<ByteArrayDataSource>();

	/**
	 * @uml.property  name="byteArrayDataSource"
	 * @uml.associationEnd  
	 */
	private ByteArrayDataSource byteArrayDataSource;

	public MailMessage()
	{
	}

	/**
	 * @return
	 * @uml.property  name="sender"
	 */
	public String getSender()
	{
		return sender;
	}

	/**
	 * @param sender
	 * @uml.property  name="sender"
	 */
	public void setSender(String sender)
	{
		this.sender = sender;
	}

	/**
	 * @return
	 * @uml.property  name="recipients"
	 */
	public ArrayList<String> getRecipients()
	{
		return recipients;
	}

	/**
	 * @param recipients
	 * @uml.property  name="recipients"
	 */
	public void setRecipients(ArrayList<String> recipients)
	{
		this.recipients = recipients;
	}

	/**
	 * @return
	 * @uml.property  name="subject"
	 */
	public String getSubject()
	{
		return subject;
	}

	/**
	 * @param subject
	 * @uml.property  name="subject"
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	/**
	 * @return
	 * @uml.property  name="text"
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @param text
	 * @uml.property  name="text"
	 */
	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 * @return
	 * @uml.property  name="byteArrayDataSource"
	 */
	public ByteArrayDataSource getByteArrayDataSource()
	{
		return byteArrayDataSource;
	}

	/**
	 * @param byteArrayDataSource
	 * @uml.property  name="byteArrayDataSource"
	 */
	public void setByteArrayDataSource(ByteArrayDataSource byteArrayDataSource)
	{
		this.byteArrayDataSource = byteArrayDataSource;
	}

	/**
	 * @return
	 * @uml.property  name="attachments"
	 */
	public ArrayList<String> getAttachments()
	{
		return attachments;
	}

	public void addAttachment(String fileName)
	{
		attachments.add(fileName);
	}

	public void addRecepient(String recipient)
	{
		recipients.add(recipient);
	}

	public String formatRecipients(String delimiter)
	{
		String addresses = "";

		for (int i = 0; i < recipients.size(); i++)
		{
			addresses += recipients.get(i) + delimiter;
		}

		return addresses.substring(0, addresses.length() - 1);
	}

	public void parseRecipients(String value)
	{
		StringTokenizer st = new StringTokenizer(value, "\t\n\r\f;,|");

		recipients = new ArrayList<String>();

		while (st.hasMoreElements())
		{
			recipients.add(st.nextToken());
		}
	}

	/**
	 * @return
	 * @uml.property  name="htmlImageDataSources"
	 */
	public ArrayList<ByteArrayDataSource> getHtmlImageDataSources()
	{
		return htmlImageDataSources;
	}

	public void addHtmlImageDataSources(ArrayList<ByteArrayDataSource> htmlImageDataSources)
	{
		this.htmlImageDataSources.addAll(htmlImageDataSources);
	}
    
    /**
	 * @return
	 * @uml.property  name="bounceAddress"
	 */
    public String getBounceAddress() 
    {
        return bounceAddress;
    }
    
    /**
	 * @param bounceAddress
	 * @uml.property  name="bounceAddress"
	 */
    public void setBounceAddress(String bounceAddress) 
    {
        this.bounceAddress = bounceAddress;
    }

}