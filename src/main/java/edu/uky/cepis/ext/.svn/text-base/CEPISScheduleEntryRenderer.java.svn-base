/**
 * 
 */
package edu.uky.cepis.ext;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.myfaces.custom.schedule.AbstractScheduleRenderer;
import org.apache.myfaces.custom.schedule.DefaultScheduleEntryRenderer;
import org.apache.myfaces.custom.schedule.HtmlSchedule;
import org.apache.myfaces.custom.schedule.model.ScheduleDay;
import org.apache.myfaces.custom.schedule.model.ScheduleEntry;
import org.apache.myfaces.shared_tomahawk.renderkit.html.HTML;

/**
 * @author keerthi
 * 
 */
public class CEPISScheduleEntryRenderer extends DefaultScheduleEntryRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CEPISScheduleEntryRenderer() {
		System.out.println("Creating CEPISScheduleEntryRenderer object");
	}

	@Override
	public String getColor(FacesContext context, HtmlSchedule schedule,
			ScheduleEntry entry, boolean selected) {
		System.out.println("Calling getColor function");

		int beginIndex = entry.getSubtitle().indexOf('(') + 1;
		int endIndex = entry.getSubtitle().length() - 1;
		String entryStatus = entry.getSubtitle()
				.substring(beginIndex, endIndex);
		System.out.println("Entry Status: " + entryStatus);
		if (entryStatus.equals("Scheduled")) {
			return "rgb(34,139,34)";
		} else if (entryStatus.equals("Completed")) {
			return "rgb(0,0,0)";
		} else if (entryStatus.equals("Cancelled")) {
			return "rgb(160,82,45)";
		} else if (entryStatus.equals("No Show")) {
			return "rgb(178,34,34)";
		} else if (entryStatus.equals("Checked In")) {
			return "rgb(255,140,0)";
		}

		return super.getColor(context, schedule, entry, selected);
	}

	/**
	 * @see org.apache.myfaces.custom.schedule.ScheduleEntryRenderer#renderContent(javax.faces.context.FacesContext,
	 *      javax.faces.context.ResponseWriter,
	 *      org.apache.myfaces.custom.schedule.HtmlSchedule,
	 *      org.apache.myfaces.custom.schedule.model.ScheduleDay,
	 *      org.apache.myfaces.custom.schedule.model.ScheduleEntry, boolean,
	 *      boolean)
	 */
	public void renderContent(FacesContext context, ResponseWriter writer,
			HtmlSchedule schedule, ScheduleDay day, ScheduleEntry entry,
			boolean compact, boolean selected) throws IOException {
		if (compact) {
			renderCompactContent(context, writer, schedule, day, entry,
					selected);
		} else {
			if (selected) {
				StringBuffer entryStyle = new StringBuffer();
				entryStyle.append("height: 100%; width: 100%;");
				// the left border of a selected entry should have the same
				// color as the entry border
				// String entryColor = getColor(context, schedule, entry,
				// selected);

				entryStyle.append("border-color: blue;");

				// draw the contents of the selected entry
				writer.startElement(HTML.DIV_ELEM, null);
				writer.writeAttribute(HTML.CLASS_ATTR, getStyleClass(schedule,
						"text"), null);
				writer.writeAttribute(HTML.STYLE_ATTR, entryStyle.toString(),
						null);

				renderDetailedContentText(context, writer, schedule, day,
						entry, selected);

				writer.endElement(HTML.DIV_ELEM);
			} else {
				renderDetailedContentText(context, writer, schedule, day,
						entry, selected);
			}
		}

	}

	private String getAppointmentStatusStyle(String entryStatus) {
		String entryStatusSize = "width:15px;height:15px;vertical-align: middle;";
		if (entryStatus.equals("Scheduled")) {
			return "background-color: rgb(34,139,34);color: rgb(34,139,34);"
					+ entryStatusSize;
		} else if (entryStatus.equals("Completed")) {
			return "background-color: rgb(0,0,0);color: rgb(0,0,0);"
					+ entryStatusSize;
		} else if (entryStatus.equals("Cancelled")) {
			return "background-color: rgb(160,82,45);color: rgb(160,82,45);"
					+ entryStatusSize;
		} else if (entryStatus.equals("No Show")) {
			return "background-color: rgb(178,34,34);color: rgb(178,34,34);"
					+ entryStatusSize;
		} else if (entryStatus.equals("Checked In")) {
			return "background-color: rgb(255,140,0);color: rgb(255,140,0);"
					+ entryStatusSize;
		}
		return "";
	}

	private String getAppointmentStatus(String title) {
		/*
		 * In order: Scheduled,Completed,Cancelled,No Show,Checked In
		 */
		// String[] colorCodes = { "rgb(34,139,34)", "rgb(0,0,0)",
		// "rgb(160,82,45)", "rgb(178,34,34)", "rgb(255,140,0)" };
		int beginIndex = title.indexOf('(') + 1;
		int endIndex = title.length() - 1;
		String entryStatus = title.substring(beginIndex, endIndex);
		return entryStatus;
	}

	protected void renderCompactContent(FacesContext context,
			ResponseWriter writer, HtmlSchedule schedule, ScheduleDay day,
			ScheduleEntry entry, boolean selected) throws IOException {
		StringBuffer text = new StringBuffer();
		Date startTime = entry.getStartTime();

		if (day.getDayStart().after(entry.getStartTime())) {
			startTime = day.getDayStart();
		}

		Date endTime = entry.getEndTime();

		if (day.getDayEnd().before(entry.getEndTime())) {
			endTime = day.getDayEnd();
		}

		writer.startElement(HTML.SPAN_ELEM, schedule);
		writer.writeAttribute(HTML.STYLE_ATTR, this
				.getAppointmentStatusStyle(this.getAppointmentStatus(entry
						.getTitle())), null);
		writer.writeText("..", null);
		writer.endElement(HTML.SPAN_ELEM);
		if (!entry.isAllDay()) {

			String pattern = "24".equals(schedule.getHourNotation()) ? "HH:mm"
					: "h:mma";
			Locale viewLocale = context.getViewRoot().getLocale();
			DateFormat format = (pattern != null && pattern.length() > 0) ? new SimpleDateFormat(
					pattern, viewLocale)
					: DateFormat.getDateInstance(DateFormat.MEDIUM, viewLocale);
			format.setTimeZone(schedule.getModel().getTimeZone());
			text.append(" " + format.format(startTime));
			if (!startTime.equals(endTime)) {
				text.append("-");
				text.append(format.format(endTime));
			}
			text.append(": ");
		}
		text.append(entry.getTitle());

		writer.writeText(text.toString(), null);
	}

	protected void renderDetailedContentText(FacesContext context,
			ResponseWriter writer, HtmlSchedule schedule, ScheduleDay day,
			ScheduleEntry entry, boolean selected) throws IOException {
		writer.startElement(HTML.SPAN_ELEM, schedule);
		writer.writeAttribute(HTML.STYLE_ATTR, this
				.getAppointmentStatusStyle(this.getAppointmentStatus(entry
						.getTitle())), null);
		writer.writeText("..", null);
		writer.endElement(HTML.SPAN_ELEM);
		// write the title of the entry
		if (entry.getTitle() != null) {
			writer.startElement(HTML.SPAN_ELEM, schedule);
			writer.writeAttribute(HTML.CLASS_ATTR, getStyleClass(schedule,
					"title"), null);
			writer.writeText(" " + entry.getTitle(), null);
			writer.endElement(HTML.SPAN_ELEM);
		}
		/*
		 * if (entry.getSubtitle() != null) { writer.startElement("br",
		 * schedule); writer.endElement("br");
		 * writer.startElement(HTML.SPAN_ELEM, schedule);
		 * writer.writeAttribute(HTML.CLASS_ATTR, getStyleClass(schedule,
		 * "subtitle"), null); writer.writeText(entry.getSubtitle(), null);
		 * writer.endElement(HTML.SPAN_ELEM); }
		 */
	}
}
