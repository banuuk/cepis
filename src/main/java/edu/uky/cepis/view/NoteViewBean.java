package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;

import org.efs.openreports.objects.MailMessage;

import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.Note;
import edu.uky.cepis.domain.User;



/**
 * @author cawalk4
 *
 */
public class NoteViewBean extends CepisWebView implements  NoteView {
	
	private static final long serialVersionUID = 1L;

	@Override
	public Note findById(long id) {		
		return this.getNoteService().findById(id);
	}

	@Override
	public boolean createNote(Note note) {
		return this.getNoteService().createNote(note);		
	}

	@Override
	public boolean updpateNote(Note note) {
		return this.getNoteService().updpateNote(note);		
	}

	@Override
	public boolean deleteNote(Note note) {
		return this.getNoteService().deleteNote(note);		
	}
	
	@Override
	public boolean sendEmail(MailMessage mail) {
		return this.getEmailService().sendEmail(mail);
	}
	
	public EmailAddress getUKYEmailAddress(User user){
		return this.getEmailAddressService().getUKYEmailAddress(user);
	}

	@Override
	public List<Note> getNotesForDateRangeAndExample(Date selectedStartDate, Date selectedEndDate, Note note) {		
		return this.getNoteService().getNotesForDateRangeAndExample(selectedStartDate, selectedEndDate, note);
	}

	@Override
	public List<Note> getNotesForCurrentUser(User currentUser) {

		return this.getNoteService().getNotesForCurrentUser(currentUser);
	}
	
}