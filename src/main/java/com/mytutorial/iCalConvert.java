/**
 * 
 */
package com.mytutorial;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;


/**
 * @author Keerthi
 *
 */
public class iCalConvert {
	
	public boolean forwardiCalConvert(){
		System.out.println("iCalConvertor");
		CalendarBuilder builder = new CalendarBuilder();
		FileInputStream fin=null;
		File fout=null;
		Writer out = null;
		Calendar calendar=null;
		ComponentList com = null;
		VEvent vevent=null;
		Date date=null;
		String txtContent=null;
		Property temp = null;
		try {
			fin = new FileInputStream("C:\\academic-year.ics");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		try {
			calendar = builder.build(fin);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ParserException e) {
			e.printStackTrace();
			return false;
		}
		
		//System.out.println(calendar.toString());
		temp=calendar.getProperty("X-WR-CALNAME");
		if(temp!=null){
			txtContent="title = "+temp.getValue();
		}
		else{
			txtContent="title = UNKNOWN";
			System.out.println("Got in else part");
		}
		txtContent+="\n";
		//System.out.println("title = "+calendar.getProperty("X-WR-CALNAME").getValue());
		temp=calendar.getProperty("X-WR-CALDESC");
		if(temp!=null){
			txtContent+="description = "+temp.getValue().replace('\n', ' ');
		}
		else{
			txtContent+="description = UNKNOWN";
			System.out.println("Got in else part");
		}
		
		txtContent+="\n";
		//System.out.println("description = "+calendar.getProperty("X-WR-CALDESC").getValue());
		com=calendar.getComponents();
		//System.out.println("Size = "+com.size());
		txtContent+="//-------------------------------------------------------------\n";
		//System.out.println("-------------------------------------------------------------");
		for(int i=0;i<com.size();i++){
		
			vevent=(VEvent) com.get(i);
			date=vevent.getStartDate().getDate();
			String dateParse=date.toString();
			txtContent+="["+(dateParse.substring(4,6))+" "+(dateParse.substring(0,4))+"]";
			txtContent+="\n";
			txtContent+="--"+dateParse.substring(6,8);
			txtContent+="\n";
			txtContent+=vevent.getSummary().getValue();
			txtContent+="\n";
			txtContent+="//-------------------------------------------------------------\n";
			
			
			
			/*System.out.println("Event Date= "+dateParse);
			System.out.println("Event Month HDR= ["+(dateParse.substring(4,6))+" "+(dateParse.substring(0,4))+"]");
			System.out.println("Event Day HDR= --"+dateParse.substring(6,8));
			System.out.println("Event name= "+vevent.getSummary().getValue());
			System.out.println("-------------------------------------------------------------");*/
		}
		System.out.println(txtContent);
		fout = new File("C:\\CalTxtACAD.txt");
		try {
			out = new BufferedWriter(new FileWriter(fout));
			out.write(txtContent);
			out.close();
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean backwardiCalConvert(){
		Calendar calendar = new Calendar();
		FileInputStream fis = null;
		
		// Event Array
		ArrayList<Date> event_date = null;
		ArrayList<String> event_detail = null;
		
		/*DateFormat dfm = new SimpleDateFormat("yyyyMMdd");
		try {
			java.util.Date d = dfm.parse("200945");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}*/
		BufferedReader reader = null;
		FileOutputStream fout =null;
		String line= "";
		String title = "";
		String desc = "";
		int title_pos = 0;
		int desc_pos = 0;
		int event_pos = 0;
		int day_pos = 0;
		int space = 0;
		int day = 0;
		int month = 0;
		int year = 0;
		boolean event_set = false;
		boolean title_set = false;
		boolean desc_set = false;
		String monthstr = null;
		String daystr = null;
		int event_count=-1;
		int desc_count=-1;
		
		
		
		
		//System.out.println(sb.indexOf("title"));
		try {
			fis = new FileInputStream("H:\\Work Space\\MyEclipse Workspace\\CalConvert\\test\\testformat.txt");
			reader = new BufferedReader(new InputStreamReader(fis));
			if(reader!=null){
				event_date = new ArrayList<Date>();
				event_detail = new ArrayList<String>();
			}
			// Read entire file into a string line by line
			while ((line = reader.readLine()) != null) {
				
				// Replace all the links
				//line = line.replaceAll(oldPattern, replPattern);
				if((line.indexOf("//")==-1)&&(!line.equals(""))){
					
					// Get the title INFORMATION
					if(!title_set){
						title_pos = line.indexOf("title")+5;
						//System.out.println(title_pos);
						if(title_pos>4){
							//System.out.println(line.indexOf("\n", (title_pos)));
							title = line.substring((line.indexOf("=",(title_pos))+1));
							System.out.println(title);
							title_set=true;
							continue;
						}
					}
					
					// Get the description INFORMATION
					if(!desc_set){
						desc_pos = (line.indexOf("description")+11);
						if(desc_pos>10){
							desc = line.substring((line.indexOf("=",(desc_pos))+1));
							System.out.println(desc);
							desc_set = true;
							continue;
						}
					}
					
					// Get the Event INFORMATION
					
					event_pos=line.indexOf("[")+1;
					if(event_pos>0){
						
							event_set=true; // indicate the event is available now
							space=line.indexOf(" ",event_pos);
							// extract the year and month
							month=Integer.parseInt(line.substring(event_pos,space));
							System.out.println(month);
							year = Integer.parseInt(line.substring(space+1,line.length()-1));
							System.out.println(year);
							 continue;
							//System.out.println("got an event date");
							// Process the event
							
							
						}
						if(event_set){
							
							// Contains the event day and description list
							day_pos = line.indexOf("--")+2;
							if(day_pos>1){
								day = Integer.parseInt(line.substring(day_pos, line.length()));
								
								// Now extract the event details
								// Create a hash table / array list that maps a date with the details
								// Fill the date
								
								event_count++;
								
								if(month<10){
									monthstr="0"+month;
								}
								else{
									monthstr=""+month;
								}
								if(day<10){
									daystr="0"+day;
								}
								else{
									daystr=""+day;
								}
									
								Date ne = new Date(year+monthstr+daystr);
								//java.util.Calendar nem = java.util.Calendar.getInstance();
								//nem.set(year, month, day);
								System.out.println(ne);
								
								event_date.add(new Date(year+monthstr+daystr));
								// follow_event specify 
								// Date of the event is extracted
								continue;
								//follow_event = true;
								
							}
							else{
								// This should be a detail of the above event date
								// Assuming the event details is written on one line
								
								System.out.println("Desc:"+line);
								//{
									
									desc_count++;
									
								//}
								/*if((event_pos<=0)){
									System.out.println("Error Creating the file: Format of the file does not match the syntax pattern.");
								}*/
								
								if(desc_count<event_count){
									for(int i = desc_count;i<=event_count;i++){
										event_detail.add(line);
									}
									desc_count=event_count;
								}
								else if (desc_count==event_count){
									event_detail.add(line);
								}
								else if(event_count<desc_count){
									for(int i = event_count+1;i<=desc_count;i++){
										event_date.add(new Date(year+monthstr+daystr));
										event_detail.add(line);
									}
									event_count=desc_count;
									//System.out.println("Error Creating the file: Format of the file does not match the syntax pattern.");
								}
								//follow_event=false;
								continue;
							}
						}// else part
						else{
							System.out.println("Error Creating the file: Format of the file does not match the syntax pattern.");
						}
						continue;
					
					
					
					
					
					//sb.append(line + "\n");
				}// End of comment check if loop here
				else{
					System.out.println("No content here: Might be a comment here");
				}
			}

			// Close the reader and writer to avoid runtime errors
			reader.close();
			} catch (Exception e) {
				System.out.println("*** exception ***" );
				e.printStackTrace();
			}
		
		/*try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\Work Space\\MyEclipse Workspace\\CalConvert\\test\\CalTxtACAD.txt")));
			fin = new FileInputStream("H:\\Work Space\\MyEclipse Workspace\\CalConvert\\test\\CalTxtACAD.txt");
			
			
			try {
				temp = in.readLine();
				System.out.println(temp);
				while(!(temp.length()<0)){
					
					if((temp.indexOf("//")<0)){
						int pos = temp.indexOf("title");
						if(pos>=0){
							System.out.println(temp.substring(pos, temp.length()));
						}
						
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}*/
		
		//System.out.println(sb);
		
		
		
		
		// Fixed Settings
		calendar.getProperties().add(new ProdId("-//The University of Kentucky//CEPIS//Academic Dates//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);
		
			//calendar.getProperties("X-WR-CALNAME").add(CalScale.GREGORIAN);
	
		//calendar.getProperties().add(net.fortuna.ical4j.model.Property.DESCRIPTION);
		
		/*BEGIN:VEVENT
		DTSTART;VALUE=DATE:20090508
		DTEND;VALUE=DATE:20090509
		DTSTAMP:20090218T234947Z
		UID:78qqu7glb5l2aqs27f93c7isok@auckland.ac.nz
		CLASS:PUBLIC
		CREATED:20090213T053212Z
		DESCRIPTION:
		LAST-MODIFIED:20090218T233055Z
		LOCATION:
		SEQUENCE:0
		STATUS:CONFIRMED
		SUMMARY:Graduation
		TRANSP:TRANSPARENT
		END:VEVENT*/
		
		// Create V Event for each event in the text file
		for(int i=0;i<=event_count;i++){
		
			/*cal.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
			cal.set(java.util.Calendar.DAY_OF_MONTH, 25);
			cal.set(java.util.Calendar.YEAR, 2009);*/
			
			VEvent event = new VEvent(event_date.get(i),event_detail.get(i));
			
			/*try {
				ug = new UidGenerator("i");
			} catch (SocketException e) {
				e.printStackTrace();
				return false;
			}
			event.getProperties().add(ug.generateUid());*/
			calendar.getComponents().add(event);
			System.out.println("DATE:"+event_date.get(i)+" ---------> Detail:"+event_detail.get(i));
		}

		
		try {
			fout = new FileOutputStream("H:\\Work Space\\MyEclipse Workspace\\CalConvert\\test\\mycalendar.ics");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		CalendarOutputter outputter = new CalendarOutputter();
		try {
			outputter.output(calendar, fout);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ValidationException e) {
			e.printStackTrace();
			return false;
		}
		
		
		System.out.println(calendar);
		return true;
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		iCalConvert ical = new iCalConvert();
		if(ical.forwardiCalConvert()){
			System.out.println("TXT File Written Successfully");
		}
		else{
			System.out.println("Error occurred in creating TXT file.");
		}/*
		if(ical.backwardiCalConvert()){
			System.out.println("iCal File Written Successfully");
		}
		else{
			System.out.println("Error occurred in creating iCal file.");
		}*/
		
		
	}

}
