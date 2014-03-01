package edu.uky.cepis.view;

import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;

public class WhoAmIViewBean extends CepisWebView implements WhoAmIView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WhoAmIViewBean() {

	}

	@Override
	public Role[] getUserRoles(User user) {

		Object[] objs = roleservice.getUserRoles(user).toArray();
		Role[] roles = new Role[objs.length];
		for (int i = 0; i < objs.length; i++) {
			roles[i] = (Role) objs[i];
		}

		return roles;
	}

}
