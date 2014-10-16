package jpa;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Character {
	@Id
	@GeneratedValue
	private Long id;
	
	@Basic
	private String firstName;
	@Basic
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	private SkillSet skillSet;
	
	public Character(){
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Role getRole() {
		return role;
	}
	
	public SkillSet getSkillSet() {
		return skillSet;
	}
}
