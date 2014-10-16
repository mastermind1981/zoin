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
	private String shortName;
	@Basic
	private String companyName;
	@Basic
	private String description;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	private SkillSet skillSet;
	
	public Mission(){
	}
	
	public Mission(String name, String companyName, String description, Role role, SkillSet skillSet) {
		this.shortName = name;
		this.companyName = companyName;
		this.description = description;
		this.role = role;
		this.skillSet = skillSet;
	}

	public Long getId() {
		return id;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Role getRole() {
		return role;
	}
	
	public SkillSet getSkillSet() {
		return skillSet;
	}
}
