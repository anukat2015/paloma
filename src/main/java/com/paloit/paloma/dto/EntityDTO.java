/**
 * 
 */
package com.paloit.paloma.dto;

import java.io.Serializable;

/**
 * @author SLOPESNEVES
 * The root DTO entity
 */
public abstract class EntityDTO<T extends Serializable> {

	/**
	 * The id
	 */
	private T id;

	/**
	 * @return the id
	 */
	public T getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(T id) {
		this.id = id;
	}
	
	/**
	 * @return The textual representation of the instance
	 */
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " #" + this.getId();
	}

}
