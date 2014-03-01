package edu.uky.cepis.service;

import java.io.Serializable;
import java.util.List;



/**
 * @author cawalk4
 *
 */
public interface GenericService<T, ID extends Serializable> {
	
	public T findById(long id, Class<T> objectClass);
	
	public boolean create(T newInstance);
   
	public boolean updpate(T updateInstance);
	
	public boolean delete(T entity);
	
	public List<T> findByExample(T exampleInstance, Class<T> objectClass);
	
}