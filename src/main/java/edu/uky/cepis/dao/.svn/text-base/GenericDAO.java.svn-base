package edu.uky.cepis.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T, ID extends Serializable> {
		
	public T findById(long id, Class<T> objectClass);
	
	public boolean create(T newInstance);
   
	public boolean updpate(T updateInstance);
	
	public boolean delete(T entity);
	
	public List<T> findByExample(T exampleInstance, Class<T> objectClass);
}