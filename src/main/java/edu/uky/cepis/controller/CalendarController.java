package edu.uky.cepis.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.myfaces.custom.schedule.model.DefaultScheduleEntry;
import org.apache.myfaces.custom.schedule.model.ScheduleModel;
import org.apache.myfaces.custom.schedule.model.SimpleScheduleModel;
import edu.uky.cepis.domain.Event;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.util.global.CEPISConfigurator;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;
import edu.uky.cepis.view.CalendarView;

/**
 * @author  keerthi
 */
public class CalendarController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="cepisConfigurator"
	 * @uml.associationEnd  
	 */
	private CEPISConfigurator cepisConfigurator;
	/**
	 * @uml.property  name="calendarBean"
	 * @uml.associationEnd  
	 */
	private CalendarView calendarBean;
	/**
	 * @uml.property  name="calendarWarnStatus"
	 */
	private boolean calendarWarnStatus;
	/**
	 * @uml.property  name="calendarStatusMessage"
	 */
	private String calendarStatusMessage;
	/**
	 * @uml.property  name="from"
	 */
	private Date from;
	/**
	 * @uml.property  name="until"
	 */
	private Date until;
	/**
	 * @uml.property  name="title"
	 */
	private String title;
	/**
	 * @uml.property  name="location"
	 */
	private String location;
	/**
	 * @uml.property  name="comments"
	 */
	private String comments;
	/**
	 * @uml.property  name="model"
	 */
	private ScheduleModel model;
	/**
	 * @uml.property  name="allDay"
	 */
	private boolean allDay;
	/**
	 * @uml.property  name="timeZone"
	 */
	private TimeZone timeZone;
	/**
	 * @uml.property  name="displayDay"
	 */
	private boolean displayDay;
	/**
	 * @uml.property  name="displayWeek"
	 */
	private boolean displayWeek;
	/**
	 * @uml.property  name="displayWorkWeek"
	 */
	private boolean displayWorkWeek;
	/**
	 * @uml.property  name="displayMonth"
	 */
	private boolean displayMonth;
	/**
	 * @uml.property  name="eventLoadStatus"
	 */
	private boolean eventLoadStatus = false;
	/**
	 * @uml.property  name="upFile"
	 */
	private UploadedFile upFile;

	/**
	 * @param cepisConfigurator  the cepisConfigurator to set
	 * @uml.property  name="cepisConfigurator"
	 */
	public void setCepisConfigurator(CEPISConfigurator cepisConfigurator) {
		this.cepisConfigurator = cepisConfigurator;
	}

	/**
	 * @return  the cepisConfigurator
	 * @uml.property  name="cepisConfigurator"
	 */
	public CEPISConfigurator getCepisConfigurator() {
		return cepisConfigurator;
	}

	/**
	 * @param calendarBean  the calendarBean to set
	 * @uml.property  name="calendarBean"
	 */
	public void setCalendarBean(CalendarView calendarBean) {
		this.calendarBean = calendarBean;
	}

	/**
	 * @return  the calendarBean
	 * @uml.property  name="calendarBean"
	 */
	public CalendarView getCalendarBean() {
		return calendarBean;
	}

	/**
	 * @return  the calendarWarnStatus
	 * @uml.property  name="calendarWarnStatus"
	 */
	public boolean isCalendarWarnStatus() {
		return calendarWarnStatus;
	}

	/**
	 * @param calendarWarnStatus  the calendarWarnStatus to set
	 * @uml.property  name="calendarWarnStatus"
	 */
	public void setCalendarWarnStatus(boolean calendarWarnStatus) {
		this.calendarWarnStatus = calendarWarnStatus;
	}

	/**
	 * @return  the calendarStatusMessage
	 * @uml.property  name="calendarStatusMessage"
	 */
	public String getCalendarStatusMessage() {
		return calendarStatusMessage;
	}

	/**
	 * @param calendarStatusMessage  the calendarStatusMessage to set
	 * @uml.property  name="calendarStatusMessage"
	 */
	public void setCalendarStatusMessage(String calendarStatusMessage) {
		this.calendarStatusMessage = calendarStatusMessage;
	}

	/**
	 * @return
	 * @uml.property  name="comments"
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 * @uml.property  name="comments"
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return
	 * @uml.property  name="from"
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * @param from
	 * @uml.property  name="from"
	 */
	public void setFrom(Date from) {
		this.from = from;
	}

	/**
	 * @return
	 * @uml.property  name="location"
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 * @uml.property  name="location"
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return
	 * @uml.property  name="model"
	 */
	public ScheduleModel getModel() {
		return model;
	}

	/**
	 * @param model
	 * @uml.property  name="model"
	 */
	public void setModel(ScheduleModel model) {
		this.model = model;
	}

	/**
	 * @return
	 * @uml.property  name="title"
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 * @uml.property  name="title"
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 * @uml.property  name="until"
	 */
	public Date getUntil() {
		return until;
	}

	/**
	 * @param until
	 * @uml.property  name="until"
	 */
	public void setUntil(Date until) {
		this.until = until;
	}

	/**
	 * @param allDay  the allDay to set
	 * @uml.property  name="allDay"
	 */
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	/**
	 * @return  the allDay
	 * @uml.property  name="allDay"
	 */
	public boolean isAllDay() {
		return allDay;
	}

	/**
	 * @param timeZone  the timeZone to set
	 * @uml.property  name="timeZone"
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @return  the timeZone
	 * @uml.property  name="timeZone"
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * @param _upFile  the _upFile to set
	 * @uml.property  name="upFile"
	 */
	public void setUpFile(UploadedFile upFile) {
		this.upFile = upFile;
	}

	/**
	 * @return  the _upFile
	 * @uml.property  name="upFile"
	 */
	public UploadedFile getUpFile() {
		return upFile;
	}

	/**
	 * @return  the eventLoadStatus
	 * @uml.property  name="eventLoadStatus"
	 */
	public boolean isEventLoadStatus() {
		return eventLoadStatus;
	}

	/**
	 * @param eventLoadStatus  the eventLoadStatus to set
	 * @uml.property  name="eventLoadStatus"
	 */
	public void setEventLoadStatus(boolean eventLoadStatus) {
		this.eventLoadStatus = eventLoadStatus;
	}

	public void initCalendarView(PhaseEvent event) {
		if (!eventLoadStatus) {
			addExistingEvents();
			this.setEventLoadStatus(true);
		}
	}

	public Date getSelectedDate() {
		return this.model.getSelectedDate();
	}

	public void setSelectedDate(Date date) {
		System.out.println("Set Selected Date function called. "
				+ date.toString() + " from "
				+ this.model.getSelectedDate().toString());
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		Calendar currentcalendar = GregorianCalendar.getInstance();
		currentcalendar.setTime(this.model.getSelectedDate());
		int current_month = currentcalendar.get(Calendar.MONTH);
		this.getModel().setSelectedDate(date);
		if (month != current_month) {
			System.out.println("New month selected");
			this.addExistingEvents();
		}
	}

	/**
	 * @return  the displayDay
	 * @uml.property  name="displayDay"
	 */
	public boolean isDisplayDay() {
		model.setMode(0);
		model.refresh();
		return true;
	}

	/**
	 * @return  the displayWorkWeek
	 * @uml.property  name="displayWorkWeek"
	 */
	public boolean isDisplayWorkWeek() {
		model.setMode(1);
		model.refresh();
		return true;
	}

	/**
	 * @return  the displayWeek
	 * @uml.property  name="displayWeek"
	 */
	public boolean isDisplayWeek() {
		model.setMode(2);
		model.refresh();
		return true;
	}

	/**
	 * @return  the displayMonth
	 * @uml.property  name="displayMonth"
	 */
	public boolean isDisplayMonth() {
		model.setMode(3);
		model.refresh();
		return true;
	}

	public String addEvent() {
		if (!from.before(until)) {
			this.setCalendarWarnStatus(true);
			this
					.setCalendarStatusMessage("Invalid Input: Start time must be before end time");
			/*
			 * FacesContext.getCurrentInstance().addMessage( null, new
			 * FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * "start time must be before end time", null));
			 */
			return null;
		}
		User user = this.getUserManager().getUser();
		Event event = this.getCalendarBean().addEventToUser(user, until, from,
				comments, location, title, false, user.getTimeZone());
		if (event == null) {
			this.setCalendarWarnStatus(true);
			this
					.setCalendarStatusMessage("Null Error: Cannot create event. Null value returned");
			return null;
		}
		model.addEntry(event);
		model.refresh();
		return "success";
	}

	public void deleteEvent(ActionEvent event) {
		System.out.println("Got in the Delete Entry");
		if (model == null) {
			System.out.println("Model object is null");
			return;
		}
		Event currentEvent = (Event) model.getSelectedEntry();
		if (this.getCalendarBean().removeEventFromUser(
				this.getUserManager().getUser(), currentEvent)) {
			System.out.println("Delete Entry Successful");
			model.removeSelectedEntry();
		}

	}

	public void addSampleHoliday(ActionEvent event) {
		if (model instanceof SimpleScheduleModel) {
			SimpleScheduleModel ssm = (SimpleScheduleModel) model;
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(ssm.getSelectedDate());
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			ssm.setHoliday(calendar.getTime(), "Poeperkesdag");
			ssm.refresh();
		}
	}

	// Loads only current month's (in model object) Events for this User
	public void addExistingEvents() {
		if (model == null) {
			System.out.println("Model is null");
			return;
		}
		List<Event> events = new ArrayList<Event>(0);
		events = this.getCalendarBean().getEventList(
				this.getUserManager().getUser(),
				this.getModel().getSelectedDate());
		System.out.println(events.size());
		Iterator<Event> iter = events.iterator();
		while (iter.hasNext()) {
			model.addEntry(iter.next());
		}

	}

	public String importICalendar() {
		String userCalLoc = this.getCepisConfigurator().getBaseLocation() + "/"
				+ this.getCepisConfigurator().getApplicationName() + "/users/"
				+ this.getUserManager().getUser().getUid()
				+ "/mycalendar/uploads/";
		try {
			File file = new File(userCalLoc);
			if (!file.exists()) {
				file.mkdirs();
			}
			file = new File(userCalLoc + "/" + this.getUpFile().getName());
			if (file.exists()) {
				this.setCalendarWarnStatus(true);
				this.setCalendarStatusMessage("File "
						+ this.getUpFile().getName() + " already exists.");
				return null;
			}
			System.out.println(file.getAbsolutePath());
			OutputStream fout = new FileOutputStream(file);
			try {
				fout.write(this.getUpFile().getBytes());
				fout.flush();
				// Processing the ics file

				this.setCalendarWarnStatus(false);
				this.setCalendarStatusMessage("File "
						+ this.getUpFile().getName()
						+ " imported successfully.");
				fout.close();
				return null;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		this.setCalendarWarnStatus(true);
		this.setCalendarStatusMessage("Upload error: Cannot upload file");
		return null;
	}

}
