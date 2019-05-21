package org.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {

	protected EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public E create(E entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	public E update(E entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;

	}

	public E find(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);
		if (entity != null) {
			entityManager.refresh(entity);

		}
		return entity;
	}

	public void delete(Class<E> type, Object id) {
		entityManager.getTransaction().begin();
		Object refrence = entityManager.getReference(type, id);
		entityManager.remove(refrence);
		entityManager.getTransaction().commit();
	}

	public List<E> findwithNamedQuery(String queryname) {
		Query query = entityManager.createNamedQuery(queryname);
		return query.getResultList();
	}
	
	public List<E> findwithNamedQuery(String queryname,String paramName, Object paramValue){
		Query query = entityManager.createNamedQuery(queryname);
		query.setParameter(paramName, paramValue);
		return query.getResultList();
	}
	
	public List<E> findwithNamedQuery(String queryname, Map<String, Object> parameter){
		
		Query query = entityManager.createNamedQuery(queryname);
		Set<Entry<String,Object>> setParameter = parameter.entrySet();
		for (Entry<String, Object> entry : setParameter) {
			query.setParameter(entry.getKey(), entry.getValue());
			
			
		}
		
		return query.getResultList();
	}


	public long countwithNamedQuery(String queryname) {
		Query query = entityManager.createNamedQuery(queryname);
		return (long) query.getSingleResult();
	}

}
