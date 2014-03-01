/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;

/**
 * @author keerthi
 * 
 */
public interface AdvisorDao {
	/**
	 * 
	 * Add the given {@link Advisor} to the {@link AdvisorGroup}.
	 * 
	 * @param advisorGroup
	 * @param advisor
	 * @return
	 */
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor);

	/**
	 * Add {@link Advisor} wrap to the input {@link User} object.
	 * 
	 * @param user
	 * @return
	 */
	public boolean addAdvisorWrapToUser(User user);

	/**
	 * 
	 * Add a new {@link AdvisorGroup}.
	 * 
	 * @param name
	 * @param shortDesc
	 * @return
	 */
	public AdvisorGroup createAdvisorGroup(String name, String shortDesc);

	/**
	 * 
	 * Delete the given {@link AdvisorGroup} object.
	 * 
	 * @param advisorGroup
	 * @return
	 */
	public boolean deleteAdvisorGroup(AdvisorGroup advisorGroup);

	/**
	 * Find advisor by id of type long
	 * 
	 * @param advisorid
	 * @return
	 */
	public Advisor findAdvisorByID(long advisorid);

	/**
	 * Find an {@link Advisor} object from the given userid of the {@link User}
	 * object.
	 * 
	 * @param userid
	 * @return
	 */
	public Advisor findAdvisorByUser(String userid);

	/**
	 * Find an advisor using the {@link User} object
	 * 
	 * @param user
	 * @return {@link Advisor}
	 */
	public Advisor findAdvisorByUser(User user);

	/**
	 * Get the list of {@link AdvisorGroup} objects.<br>
	 * Used by the {@link CEPISGlobalComponentConfigurator} object to preload
	 * list fields.
	 * 
	 * @return
	 */
	public List<AdvisorGroup> getAdvisorGroupList();

	/**
	 * Used by {@link CEPISGlobalComponentConfigurator} to preload the advisor
	 * list.
	 * 
	 * @return List<Advisor>
	 */
	public List<Advisor> getAdvisorList();

	/**
	 * 
	 * Get {@link User} object from the {@link Advisor} object.
	 * 
	 * @param advisor
	 * @return
	 */
	public User getUser(Advisor advisor);

	/**
	 * Check whether the given {@link User} object is an {@link Advisor}.
	 * 
	 * @param user
	 * @return
	 */
	public boolean isAdvisor(User user);

	/**
	 * 
	 * Remove the given {@link Advisor} from the {@link AdvisorGroup}.
	 * 
	 * @param advisorGroup
	 * @param advisor
	 * @return
	 */
	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup,
			Advisor advisor);

	/**
	 * Remove {@link Advisor} wrap from the given {@link Advisor} object.
	 * 
	 * @param advisor
	 * @return
	 */
	public boolean removeAdvisorWrapFromUser(Advisor advisor);

	/**
	 * Remove {@link Advisor} wrap from the input {@link User} object.
	 * 
	 * @param user
	 * @return
	 */
	public boolean removeAdvisorWrapFromUser(User user);

	/**
	 * Update the given {@link Advisor} object.
	 * 
	 * @param advisor
	 * @param shortDesc
	 * @return
	 */
	public boolean updateAdvisor(Advisor advisor, String shortDesc);

	/**
	 * 
	 * Update the given {@link AdvisorGroup} object.
	 * 
	 * @param advisorGroup
	 * @param name
	 * @param shortDesc
	 * @return
	 */
	public AdvisorGroup updateAdvisorGroup(AdvisorGroup advisorGroup,
			String name, String shortDesc);

	/**
	 * 
	 * Update the {@link Advisor} object.<br>
	 * <b>status:</b> ACTIVE, INACTIVE<br>
	 * <b>officeLocation:</b> Valid {@link Address} object with the type
	 * "OFFICE".
	 * 
	 * @param advisor
	 * @param status
	 * @param officeLocation
	 * @return
	 */
	public boolean updateAdvisorStatus(Advisor advisor, String status,
			Address officeLocation);

}
