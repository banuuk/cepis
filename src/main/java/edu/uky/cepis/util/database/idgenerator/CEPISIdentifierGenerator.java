/**
 * 
 */
package edu.uky.cepis.util.database.idgenerator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.QueryParameters;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public class CEPISIdentifierGenerator implements IdentifierGenerator,
		Configurable {
	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.
	 * SessionImplementor, java.lang.Object)
	 */
	@Override
	public Serializable generate(
			org.hibernate.engine.spi.SessionImplementor session, Object object)
			throws HibernateException {
		System.out.println("Calling genere cepis uid");
		User user = (User) object;
		return generateCEPISPrimaryKey(session, user);
	}

	private Serializable generateCEPISPrimaryKey(SessionImplementor session,
			User user) throws HibernateException {
		String uid = "";
		if (user.getlName() == null || user.getfName() == null
				|| user.getlName().equals("") || user.getfName().equals("")) {
			throw new HibernateException(
					"First Name or Last Name of the User is null/empty.");
		}
		// Add First 3 characters of Last Name
		int len = user.getlName().length();
		if (len >= 3) {
			uid += user.getlName().substring(0, 3).toUpperCase();
		} else {
			uid += user.getlName().substring(0, len).toUpperCase();
			for (int i = len; i <= 3; i++) {
				uid += "X";
			}
		}
		// Add First 1 character of First Name
		uid += user.getfName().substring(0, 1).toUpperCase();

		// Add First 1 character of Middle Name
		if (user.getmName() != null && user.getmName().length() > 0) {
			uid += user.getmName().substring(0, 1).toUpperCase();
		} else {
			uid += "X";
		}
		uid += "-";
		uid += (Calendar.getInstance().get(Calendar.YEAR) % 100);

		String sql = "select a from User a where a.uid like '" + uid + "%'";
		List<User> users = session.list(sql, new QueryParameters());
		if (users.size() < 1) {
			uid += String.format("%02d", 1);
			return uid;
		}
		int max = 0;
		Iterator<User> iter = users.iterator();
		User duplicateUser = null;
		String temp = null;
		int num = 0;
		while (iter.hasNext()) {
			duplicateUser= iter.next();
			// Get last two characters of the id
			len = duplicateUser.getUid().length();
			temp = duplicateUser.getUid().substring(len-2);
			System.out.println(temp);
			// convert it to number
			num = Integer.parseInt(temp);
			// find the maximum value
			if(num > max){
				max = num;
			}
		}
		// Add 1 to the max value
		max++;
		uid += String.format("%02d", max);
		return uid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.id.Configurable#configure(org.hibernate.type.Type,
	 * java.util.Properties, org.hibernate.dialect.Dialect)
	 */
	@Override
	public void configure(Type type, Properties params, Dialect d)
			throws MappingException {

	}


}
