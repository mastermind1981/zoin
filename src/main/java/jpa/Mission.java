package jpa;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mission {
	@Id
	@GeneratedValue
	private Long id;
	
	@Basic
	private String name;
	@Basic
	private String companyName;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	private SkillSet skillSet;
	
	public Mission(){
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public Role getRole() {
		return role;
	}
	
	public SkillSet getSkillSet() {
		return skillSet;
	}
}
