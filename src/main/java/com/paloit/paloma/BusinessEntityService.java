/**
 * 
 */
package com.paloit.paloma;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paloit.paloma.domain.BusinessEntity;
import com.paloit.paloma.utils.exception.PalomaPersistenceContextException;

/**
 * @author DTRANG, SLOPES
 * @version 0.0.1
 * The root class to extends by business
 * entity service
 * @param T The business entity class
 * @param U The business entity id class
 *
 */
public interface BusinessEntityService<T extends BusinessEntity<U>
, U extends Serializable, V extends JpaRepository<T, U>> {
	/**
	 * Create a business entity
	 * @return The created business entity
	 * @throws PalomaPersistenceContextException
	 */
	T create() throws PalomaPersistenceContextException;
	/**
	 * Find all business entities
	 * @return The business entities
	 * @throws PalomaPersistenceContextException
	 */
	List<T> findAll() throws PalomaPersistenceContextException;
	/**
	 * Find the business entity matching the
	 * id given in parameter
	 * @param id The id
	 * @return The business entity
	 * @throws PalomaPersistenceContextException
	 */
	T find(U id) throws PalomaPersistenceContextException;
	/**
	 * Update business entity given in parameter
	 * in the persistence context
	 * @param entity The business entity
	 * @return The updated business entity
	 */
	T update(T entity) throws PalomaPersistenceContextException;
	/**
	 * Delete the business entity given in parameter
	 * of the persistence context
	 * @param entity
	 * @throws PalomaPersistenceContextException
	 */
	void delete(T entity) throws PalomaPersistenceContextException;

	/**
	 * Return the entity class
	 * @return The class
	 */
	Class<T> getEntityClass();

	/**
	 * 
	 * @return The repository used to manage entities in persistence context
	 */
	V getRepository();
}
