package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SomeEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	
	public SomeEntity() {
		
	}
	
	

	public Long getId() {
		return id;
	}
}