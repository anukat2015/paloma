/**
 * 
 */
package com.paloit.paloma.domain;

/**
 * @author DTRANG, SLOPES
 * The root class used by business entities
 * @param V The type of the id
 *
 */
public abstract class BusinessEntity<V> {
	

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
	 * @return The textual representation of the instance
	 */
	public String toString(){
		return this.getClass().getSimpleName() + " #" + this.getId();
	}
	
	/**
	 * @return True if the object is an instance of the current 
	 */
	public boolean equals(Object o){
		boolean equals = this == o;
		if(!equals){
			if(o != null && this.getClass().equals(o)){				
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
