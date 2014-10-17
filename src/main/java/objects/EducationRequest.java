package objects;

import jpa.Skill;

public class EducationRequest {

	private int heroId;
	private Skill educationSkill;
	
	public EducationRequest() {
		
	}

	public int getHeroId() {
		return heroId;
	}

	public Skill getEducationSkill() {
		return educationSkill;
	}
}
