/**
 * 
 */
package edu.uky.cepis.util.global;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import edu.uky.cepis.domain.User;
import edu.uky.cepis.service.UserService;

/**
 * @author Keerti
 */
public class FileUploadBean {

	private ArrayList<File> files = new ArrayList<File>();
	/**
	 * @uml.property name="cepisGlobalComponentConfigurator"
	 * @uml.associationEnd
	 */
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;
	private UserService userService;
	private int uploadsAvailable = 25;
	private boolean autoUpload = true;
	private boolean useFlash = true;

	public int getSize() {
		if (getFiles().size() > 0) {
			return getFiles().size();
		} else {
			return 0;
		}
	}

	public FileUploadBean() {
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(getFiles().get((Integer) object).getData());
	}

	public void listener(UploadEvent event) throws Exception {
		System.out.println("Calling Upload Listener");
		FileOutputStream fos = null;
		UploadItem item = event.getUploadItem();
		System.out.println("File name:" + item.getFileName());
		System.out.println("File :" + item.getData());
		File file = new File();
		file.setLength(item.getData().length);
		file.setName(item.getFileName());
		file.setData(item.getData());
		files.add(file);
		try {
			fos = new FileOutputStream(this.getCepisGlobalComponentConfigurator().getProfileBaseLocation() +"/"+ item.getFileName());
			System.out.println("Writing file: "+this.getCepisGlobalComponentConfigurator().profileBaseLocation +"/"+ item.getFileName());
			fos.write(item.getData());
			String uid = file.getName().substring(0,
					file.getName().length() - 4);
			if (uid.matches("[a-zA-Z]{5}-[0-9]{4}")) {
				User user = this.getUserService().findByUid(uid);
				if (user != null) {
					System.out
					.println("Previous Badge info: "
							+ user.getUsername()+"-"
							+ user.getBadgeHolder());
					if (this.getUserService().updateBadgeInfo(user,  1) != null) {
						System.out
								.println("Badge info updated successfully for the user: "
										+ user.getUsername()+"-"
										+ user.getBadgeHolder());
					} else {
						System.out
								.println("Cannot update badge info for the user: "
										+ user.getUsername());
					}
				} else {
					System.out.println("Cannot find user: " + uid);
				}
			} else {
				System.out.println("Invalid File name ");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException : " + ex);
		} catch (IOException ioe) {
			System.out.println("IOException : " + ioe);
		} finally {
			if (fos != null)
				fos.close();
		}
	}

	public String clearUploadData() {
		files.clear();
		setUploadsAvailable(25);
		return null;
	}

	public long getTimeStamp() {
		return System.currentTimeMillis();
	}

	/**
	 * @return
	 * @uml.property name="files"
	 */
	public ArrayList<File> getFiles() {
		return files;
	}

	/**
	 * @param files
	 * @uml.property name="files"
	 */
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}

	/**
	 * @return
	 * @uml.property name="uploadsAvailable"
	 */
	public int getUploadsAvailable() {
		return uploadsAvailable;
	}

	/**
	 * @param uploadsAvailable
	 * @uml.property name="uploadsAvailable"
	 */
	public void setUploadsAvailable(int uploadsAvailable) {
		this.uploadsAvailable = uploadsAvailable;
	}

	/**
	 * @return
	 * @uml.property name="autoUpload"
	 */
	public boolean isAutoUpload() {
		return autoUpload;
	}

	/**
	 * @param autoUpload
	 * @uml.property name="autoUpload"
	 */
	public void setAutoUpload(boolean autoUpload) {
		this.autoUpload = autoUpload;
	}

	/**
	 * @return
	 * @uml.property name="useFlash"
	 */
	public boolean isUseFlash() {
		return useFlash;
	}

	/**
	 * @param useFlash
	 * @uml.property name="useFlash"
	 */
	public void setUseFlash(boolean useFlash) {
		this.useFlash = useFlash;
	}

	/**
	 * @param cepisGlobalComponentConfigurator
	 *            the cepisGlobalComponentConfigurator to set
	 * @uml.property name="cepisGlobalComponentConfigurator"
	 */
	public void setCepisGlobalComponentConfigurator(
			CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	/**
	 * @return the cepisGlobalComponentConfigurator
	 * @uml.property name="cepisGlobalComponentConfigurator"
	 */
	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

}