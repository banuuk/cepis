/**
 * 
 */
package edu.uky.cepis.util.database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * @author keerthi
 * 
 */
public class DetachedCriteriaUserType implements UserType {

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) {
			return true;
		} else if (x == null || y == null) {
			return false;
		} else {
			return x.equals(y);
		}
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		assert (x != null);
		return x.hashCode();
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet,
	 * java.lang.String[], java.lang.Object)
	 */
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor sessionImplementer, Object owner)
			throws HibernateException, SQLException {
		System.out.println("Calling Null Safe Get " + names[0] + " Length: "
				+ names.length);
		ByteArrayInputStream bais = null;
		ObjectInputStream ins = null;
		DetachedCriteria query = null;
		try {

			bais = new ByteArrayInputStream(rs.getBytes(names[0]));
			ins = new ObjectInputStream(bais);
			query = (DetachedCriteria) ins.readObject();
			System.out.println("Query ::" + query);
			ins.close();

		} catch (Exception e) {
			System.err.println(e);

		}
		return rs.wasNull() ? null : query;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement,
	 * java.lang.Object, int)
	 */
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor sessionImplementer) throws HibernateException,
			SQLException {
		System.out.println("Calling Null Safe Set");

		if (value == null) {
			st.setNull(index, Types.BINARY);
		} else {
			ByteArrayOutputStream bos = null;
			ObjectOutputStream oos = null;
			try {
				bos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(bos);
				oos.writeObject((DetachedCriteria) value);
				oos.flush();
				oos.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] data = bos.toByteArray();
			st.setBytes(index, data);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	@Override
	public Class returnedClass() {
		return byte[].class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.BINARY };
	}

}
