/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface AdvisorService {
	public Advisor findAdvisorByUser(User user);

	public Advisor findAdvisorByUser(String userid);

	public Advisor findAdvisorByID(long advisorid);

	public List<Advisor> getAdvisorList();

	public boolean addAdvisorWrapToUser(User user);

	public boolean removeAdvisorWrapFromUser(User user);

	public boolean updateAdvisor(Advisor advisor, String shortDesc);

	public boolean isAdvisor(User user);

	public boolean removeAdvisorWrapFromUser(Advisor advisor);
	
	public boolean updateAdvisorStatus(Advisor advisor, String status,
			Address officeLocation);
	public User getUser(Advisor advisor);
	
	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup, Advisor advisor);
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor);
	public boolean deleteAdvisorGroup(AdvisorGroup advisorGroup);
	public AdvisorGroup updateAdvisorGroup(AdvisorGroup advisorGroup, String name,
			String shortDesc);
	public AdvisorGroup createAdvisorGroup(String name, String shortDesc);
	public List<AdvisorGroup> getAdvisorGroupList();
}
