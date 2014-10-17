package scoring;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jpa.Hero;
import jpa.Mission;
import jpa.Skill;
import objects.Score;

public class Scoring {
	private static final int SCORE_FOR_MATCHING_SKILL = 1;
	private static final int SCORE_FOR_MATCHING_EDUCATION_TARGET = 2;
	private static final int SCORE_FOR_MATCHING_ROLE = 10;

	public Score computeScoreForHero(Hero hero, Mission mission, Integer zoins) {
		return computeScore(mission.getSkillSet().getSkills(), hero.getSkillSet().getSkills(),
				hero.getEducationTarget(), hero.getRole().equals(mission.getRole()), zoins);
	}

	public Score computeScoreForMission(Mission mission, Hero hero,
			Integer zoins) {
		return computeScore(hero.getSkillSet().getSkills(), mission.getSkillSet().getSkills(),
				hero.getEducationTarget(), hero.getRole().equals(mission.getRole()), zoins);
	}

	private Score computeScore(final Set<Skill> requestedSkills,
			final Set<Skill> availableSkills, Skill educationTarget,
			final boolean roleMatching, Integer zoins) {
		int compureScoreBySkills = compureScoreBySkills(requestedSkills,
				availableSkills, educationTarget);
		return new Score(computeTotalScore(roleMatching, compureScoreBySkills,
				zoins), roleMatching, computeSkillMatches(requestedSkills,
				availableSkills), compureScoreBySkills);
	}

	private int computeTotalScore(final boolean roleMatching,
			int compureScoreBySkills, Integer zoins) {
		return (roleMatching ? SCORE_FOR_MATCHING_ROLE : 0)
				+ compureScoreBySkills + (zoins == null ? 0 : zoins.intValue());
	}

	private Map<Skill, Boolean> computeSkillMatches(Set<Skill> requestedSkills,
			Set<Skill> availableSkills) {
		final Map<Skill, Boolean> skillMatches = new TreeMap<Skill, Boolean>();
		for (Skill requestedSkill : requestedSkills) {
			skillMatches.put(requestedSkill,
					availableSkills.contains(requestedSkill));
		}
		return skillMatches;
	}

	private int compureScoreBySkills(Set<Skill> requestedSkills,
			Set<Skill> availableSkills, Skill educationTarget) {
		int score = 0;
		for (Skill requestedSkill : requestedSkills) {
			if (availableSkills.contains(requestedSkill)) {
				score += SCORE_FOR_MATCHING_SKILL;
			}
			if (educationTarget.equals(requestedSkill)) {
				score += SCORE_FOR_MATCHING_EDUCATION_TARGET;
			}
		}
		return score;
	}
}
