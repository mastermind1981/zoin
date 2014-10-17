package objects;

import java.util.Map;
import java.util.TreeMap;

import jpa.Skill;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Score {
	private int totalScore;
	private boolean roleMatching;
	private int skillScore;
	private Map<Skill, SkillMatch> skillMatches;

	public Score() {
	}

	public Score(int totalScore, boolean roleMatching,
			Map<Skill, SkillMatch> skillMatches, int skillScore) {
		this.totalScore = totalScore;
		this.roleMatching = roleMatching;
		this.skillMatches = new TreeMap<Skill, SkillMatch>(skillMatches);
		this.skillScore = skillScore;
	}

	public int getTotalScore() {
		return totalScore;
	}
	
	public int getSkillScore() {
		return skillScore;
	}

	public boolean isRoleMatching() {
		return roleMatching;
	}

	public Map<Skill, SkillMatch> getSkillMatches() {
		return skillMatches;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
