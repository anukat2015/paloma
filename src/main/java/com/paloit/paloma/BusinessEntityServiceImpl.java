/**
 * 
 */
package com.paloit.paloma;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paloit.paloma.domain.BusinessEntity;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * @author SLOPESNEVES
 *
 */
public abstract class BusinessEntityServiceImpl<V extends BusinessEntity<W>, 
 W extends Serializable> 
implements BusinessEntityService<V, W> {
	/**
	 * The entity manager
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	public V create() throws PalomaPersistenceContextException {
		try{
			V entity = this.getEntityClass().newInstance();
			entity = this.getRepository().save(entity);
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
			return this.getRepository().findAll();
		}catch(Exception e){
			String message = this + " fail to find all " + this.getEntityClass();
			//TODO Add error logger
			throw new PalomaPersistenceContextException(message);
		}
	}

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
	
	public abstract JpaRepository<V, W> getRepository();
}
