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
package org.efs.openreports;

public class ReportConstants 
{
	/**
	 * Report delivery methods. Name is used to map a delivery method to a Spring bean identifier using the following format: name + "DeliveryMethod"
	 */
	public enum DeliveryMethod {/**
	 * @uml.property  name="eMAIL"
	 * @uml.associationEnd  
	 */
	EMAIL("email"), /**
	 * @uml.property  name="fILE"
	 * @uml.associationEnd  
	 */
	FILE("fileSystem"), /**
	 * @uml.property  name="fAX"
	 * @uml.associationEnd  
	 */
	FAX("fax"), /**
	 * @uml.property  name="fTP"
	 * @uml.associationEnd  
	 */
	FTP("ftp"), /**
	 * @uml.property  name="pRINTER"
	 * @uml.associationEnd  
	 */
	PRINTER("printer"), /**
	 * @uml.property  name="dOCUMENT_REPOSITORY"
	 * @uml.associationEnd  
	 */
	DOCUMENT_REPOSITORY("documentRepository");
	
		/**
		 * @uml.property  name="name"
		 */
		private final String name;

		DeliveryMethod(String name) 
		{
			this.name = name;
		}

		/**
		 * @return
		 * @uml.property  name="name"
		 */
		public String getName() 
		{
			return name;
		}
        
        public static DeliveryMethod findByName(String name) {
            for (DeliveryMethod value : DeliveryMethod.values()) {
                if (value.getName().equalsIgnoreCase(name)) {
                    return value;
                }
            }
            return null;
        }
	}
	
	/**
	 * Report export types. int code is used to support legacy export types persisted or serialized as integers in ReportSchedule and ReportLog objects
	 */
	public enum ExportType {/**
	 * @uml.property  name="pDF"
	 * @uml.associationEnd  
	 */
	PDF(0), /**
	 * @uml.property  name="xLS"
	 * @uml.associationEnd  
	 */
	XLS(1), /**
	 * @uml.property  name="hTML"
	 * @uml.associationEnd  
	 */
	HTML(2), /**
	 * @uml.property  name="cSV"
	 * @uml.associationEnd  
	 */
	CSV(3), /**
	 * @uml.property  name="iMAGE"
	 * @uml.associationEnd  
	 */
	IMAGE(4), /**
	 * @uml.property  name="rTF"
	 * @uml.associationEnd  
	 */
	RTF(5), /**
	 * @uml.property  name="tEXT"
	 * @uml.associationEnd  
	 */
	TEXT(6), /**
	 * @uml.property  name="eXCEL"
	 * @uml.associationEnd  
	 */
	EXCEL(7), /**
	 * @uml.property  name="hTML_EMBEDDED"
	 * @uml.associationEnd  
	 */
	HTML_EMBEDDED(8);

		/**
		 * @uml.property  name="code"
		 */
		private final int code;

		ExportType(int code) 
		{
			this.code = code;
		}

		/**
		 * @return
		 * @uml.property  name="code"
		 */
		public int getCode() 
		{
			return code;
		}

		public static ExportType findByCode(int code) 
		{
			for (ExportType exportType : ExportType.values()) 
			{
				if (exportType.getCode() == code) return exportType;
			}
			
			return null;
		}
	}

	/**
	 * Report schedule types. int code is used to support legacy schedule types serialized as integers in ReportSchedule objects.
	 */
	public enum ScheduleType {/**
	 * @uml.property  name="oNCE"
	 * @uml.associationEnd  
	 */
	ONCE(0), /**
	 * @uml.property  name="dAILY"
	 * @uml.associationEnd  
	 */
	DAILY(1), /**
	 * @uml.property  name="wEEKLY"
	 * @uml.associationEnd  
	 */
	WEEKLY(2), /**
	 * @uml.property  name="mONTHLY"
	 * @uml.associationEnd  
	 */
	MONTHLY(3), /**
	 * @uml.property  name="wEEKDAYS"
	 * @uml.associationEnd  
	 */
	WEEKDAYS(4), /**
	 * @uml.property  name="hOURLY"
	 * @uml.associationEnd  
	 */
	HOURLY(5), /**
	 * @uml.property  name="cRON"
	 * @uml.associationEnd  
	 */
	CRON(6);

		/**
		 * @uml.property  name="code"
		 */
		private final int code;

		ScheduleType(int code) 
		{
			this.code = code;
		}

		/**
		 * @return
		 * @uml.property  name="code"
		 */
		public int getCode() 
		{
			return code;
		}

		public static ScheduleType findByCode(int code) 
		{
			for (ScheduleType scheduleType : ScheduleType.values()) 
			{
				if (scheduleType.getCode() == code)	return scheduleType;
			}
			
			return null;
		}
	}
	
	/**
	 * AM/PM indicator for scheduled request. The code corresponds to the AM and PM constants  in the java.util.Calendar class.
	 */
	public enum ScheduleAmPm {/**
	 * @uml.property  name="aM"
	 * @uml.associationEnd  
	 */
	AM(0), /**
	 * @uml.property  name="pM"
	 * @uml.associationEnd  
	 */
	PM(1);
		
		/**
		 * @uml.property  name="code"
		 */
		private final int code;

		ScheduleAmPm(int code) 
		{
			this.code = code;
		}

		/**
		 * @return
		 * @uml.property  name="code"
		 */
		public int getCode() 
		{
			return code;
		}
		
		public static ScheduleAmPm findByCode(int code) 
		{
			for (ScheduleAmPm scheduleAmPm : ScheduleAmPm.values()) 
			{
				if (scheduleAmPm.getCode() == code) return scheduleAmPm;
			}
			
			return null;
		}		
	}
	
	/**
	 * @author      keerthi
	 */
	public enum Status {/**
	 * @uml.property  name="sUCCESS"
	 * @uml.associationEnd  
	 */
	SUCCESS, /**
	 * @uml.property  name="fAILURE"
	 * @uml.associationEnd  
	 */
	FAILURE, /**
	 * @uml.property  name="iNVALID"
	 * @uml.associationEnd  
	 */
	INVALID};	
}
