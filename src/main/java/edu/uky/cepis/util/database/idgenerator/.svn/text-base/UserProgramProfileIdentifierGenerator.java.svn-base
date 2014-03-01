/**
 * 
 */
package edu.uky.cepis.util.database.idgenerator;

import java.io.Serializable;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;
import edu.uky.cepis.domain.UserProgramProfile;

/**
 * @author keerthi
 * 
 */
public class UserProgramProfileIdentifierGenerator implements
		IdentifierGenerator, Configurable {
	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.
	 * SessionImplementor, java.lang.Object)
	 */
	@Override
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		System.out.println("Calling get userprogram profile id generator");
		UserProgramProfile userProgramProfile = (UserProgramProfile) object;
		System.out.println(userProgramProfile.getUserprogramprofileid());
		return userProgramProfile.getUserprogramprofileid();
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
