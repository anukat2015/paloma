/**
 * 
 */
package com.paloit.paloma;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.BusinessEntity;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * @author SLOPESNEVES
 * Root entity service
 *
 */
@Service
@Transactional
public abstract class BusinessEntityServiceImpl<V extends BusinessEntity<W>, 
W extends Serializable, X extends JpaRepository<V, W>> 
implements BusinessEntityService<V, W, X> {
	@Autowired
	private LogService logService;

	@Override
	public V create() throws PalomaPersistenceContextException {
		try{
			V entity = this.getEntityClass().newInstance();
			this.getLogger().info("Success save " + entity + " in the persistence context");
			return entity;
		}catch(Exception e){
			String message = "Fail to create a "
					+ this.getEntityClass();
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}
	}

	@Override
	public List<V> findAll() throws PalomaPersistenceContextException {
		try{
			return this.findAllQuery();
		}catch(Exception e){
			String message = "Fail to find all " 
					+ this.getEntityClass().getSimpleName();
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}
	}

	@Override
	public V find(W id) throws PalomaPersistenceContextException {
		V entity = null;
		try{
			entity = this.getRepository().findOne(id);
			this.getLogger().debug("Success to find " + entity);
			return entity;
		}catch(Exception e){
			String message = this + " fail to find "
					+ this.getEntityClass() + " id " + id;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}

	}

	@Override
	public V update(V entity) throws PalomaPersistenceContextException {
		try{
			entity = this.getRepository().saveAndFlush(entity);
			this.getLogger().debug("Success to update " + entity);
			return entity;
		}catch(Exception e){
			String message = "Fail to update " + entity;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}
	}

	@Override
	public void delete(V entity) throws PalomaPersistenceContextException {
		try{
			this.getRepository().delete(entity);
			this.getLogger().info(this + " success");
		}catch(Exception e){
			String message = "Fail to update " + entity;
			this.getLogger().error(message, e);
			throw new PalomaPersistenceContextException(message);
		}

	}

	public abstract X getRepository();

	/**
	 * Return the logger
	 */
	protected Logger getLogger(){
		return this.logService.getLogger();
	}

	/**
	 * @return Textual informations of the instance
	 */
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	/**
	 * Query used to find all entities
	 * @return The entities
	 */
	protected List<V> findAllQuery(){
		return this.getRepository().findAll();
	}
}
