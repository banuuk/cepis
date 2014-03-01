package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;

import org.efs.openreports.objects.MailMessage;

import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.Note;
import edu.uky.cepis.domain.User;

public interface NoteView{
	
	public Note findById(long id);
		
	public boolean createNote(Note note);
	
	public boolean updpateNote(Note note);
	
	public boolean deleteNote(Note note);
	
	public abstract boolean sendEmail(MailMessage mail);
	
	public List<Note> getNotesForDateRangeAndExample(Date selectedStartDate, Date selectedEndDate, Note note);
	
	public List<Note> getNotesForCurrentUser(User currentUser);
	
	public EmailAddress getUKYEmailAddress(User user);
	
}