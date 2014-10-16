package jpa;

import java.util.HashSet;
import java.util.List;
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
	
	public SkillSet(List<Skill> skills){
		this.skills = new HashSet<Skill>(skills);
	}
	
	public Long getId() {
		return id;
	}
	
	public Set<Skill> getSkills() {
		return skills;
	}
}
