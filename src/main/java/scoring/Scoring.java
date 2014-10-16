package scoring;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import objects.Score;

import jpa.Hero;
import jpa.Mission;
import jpa.Skill;

public class Scoring {
	private static final int SCORE_FOR_MATCHING_SKILL = 1;
	private static final int SCORE_FOR_MATCHING_ROLE = 10;

	public Score computeScore(Hero hero, Mission mission) {
		if (!hero.getRole().equals(mission.getRole())) {
			return new Score(0, false);
		}
		return new Score(SCORE_FOR_MATCHING_ROLE
				+ compureScoreBySkills(hero, mission), true);
	}

	private int compureScoreBySkills(Hero hero, Mission mission) {
		int score = 0;
		final Set<Skill> skillsOfMission = mission.getSkillSet().getSkills();
		for (Skill skillOfHero : hero.getSkillSet().getSkills()) {
			if (skillsOfMission.contains(skillOfHero)) {
				score += SCORE_FOR_MATCHING_SKILL;
			}
		}
		return score;
	}
}
