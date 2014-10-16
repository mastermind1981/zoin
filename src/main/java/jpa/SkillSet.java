package jpa;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SkillSet {
	@Id
	@GeneratedValue
	private Long id;
	
	@ElementCollection
	private Set<Skill> skills;

	public SkillSet() {
	}
	
	public Long getId() {
		return id;
	}
	
	public Set<Skill> getSkills() {
		return skills;
	}
}
