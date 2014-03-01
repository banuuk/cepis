

package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.dao.NoteDao;
import edu.uky.cepis.domain.Note;
import edu.uky.cepis.domain.User;

public class NoteServiceImpl implements NoteService{
	
	private NoteDao noteDao;
	
	@Override
	public Note findById(long id) {
		return this.getNoteDao().findById(id);
	}

	@Override
	public boolean createNote(Note note) {
		return this.getNoteDao().createNote(note);
	}

	@Override
	public boolean updpateNote(Note note) {
		return this.getNoteDao().updpateNote(note);
	}

	@Override
	public boolean deleteNote(Note note) {
		return this.getNoteDao().deleteNote(note);
	}

	public NoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	@Override
	public List<Note> getNotesForDateRangeAndExample(Date selectedStartDate, Date selectedEndDate, Note note) {
		return this.noteDao.getNotesForDateRangeAndExample(selectedStartDate, selectedEndDate, note);
	}

	@Override
	public List<Note> getNotesForCurrentUser(User currentUser) {
		return this.getNoteDao().getNotesForCurrentUser(currentUser);
	}
	
}