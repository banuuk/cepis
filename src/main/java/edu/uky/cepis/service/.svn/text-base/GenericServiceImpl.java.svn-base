

package edu.uky.cepis.service;

import java.io.Serializable;
import java.util.List;

import edu.uky.cepis.dao.GenericDAO;

/**
 * @author cawalk4
 *
 */
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID>{
	
	private GenericDAO<T, ID> genericDao;

	@Override
	public T findById(long id, Class<T> objectClass) {
		return this.getGenericDao().findById(id, objectClass);
	}

	@Override
	public boolean create(T newInstance) {
		return this.getGenericDao().create(newInstance);
	}

	@Override
	public boolean updpate(T updateInstance) {
		return this.getGenericDao().updpate(updateInstance);
	}

	@Override
	public boolean delete(T entity) {
		return this.getGenericDao().delete(entity);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findByExample(T exampleInstance, Class<T> objectClass) {
		return this.getGenericDao().findByExample(exampleInstance, objectClass);
	}


	public GenericDAO<T, ID> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDAO<T, ID> genericDao) {
		this.genericDao = genericDao;
	}
	

}