package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import edu.uky.cepis.domain.Note;
import edu.uky.cepis.domain.User;


/**
 * @author cawalk4
 *
 */
public class NoteDaoImpl implements NoteDao{
	
	private static Logger log = Logger.getLogger(NoteDaoImpl.class.getName());
	private SessionFactory sessionFactory;

	@Override
	public Note findById(long id) {
		log.info("Entered NoteDaoImpl findById(" + id +")");
		Note result = (Note) getSessionFactory().getCurrentSession().load(Note.class, id);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}			
	@Override
	public boolean createNote(Note note) {
		log.info("Entered NoteDaoImpl createNote()");
		if(note == null){
			return false;
		}
		getSessionFactory().getCurrentSession().saveOrUpdate(note);
		return true;		
	}
	@Override
	public boolean updpateNote(Note note) {
		log.info("Entered NoteDaoImpl updpateNote()");
		if(note == null){
			return false;
		}
		getSessionFactory().getCurrentSession().update(note);	
		return true;
	}
	@Override
	public boolean deleteNote(Note note) {
		log.info("Entered NoteDaoImpl deleteNote()");
		if(note == null){
			return false;
		}
		getSessionFactory().getCurrentSession().delete(note);
		return true;
		
	}	
	@Override
	@SuppressWarnings("unchecked")
	public List<Note> getNotesForDateRangeAndExample(Date selectedStartDate, Date selectedEndDate, Note note) {		
		log.info("Entered NoteDaoImpl getNotesForDateRange()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(Note.class);
						
		if(selectedStartDate != null){
			searchCriteria.add(Restrictions.ge("creationDate", selectedStartDate));
		}
		if(selectedEndDate != null){
			searchCriteria.add(Restrictions.le("creationDate", selectedEndDate));
		}
		if(note != null){
			if(note.getNoteHidden() != null){
				searchCriteria.add(Restrictions.eq("noteHidden", note.getNoteHidden()));
			}
			if(note.getEmailSaved() != null){
				searchCriteria.add(Restrictions.eq("emailSaved", note.getEmailSaved()));
			}
			if(note.getNoteSaved() != null){
				searchCriteria.add(Restrictions.eq("noteSaved", note.getNoteSaved()));
			}
			if(note.getEmailSent() != null){
				searchCriteria.add(Restrictions.eq("emailSent", note.getEmailSent()));
			}
			if(note.getEnteredBy() != null){
				searchCriteria.add(Restrictions.like("enteredBy", note.getEnteredBy() + "%"));
			}
			if(note.getCategory() != null){
				searchCriteria.add(Restrictions.like("category", note.getCategory() + "%"));
			}
		}
		if(searchCriteria != null){
			searchCriteria.addOrder(Order.desc("id"));
			return (List<Note>)searchCriteria.list();			
		}
		else{ 
			return null;
		}			
	}	
	@SuppressWarnings("unchecked")
	public List<Note> getNotesForCurrentUser(User currentUser){
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(Note.class);
		searchCriteria.createAlias("students", "student");
		searchCriteria.add(Restrictions.eq("student.uid", currentUser.getUid() ));				
		List<Note> notesForCurrentUser = (List<Note>)searchCriteria.list();
		
		return notesForCurrentUser;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}