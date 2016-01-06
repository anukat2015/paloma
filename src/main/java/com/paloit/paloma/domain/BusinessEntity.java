/**
 * 
 */
package com.paloit.paloma.domain;

import java.io.Serializable;

import javax.persistence.Version;

/**
 * @author DTRANG, SLOPES
 * The root class used by business entities
 * @param V The type of the id
 *
 */
public abstract class BusinessEntity<V extends Serializable> implements Serializable {
	

	/**
	 * The generated serial UID
	 */
	private static final long serialVersionUID = -8588173670017548991L;
	
	/**
	 * The version used to manage concurrent
	 * access of the instance in persistence
	 * context
	 */
	@Version
	private Integer version;

	/**
	 * 
	 * @return The id
	 */
	abstract V getId();
	
	/**
	 * 
	 * @param id The id to set
	 */
	abstract void setId(V id);
	
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return The textual representation of the instance
	 */
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " #" + this.getId();
	}
	
	/**
	 * @return True if the object is an instance of the current 
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = this == o;
		if(!equals){
			if(o != null && this.getClass().equals(o.getClass())){				
				@SuppressWarnings("unchecked")
				BusinessEntity<V> businessEntity = (BusinessEntity<V>) o;
				if(this.getId() != null){
					equals = this.getId().equals(businessEntity.getId());
				}				
			}
		}
		return equals;
	}

}
