package objects;

import java.util.Map;

import jpa.Skill;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Score {
	private int totalScore;
	private boolean roleMatching;
	private Map<Skill, Boolean> skillMatches;

	public Score() {
	}

	public Score(int totalScore, boolean roleMatching,
			Map<Skill, Boolean> skillMatches) {
		this.totalScore = totalScore;
		this.roleMatching = roleMatching;
		this.skillMatches = skillMatches;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public boolean isRoleMatching() {
		return roleMatching;
	}

	public Map<Skill, Boolean> getSkillMatches() {
		return skillMatches;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
