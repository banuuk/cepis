package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.domain.Note;
import edu.uky.cepis.domain.User;


/**
 * @author cawalk4
 *
 */
public interface NoteDao  {
	
	public Note findById(long id);
		
	public boolean createNote(Note note);
	
	public boolean updpateNote(Note note);
	
	public boolean deleteNote(Note note);

	public List<Note> getNotesForDateRangeAndExample(Date selectedStartDate, Date selectedEndDate, Note note);
	
	public List<Note> getNotesForCurrentUser(User currentUser);
	
}