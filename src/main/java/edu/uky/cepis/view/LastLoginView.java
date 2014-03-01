/**
 * 
 */
package edu.uky.cepis.view;

import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 *
 */
public interface LastLoginView {

	IPAddress[] getIpAddress(User user);
	LastLogin[] getLastLogin(User user);

}
