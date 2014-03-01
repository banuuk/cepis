/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public class PhoneDaoImpl implements PhoneDao {

	private static Logger log = Logger.getLogger(PhoneDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneDao#findById(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Phone findById(long id) {
		List<Phone> phones = new ArrayList<Phone>(0);

		String hql = "select a from Phone a where a.id = " + id;
		phones = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (phones.size() > 0)
			return phones.get(0);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneDao#findByPhoneNo(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Phone findByPhoneNo(String phoneNo) {
		List<Phone> phones = new ArrayList<Phone>(0);

		String hql = "select a from Phone a where a.phoneNo like '" + phoneNo
				+ "'";
		phones = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (phones.size() > 0)
			return phones.get(0);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneDao#findByPhoneNoAndExt(java.lang.String,
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Phone findByPhoneNoAndExt(String phoneNo, String ext) {
		List<Phone> phones = new ArrayList<Phone>(0);

		String hql = "select a from Phone a where a.phoneNo like '" + phoneNo
				+ "' AND a.ext like '" + ext + "'";
		phones = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (phones.size() > 0)
			return phones.get(0);
		return null;
	}

	public Phone findByPhoneNo(User user, String phoneNo, String phoneType) {

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		Set<Phone> phones = newuser.getPhoneNumbers();
		Iterator<Phone> iter = phones.iterator();
		while (iter.hasNext()) {
			Phone phone = iter.next();
			if (phone.getPhoneNo().equals(phoneNo)
					&& phone.getPhoneType().getCode().equals(phoneType)) {
				return phone;
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean addPhoneToUser(User user, String phoneNo, String ext,
			String memo, PhoneType phoneType) {
		if (user == null) {
			return false;
		}

		if (findByPhoneNo(user, phoneNo, phoneType.getCode()) != null) {
			// Duplicate phone exist
			System.out
					.println("Duplicate Phone Number available for this user");
			return false;
		}
		Phone phone = new Phone(phoneNo, ext, memo, phoneType);
		if (phone == null) {
			System.out.println("Cannot create phone number");
			return false;
		}
		if (!this.savePhone(phone)) {
			return false;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		Set<Phone> phoneNos = newuser.getPhoneNumbers();
		phoneNos.add(phone);
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.PhoneDao#removePhoneFromUser(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Phone)
	 */
	@Override
	public boolean removePhoneFromUser(User user, Phone phone) {
		if (user == null) {
			return false;
		}
		if (phone == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Phone newphone = (Phone) this.sessionFactory.getCurrentSession().load(
				Phone.class, phone.getId());
		if (newphone == null) {
			return false;
		}
		Set<Phone> phoneNos = newuser.getPhoneNumbers();
		if (phoneNos.contains(newphone)) {
			phoneNos.remove(newphone);
			this.sessionFactory.getCurrentSession().delete(phone);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneDao#updatePhone(edu.uky.cepis.domain.Phone,
	 * java.lang.String, java.lang.String, java.lang.String,
	 * edu.uky.cepis.domain.PhoneType)
	 */
	@Override
	public Phone updatePhone(User user, Phone phone, String phoneNo,
			String ext, String memo, PhoneType phoneType) {
		if (user == null) {
			return null;
		}
		if (phone == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Phone newphone = (Phone) this.sessionFactory.getCurrentSession().load(
				Phone.class, phone.getId());
		if (newphone == null) {
			return null;
		}
		if (!newuser.getPhoneNumbers().contains(newphone)) {
			return null;
		}
		newphone.setPhoneNo(phoneNo);
		newphone.setExt(ext);
		newphone.setMemo(memo);
		newphone.setPhoneType(phoneType);
		newphone.setLastEdit(new Date());
		this.savePhone(newphone);
		return newphone;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneDao#savePhone(edu.uky.cepis.domain.Phone)
	 */
	@Override
	public boolean savePhone(Phone phone) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(phone);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> getPhoneList(User user) {
		List<Phone> phoneNumbers = new ArrayList<Phone>(0);
		if (user == null) {
			return phoneNumbers;
		}

		String hql = "select b from  edu.uky.cepis.domain.User a join a.phoneNumbers b  where a.uid like '"
				+ user.getUid() + "' order by b.id";
		phoneNumbers = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return phoneNumbers;
	}

}
