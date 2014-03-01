package edu.uky.cepis.view;

import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;


public class LastLoginViewBean extends CepisWebView implements LastLoginView {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LastLoginViewBean(){
		
	}
	



	@Override
	public IPAddress[] getIpAddress(User user) {
		
	
		Object[] objs = this.getIpAddressService().getUserIPAddressInfo(user).toArray();
		IPAddress[] ips = new IPAddress[objs.length];
		for(int i=0;i< objs.length;i++){
			ips[i]= (IPAddress)objs[i];
		}
		
		return ips;
	}

	@Override
	public LastLogin[] getLastLogin(User user) {
	
		
		Object[] objs = this.getLastLoginService().getUserLastLoginInfo(user).toArray();
		LastLogin[] lastLogins = new LastLogin[objs.length];
		for(int i=0;i< objs.length;i++){
			lastLogins[i]= (LastLogin)objs[i];
		}
		
		return lastLogins;
	}
}
