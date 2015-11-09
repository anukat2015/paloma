/**
 * 
 */
package com.paloit.paloma;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.paloit.paloma.domain.BusinessEntity;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * @author SLOPESNEVES
 *
 */
public abstract class BusinessEntityServiceImpl<V extends BusinessEntity<W>, W> 
implements BusinessEntityService<V, W> {
	/**
	 * The entity manager
	 */
	@PersistenceContext
	private EntityManager em;
	
	private TypedQuery<V> QUERY_FIND_ALL;
	
	public BusinessEntityServiceImpl() {
		try{
			this.QUERY_FIND_ALL = 
					this.em.createNamedQuery(
							this.findAllQueryName(), 
							this.getEntityClass());
			//TODO Add info logger
		}catch(Exception e){
			//TODO Add error logger
		}
	}

	@Override
	public V create() throws PalomaPersistenceContextException {
		try{
			V entity = this.getEntityClass().newInstance();
			this.em.persist(entity);
			return entity;
		}catch(Exception e){
			String message = this + " fail to create a "
					+ this.getEntityClass();
			e.printStackTrace();
			//TODO Adding error logger
			throw new PalomaPersistenceContextException(message);
		}
		
	}

	@Override
	public List<V> findAll() throws PalomaPersistenceContextException {
		try{
			return this.QUERY_FIND_ALL.getResultList();
		}catch(Exception e){
			String message = this + " fail to find all " + this.getEntityClass();
			//TODO Add error logger
			throw new PalomaPersistenceContextException(message);
		}
	}
	
	/**
	 * Return the find all query to use
	 * @return
	 */
	protected abstract String findAllQueryName();

	@Override
	public V find(W id) throws PalomaPersistenceContextException {
		try{
			return this.em.find(this.getEntityClass(), id);
		}catch(Exception e){
			String message = this + " fail to find "
					+ this.getEntityClass() + " id " + id;
			//TODO Add error logger
			throw new PalomaPersistenceContextException(message);
		}
		
	}

	@Override
	public V update(V entity) throws PalomaPersistenceContextException {
		try{
			entity = this.em.merge(entity);
			//TODO Add debug logger
			return entity;
		}catch(Exception e){
			String message = this + " fail to update " + entity;
			//TODO Add error logger
			throw new PalomaPersistenceContextException(message);
		}
	}

	@Override
	public void delete(V entity) throws PalomaPersistenceContextException {
		try{
			this.em.remove(entity);
			//TODO Add  info logger
		}catch(Exception e){
			String message = this + " fail to update " + entity;
			//TODO Add error logger
			throw new PalomaPersistenceContextException(message);
		}
		
	}
}
