package jpa;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medal {
	@Id
	@GeneratedValue
	private Long id;
	
	@Basic
	private String imagePath;
	@Basic
	private String comment;
	
	public Medal()  {
		
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getComment() {
		return comment;
	}
}
