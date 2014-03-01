package edu.uky.cepis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.efs.openreports.objects.MailMessage;
import org.jfree.util.Log;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.Note;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.view.NoteView;

/**
 * @author cawalk4
 *
 */
@Component
@Scope("session")
public class NoteController extends AbstractController {
	
	private static final long serialVersionUID = 1L;
	
	@Resource(name="noteBean")
	private NoteView noteBean;
	
	private List<Note> notes;	
	
	private Note selectedNote;	
	
	private List<User> selectedWSUsersList = new ArrayList<User>(0);	
	
	private boolean saveNote;	
	
	private Boolean noteSaved;
	
	private boolean sendEmail;
	
	private Boolean emailSent;	
	
	private String category; //Note Category
	
	private Boolean hideNote; //Note is hidden from user
	
	private String noteContent;	
	
	private String emailFrom;
	
	private String emailSubject;
	
	private String emailContent;
	
	private boolean noReply;
	
	private boolean ccEnteredBy;	
	
	private boolean saveEmail;	
	
	private Date fromDate;
	
	private Date toDate;
	
	private String enteredBy;	
	
	private HtmlExtendedDataTable noteTable;
	
	private SimpleSelection selection = new SimpleSelection();
	
	private ExtendedTableDataModel<Note> noteDataModel;
	
	private Object tableState;
	
	private static String TEB166_EMAIL = "teb166@coe.uky.edu";
	private static String NOREPLY_EMAIL= "noreply@coe.uky.edu";
	
	 private static String NOTE = "Note: ";
	
	private static String ERROR_NO_EMAIL_SENT = "No email on file for current user! ";
	private static String ERROR_NO_EMAIL_SENT_USER = "No UK email email on file for user: ";
	private static String ERROR_NOTE_CREATION = "Error during note creation. Please contact an administratior!";
	private static String ERROR_NOTE_DELETE = "ERROR ON DELETE NOTE: ";
	private static String ERROR_SELECT_NOTE_OR_EMAIL = "Please select 'Create Note' or 'Send Email' or Both.";
		
	private static String SUCCESS_DELETE = " successfully deleted.";
	private static String SUCCESS_EDIT = " successfully edited.";
	private static String SUCCESS_EMAIL_SENT = "Email sent successfully to user(s) on: ";
	private static String SUCCESS_NOTE_CREATED = "New note created.";
	
	
	
	@PostConstruct
	public void initNotes() {
		//Load notes for current user
		Note currentUserNote = new Note();
		currentUserNote.setEnteredBy(this.getUserManager().getUser().getFullName());
		setNotes(getNoteBean().getNotesForDateRangeAndExample(null, null, currentUserNote));
	}
	
	public void go(){
		Note newNote = new Note();
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(isSendEmail() || isSaveNote()){
			newNote.setCategory(getCategory());
			newNote.setEnteredBy(this.getUserManager().getUser().getFullName());
			newNote.setEmailSubject(getEmailSubject());
			newNote.setEmailContent(getEmailContent());
			newNote.setNoteContent(getNoteContent());		
			newNote.setCreationDate(new Date());
			newNote.setEmailSent(isSendEmail());
			newNote.setEmailSaved(isSaveEmail());
			newNote.setNoteSaved(isSaveNote());
			newNote.setNoteHidden(getHideNote());
												
			if(isSaveNote()){			
				createNote(newNote);
			}
			if(isSendEmail()){
				sendEmail(newNote);
			}		
			clear();
			initNotes();
		}else{
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary(ERROR_SELECT_NOTE_OR_EMAIL);
			context.addMessage("msg", message);
		}	
	}
	
	private void createNote(Note newNote){		
		FacesContext context = FacesContext.getCurrentInstance();
							
		for(User selectedUser : selectedWSUsersList){			
			newNote.getStudents().add(selectedUser);				
		}			
		
		if(getNoteBean().createNote(newNote)){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(SUCCESS_NOTE_CREATED + new Date());
			context.addMessage("msg", message);
		}else{
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary(ERROR_NOTE_CREATION);
			context.addMessage("msg", message);
		}		
	}
	
	private void sendEmail(Note newEmail){		
		FacesContext context = FacesContext.getCurrentInstance();		
		MailMessage mail = new MailMessage();
		
		EmailAddress senderEmailAddress = new EmailAddress();
		EmailAddress recipientEmailAddress = new EmailAddress();
		
		//****************Set Email Content****************
		mail.setText(getEmailContent());
		//****************Set Email Subject****************
		mail.setSubject(getEmailSubject());		
		//****************Set Email Recipients****************
		for(User selectedUser : selectedWSUsersList){	
			
			EmailAddress selectedUserUkyEmail = this.getNoteBean().getUKYEmailAddress(selectedUser);	
			
			if(selectedUserUkyEmail != null){				
				Log.debug("Adding Email Recepient: " + selectedUser.getUid());				
				recipientEmailAddress = selectedUserUkyEmail;
				mail.addRecepient("TO:" + recipientEmailAddress.getAddress());	
			}else{
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary(ERROR_NO_EMAIL_SENT_USER + selectedUser.getFullName());
			}
		}		
		//****************Set Email Sender****************
		senderEmailAddress = this.getNoteBean().getUKYEmailAddress(this.getUserManager().getUser());
		if(getEmailFrom().equals("1")){			
			if(senderEmailAddress.getAddress() != null){
				mail.setSender(senderEmailAddress.getAddress());
			}else{
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary(ERROR_NO_EMAIL_SENT + new Date());
				context.addMessage("msg", message);
				return;
			}
		}else if(getEmailFrom().equals("0")){
			mail.setSender(TEB166_EMAIL);
		}				
		//****************Set Email Bounce****************
		if(isNoReply()){
			mail.setBounceAddress(NOREPLY_EMAIL);
		}else{
			mail.setBounceAddress(senderEmailAddress.getAddress());
		}
		//****************Set CC Sender****************
		if(isCcEnteredBy()){
			mail.addRecepient("CC:" + senderEmailAddress.getAddress());
		}
		//****************Send E-Mail****************
		if(this.getNoteBean().sendEmail(mail)){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(SUCCESS_EMAIL_SENT + new Date());
			context.addMessage("msg", message);
		}
	}		
		
	public void search(){				
		
		Note note = new Note();
		setNotes(new ArrayList<Note>());
		note.setEmailSent(getEmailSent());
		note.setNoteHidden(getHideNote());
		note.setCategory(getCategory());
		note.setEnteredBy(getEnteredBy());
		List<Note> retrievedNotes = getNoteBean().getNotesForDateRangeAndExample(getFromDate(), getToDate(), note);			
		
		for(Note selectedNote : retrievedNotes){			
			if(selectedNote.getNoteHidden() == true){
				System.out.println(this.getUserManager().getUser().getFullName());
				if(selectedNote.getEnteredBy().equals(this.getUserManager().getUser().getFullName())){
					getNotes().add(selectedNote);					
				}				
			}else if(selectedNote.getNoteHidden() == false){
				getNotes().add(selectedNote);
			}			
		}		
		clear();		
	}
	
	public ExtendedTableDataModel<Note> getSelectedNotesDataModel() {
		System.out.println("getSelectedNotesDataModel()");
					
		this.setSelection(new SimpleSelection());
		this.setNoteDataModel(new ExtendedTableDataModel<Note>(
				new DataProvider<Note>() {

					private static final long serialVersionUID = 5054087821033164847L;

					public Note getItemByKey(Object key) {
						for (Note a : getNotes()) {
							if (key.equals(getKey(a))) {
								return a;
							}
						}
						return null;
					}
					public List<Note> getItemsByRange(int firstRow,
							int endRow) {
						return getNotes().subList(firstRow, endRow);
					}
					public Object getKey(Note item) {
						return item.getId();
					}
					public int getRowCount() {
						return getNotes().size();
					}
				}));
				getNoteDataModel().setRowIndex(-1);

		return this.getNoteDataModel();
	}
	
	public void takeSelection() {
		Object key = null;
		if(this.getNoteTable() != null){
			key = this.getNoteTable().getActiveRowKey();
		}		
			
		Note note = findNoteByID((long)key);
		if (note != null) {
			setSelectedNote(getNoteBean().findById(note.getId()));			
		}		
	}
	
	private Note findNoteByID(long key) {
		for (Note item : notes) {
			if (key == item.getId()) {
				return item;
			}
		}
		return null;
	}
	
	public void editNote(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(getNoteBean().updpateNote(getSelectedNote())){			
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(NOTE + getSelectedNote().getId() + SUCCESS_EDIT);
			context.addMessage("msg", message);
			initNotes();
		}else{
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("ERROR ON EDIT NOTE: " + getSelectedNote().getId());
			context.addMessage("msg", message);
		}
	}
	
	public void deleteNote(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(getNoteBean().deleteNote(getSelectedNote())){
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(NOTE + getSelectedNote().getId() + SUCCESS_DELETE);
			context.addMessage("msg", message);
			initNotes();
		}else{
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary(ERROR_NOTE_DELETE + getSelectedNote().getId());
			context.addMessage("msg", message);
		}
	}
	
	public void cloneNote(){
		if(getSelectedNote().getEmailSaved() == true){
			setSendEmail(true);
			setEmailContent(getSelectedNote().getEmailContent());
		}else{
			setSendEmail(false);
			setEmailContent("");
		}
		if(getSelectedNote().getNoteSaved() == true){
			setSaveNote(true);
			setNoteContent(getSelectedNote().getNoteContent());
		}else{
			setSaveNote(false);
			setNoteContent("");
		}
	}
	
	private void clear(){
		setHideNote(null);
		setEmailSent(null);
		setCategory(null);
		setEmailContent("");
		setNoteContent("");
		setSendEmail(false);
		setSaveNote(false);
		setEmailSubject(" ");
	}
	
	
	/* **************************GETTERS AND SETTERS************************** */

	public NoteView getNoteBean() {
		return noteBean;
	}

	public void setNoteBean(NoteView noteBean) {
		this.noteBean = noteBean;
	}

	public List<Note> getNotes() {
		if(this.notes == null){
			setNotes(new ArrayList<Note>());
		}
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note getSelectedNote() {
		if(this.selectedNote == null){
			setSelectedNote(new Note());
		}
		return selectedNote;
	}

	public void setSelectedNote(Note selectedNote) {
		this.selectedNote = selectedNote;
	}

	public List<User> getSelectedWSUsersList() {
		return selectedWSUsersList;
	}

	public void setSelectedWSUsersList(List<User> selectedWSUsersList) {
		this.selectedWSUsersList = selectedWSUsersList;
	}

	public boolean isSaveNote() {
		return saveNote;
	}

	public void setSaveNote(boolean saveNote) {
		this.saveNote = saveNote;
	}

	public Boolean getNoteSaved() {
		return noteSaved;
	}

	public void setNoteSaved(Boolean noteSaved) {
		this.noteSaved = noteSaved;
	}

	public boolean isSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(boolean sendEmail) {
		this.sendEmail = sendEmail;
	}

	public Boolean getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHideNoteString() {
		return " ";
	}

	public void setHideNoteString(String hideNoteString) {
		if(hideNoteString.equals("YES")){
			setHideNote(true);
		}else if(hideNoteString.equals("NO")){
			setHideNote(false);
		}
	}

	public Boolean getHideNote() {
		return hideNote;
	}

	public void setHideNote(Boolean hideNote) {
		this.hideNote = hideNote;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public boolean isNoReply() {
		return noReply;
	}

	public void setNoReply(boolean noReply) {
		this.noReply = noReply;
	}

	public boolean isCcEnteredBy() {
		return ccEnteredBy;
	}

	public void setCcEnteredBy(boolean ccEnteredBy) {
		this.ccEnteredBy = ccEnteredBy;
	}

	public boolean isSaveEmail() {
		return saveEmail;
	}

	public void setSaveEmail(boolean saveEmail) {
		this.saveEmail = saveEmail;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getEmailSentString() {
		return " ";
	}

	public void setEmailSentString(String emailSentString) {
		if(emailSentString.equals("YES")){
			setEmailSent(true);
		}else if(emailSentString.equals("NO")){
			setEmailSent(false);
		}
	}

	public HtmlExtendedDataTable getNoteTable() {
		return noteTable;
	}

	public void setNoteTable(HtmlExtendedDataTable noteTable) {
		this.noteTable = noteTable;
	}

	public SimpleSelection getSelection() {
		return selection;
	}

	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}

	public ExtendedTableDataModel<Note> getNoteDataModel() {
		return noteDataModel;
	}

	public void setNoteDataModel(ExtendedTableDataModel<Note> noteDataModel) {
		this.noteDataModel = noteDataModel;
	}

	public Object getTableState() {
		return tableState;
	}

	public void setTableState(Object tableState) {
		this.tableState = tableState;
	}
	
	
}